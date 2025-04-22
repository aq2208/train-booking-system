/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DELL
 */
public class BookingLinkedList {
    BookingNode head;

    public void addLast(String bcode, String tcode, String pcode, int seat) {
        // Booking newBooking = new Booking(bcode, tcode, pcode, seat);
        Booking newBooking = new Booking();
        BookingNode newNode = new BookingNode(newBooking);

        if (head == null) {
            head = newNode;
        } else {
            BookingNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        BookingNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    public void loadFromFile() {
        String fileName = "bookings.txt";
        head = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                this.addLast(fields[0], fields[1], fields[2], Integer.parseInt(fields[3]));
            }
            System.out.println("Loaded bookings from file.");
        } catch (IOException e) {
            System.out.println("Error reading bookings file.");
        }
    }

    public void saveToFile() {
        String fileName = "bookings.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            BookingNode current = head;
            while (current != null) {
                bw.write(current.data.toString());
                bw.newLine();
                current = current.next;
            }
            System.out.println("Saved bookings to file.");
        } catch (IOException e) {
            System.out.println("Error writing bookings file.");
        }
    }

    public void deleteByBcode(String bcode) {
        if (head == null)
            return;

        if (head.data.getBcode().equals(bcode)) {
            head = head.next;
            return;
        }

        BookingNode current = head;
        while (current.next != null) {
            if (current.next.data.getBcode().equals(bcode)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void deleteByPcode(String pcode) {
        while (head != null && head.data.getPcode().equals(pcode)) {
            head = head.next;
        }

        BookingNode current = head;
        while (current != null && current.next != null) {
            if (current.next.data.getPcode().equals(pcode)) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }
}
