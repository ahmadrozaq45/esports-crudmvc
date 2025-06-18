/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;
import java.util.List;
import Model.TeamEsports;
/**
 *
 * @author HYPE AMD
 */
public interface IEsports {
    public void insert(TeamEsports te);
    public void update(TeamEsports te);
    public void delete(int id_team);
    public List<TeamEsports> getAll();
    public List<TeamEsports>getCariNama(String text);
    //public List<TeamEsports>getCariRegion(String text);
}
