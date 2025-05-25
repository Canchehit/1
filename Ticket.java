package sistematickets1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author luisa
 */
import java.util.Stack;

public class Ticket {
    private int id;
    private String descripcion;
    private Stack<String> historial = new Stack<>();
    private String conexion;

    public Ticket(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getconexion() {
        return conexion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void actualizarDescripcion(String nueva) {
        historial.push(this.descripcion); // guarda el anterior
        this.descripcion = nueva;
    }

    public void deshacerCambio() {
        if (!historial.isEmpty()) {
            this.descripcion = historial.pop();
        }
    }

   

    

}


    
    

