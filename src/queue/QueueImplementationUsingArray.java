package queue;

public class QueueImplementationUsingArray {
    static class QueueDS {
        int[] queue;
        int size;
        int currentSize;
        int start;
        int end;

        QueueDS(int size) {
            this.queue = new int[size];
            this.size = size;
            this.start = this.end = -1;
            this.currentSize = 0;
        }

        void push(int element) {
            if(currentSize == size) {
                throw new RuntimeException("Queue is at its capacity");
            } else if(currentSize == 0) {
                start = end = 0;
                queue[start] = element;
                currentSize += 1;
            } else {
                end = (end + 1) % size;
                queue[end] = element;
                currentSize += 1;
            }
        }

        int pop() {
            if(currentSize == 0) {
                throw new RuntimeException("Queue is empty");
            } else if(currentSize == 1) {
                int element = queue[start];
                start = end = -1;
                currentSize = 0;
                return element;
            } else {
                int element = queue[start];
                start = (start + 1) % size;
                currentSize -= 1;
                return element;
            }
        }

        int peek() {
            if(currentSize == 0) {
                throw new RuntimeException("Queue is empty");
            } else {
                return queue[start];
            }
        }

        int getSize() {
            return currentSize;
        }

        void printQueue() {
            for(int i = start; i <= end; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueueDS queueDS = new QueueDS(5);
        queueDS.push(10);
        queueDS.push(20);
        queueDS.push(30);
        queueDS.push(40);
        queueDS.push(50);
        queueDS.printQueue();
        System.out.println(queueDS.pop());
        queueDS.printQueue();
        System.out.println(queueDS.pop());
        queueDS.printQueue();
        System.out.println(queueDS.pop());
        queueDS.printQueue();
    }
}
