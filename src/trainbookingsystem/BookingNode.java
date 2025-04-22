/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

/**
 *
 * @author DELL
 */
public class BookingNode {
    Booking data;
    
    BookingNode next;

    public BookingNode() {}

    public BookingNode(Booking data) {
        this.data = data;
        this.next = null;
    }

    public BookingNode(Booking data, BookingNode next) {
        this.data = data;
        this.next = next;
    }
}
