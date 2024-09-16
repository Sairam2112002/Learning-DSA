package queue;

import linkedList.LinkedListImplementation;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementationUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class QueueDS {
        Node start;
        Node end;
        int size;

        QueueDS() {
            this.size = 0;
            this.start = this.end = null;
        }

        void enqueue(int data) {
            Node newNode = new Node(data);
            if(start == null && end == null) {
                start = end = newNode;
            } else {
                end.next = newNode;
                end = newNode;
            }
            size += 1;
        }

        int dequeue() {
            if(start == null && end == null) {
                throw new RuntimeException("Queue is empty");
            } else if(start == end) {
                int poppedData = start.data;
                start = end = null;
                size -= 1;
                return poppedData;
            } else {
                assert start != null;
                int poppedData = start.data;
                start = start.next;
                size -= 1;
                return poppedData;
            }
        }

        int peek() {
            if(start == null && end == null) {
                throw new RuntimeException("Queue is empty");
            } else {
                assert start != null;
                return start.data;
            }
        }

        void printQueue() {
            if(start == null && end == null) {
                System.out.println("Queue is empty");
                return;
            }
            Node currentNode = start;
            while(currentNode != null) {
                System.out.print(currentNode.data + " -> ");
                currentNode = currentNode.next;
            }
            System.out.print("NULL" + "\n");
        }

        int getSize() {
            return size;
        }
    }

    public static void main(String[] args) {
        QueueDS queue = new QueueDS();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue.peek());
        queue.printQueue();
        System.out.println(queue.dequeue());
        queue.printQueue();
        System.out.println(queue.dequeue());
        queue.printQueue();
        System.out.println(queue.dequeue());
        queue.printQueue();
        System.out.println(queue.dequeue());
        queue.printQueue();
        System.out.println(queue.dequeue());
        queue.printQueue();
    }
}
