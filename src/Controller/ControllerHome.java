/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.FormHome;
import DAO.DAOTeamEsports;
import DAOInterface.IEsports;
import Model.TeamEsports;
import Model.TabelModelTeamEsports;
import DAO.DAOPlayer;
import DAOInterface.IPlayer;
import Model.Player;
import Model.TabelModelPlayer;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author HYPE AMD
 */
public class ControllerHome {
   FormHome frame;
   IEsports implEsports;
   IPlayer implPlayer;
   List<TeamEsports> lte;
   List<Player> lpe;
    
    public ControllerHome(FormHome frame) {
        this.frame = frame;
        implEsports = new DAOTeamEsports();
        implPlayer = new DAOPlayer();
        lte = implEsports.getAll();
        lpe = implPlayer.getAll();
    }
    
    public void isiTableTeam() {
        lte = implEsports.getAll();
        TabelModelTeamEsports tmte = new TabelModelTeamEsports(lte);
        frame.getTabelDataTeam().setModel(tmte);
    }
    
    public void isiTablePlayer() {
        lpe = implPlayer.getAll();
        TabelModelPlayer tmpe = new TabelModelPlayer(lpe);
        frame.getTabelDataPlayer().setModel(tmpe);
    }
    
    public void isiTabelCariNamaTeam() {
        lte = implEsports.getCariNama (frame.getTxtCariNamaTeam().getText());
        TabelModelTeamEsports tmte = new TabelModelTeamEsports (lte);
        frame.getTabelDataTeam().setModel(tmte);
    }
    public void cariNamaTeam() {
        if (!frame.getTxtCariNamaTeam().getText().trim().isEmpty()) {
        implEsports.getCariNama (frame.getTxtCariNamaTeam().getText());
        isiTabelCariNamaTeam();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN ISI");
        }
    }
    
    public void isiTabelCariIGN() {
        lpe = implPlayer.getCariNama(frame.getTxtCariIGN().getText());
        TabelModelPlayer tmpe = new TabelModelPlayer(lpe);
        frame.getTabelDataPlayer().setModel(tmpe);
    }
    
    public void cariIGN() {
        if(!frame.getTxtCariIGN().getText().trim().isEmpty()) {
            implPlayer.getCariNama(frame.getTxtCariIGN().getText());
            isiTabelCariIGN();
        } else {
            JOptionPane.showMessageDialog(frame, "SILAHKAN ISI");
        }
    }
}
