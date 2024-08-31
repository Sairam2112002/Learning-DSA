package linkedList;

import java.util.LinkedList;

public class LinkedListImplementation {
    Node head;
    int size;

    LinkedListImplementation() {
        size = 0;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    // Insert at start
    void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node currentNode = head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
    }

    // Delete first
    void deleteFirst() {
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        head = head.next;
        size--;
    }

    // Delete last
    void deleteLast() {
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        } else if(head.next == null) {
            head = null;
            size--;
            return;
        }

        Node secondLastNode = head;
        Node currentNode = head.next;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
        size--;
    }

    // Print linked list
    void printLinkedList() {
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node currentNode = head;
        while(currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("NULL" + "\n");
    }

    // Get size of linked list
    int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListImplementation linkedList = new LinkedListImplementation();
        linkedList.addFirst(47);
        linkedList.addFirst(46);
        linkedList.addLast(48);
        linkedList.addLast(49);
        linkedList.addFirst(45);
        linkedList.addFirst(44);
        linkedList.addLast(50);
        linkedList.printLinkedList();
        System.out.println(linkedList.getSize());

        linkedList.deleteFirst();
        linkedList.deleteLast();
        linkedList.printLinkedList();
        System.out.println(linkedList.getSize());

        LinkedList<Integer> integers = new LinkedList<>();
    }
}
