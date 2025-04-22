/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trainbookingsystem;

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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Train Booking System ---");

            System.out.println("1.1. Load train data from file");
            System.out.println("1.2. Input & add train to the end");
            System.out.println("1.3. Display all train data");
            System.out.println("1.4. Save train list to file");
            System.out.println("1.5. Search train by tcode");
            System.out.println("1.6. Delete train by tcode");
            System.out.println("1.7. Sort train list by tcode");
            System.out.println("1.8. Input & add train to beginning");
            System.out.println("1.9. Add train before position k");
            System.out.println("1.10. Delete train at position k");
            System.out.println("1.11. Search train by name");
            System.out.println("1.12. Search train by tcode and list passengers who booked it");

            System.out.println("\n2.1. Load passenger data from file");
            System.out.println("2.2. Input & add passenger to the end");
            System.out.println("2.3. Display all passenger data");
            System.out.println("2.4. Save passenger list to file");
            System.out.println("2.5. Search passenger by pcode");
            System.out.println("2.6. Delete passenger by pcode");
            System.out.println("2.7. Search passenger by name");
            System.out.println("2.8. Search passenger by pcode and list all trains booked");

            System.out.println("\n3.1. Load booking data from file");
            System.out.println("3.2. Book train");
            System.out.println("3.3. Display all booking data");
            System.out.println("3.4. Save booking list to file");
            System.out.println("3.5. Sort bookings by tcode and pcode (descending)");
            System.out.println("3.6. Pay booking by tcode and pcode");

            System.out.println("\n0. Exit");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1.1":
                        trainList.loadFromFile();
                        break;
                    case "1.2":
                        System.out.print("Enter tcode,name,dstation,astation,dtime,atime,seat,booked: ");
                        String[] fields = scanner.nextLine().split(",");
                        trainList.addFirst(fields[0], fields[1], fields[2], fields[3], Double.parseDouble(fields[4]),
                                Double.parseDouble(fields[5]), Integer.parseInt(fields[6]),
                                Integer.parseInt(fields[7]));
                        break;
                    case "1.3":
                        trainList.display();
                        break;
                    case "1.4":
                        trainList.saveToFile();
                        break;
                    case "1.5":
                        System.out.print("Enter tcode to search: ");
                        String tcode = scanner.nextLine();
                        trainList.searchByTcode(tcode);
                        break;
                    case "1.6":
                        System.out.print("Enter tcode to delete: ");
                        String tcodeToDelete = scanner.nextLine();
                        trainList.deleteByTcode(tcodeToDelete, bookingList);
                        break;
                    case "1.7":
                        trainList.sortByTcode();
                        break;
                    case "1.8":
                        System.out.print("Enter tcode,name,dstation,astation,dtime,atime,seat,booked: ");
                        String[] fields1 = scanner.nextLine().split(",");
                        trainList.addFirst(fields1[0], fields1[1], fields1[2], fields1[3],
                                Double.parseDouble(fields1[4]), Double.parseDouble(fields1[5]),
                                Integer.parseInt(fields1[6]), Integer.parseInt(fields1[7]));
                        break;
                    case "1.9":
                        System.out.print("Enter tcode,name,dstation,astation,dtime,atime,seat,booked: ");
                        String[] fields2 = scanner.nextLine().split(",");
                        System.out.print("Enter position to add before: ");
                        String position = scanner.nextLine();
                        trainList.addBeforePosition(Integer.parseInt(position), fields2[0], fields2[1], fields2[2],
                                fields2[3], Double.parseDouble(fields2[4]), Double.parseDouble(fields2[5]),
                                Integer.parseInt(fields2[6]), Integer.parseInt(fields2[7]));
                        break;
                    case "1.10":
                        System.out.println("Enter kth position to delete: ");
                        String k = scanner.nextLine();
                        trainList.deleteAtPosition(k);
                        break;
                    case "1.11":
                        System.out.print("Enter name to search: ");
                        String name = scanner.nextLine();
                        trainList.searchByName(name);
                        break;
                    case "1.12":
                        System.out.print("Enter tcode to search: ");
                        String tcode2 = scanner.nextLine();
                        trainList.searchBookedByTcode(tcode2, bookingList, passengerList);
                        break;

                    case "2.1":
                        passengerList.loadFromFile();
                        break;
                    case "2.2":
                        System.out.print("Enter pcode,name,phone: ");
                        String[] p = scanner.nextLine().split(",");
                        passengerList.addLast(p[0], p[1], p[2]);
                        break;
                    case "2.3":
                        passengerList.display();
                        break;
                    case "2.4":
                        passengerList.saveToFile();
                        break;
                    case "2.5":
                        System.out.print("Enter pcode to search: ");
                        String pcode = scanner.nextLine();
                        passengerList.searchByPcode(pcode);
                        break;
                    case "2.6":
                        System.out.print("Enter pcode to delete: ");
                        String pcodeToDelete = scanner.nextLine();
                        passengerList.deleteByPcode(pcodeToDelete, bookingList);
                        break;
                    case "2.7":
                        System.out.print("Enter name to search: ");
                        String pname = scanner.nextLine();
                        passengerList.searchByName(pname);
                        break;
                    case "2.8":
                        System.out.print("Enter pcode: ");
                        String pc = scanner.nextLine();
                        passengerList.searchTrainsByPcode(pc, bookingList, trainList);
                        break;

                    case "3.1":
                        bookingList.loadFromFile();
                        break;
                    case "3.2":
                        System.out.print("Enter bcode,tcode: ");
                        String[] bookFields = scanner.nextLine().split(",");
                        bookingList.bookTrain(bookFields[0], bookFields[1], trainList, passengerList);
                        break;
                    case "3.3":
                        bookingList.display();
                        break;
                    case "3.4":
                        bookingList.saveToFile();
                        break;
                    case "3.5":
                        bookingList.sortByTcodeAndPcode();
                        break;
                    case "3.6":
                        System.out.print("Enter tcode and pcode to pay: ");
                        String[] payInput = scanner.nextLine().split(",");
                        bookingList.payBooking(payInput[0], payInput[1]);
                        break;

                    case "0":
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception ex) {
                System.out.println("ERROR: " + ex.getLocalizedMessage());
            }
        }
    }

}
