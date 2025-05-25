/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets1;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.ds.PGSimpleDataSource;


public class TicketDAO {
     public void create(Ticket e) {
        String sql = """ 
                INSERT INTO Ticket(id, descripcion)
            VALUES(?,?,?)
                """;

        try (Connection conn = ticket.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ticket read(String identificacion) {
        String sql = """
                     
        SELECT id, Descripcion
        FROM Ticket
        WHERE id = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         Ticket e = new Ticket();
         e.setid(rs.getString("id"));
         e.setDescripcion(rs.getString("Descripcion"));
        
         return e;
         }
       
         }
  
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        return null;
}
