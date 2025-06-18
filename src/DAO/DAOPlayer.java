/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this pemplate
 */
package DAO;

import Helper.KoneksiDB;
import Model.Player;
import Model.TeamEsports;
import DAOInterface.IPlayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gazez
 */
public class DAOPlayer implements IPlayer{
    Connection con;
    final String insert = "INSERT INTO tblplayer (id_player, ign, realname, nationality, status, id_team, division) VALUES (?, ?, ?, ?, ?, ?, ?);";
    final String update = "UPDATE tblplayer set id_player=?, ign=?, realname=?, nationality=?, status=?, id_team=?, division=? where id_player=? ;";
    final String delete = "DELETE FROM tblplayer where id_player=? ;";
    final String select = "SELECT * FROM tblplayer;";
    final String carinama = "SELECT * FROM tblplayer where ign like ?";
    
    public DAOPlayer() {
        con = KoneksiDB.getConnection();
    }
    
    @Override
    public void insert(Player p) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(insert);
            statement.setInt(1, p.getId_player());
            statement.setString(2, p.getIgn());
            statement.setString(3, p.getRealname());
            statement.setString(4, p.getNationality());
            statement.setString(5, p.getStatus());
            statement.setString(7, p.getDivision());
            if (p.getId_team() == null) {
                statement.setNull(6, java.sql.Types.INTEGER);
            } else {
                statement.setInt(6, p.getId_team());
            }
            statement.executeUpdate();
//            ResultSet rs = statement.getGeneratedKeys();
//            while (rs.next()) {
//                p.setId_player(rs.getInt(1));
//            }
        } catch (SQLException ex) {
            System.out.println("Berhasil Input");
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println("Gagal Input");
            }
        }
    }
    
    @Override
    public void update(Player p) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(update);
            statement.setInt(1, p.getId_player());
            statement.setString(2, p.getIgn());
            statement.setString(3, p.getRealname());
            statement.setString(4, p.getNationality());
            statement.setString(5, p.getStatus());
            statement.setString(7, p.getDivision());
            if (p.getId_team() == null) {
                statement.setNull(6, java.sql.Types.INTEGER);
            } else {
                statement.setInt(6, p.getId_team());
            }
            statement.setInt(8, p.getId_player());
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Berhasil Update");
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println("Gagal Update");
            }
        }
    }
    
    @Override
    public void delete(int id_player) {
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(delete);
            statement.setInt(1, id_player);
            statement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Berhasil Hapus");
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                System.out.println("Gagal Hapus");
            }
        }
    }
    
    @Override
    public List<Player> getAll() {
        List<Player> lp = null;
        try {
            lp = new ArrayList<Player>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                Player p = new Player();
                p.setId_player(rs.getInt("id_player"));
                p.setIgn(rs.getString("ign"));
                p.setRealname(rs.getString("realname"));
                p.setNationality(rs.getString("nationality"));
                p.setStatus(rs.getString("status"));
                p.setDivision(rs.getString("division"));
                int fk = rs.getInt("id_team");
                if (rs.wasNull()) {
                    p.setId_team(null);
                } else {
                    p.setId_team(fk);
                }
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    
    @Override
    public List<Player> getCariNama(String name_player) {
        List<Player> lp = null;
        try {
            lp = new ArrayList<Player>();
            PreparedStatement st = con.prepareStatement(carinama);
            st.setString(1, "%" + name_player + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Player p = new Player();
                p.setId_player(rs.getInt("id_player"));
                p.setIgn(rs.getString("ign"));
                p.setRealname(rs.getString("realname"));
                p.setNationality(rs.getString("nationality"));
                p.setStatus(rs.getString("status"));
                p.setDivision(rs.getString("division"));
                int fk = rs.getInt("id_team");
                if (rs.wasNull()) {
                    p.setId_team(null);
                } else {
                    p.setId_team(fk);
                }
                lp.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
    
    @Override
    public List<Player> getByTeam(int idTeam) {
        List<Player> lp = new ArrayList<>();
        String sql = "SELECT * FROM tblplayer WHERE id_team = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, idTeam);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Player p = new Player();
                p.setId_player(rs.getInt("id_player"));
                p.setIgn(rs.getString("ign"));
                p.setRealname(rs.getString("realname"));
                p.setNationality(rs.getString("nationality"));
                p.setStatus(rs.getString("status"));
                p.setDivision(rs.getString("division"));
                // Kolom id_team sudah pasti ada karena kita filtering
                p.setId_team(rs.getInt("id_team"));
                lp.add(p);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lp;
    }
}
