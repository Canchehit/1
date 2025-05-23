/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets1;

import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;
import java.util.List; 

public class TicketController  {

    private GestorDeCola gestorCola = new GestorDeCola();
    private Ticket ticketActual;


    @FXML
    private ListView<String> listaTickets;
    @FXML
    private TextArea descripcionArea;
    @FXML
    private Label labelTicketActual;
    


    @FXML
    private void AgregarTicket() {
        String desc = descripcionArea.getText();
        if (!desc.isEmpty()) {
            Ticket nuevo = new Ticket(generarId(), desc);
            gestorCola.agregarTicket(nuevo);
            actualizarLista();
        }
    }

    @FXML
    private void AtenderTicket() {
        ticketActual = gestorCola.atenderTicket();
        if (ticketActual != null) {
            labelTicketActual.setText("Atendiendo ticket ID: " + ticketActual.getId());
            descripcionArea.setText(ticketActual.getDescripcion());
        }
        actualizarLista();
    }

    @FXML
    private void GuardarCambio() {
        if (ticketActual != null) {
            ticketActual.actualizarDescripcion(descripcionArea.getText());
        }
    }

    @FXML
    private void DeshacerCambio() {
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
        return (int)(Math.random() * 10000);
    }
      public static void main(String[] args) {
        launch(args);
        
    }
}
