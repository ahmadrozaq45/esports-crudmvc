/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author HYPE AMD
 */
public class KoneksiDB {
    static Connection con;
    public static Connection getConnection() {
        if(con == null)
        {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_esports");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("CONNECTED");
            } catch(SQLException e){
                System.out.println("BELUM NYALAIN XAMPP/ BELUM TERKONEKSI BOSKU");
            }
        }
        return con;
    }

    public static Connection connection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
