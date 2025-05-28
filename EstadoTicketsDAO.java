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
public class EstadoTicketsDAO {
    public void create(EstadoTicketsController e) {
        String sql = """ 
                INSERT INTO Ticket(nombreEstado, descripcionEstadoo,estadoFinal,listaEstadosSiguientes)
            VALUES(?,?,?,?)
                """;

        try (Connection conn = EstadoTicketsController.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EstadoTicketsController read(String identificacion) {
        String sql = """
                     
        SELECT nombreEstado, descripcionEstadoo,estadoFinal,listaEstadosSiguientes
        FROM Ticket
        WHERE id = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         EstadoTicketsController e = new EstadoTicketsController();
         e.setnombreEstado(rs.getString("nombreEstado"));
         e.setdescripcionEstado(rs.getString("descripcionEstado"));
         e.setestadoFinalrs.getString("estadoFinal"));
         e.setlistaEstadosSiguientes(rs.getString("listaEstadosSiguientes"));
        
         return e;
         }
       
         }
  
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        return null;
}
}
