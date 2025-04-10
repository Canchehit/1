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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luisa
 */
public class FlujoDeTrabajoController extends Application {
    
  private ListView<String> workflowListView;
    private ObservableList<String> workflows;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gestión de Flujos de Trabajo");

        workflows = FXCollections.observableArrayList();
        workflowListView = new ListView<>(workflows);

        TextField workflowNameField = new TextField();
        workflowNameField.setPromptText("Nombre del flujo de trabajo");

        Button addButton = new Button("Agregar");
        Button modifyButton = new Button("Modificar");
        Button deleteButton = new Button("Eliminar");

        addButton.setOnAction(e -> addWorkflow(workflowNameField.getText()));
        modifyButton.setOnAction(e -> modifyWorkflow(workflowNameField.getText()));
        deleteButton.setOnAction(e -> deleteWorkflow());

        HBox buttonBox = new HBox(10, addButton, modifyButton, deleteButton);
        buttonBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(10, workflowListView, workflowNameField, buttonBox);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new javafx.geometry.Insets(20));

        primaryStage.setScene(new Scene(layout, 400, 300));
        primaryStage.show();
    }

    private void addWorkflow(String name) {
        if (!name.isEmpty() && !workflows.contains(name)) {
            workflows.add(name);
        } else {
            showAlert("Error", "El nombre del flujo ya existe o está vacío.");
        }
    }

    private void modifyWorkflow(String newName) {
        int selectedIndex = workflowListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1 && !newName.isEmpty()) {
            workflows.set(selectedIndex, newName);
        } else {
            showAlert("Error", "Debe seleccionar un flujo y proporcionar un nuevo nombre válido.");
        }
    }

    private void deleteWorkflow() {
        int selectedIndex = workflowListView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            workflows.remove(selectedIndex);
        } else {
            showAlert("Error", "Debe seleccionar un flujo para eliminar.");
        }
    }
 @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

