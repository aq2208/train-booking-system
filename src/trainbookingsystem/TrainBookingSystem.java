/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trainbookingsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class TrainBookingSystem {

    /**
     * @param args the command line arguments
     */
    
    static TrainLinkedList trainList = new TrainLinkedList();
    static PassengerLinkedList passengerList = new PassengerLinkedList();
    static BookingLinkedList bookingList = new BookingLinkedList();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Train Booking System ---");
            System.out.println("1.1 Load train data from file");
            System.out.println("1.2 Input & add train to end");
            System.out.println("1.3 Display trains");
            System.out.println("2.1 Load passenger data from file");
            System.out.println("2.2 Input & add passenger to end");
            System.out.println("2.3 Display passengers");
            System.out.println("3.1 Load bookings from file");
            System.out.println("3.2 Add new booking");
            System.out.println("3.3 Display bookings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1.1":
                    loadTrainsFromFile("trains.txt");
                    break;
                case "1.2":
                    System.out.print("Enter tcode, name, dstation, astation, dtime, atime, seat, booked: ");
                    String[] t = scanner.nextLine().split(",");
                    trainList.addToEnd(new TrainNode(t[0], t[1], t[2], t[3], Double.parseDouble(t[4]), Double.parseDouble(t[5]), Integer.parseInt(t[6]), Integer.parseInt(t[7])));
                    break;
                case "1.3":
                    trainList.display();
                    break;
                case "2.1":
                    loadPassengersFromFile("passengers.txt");
                    break;
                case "2.2":
                    System.out.print("Enter pcode, name, phone: ");
                    String[] p = scanner.nextLine().split(",");
                    passengerList.addToEnd(new PassengerNode(p[0], p[1], p[2]));
                    break;
                case "2.3":
                    passengerList.display();
                    break;
                case "3.1":
                    loadBookingsFromFile("bookings.txt");
                    break;
                case "3.2":
                    System.out.print("Enter bcode, pcode, seat: ");
                    String[] b = scanner.nextLine().split(",");
                    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                    bookingList.addToEnd(new BookingNode(b[0], b[1], today, 0, Integer.parseInt(b[2])));
                    break;
                case "3.3":
                    bookingList.display();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    
    static void loadTrainsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                trainList.addToEnd(new TrainNode(t[0], t[1], t[2], t[3], Double.parseDouble(t[4]), Double.parseDouble(t[5]), Integer.parseInt(t[6]), Integer.parseInt(t[7])));
            }
        } catch (IOException e) {
            System.out.println("Error reading trains file.");
        }
    }

    static void loadPassengersFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                passengerList.addToEnd(new PassengerNode(p[0], p[1], p[2]));
            }
        } catch (IOException e) {
            System.out.println("Error reading passengers file.");
        }
    }

    static void loadBookingsFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] b = line.split(",");
                bookingList.addToEnd(new BookingNode(b[0], b[1], b[2], Integer.parseInt(b[3]), Integer.parseInt(b[4])));
            }
        } catch (IOException e) {
            System.out.println("Error reading bookings file.");
        }
    }
    
}
