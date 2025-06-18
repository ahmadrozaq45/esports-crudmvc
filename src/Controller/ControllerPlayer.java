/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOPlayer;
import DAOInterface.IPlayer;
import Model.Player;
import Model.TabelModelPlayer;
import View.FormPlayer;
import java.util.List;
import javax.swing.JOptionPane;
//import javax.swing.table.TableModel;

/**
 *
 * @author Gazez
 */
public class ControllerPlayer {
    FormPlayer frame;
    IPlayer implPlayer;
    List<Player> lpe;
    
    public ControllerPlayer(FormPlayer frame){
        this.frame = frame;
        implPlayer = new DAOPlayer();
        lpe = implPlayer.getAll();
    }
    
    //mengosongkan field
    public void cancel() {
        frame.getId_player().setText("");
        frame.getIgn().setText("");
        frame.getRealname().setText("");
        frame.getNationality().setText("");
        frame.getStatus().setSelectedItem("");
        frame.getId_team().setText("");
        frame.getDivision().setSelectedItem("");
    }
    
    public void isiTable(){
        lpe = implPlayer.getAll();
        TabelModelPlayer TM = new TabelModelPlayer(lpe);
        frame.getTablePlayer().setModel(TM);
    }
    
    public void isiField(int row) {
        frame.getId_player().setText(lpe.get(row).getId_player().toString());
        frame.getIgn().setText(lpe.get(row).getIgn());
        frame.getRealname().setText(lpe.get(row).getRealname());
        frame.getNationality().setText(lpe.get(row).getNationality());
        frame.getStatus().setSelectedItem(lpe.get(row).getStatus());
        frame.getDivision().setSelectedItem(lpe.get(row).getDivision());
        if (lpe.get(row).getId_team() != null) {
            frame.getId_team().setText(lpe.get(row).getId_team().toString());
        } else {
            frame.getId_team().setText("");
        }
    }
    
    public void insert() {
        if (!frame.getIgn().getText().trim().isEmpty() && 
            !frame.getRealname().getText().trim().isEmpty()) {
            
            Player pe = new Player();
            pe.setId_player(Integer.parseInt(frame.getId_player().getText()));
            pe.setIgn(frame.getIgn().getText());
            pe.setRealname(frame.getRealname().getText());
            pe.setNationality(frame.getNationality().getText());
            pe.setStatus(frame.getStatus().getSelectedItem().toString());
            
            String idTeamStr = frame.getId_team().getText().trim();
            if (idTeamStr.isEmpty()) {
                pe.setId_team(null);
            } else {
                pe.setId_team(Integer.parseInt(idTeamStr));
            }
            pe.setDivision(frame.getDivision().getSelectedItem().toString());
            
            implPlayer.insert(pe);
            JOptionPane.showMessageDialog(null, "Simpan data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "IGN dan Real Name tidak boleh kosong");
        }
    }
    
    public void update() {
        if (!frame.getId_player().getText().trim().isEmpty()) {
            Player pe = new Player();
            pe.setId_player(Integer.parseInt(frame.getId_player().getText()));
            pe.setIgn(frame.getIgn().getText());
            pe.setRealname(frame.getRealname().getText());
            pe.setNationality(frame.getNationality().getText());
            pe.setStatus(frame.getStatus().getSelectedItem().toString());
            pe.setDivision(frame.getDivision().getSelectedItem().toString());
            
            String idTeamStr = frame.getId_team().getText().trim();
            if (idTeamStr.isEmpty()) {
                pe.setId_team(null);
            } else {
                pe.setId_team(Integer.parseInt(idTeamStr));
            }
            
            pe.setId_player(Integer.parseInt(frame.getId_player().getText()));
            implPlayer.update(pe);
            JOptionPane.showMessageDialog(null, "Update data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan diubah");
        }
    }
    
    public void delete() {
        if (!frame.getId_player().getText().trim().isEmpty()) {
            int id_player = Integer.parseInt(frame.getId_player().getText());
            implPlayer.delete(id_player);
            JOptionPane.showMessageDialog(null, "Hapus data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan dihapus");
        }
    }
    
    public void isiTableCariNama() {
        lpe = implPlayer.getCariNama(frame.getFieldCariNama().getText());
        TabelModelPlayer TM = new TabelModelPlayer(lpe);
        frame.getTablePlayer().setModel( TM);
    }
    
    public void carinama () {
        if (!frame.getFieldCariNama().getText().trim().isEmpty()) {
        implPlayer.getCariNama (frame.getFieldCariNama().getText());
        isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
    
    public void isiTableByTeam(int idTeam) {
        List<Player> lpeByTeam = implPlayer.getByTeam(idTeam);
        TabelModelPlayer TM = new TabelModelPlayer(lpeByTeam);
        frame.getTablePlayer().setModel(TM);    
    }
}
