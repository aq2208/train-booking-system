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

    String bcode, pcode;
    String odate; // Format: yyyy-MM-dd
    int paid;     // 0 - not paid, 1 - paid
    int seat;
    
    BookingNode next;

    public BookingNode(String bcode, String pcode, String odate, int paid, int seat) {
        this.bcode = bcode;
        this.pcode = pcode;
        this.odate = odate;
        this.paid = paid;
        this.seat = seat;
    }

    @Override
    public String toString() {
        return bcode + "," + pcode + "," + odate + "," + paid + "," + seat;
    }
}
