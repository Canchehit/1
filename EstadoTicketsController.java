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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luisa
 */
public class EstadoTicketsController extends Application {

    
    @FXML
    private TextField nombreEstado;
    
    @FXML
    private TextArea descripcionEstado;
    
    @FXML
    private CheckBox estadoFinal;
    
    @FXML
    private ListView<String> listaEstadosSiguientes;
    
    @FXML
    private Button btnGuardar, btnCancelar, btnEliminar, btnVolver;

    // Acción para guardar un estado
    @FXML
    private void guardarEstado() {
        String nombre = nombreEstado.getText().trim();
        String descripcion = descripcionEstado.getText().trim();
        boolean esFinal = estadoFinal.isSelected();

        // Validaciones
        if (nombre.isEmpty() || nombre.length() < 3 || nombre.length() > 50) {
            mostrarAlerta("Error", "El nombre del estado debe tener entre 3 y 50 caracteres.");
            return;
        }

        if (!esFinal && listaEstadosSiguientes.getSelectionModel().isEmpty()) {
            mostrarAlerta("Error", "Debe seleccionar al menos un estado siguiente.");
            return;
        }

      
        mostrarAlerta("Éxito", "Estado guardado correctamente.");
    }


    @FXML
    private void cancelar() {
        nombreEstado.clear();
        descripcionEstado.clear();
        estadoFinal.setSelected(false);
        listaEstadosSiguientes.getSelectionModel().clearSelection();
    }

    // Boton para eliminar un estado
    @FXML
    private void eliminarEstado() {
        String nombre = nombreEstado.getText().trim();
        if (nombre.isEmpty()) {
            mostrarAlerta("Error", "Debe seleccionar un estado para eliminar.");
            return;
        }
        mostrarAlerta("Información", "Estado eliminado correctamente.");
    }
   @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
   
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    
}

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
