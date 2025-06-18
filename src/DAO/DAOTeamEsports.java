/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Helper.KoneksiDB;
import Model.TeamEsports;
import DAOInterface.IEsports;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HYPE AMD
 */
public class DAOTeamEsports implements IEsports{
    Connection con;
    final String insert = "INSERT INTO tblteam (id_team, name_team, location_team, region_team, years) VALUES (?, ?, ?, ?, ?);";
    final String update = "UPDATE tblteam set id_team=?, name_team=?, location_team=?, region_team=?, years=? where id_team=? ;";
    final String delete = "DELETE FROM tblteam where id_team=? ;";
    final String select = "SELECT * FROM tblteam";
    final String carinama = "SELECT * FROM tblteam where name_team like ?";
    
    public DAOTeamEsports() {
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public void insert (TeamEsports te) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert);
            statement.setInt(1, te.getId_team());
            statement.setString(2, te.getName_team());
            statement.setString(3, te.getLocation_team());
            statement.setString(4, te.getRegion_team());
            statement.setInt(5, te.getYears());
            statement.executeUpdate();
//            ResultSet rs = statement.getGeneratedKeys();
//            while (rs.next()) {
//                te.setId_team(rs.getInt(1));
//            }
        } catch (SQLException ex) {
            System.out.println("Berhasil Input");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Input");
            }
        }
    }
    
    @Override
    public void update (TeamEsports te) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(update);
            statement.setInt(1, te.getId_team());
            statement.setString(2, te.getName_team());
            statement.setString(3, te.getLocation_team());
            statement.setString(4, te.getRegion_team());
            statement.setInt(5, te.getYears());
            statement.setInt(6, te.getId_team());
            statement.executeUpdate();
        
        } catch (SQLException ex) {
            System.out.println("Berhasil Update");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Input");
            }
        }
    }
    
    @Override
    public void delete(int id_team) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(delete);
            
            statement.setInt(1, id_team);
            statement.executeUpdate();  
        } catch (SQLException ex) {
            System.out.println("Berhasil Hapus");
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                System.out.println("Gagal Update");
            }
        }
    }
    
    @Override
    public List<TeamEsports> getAll() {
        List<TeamEsports> lte = null;
        try {
            lte = new ArrayList<TeamEsports>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                TeamEsports te = new TeamEsports();
                te.setId_team(rs.getInt("Id_team"));
                te.setName_team(rs.getString("Name_team"));
                te.setLocation_team(rs.getString("Location_team"));
                te.setRegion_team(rs.getString("Region_team"));
                te.setYears(rs.getInt("Years"));
                lte.add(te);
            }
        }   catch (SQLException ex) {
            Logger.getLogger(DAOTeamEsports.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lte;
    }
    
    @Override
    public List<TeamEsports> getCariNama(String name_team) {
        List<TeamEsports> lte = null;
        try {
            lte = new ArrayList<TeamEsports>();
            PreparedStatement st = con.prepareStatement(carinama);
            st.setString(1, "%" + name_team + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TeamEsports te = new TeamEsports();
                te.setId_team(rs.getInt("Id_team"));
                te.setName_team(rs.getString("Name_team"));
                te.setLocation_team(rs.getString("Location_team"));
                te.setRegion_team(rs.getString("Region_team"));
                te.setYears(rs.getInt("Years"));
                lte.add(te);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTeamEsports.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lte;
    }
}
