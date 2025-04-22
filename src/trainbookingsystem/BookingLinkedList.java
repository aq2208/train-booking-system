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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class BookingLinkedList {
    BookingNode head;

    public void addLast(String bcode, String pcode, String odateStr, String paidStr, String seatStr) {
        try {
            int paid = Integer.parseInt(paidStr);
            int seat = Integer.parseInt(seatStr);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date odate = formatter.parse(odateStr);

            Booking newBooking = new Booking(bcode, pcode, odate, paid, seat);
            // Booking newBooking = new Booking();
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
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return;
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
        String fileName = "/Users/nguyenanhquan/Documents/coding/csd201/train-booking-system/src/trainbookingsystem/bookings.txt";
        head = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                this.addLast(fields[0], fields[1], fields[2], fields[3], fields[4]);
            }
            System.out.println("Loaded bookings from file.");
        } catch (IOException e) {
            System.out.println("Error reading bookings file.");
        }
    }

    public void saveToFile() {
        String fileName = "/Users/nguyenanhquan/Documents/coding/csd201/train-booking-system/src/trainbookingsystem/bookings_save.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            BookingNode current = head;
            while (current != null) {
                bw.write(current.toString());
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

    public void bookTrain(String tcode, String pcode, TrainLinkedList trainList, PassengerLinkedList passengerList) {
        if (tcode == null || tcode.isEmpty() || pcode == null || pcode.isEmpty()) {
            System.out.println("ERROR: Invalid booking details.");
            return;
        }

        TrainNode trainCurrent = trainList.head;
        while (trainCurrent != null) {
            if (trainCurrent.data.getTcode().equals(tcode)) {
                if (trainCurrent.data.getSeat() >= trainCurrent.data.getBooked() + 1) {
                    Booking newBooking = new Booking(tcode, pcode, new Date(), 0, 1);
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
                    trainCurrent.data.setBooked(trainCurrent.data.getBooked() + 1);
                    System.out.println("Booking successful.");
                } else {
                    System.out.println("ERROR: Not enough seats available.");
                }
                return;
            }
            trainCurrent = trainCurrent.next;
        }
        System.out.println("ERROR: Train not found.");
    }

    public void payBooking(String tcode, String pcode) {
        if (tcode == null || tcode.isEmpty() || pcode == null || pcode.isEmpty()) {
            System.out.println("ERROR: Invalid booking details.");
            return;
        }

        BookingNode current = head;
        while (current != null) {
            if (current.data.getBcode().equals(tcode) && current.data.getPcode().equals(pcode)) {
                if (current.data.getPaid() == 1) {
                    System.out.println("ERROR: Booking already paid.");
                    return;
                }
                current.data.setPaid(1);
                System.out.println("Pay booking successful.");
                return;
            }
            current = current.next;
        }
        System.out.println("ERROR: Booking not found.");
    }

    public void sortByTcodeAndPcode() {
        if (head == null || head.next == null) {
            return;
        }

        BookingNode current = head;
        BookingNode index = null;
        Booking temp;

        while (current != null) {
            index = current.next;

            while (index != null) {
                if (current.data.getBcode().compareTo(index.data.getBcode()) > 0) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}
