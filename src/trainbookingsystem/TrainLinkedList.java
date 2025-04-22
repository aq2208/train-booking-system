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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author DELL
 */
public class TrainLinkedList {
    private TrainNode head;

    private TrainNode tail;

    private Set<String> tcodeSet = new HashSet<>();

    public void addLast(String tcode, String name, String dstation, String astation, double dtime, double atime,
            int seat, int booked) {
        if (!validateData(tcode, name, dstation, astation, dtime, atime, seat, booked)) {
            return;
        }
        Train newTrain = new Train(tcode, name, dstation, astation, dtime, atime, seat, booked);
        TrainNode newTrainNode = new TrainNode(newTrain);
        if (head == null) {
            head = tail = newTrainNode;
        } else {
            TrainNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTrainNode;
        }

        tail = newTrainNode;
        // add tcode to set
        tcodeSet.add(tcode);
    }

    public void addFirst(String tcode, String name, String dstation, String astation, double dtime, double atime,
            int seat, int booked) {
        if (!validateData(tcode, name, dstation, astation, dtime, atime, seat, booked)) {
            return;
        }

        Train newTrain = new Train(tcode, name, dstation, astation, dtime, atime, seat, booked);
        TrainNode newTrainNode = new TrainNode(newTrain);

        if (head == null) {
            head = tail = newTrainNode;
        } else {
            newTrainNode.next = head;
            head = newTrainNode;
        }

        // add tcode to set
        tcodeSet.add(tcode);
    }

    private boolean validateData(String tcode, String name, String dstation, String astation, double dtime, double atime, int seat, int booked) {
        // tcode unique
        if (tcodeSet.contains(tcode)) {
            System.out.println("ERROR: tcode existed");
            return false;
        }

        // 0 ≤ dtime ≤ 24
        if (dtime < 0 || dtime > 24) {
            System.out.println("ERROR: dtime must be in range [0, 24]");
            return false;
        }

        // seat > 0
        if (seat <= 0) {
            System.out.println("ERROR: seat must be greater than 0");
            return false;
        }

        // 0 ≤ booked ≤ seat
        if (seat < 0 || booked < 0 || booked > seat) {
            System.out.println("ERROR: failed validate 0 ≤ booked ≤ seat");
        }

        // dtime ≤ atime ≤ 24
        if (dtime > 24 || atime > 24 || dtime > atime) {
            System.out.println("ERROR: failed validate dtime ≤ atime ≤ 24");
        }
        
        return true;
    }

    public void display() {
        TrainNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    public void loadFromFile() {
        String fileName = "/Users/nguyenanhquan/Documents/coding/csd201/train-booking-system/src/trainbookingsystem/trains.txt";

        // reset current list
        head = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                this.addLast(fields[0], fields[1], fields[2], fields[3], Double.parseDouble(fields[4]),
                        Double.parseDouble(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]));
            }

