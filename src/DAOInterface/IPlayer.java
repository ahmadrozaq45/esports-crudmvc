/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOInterface;
import java.util.List;
import Model.Player;

/*
 *
 * @author HYPE AMD
 */
public interface IPlayer {    
    public void insert (Player pe);
    public void update (Player pe);
    public void delete (int id_player);
    public List<Player> getAll();
    public List<Player> getCariNama(String text);
    public List<Player> getByTeam(int idTeam);
}
