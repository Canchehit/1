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
public class RegistrarUsuariosDAO {
        public void create(RegistrarUsuarios e) {
        String sql = """ 
                INSERT INTO RegistrarUsuarios(nombreCompleto, correoElectronico,nombreUsuario,contrasena,rolAsignado,departamento)
            VALUES(?,?,?)
                """;

        try (Connection conn = RegistrarUsuarios.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public RegistrarUsuarios read(String identificacion) {
        String sql = """
                     
        SELECT nombreCompleto, correoElectronico,nombreUsuario,contrasena,rolAsignado,departamento
        FROM RegistrarUsuarios
        WHERE nombreCompleto = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         RegistrarUsuarios e = new RegistrarUsuarios();
         e.setnombreCompleto(rs.getString("nombreCompleto"));
         e.setcorreoElectronico.getString("correoElectronico"));
          e.setnombreUsuario(rs.getString("nombreUsuario"));
         e.setcontrasena.getString("contrasena"));
         e.setrolAsignado(rs.getString("rolAsignado"));
         e.setdepartamento(rs.getString("departamento"));
         
        
         return e;
         }
}
