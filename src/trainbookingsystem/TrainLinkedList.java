/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trainbookingsystem;

/**
 *
 * @author DELL
 */
public class TrainLinkedList {
    TrainNode head;

    public void addToEnd(TrainNode train) {
        if (head == null) {
            head = train;
        } else {
            TrainNode current = head;
            while (current.next != null) current = current.next;
            current.next = train;
        }
    }

    public void display() {
        TrainNode current = head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }
}
