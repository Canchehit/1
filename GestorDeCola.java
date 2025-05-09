/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistematickets1;

import java.util.LinkedList;
import java.util.Queue;

public class GestorDeCola {
     private Queue<Ticket> colaTickets = new LinkedList<>();

    public void agregarTicket(Ticket ticket) {
        colaTickets.offer(ticket);
    }

    public Ticket atenderTicket() {
        return colaTickets.poll(); // Devuelve y elimina el primero
    }

    public Queue<Ticket> obtenerCola() {
        return colaTickets;
    }

    public boolean hayTickets() {
        return !colaTickets.isEmpty();
    }
}

