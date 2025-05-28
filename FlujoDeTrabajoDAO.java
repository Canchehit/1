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
public class FlujoDeTrabajoDAO {
      public void create(FlujoDeTrabajoController  e) {
        String sql = """ 
                INSERT INTO Ticket(Nombre del flujo de trabajo)
            VALUES(?,?)
                """;

        try (Connection conn = FlujoDeTrabajoController .getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FlujoDeTrabajoController  read(String identificacion) {
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
         FlujoDeTrabajoController  e = new FlujoDeTrabajoController ();
         e.setNombre del flujo de trabajo(rs.getString("Nombre del flujo de trabajo"));
        
        
         return e;
         }
       
         }
  
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        return null;
    }
}
