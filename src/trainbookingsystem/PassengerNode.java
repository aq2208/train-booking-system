/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

/**
 *
 * @author DELL
 */
public class PassengerNode {

    String pcode, name, phone;
    
    PassengerNode next;

    public PassengerNode(String pcode, String name, String phone) {
        this.pcode = pcode;
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return pcode + "," + name + "," + phone;
    }
}
