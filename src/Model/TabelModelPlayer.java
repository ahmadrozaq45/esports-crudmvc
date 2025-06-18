/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author HYPE AMD
 */
public class TabelModelPlayer extends AbstractTableModel{
    List<Player> lp;
    
    public TabelModelPlayer(List<Player> lp)
    {
        this.lp = lp;
    }
    
    public int getColumnCount()
    {
        return 7;
    }
    
    public int getRowCount()
    {
        return lp.size();
    }
    
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0:
                return "ID Player";
            case 1:
                return "In Game Name";
            case 2:
                return "Real Name";
            case 3:
                return "Nationality";
            case 4:
                return "Status";
            case 5:
                return "ID Team";
            case 6:
                return "Division";
            default:
                return null;
        }
    }
    
    public Object getValueAt(int row, int column)
    {
        switch (column)
        {
            case 0:
                return lp.get(row).getId_player();
            case 1:
                return lp.get(row).getIgn();
            case 2:
                return lp.get(row).getRealname();
            case 3:
                return lp.get(row).getNationality();
            case 4:
                return lp.get(row).getStatus();
            case 5 :
                return (lp.get(row).getId_team() != null) ? lp.get(row).getId_team() : "Free Agent";
            case 6:
                return lp.get(row).getDivision();
            default:
                return null;
        }
    }
}
