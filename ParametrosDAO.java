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
public class ParametrosDAO {
      public void create(Parametros e) {
        String sql = """ 
                INSERT INTO Parametros(Nombre de la Empresa, Logo,idioma,zonaHoraria,tiempoVencimiento,listaPrioridades)
            VALUES(?,?,?,?)
                """;

        try (Connection conn = Parametros.getConexion(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, e.getid());
            

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Parametros read(String identificacion) {
        String sql = """
                     
        SELECT Nombre de la Empresa, Logo,idioma,zonaHoraria,tiempoVencimiento,listaPrioridades
        FROM Parametros
        WHERE Nombre de la Empresa = ?
        """;
         try (Connection conn = Conexion.getConexion(); 
              PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, identificacion);
        
         try (ResultSet rs = ps.executeQuery()){
         if (rs.next()){
         Parametros e = new Parametros();
         e.setLogo(rs.getString("Nombre de la Empresa"));
         e.setEstadors.getString("Logo"));
         e.setidioma(rs.getString("idioma"));
         e.setzonaHoraria(rs.getString("zonaHoraria"));
         e.settiempoVencimiento.getString("tiempoVencimiento"));
          e.setlistaPrioridades(rs.getString("listaPrioridades"));
         return e;
         }
}
