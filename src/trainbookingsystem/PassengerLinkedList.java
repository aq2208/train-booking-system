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
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author DELL
 */
public class PassengerLinkedList {
    PassengerNode head;
    private Set<String> pcodeSet = new HashSet<>();

    public void addLast(String pcode, String name, String phone) {
        if (pcodeSet.contains(pcode)) {
            System.out.println("ERROR: pcode existed");
            return;
        }

        Passenger newPassenger = new Passenger(pcode, name, phone);
        PassengerNode newNode = new PassengerNode(newPassenger);
        if (head == null) {
            head = newNode;
        } else {
            PassengerNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        pcodeSet.add(pcode);
    }

    public void display() {
        PassengerNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    public void loadFromFile() {
        String fileName = "passengers.txt";
        head = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                this.addLast(fields[0], fields[1], fields[2]);
            }
            System.out.println("Loaded passengers from file.");
        } catch (IOException e) {
            System.out.println("Error reading passengers file.");
        }
    }

    public void saveToFile() {
        String fileName = "passengers.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            PassengerNode current = head;
            while (current != null) {
                bw.write(current.data.toString());
                bw.newLine();
                current = current.next;
            }
            System.out.println("Saved passengers to file.");
        } catch (IOException e) {
            System.out.println("Error writing passengers file.");
        }
    }

    public void searchByPcode(String pcode) {
        PassengerNode current = head;
        while (current != null) {
            if (current.data.getPcode().equals(pcode)) {
                System.out.println(current.toString());
                return;
            }
            current = current.next;
        }
        System.out.println("Passenger not found.");
    }

    public void deleteByPcode(String pcode, BookingLinkedList bookingList) {
        if (head == null)
            return;

        if (head.data.getPcode().equals(pcode)) {
            head = head.next;
        } else {
            PassengerNode current = head;
            while (current.next != null) {
                if (current.next.data.getPcode().equals(pcode)) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }

        // remove bookings too
        BookingNode currentBooking = bookingList.head;
        while (currentBooking != null) {
            if (currentBooking.data.getPcode().equals(pcode)) {
                bookingList.deleteByPcode(pcode);
                break;
            }
            currentBooking = currentBooking.next;
        }
        System.out.println("Deleted passenger and associated bookings.");
    }
}
