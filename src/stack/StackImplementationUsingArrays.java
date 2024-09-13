package stack;

public class StackImplementationUsingArrays {
    static class StackDS {
        int top;
        int size;
        int[] stack;
        StackDS(int size) {
            this.stack = new int[size];
            this.top = -1;
            this.size = size;
        }

        void push(int element) {
            if(top >= size) {
                throw new RuntimeException("Stack size exceeded");
            } else {
                top += 1;
                stack[top] = element;
            }
        }

        int pop() {
            if(isEmpty()) {
                throw new RuntimeException("Stack is empty!!");
            } else {
                int poppedElement = stack[top];
                top -= 1;
                return poppedElement;
            }
        }

        int peek() {
            if(isEmpty()) {
                throw new RuntimeException("Stack is empty!!");
            } else {
                return stack[top];
            }
        }

        boolean isEmpty() {
            return top == -1;
        }

        int getSize() {
            return top + 1;
        }
    }
    public static void main(String[] args) {
        StackDS stackDS = new StackDS(10);
        stackDS.push(10);
        stackDS.push(25);
        stackDS.push(37);
        stackDS.push(47);
        stackDS.push(50);
        System.out.println(stackDS.pop());
        System.out.println(stackDS.peek());
        System.out.println(stackDS.getSize());
    }
}
