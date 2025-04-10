/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets1;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luisa
 */
public class GestionarTicketsController extends Application{
     @FXML
    private Button  btnVolver;
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Tickets");
        
        // Elementos de la UI
        Label titleLabel = new Label("Título:");
        TextField titleField = new TextField();
        
        Label descLabel = new Label("Descripción:");
        TextArea descArea = new TextArea();
        
        Label deptLabel = new Label("Departamento:");
        ComboBox<String> deptCombo = new ComboBox<>();
        deptCombo.getItems().addAll("Soporte", "IT", "Mantenimiento");
        
        Label priorityLabel = new Label("Prioridad:");
        ComboBox<String> priorityCombo = new ComboBox<>();
        priorityCombo.getItems().addAll("Baja", "Media", "Alta");
        
        Button submitButton = new Button("Crear Ticket");
        submitButton.setOnAction(e -> createTicket(titleField, descArea, deptCombo, priorityCombo));
        
        VBox layout = new VBox(10, titleLabel, titleField, descLabel, descArea, deptLabel, deptCombo, priorityLabel, priorityCombo, submitButton);
        Scene scene = new Scene(layout, 400, 400);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void createTicket(TextField titleField, TextArea descArea, ComboBox<String> deptCombo, ComboBox<String> priorityCombo) {
        String title = titleField.getText();
        String description = descArea.getText();
        String department = deptCombo.getValue();
        String priority = priorityCombo.getValue();
        
        if (title.isEmpty() || description.isEmpty() || department == null || priority == null) {
            showAlert("Error", "Todos los campos son obligatorios");
            return;
        }
        
        System.out.println("Ticket creado: " + title + " - " + department + " - " + priority);
        showAlert("Éxito", "Ticket creado exitosamente");
        
        titleField.clear();
        descArea.clear();
        deptCombo.setValue(null);
        priorityCombo.setValue(null);
    }
    
     @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