            System.out.println("Load data from file successful!");
        } catch (IOException e) {
            System.out.println("Error reading trains file.");
        }
    }

    public void saveToFile() {
        String fileName = "/Users/nguyenanhquan/Documents/coding/csd201/train-booking-system/src/trainbookingsystem/trains.txt";
        clearFile(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            TrainNode current = head;
            while (current != null) {
                writer.write(current.data.toString());
                writer.newLine();
                current = current.next;
            }

            System.out.println("Train list saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    private void clearFile(String fileName) {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            fw.write("");
        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }

    public void searchByTcode(String tcode) {
        TrainNode current = head;
        while (current != null) {
            if (current.data.getTcode().equals(tcode)) {
                System.out.println(current.toString());
                return;
            }
            current = current.next;
        }
        
        System.out.println("Train not found");
    }

    public void searchByName(String name) {
        TrainNode current = head;
        while (current != null) {
            if (current.data.getName().equals(name)) {
                System.out.println(current.toString());
                return;
            }
            current = current.next;
        }
        
        System.out.println("Train not found");
    }

    public void searchBookedByTcode(String tcode, BookingLinkedList bookingList, PassengerLinkedList passengerList) {
        System.out.println("Train data: ");

        // input tcode to be searched, then return the train data or not found; Then list all passengers who booked the train
        TrainNode current = head;
        while (current != null) {
            if (current.data.getTcode().equals(tcode)) {
                System.out.println(current.toString());
                return;
            }
            current = current.next;
        }

        System.out.println("Passenger who booked the train data: ");

        // list all passengers who booked the train
        BookingNode bookingCurrent = bookingList.head;
        while (bookingCurrent != null) {
            if (bookingCurrent.data.getBcode().equals(tcode)) {
                PassengerNode passengerCurrent = passengerList.head;
                while (passengerCurrent != null) {
                    if (passengerCurrent.data.getPcode().equals(bookingCurrent.data.getPcode())) {
                        System.out.println(passengerCurrent.toString());
                    }
                    passengerCurrent = passengerCurrent.next;
                }
                return;
            }
            bookingCurrent = bookingCurrent.next;
        }

        System.out.println("Train not found");
    }

    public void sortByTcode() {
        if (head == null) return;

        List<Train> trains = new ArrayList<>();
        TrainNode current = head;
        while (current != null) {
            trains.add(current.data);
            current = current.next;
        }

        // sort by tcode
        for (int i = 0; i < trains.size() - 1; i++) {
            for (int j = 0; j < trains.size() - i - 1; j++) {
                if (trains.get(j).getTcode().compareTo(trains.get(j + 1).getTcode()) > 0) {
                    // swap
                    Train tmp = trains.get(j);
                    trains.set(j, trains.get(j + 1));
                    trains.set(j + 1, tmp);
                }
            }
        }

        // display
        for (Train train : trains) {
            System.out.println(train.getTcode() + "," + train.getName() + "," + train.getDstation() + "," + train.getAstation() + "," + train.getDtime() + "," + train.getAtime() + "," + train.getSeat() + "," + train.getBooked());
        }
    }

    public void addBeforePosition(int k, String tcode, String name, String dstation, String astation, double dtime, double atime, int seat, int booked) {
        if (k < 0) {
            System.out.println("ERROR: k value invalid!");
            return;
        }

        if (!validateData(tcode, name, dstation, astation, dtime, atime, seat, booked)) {
            return;
        }
        
        if (k == 1) {
            // add first
            addFirst(tcode, name, dstation, astation, dtime, atime, seat, booked);
        }

        Train newTrain = new Train(tcode, name, dstation, astation, dtime, atime, seat, booked);
        TrainNode newTrainNode = new TrainNode(newTrain);

        int index = 1;
        TrainNode current = head;
        while (index < (k - 2) && current != null) {
            current = current.next;
            index++;
        }

        // index = k - 2 now

        if (index != (k - 2) || current == null) {
            System.out.println("ERROR: k element not found");
            return;
        }

        newTrainNode.next = current.next;
        current.next = newTrainNode;
        tcodeSet.add(tcode);

        System.out.println("Add before position " + k + " successful");
    }

    public void deleteByTcode(String tcode, BookingLinkedList bookingList) {
        TrainNode current = head;

        if (head == null) {
            System.out.println("Train not found");
            return;
        }

        if (current.data.getTcode().equals(tcode)) {
            // delete first
            head = current.next;
        }

        while (current.next != null) {
            if (current.next.data.getTcode().equals(tcode)) {
                current.next = current.next.next;
                System.out.println("Delete train successful!");
                return;
            }
            current = current.next;
        }

        // delete all related records in booking list
        BookingNode bookingCurrent = bookingList.head;
        while (bookingCurrent != null) {
            if (bookingCurrent.data.getBcode().equals(tcode)) {
                bookingList.deleteByBcode(tcode);
                break;
            }
            bookingCurrent = bookingCurrent.next;
        }
        
        System.out.println("Train not found");
    }

    public void deleteAtPosition(String kString) {
        int k = 0;
        try {
            k = Integer.parseInt(kString);

            if (k < 0) {
                System.out.println("ERROR: k value invalid!");
                return;
            }
        } catch (Exception ex) {
            System.out.println("ERROR: invalid input value k");
            return;
        }

        if (head == null) {
            System.out.println("ERROR: train list is empty");
            return;
        }

        if (k == 0) {
            // delete first
            head = head.next;
        }

        int index = 1;
        TrainNode current = head;
        while (index < (k - 1) && current != null) {
            current = current.next;
            index++;
        }

        // index = k - 1 now

        if (index != k - 1 || current.next == null) {
            System.out.println("ERROR: k element not found");
            return;
        }

        // index = k - 1
        current.next = current.next.next;
        System.out.printf("Delete at position %d successful\n", k);
    }

}
