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

public class Conexion {
    
   private static PGSimpleDataSource dataSource;
    private static Connection conn = null;  
   private String conexion;
   
     public String getconexion() {
        return conexion;
    }
      static {
    dataSource = new PGSimpleDataSource();
    dataSource.setServerNames(new String [] {"ep-spring-bush-a8la3tib-pooler.eastus2.azure.neon.tech"});
    dataSource.setDatabaseName("SistemaTickets");
    dataSource.setUser("neondb_owner");
    dataSource.setPassword("npg_3rfleRJNBsV4");
   
   
}
}