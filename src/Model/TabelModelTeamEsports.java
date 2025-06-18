/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-defaulte.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author HYPE AMD
 */
public class TabelModelTeamEsports extends AbstractTableModel{
    List<TeamEsports> lte;
    
    public TabelModelTeamEsports(List<TeamEsports> lte)
    {
        this.lte = lte;
    }
    
    @Override
    public int getColumnCount()
    {
        return 5;
    }
    
    @Override
    public int getRowCount()
    {
        return lte.size();
    }
    
    @Override
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0:
                return "ID Team";
            case 1:
                return "Name Team";
            case 2:
                return "Location";
            case 3:
                return "Region";
            case 4:
                return "Years";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row,int column)
    {
        switch (column)
        {
            case 0:
                return lte.get(row).getId_team();
            case 1:
                return lte.get(row).getName_team();
            case 2:
                return lte.get(row).getLocation_team();
            case 3:
                return lte.get(row).getRegion_team();
            case 4:
                return lte.get(row).getYears();
            default:
                return null;
        }
    }
}
