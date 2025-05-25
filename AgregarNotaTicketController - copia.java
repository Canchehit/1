/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sistematickets1;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author luisa
 */
public class AgregarNotaTicketController extends Application  {

    
    private TableView<Ticket> ticketTable;
    private TextArea noteTextArea;
    private Button addNoteButton, attachButton,btnVolver;
    private File attachedFile;
    private ObservableList<Ticket> ticketList;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Agregar Nota al Ticket");

        ticketList = FXCollections.observableArrayList(
                new Ticket("001", "Pendiente"),
                new Ticket("002", "En proceso")
        );

  
        ticketTable = new TableView<>();
        TableColumn<Ticket, String> ticketNumberColumn = new TableColumn<>("Número de Ticket");
        ticketNumberColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTicketNumber()));

        TableColumn<Ticket, String> ticketStatusColumn = new TableColumn<>("Estado");
        ticketStatusColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        ticketTable.getColumns().addAll(ticketNumberColumn, ticketStatusColumn);
        ticketTable.setItems(ticketList);

       
        noteTextArea = new TextArea();
        noteTextArea.setPromptText("Escribe tu nota aquí...");

      
        addNoteButton = new Button("Agregar Nota");
        addNoteButton.setOnAction(event -> addNoteToTicket());

   
        attachButton = new Button("Adjuntar Archivo");
        attachButton.setOnAction(event -> attachFile());
        
        btnVolver = new Button("Volver al Menú");
        btnVolver.setOnAction(e -> volverAlMenu(primaryStage));


        VBox layout = new VBox(10, ticketTable, noteTextArea, attachButton, addNoteButton);
        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //Boton para bolver al menu
     private void volverAlMenu(Stage primaryStage) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Volver al Menú");
        alerta.setContentText("Funcionalidad para cambiar de escena aún no implementada.");
        alerta.showAndWait(); 
     }
    

   
    private void addNoteToTicket() {
        Ticket selectedTicket = ticketTable.getSelectionModel().getSelectedItem();
        if (selectedTicket != null) {
            String noteContent = noteTextArea.getText();
            if (!noteContent.isEmpty()) {
               
                selectedTicket.addNote(noteContent, attachedFile);

           
                noteTextArea.clear();
                attachedFile = null;

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nota agregada con éxito", ButtonType.OK);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "La nota no puede estar vacía.", ButtonType.OK);
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Selecciona un ticket primero.", ButtonType.OK);
            alert.show();
        }
    }
     @FXML
    private void volverAlMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

 
    private void attachFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todos los Archivos", "*.*"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            attachedFile = file;
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Archivo adjunto: " + file.getName(), ButtonType.OK);
            alert.show();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


class Ticket {
    private String ticketNumber;
    private String status;
    private String notesHistory = "";
    

    public Ticket(String ticketNumber, String status) {
        this.ticketNumber = ticketNumber;
        this.status = status;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public String getStatus() {
        return status;
    }

    public void addNote(String noteContent, File attachedFile) {
        notesHistory += "Nota: " + noteContent + "\n";
        if (attachedFile != null) {
            notesHistory += "Archivo adjunto: " + attachedFile.getName() + "\n";
            
       
        }
    }
}

   


