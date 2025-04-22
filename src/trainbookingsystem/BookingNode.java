/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

import java.text.SimpleDateFormat;

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

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(data.getOdate());
        return data.getBcode() + "," + data.getPcode() + "," + formattedDate + "," + data.getPaid() + "," + data.getSeat();
    }
}
