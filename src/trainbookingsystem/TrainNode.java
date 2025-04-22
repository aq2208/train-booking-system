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
    Train data;

    TrainNode next;

    public TrainNode() {}

    public TrainNode(Train data) {
        this.data = data;
        this.next = null;
    }

    public TrainNode(Train data, TrainNode next) {
        this.data = data;
        this.next = next;
    }

    public Train getData() {
        return data;
    }

    public void setData(Train data) {
        this.data = data;
    }

    public TrainNode getNext() {
        return next;
    }

    public void setNext(TrainNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data.getTcode() + "," + data.getName() + "," + data.getDstation() + "," + data.getAstation() + "," + data.getDtime() + "," + data.getAtime() + "," + data.getSeat() + "," + data.getBooked();
    }
}
