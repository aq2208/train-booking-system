/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

/**
 *
 * @author DELL
 */
public class Train {
    private String tcode;

    private String name;

    private String dstation;

    private String astation;

    private double dtime;

    private double atime;

    private int seat;
    
    private int booked;

    public String getTcode() {
        return tcode;
    }
    public void setTcode(String tcode) {
        this.tcode = tcode;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDstation() {
        return dstation;
    }
    public void setDstation(String dstation) {
        this.dstation = dstation;
    }
    public String getAstation() {
        return astation;
    }
    public void setAstation(String astation) {
        this.astation = astation;
    }
    public double getDtime() {
        return dtime;
    }
    public void setDtime(double dtime) {
        this.dtime = dtime;
    }
    public double getAtime() {
        return atime;
    }
    public void setAtime(double atime) {
        this.atime = atime;
    }
    public int getSeat() {
        return seat;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
    public int getBooked() {
        return booked;
    }
    public void setBooked(int booked) {
        this.booked = booked;
    }
    
    public Train() {}

    public Train(String tcode, String name, String dstation, String astation, double dtime, double atime, int seat, int booked) {
        this.tcode = tcode;
        this.name = name;
        this.dstation = dstation;
        this.astation = astation;
        this.dtime = dtime;
        this.atime = atime;
        this.seat = seat;
        this.booked = booked;
    }
    
}
