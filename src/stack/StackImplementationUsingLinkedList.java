package stack;

public class StackImplementationUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class StackDS {
        Node top;
        int size;

        StackDS() {
            this.top = null;
            this.size = 0;
        }

        void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            size += 1;
        }

        int pop() {
            if(top == null) {
                throw new RuntimeException("Stack is empty");
            } else if(size == 1) {
                int poppedData = top.data;
                top = null;
                return poppedData;
            } else {
                int poppedData = top.data;
                Node newTop = top.next;
                top.next = null;
                top = newTop;
                size -= 1;
                return poppedData;
            }
        }

        int peek() {
            if(top == null) {
                throw new RuntimeException("Stack is empty");
            } else {
                return top.data;
            }
        }

        int getSize() {
            return size;
        }

        void printStack() {
            if(top == null) {
                System.out.println("Linked list is empty");
                return;
            }
            Node topNode = top;
            while(topNode != null) {
                System.out.print(topNode.data + " -> ");
                topNode = topNode.next;
            }
            System.out.print("NULL" + "\n");
        }
    }

    public static void main(String[] args) {
        StackDS stack = new StackDS();
        stack.push(4);
        stack.printStack();
        stack.push(2);
        stack.printStack();
        stack.push(3);
        stack.printStack();
        stack.push(1);
        stack.printStack();
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.printStack();
        System.out.println(stack.pop());
        stack.printStack();
        System.out.println(stack.pop());
        stack.printStack();
        System.out.println(stack.pop());
    }
}
