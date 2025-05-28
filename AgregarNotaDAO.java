/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import sistematickets1.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luisa
 */
public class AgregarNotaDAO {
       public void create(Ticket e) {
        String sql = """ 
                INSERT INTO Ticket(ticketNumber, status,notesHistory)
            VALUES(?,?,?,?)
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
                     
        SELECT ticketNumber, status,notesHistory
        FROM Ticket
        WHERE id = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         Ticket e = new Ticket();
         e.setticketNumber(rs.getString("ticketNumber"));
         e.setstatus(rs.getString("status"));
         e.setnotesHistory(rs.getString("notesHistory"));
        
         return e;
         }
       
         }
  
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        return null;
}
 
}
