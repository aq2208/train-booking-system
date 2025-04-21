/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

/**
 *
 * @author DELL
 */
public class TrainNode {

    String tcode, name, dstation, astation;
    double dtime, atime;
    int seat, booked;
    
    TrainNode next;

    public TrainNode(String tcode, String name, String dstation, String astation, double dtime, double atime, int seat, int booked) {
        this.tcode = tcode;
        this.name = name;
        this.dstation = dstation;
        this.astation = astation;
        this.dtime = dtime;
        this.atime = atime;
        this.seat = seat;
        this.booked = booked;
    }

    @Override
    public String toString() {
        return tcode + "," + name + "," + dstation + "," + astation + "," + dtime + "," + atime + "," + seat + "," + booked;
    }
}
