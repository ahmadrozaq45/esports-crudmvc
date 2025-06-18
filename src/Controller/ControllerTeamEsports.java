/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.DAOTeamEsports;
import DAOInterface.IEsports;
import Model.TeamEsports;
import Model.TabelModelTeamEsports;
import View.FormTeam;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Gazez
 */
public class ControllerTeamEsports {
    FormTeam frame;
    IEsports implEsports;
    List<TeamEsports> lte;
    
    public ControllerTeamEsports(FormTeam frame){
        this.frame = frame;
        implEsports = new DAOTeamEsports();
        lte = implEsports.getAll();
    }
    
    //mengosongkan field
    public void cancel(){
        frame.getId_team().setText("");
        frame.getName_team().setText("");
        frame.getLocation_team().setText("");
        frame.getRegion_team().setSelectedItem("");
        frame.getYears().setText("");
    }
    
    public void isiTable(){
        lte = implEsports.getAll();
        TabelModelTeamEsports TM = new TabelModelTeamEsports(lte);
        frame.getTabelEsports().setModel(TM);
    }
    
    public void isiField(int row){
        frame.getId_team().setText (lte.get(row).getId_team().toString());
        frame.getName_team().setText(lte.get(row).getName_team());
        frame.getLocation_team().setText (lte.get(row).getLocation_team());
        frame.getRegion_team().setSelectedItem(lte.get(row).getRegion_team());
        frame.getYears().setText(lte.get(row).getYears().toString());
    }
    
    public void insert(){
        if (!frame.getName_team().getText().trim().isEmpty()& !frame.getLocation_team().getText().trim().isEmpty()){
            TeamEsports te = new TeamEsports();
            te.setId_team (Integer.parseInt(frame.getId_team().getText()));
            te.setName_team(frame.getName_team().getText());
            te.setLocation_team (frame.getLocation_team().getText());
            te.setRegion_team(frame.getRegion_team().getSelectedItem().toString());
            te.setYears (Integer.parseInt(frame.getYears().getText()));
            implEsports.insert(te);
            JOptionPane.showMessageDialog(null, "simpan Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Deta Tidak Boleh Kosong");
        }
    }
    
    public void update(){
        if (!frame.getId_team().getText().trim().isEmpty()) {
            TeamEsports te = new TeamEsports();
            te.setId_team(Integer.parseInt(frame.getId_team().getText()));
            te.setName_team(frame.getName_team().getText());
            te.setLocation_team (frame.getLocation_team().getText());
            te.setRegion_team(frame.getRegion_team().getSelectedItem().toString());
            te.setYears (Integer.parseInt(frame.getYears().getText()));
            te.setId_team(Integer.parseInt(frame.getId_team().getText()));
            implEsports.update(te);
            JOptionPane.showMessageDialog(null, "Update Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di ubah");
        }
    }
    
    public void delete() {
        if (!frame.getId_team().getText().trim().isEmpty()) {
            int id_team= Integer.parseInt(frame.getId_team().getText());
            implEsports.delete(id_team);
            JOptionPane.showMessageDialog(null, "Hapus Data sukses");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih data yang akan di hapus");
        }
    }
    
    public void isiTableCariNama() {
        lte = implEsports.getCariNama (frame.getCari().getText());
        TabelModelTeamEsports tmb = new TabelModelTeamEsports (lte);
        frame.getTabelEsports().setModel(tmb);
    }
    
    public void carinama () {
        if (!frame.getCari().getText().trim().isEmpty()) {
        implEsports.getCariNama (frame.getCari().getText());
        isiTableCariNama();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN PILIH DATA");
        }
    }
}
