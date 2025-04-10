/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets1;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrarDepartamentosOAreasController extends Application {
 
    
    
    private ObservableList<String> departamentos = FXCollections.observableArrayList();
    private ListView<String> listView;
    private TextField nombreDepartamento;
    private TextArea descripcionDepartamento;
    private ComboBox<String> tecnicosComboBox;
    private ObservableList<String> tecnicosDisponibles = FXCollections.observableArrayList("Técnico 1", "Técnico 2", "Técnico 3");

    private Button btnVolver;
   @Override   
       public void start(Stage primaryStage) {
        listView = new ListView<>(departamentos);
        nombreDepartamento = new TextField();
        nombreDepartamento.setPromptText("Nombre del departamento");
        descripcionDepartamento = new TextArea();
        descripcionDepartamento.setPromptText("Descripción del departamento");
        tecnicosComboBox = new ComboBox<>(tecnicosDisponibles);

        Button btnAgregar = new Button("Agregar");
        btnAgregar.setOnAction(e -> agregarDepartamento());
        
        Button btnEliminar = new Button("Eliminar");
        btnEliminar.setOnAction(e -> eliminarDepartamento());
        
    
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(new Label("Departamentos"), listView, nombreDepartamento, descripcionDepartamento, tecnicosComboBox, btnAgregar, btnEliminar);

        Scene scene = new Scene(layout, 400, 500);
        primaryStage.setTitle("Gestión de Departamentos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarDepartamento() {
        String nombre = nombreDepartamento.getText().trim();
        if (nombre.length() < 3 || nombre.length() > 50) {
            mostrarAlerta("Error", "El nombre del departamento debe contener entre 3 y 50 caracteres.");
            return;
        }
        if (!departamentos.contains(nombre)) {
            departamentos.add(nombre);
            nombreDepartamento.clear();
            descripcionDepartamento.clear();
            tecnicosComboBox.getSelectionModel().clearSelection();
        } else {
            mostrarAlerta("Error", "El departamento ya existe.");
        }
    }

    private void eliminarDepartamento() {
        String seleccionado = listView.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            departamentos.remove(seleccionado);
        } else {
            mostrarAlerta("Error", "Seleccione un departamento para eliminar.");
           
        }
    }
     @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
        
    
    
}
