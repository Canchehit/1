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
public class ListaSolicitudesDAO {
     public void create(ListaSolicitudes e) {
        String sql = """ 
                INSERT INTO ListaSolicitudes(Número de Ticket, Estado,Fecha de Creación,Departamento,Prioridad,Resumen)
            VALUES(?,?,?,?)
                """;

        try (Connection conn = ListaSolicitudes.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ListaSolicitudes read(String identificacion) {
        String sql = """
                     
        SELECT Número de Ticket, Estado,Fecha de Creación,Departamento,Prioridad,Resumen
        FROM ListaSolicitudes
        WHERE Número de Ticket = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         ListaSolicitudes e = new ListaSolicitudes();
         e.setNúmero de Ticket(rs.getString("Número de Ticket"));
         e.setEstadors.getString("Estado"));
         e.setFecha de Creación(rs.getString("Fecha de Creación"));
         e.setDepartamento(rs.getString("Departamento"));
         e.setPrioridadrs.getString("Prioridad"));
          e.setResumen(rs.getString("Resumen"));
         return e;
         }
}
