/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luisa
 */
public class ListaSolicitudesController extends Application {

   private TableView<Tickets> ticketTable;
    private ObservableList<Tickets> ticketList;
  private Button btnVolver;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Tickets");
        
        // Tabla de tickets
        ticketTable = new TableView<>();
        TableColumn<Tickets, String> numberColumn = new TableColumn<>("Número de Ticket");
        TableColumn<Tickets, String> statusColumn = new TableColumn<>("Estado");
        TableColumn<Tickets, String> dateColumn = new TableColumn<>("Fecha de Creación");
        TableColumn<Tickets, String> deptColumn = new TableColumn<>("Departamento");
        TableColumn<Tickets, String> priorityColumn = new TableColumn<>("Prioridad");
        TableColumn<Tickets, String> summaryColumn = new TableColumn<>("Resumen");
        
        ticketTable.getColumns().addAll(numberColumn, statusColumn, dateColumn, deptColumn, priorityColumn, summaryColumn);
        
        // Lista de tickets (datos de prueba)
        ticketList = FXCollections.observableArrayList(
            new Tickets("1", "Pendiente", "2025-03-26", "Soporte", "Alta", "Problema con la red"),
            new Tickets("2", "En proceso", "2025-03-25", "IT", "Media", "Error en el sistema")
        );
        ticketTable.setItems(ticketList);
        
       
        TextField searchField = new TextField();
        searchField.setPromptText("Buscar por número de ticket");
        ComboBox<String> statusFilter = new ComboBox<>(FXCollections.observableArrayList("Pendiente", "En proceso", "Escalado", "Cerrado"));
        statusFilter.setPromptText("Filtrar por estado");
        
        Button filterButton = new Button("Aplicar Filtro");
        filterButton.setOnAction(e -> applyFilters(searchField, statusFilter));
        
         btnVolver = new Button("Volver al Menú");
        btnVolver.setOnAction(e -> volverAlMenu(primaryStage));
        
        VBox layout = new VBox(10, searchField, statusFilter, filterButton, ticketTable);
        Scene scene = new Scene(layout, 600, 400);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void volverAlMenu(Stage primaryStage) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Volver al Menú");
        alerta.setContentText("Funcionalidad para cambiar de escena aún no implementada.");
        alerta.showAndWait(); 
     }
  

    
    private void applyFilters(TextField searchField, ComboBox<String> statusFilter) {
        String searchText = searchField.getText();
        String selectedStatus = statusFilter.getValue();
        
        ObservableList<Tickets> filteredList = FXCollections.observableArrayList();
        for (Tickets ticket : ticketList) {
            boolean matchesSearch = searchText.isEmpty() || ticket.getNumber().contains(searchText);
            boolean matchesStatus = selectedStatus == null || ticket.getStatus().equals(selectedStatus);
            
            if (matchesSearch && matchesStatus) {
                filteredList.add(ticket);
            }
        }
        
        ticketTable.setItems(filteredList);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}

 class Tickets {
    private String id;
    private String estado;
    private String fecha;
    private String departamento;
    private String prioridad;
    private String descripcion;

    // Constructor 
    public Tickets(String id, String estado, String fecha, String departamento, String prioridad, String descripcion) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
        this.departamento = departamento;
        this.prioridad = prioridad;
        this.descripcion = descripcion;
    }
    public String getNumber() {
    return id; 
}

public String getStatus() {
    return estado;
}
}

