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
    private Set<String> phoneSet = new HashSet<>();

    public void addLast(String pcode, String name, String phone) {
        if (!isValidData(pcode, name, phone)) {
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
        phoneSet.add(phone);
    }

    private boolean isValidData(String pcode, String name, String phone) {
        if (pcode == null || pcode.isEmpty() || name == null || name.isEmpty() || phone == null || phone.isEmpty()) {
            System.out.println("ERROR: Invalid data");
            return false;
        }

        if (pcodeSet.contains(pcode)) {
            System.out.println("ERROR: pcode existed");
            return false;
        }

        if (phoneSet.contains(phone)) {
            System.out.println("ERROR: phone existed");
            return false;
        }

        return true;
    }

    public void display() {
        PassengerNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    public void loadFromFile() {
        String fileName = "/Users/nguyenanhquan/Documents/coding/csd201/train-booking-system/src/trainbookingsystem/passengers.txt";
        head = null;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                this.addLast(fields[0], fields[1], fields[2]);
            }
            System.out.println("Loaded passengers from file");
        } catch (IOException e) {
            System.out.println("Error reading passengers file");
        }
    }

    public void saveToFile() {
        String fileName = "/Users/nguyenanhquan/Documents/coding/csd201/train-booking-system/src/trainbookingsystem/passengers_save.txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            PassengerNode current = head;
            while (current != null) {
                bw.write(current.toString());
                bw.newLine();
                current = current.next;
            }
            System.out.println("Saved passengers to file");
        } catch (IOException e) {
            System.out.println("Error writing passengers file");
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
        System.out.println("Passenger not found");
    }

    public void searchTrainsByPcode(String pcode, BookingLinkedList bookingList, TrainLinkedList trainList) {
        PassengerNode currentPassenger = head;
        while (currentPassenger != null) {
            if (currentPassenger.data.getPcode().equals(pcode)) {
                System.out.println("Passenger data: ");
                System.out.println(currentPassenger.toString());

                System.out.println("Train data: ");
                BookingNode bookingCurrent = bookingList.head;
                while (bookingCurrent != null) {
                    if (bookingCurrent.data.getPcode().equals(pcode)) {
                        TrainNode trainCurrent = trainList.head;
                        while (trainCurrent != null) {
                            if (trainCurrent.data.getTcode().equals(bookingCurrent.data.getBcode())) {
                                System.out.println(trainCurrent.toString());
                            }
                            trainCurrent = trainCurrent.next;
                        }
                        // return;
                    }
                    bookingCurrent = bookingCurrent.next;
                }

                return;
            }
            currentPassenger = currentPassenger.next;
        }
        System.out.println("No bookings found for this passenger");
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
        System.out.println("Deleted passenger successful");
    }

    public void searchByName(String name) {
        PassengerNode currentP = head;
        while (currentP != null) {
            if (currentP.data.getName().equalsIgnoreCase(name)) {
                System.out.println(currentP.toString());
                return;
            }
            currentP = currentP.next;
        }

        System.out.println("Passenger not found.");
    }
}
