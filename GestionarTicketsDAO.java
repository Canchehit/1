/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistematickets1.Conexion;

/**
 *
 * @author luisa
 */
public class GestionarTicketsDAO {
       public void create(GestionarTickets e) {
        String sql = """ 
                INSERT INTO Ticket(Título, descripcionEstadoo,Departamento,Mantenimiento,Prioridad)
            VALUES(?,?,?,?)
                """;

        try (Connection conn = GestionarTickets.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GestionarTickets read(String identificacion) {
        String sql = """
                     
        SELECT Título, descripcionEstadoo,Departamento,Mantenimiento,Prioridad
        FROM GestionarTickets
        WHERE id = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         GestionarTickets e = new GestionarTickets();
         e.setTítulo(rs.getString("Título"));
         e.setDepartamento(rs.getString("Departamento"));
         e.setMantenimiento(rs.getString("Mantenimiento"));
         e.setPrioridad(rs.getString("Prioridad"));
        
         return e;
         }
       
         }
  
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        return null;
}
}
