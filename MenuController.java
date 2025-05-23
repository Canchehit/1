/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuController extends Application {

      @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Menú Principal");
        
 
        Button btnParametros = new Button("Parámetros");
        Button btnRolesPermisos = new Button("Roles y Permisos");
        Button btnDepartamentos = new Button("Departamentos o Áreas");
        Button btnUsuarios = new Button("Usuarios");
        Button btnEstadoTicket = new Button("Estado del Ticket");
        Button btnFlujoTrabajo = new Button("Flujo de Trabajo");
        Button btnGestionTicket = new Button("Gestión de Ticket");
        Button btnListaSolicitudes = new Button("Lista de Solicitudes");
        Button btnConfiguraciones = new Button("Configuraciones");
        Button btnTicket = new Button("Ticket");
        Button btnSalir = new Button("Salir");
        
     
        btnParametros.setOnAction(e -> abrirVentana("Parámetros"));
        btnRolesPermisos.setOnAction(e -> abrirVentana("Roles y Permisos"));
        btnDepartamentos.setOnAction(e -> abrirVentana("Departamentos o Áreas"));
        btnUsuarios.setOnAction(e -> abrirVentana("Usuarios"));
        btnEstadoTicket.setOnAction(e -> abrirVentana("Estado del Ticket"));
        btnFlujoTrabajo.setOnAction(e -> abrirVentana("Flujo de Trabajo"));
        btnGestionTicket.setOnAction(e -> abrirVentana("Gestión de Ticket"));
        btnListaSolicitudes.setOnAction(e -> abrirVentana("Lista de Solicitudes"));
        btnConfiguraciones.setOnAction(e -> abrirVentana("Configuraciones"));
        btnTicket.setOnAction(e -> abrirVentana("Configuraciones"));
        btnSalir.setOnAction(e -> primaryStage.close());
        

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(
            btnParametros, btnRolesPermisos, btnDepartamentos, btnUsuarios, 
            btnEstadoTicket, btnFlujoTrabajo, btnGestionTicket, btnListaSolicitudes, 
            btnConfiguraciones, btnSalir
        );
        

        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void abrirVentana(String titulo) {
        Stage ventana = new Stage();
        ventana.setTitle(titulo);
        ventana.setScene(new Scene(new VBox(new Button("Contenido de " + titulo)), 250, 200));
        ventana.show();
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}
