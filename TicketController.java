/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets1;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author luisa
 */
public class TicketController  {

    private GestorDeCola gestorCola = new GestorDeCola();
    private Ticket ticketActual;
    private Button btnVolver;
    
    @FXML
    private ListView<String> listaTickets;
    @FXML
    private TextArea descripcionArea;
    @FXML
    private Label labelTicketActual;
  
  
    @FXML
    private void onAgregarTicket() {
        String desc = descripcionArea.getText();
        if (!desc.isEmpty()) {
            Ticket nuevo = new Ticket(generarId(), desc);
            gestorCola.agregarTicket(nuevo);
            actualizarLista();
        }
    }

    @FXML
    private void onAtenderTicket() {
        ticketActual = gestorCola.atenderTicket();
        if (ticketActual != null) {
            labelTicketActual.setText("Atendiendo ticket ID: " + ticketActual.getId());
            descripcionArea.setText(ticketActual.getDescripcion());
        }
        actualizarLista();
    }

    @FXML
    private void onGuardarCambio() {
        if (ticketActual != null) {
            ticketActual.actualizarDescripcion(descripcionArea.getText());
        }
    }

    @FXML
    private void onDeshacerCambio() {
        if (ticketActual != null) {
            ticketActual.deshacerCambio();
            descripcionArea.setText(ticketActual.getDescripcion());
        }
    }

    private void actualizarLista() {
        listaTickets.getItems().clear();
        for (Ticket t : gestorCola.obtenerCola()) {
            listaTickets.getItems().add("ID " + t.getId() + ": " + t.getDescripcion());
        }
    }
    
       

    private int generarId() {
        return (int)(Math.random() * 10000); // ejemplo simple, reemplaza con algo mejor si ya tienes lógica
    }
      @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}