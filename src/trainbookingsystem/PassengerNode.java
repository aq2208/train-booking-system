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
    Passenger data;
    
    PassengerNode next;

    public PassengerNode() {}

    public PassengerNode(Passenger data) {
        this.data = data;
        this.next = null;
    }

    public PassengerNode(Passenger data, PassengerNode next) {
        this.data = data;
        this.next = next;
    }
}
