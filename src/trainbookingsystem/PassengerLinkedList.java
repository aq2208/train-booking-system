/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

/**
 *
 * @author DELL
 */
public class PassengerLinkedList {
    PassengerNode head;

    public void addToEnd(PassengerNode passenger) {
        if (head == null) {
            head = passenger;
        } else {
            PassengerNode current = head;
            while (current.next != null) current = current.next;
            current.next = passenger;
        }
    }

    public void display() {
        PassengerNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }
}
