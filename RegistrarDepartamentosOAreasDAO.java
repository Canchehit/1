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
public class RegistrarDepartamentosOAreasDAO {
       public void create(RegistrarDepartamentosOAreas e) {
        String sql = """ 
                INSERT INTO Parametros(Nombre del departamento, Descripción del departamento,)
            VALUES(?,?,?,?)
                """;

        try (Connection conn = RegistrarDepartamentosOAreas.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public RegistrarDepartamentosOAreas read(String identificacion) {
        String sql = """
                     
        SELECT Nombre del departamento, Descripción del departamento,
        FROM RegistrarDepartamentosOAreas
        WHERE Nombre del departamento = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         RegistrarDepartamentosOAreas e = new RegistrarDepartamentosOAreas();
         e.setNombre del departamento(rs.getString("Nombre del departamento"));
         e.setDescripción del departamento.getString("Descripción del departamento"));
        
         return e;
         }
}
