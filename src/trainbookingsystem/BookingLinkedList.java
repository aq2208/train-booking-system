/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

/**
 *
 * @author DELL
 */
public class BookingLinkedList {
    BookingNode head;

    public void addToEnd(BookingNode booking) {
        if (head == null) {
            head = booking;
        } else {
            BookingNode current = head;
            while (current.next != null) current = current.next;
            current.next = booking;
        }
    }

    public void display() {
        BookingNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }
}
