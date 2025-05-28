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
public class RolesyPermisosDAO {
         public void create(RolesyPermisos e) {
        String sql = """ 
                INSERT INTO Parametros(nombreRol, descripcionRol,)
            VALUES(?,?,?)
                """;

        try (Connection conn = RolesyPermisos.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public RolesyPermisos read(String identificacion) {
        String sql = """
                     
        SELECT nombreRol, descripcionRol,
        FROM nombreRol
        WHERE Nombre del departamento = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         RolesyPermisos e = new RolesyPermisos();
         e.setnombreRol(rs.getString("nombreRol"));
         e.setdescripcionRol.getString("descripcionRol"));
        
         return e;
         }
}
