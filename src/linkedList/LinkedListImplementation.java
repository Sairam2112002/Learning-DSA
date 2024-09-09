package linkedList;

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
            size += 1;
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

    // Insert at index
    void addAtIndex(int data, int index) {
        if(index > size-1) {
            System.out.println("Index out of bounds, enter a valid index");
            return;
        }

        if(index == 0) {
            addFirst(data);
            return;
        } else if(index == size - 1) {
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node currentNode = head;
        int currentIndex = 0;
        while(currentIndex != index-1) {
            currentNode = currentNode.next;
            currentIndex++;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }

    // Delete first
    void deleteFirst() {
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        head = head.next;
        size -= 1;
    }

    // Delete last
    void deleteLast() {
        if(head == null) {
            System.out.println("Linked list is empty");
            return;
        } else if(head.next == null) {
            head = null;
            size -= 1;
            return;
        }

        Node secondLastNode = head;
        Node currentNode = head.next;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
        size -= 1;
    }

    // Delete at index
    void deleteAtIndex(int index) {
        if(index > size-1) {
            System.out.println("Index out of bounds, enter a valid index");
            return;
        }

        if(index == 0) {
            deleteFirst();
            return;
        } else if(index == size - 1) {
            deleteLast();
            return;
        }

        Node currentNode = head;
        Node previousNode = currentNode;
        int currentIndex = 0;
        while(currentIndex != index) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        previousNode.next = currentNode.next;
        size -= 1;
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
        linkedList.addAtIndex(100, 3);
        linkedList.addAtIndex(200, 1);
        linkedList.printLinkedList();
        System.out.println(linkedList.getSize());

        linkedList.deleteFirst();
        linkedList.deleteLast();
        linkedList.printLinkedList();
        System.out.println(linkedList.getSize());

        linkedList.deleteAtIndex(2);
        linkedList.printLinkedList();
        System.out.println(linkedList.getSize());
    }
}
