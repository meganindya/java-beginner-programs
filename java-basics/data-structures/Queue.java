/**
 * Circular Queue implementation using ArrayList
 */


import java.util.*;
import static java.lang.System.*;

class Queue {
    // driver function
    public static void main(String args[]) {
        Queue q = new Queue(3);

        // enqueue
        out.println(q.enqueue(5) == 0 ? "5 enqueued" : "Queue full");
        out.println(q.enqueue(1) == 0 ? "1 enqueued" : "Queue full");
        out.println(q.enqueue(4) == 0 ? "4 enqueued" : "Queue full");
        out.println(q.enqueue(3) == 0 ? "3 enqueued" : "Queue full");


        try {
            out.println("Queue front: " + q.peek());
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }


        out.println("Queue: " + q.displayQueue());


        // dequeue
        try {
            out.println(q.dequeue() + " dequeued");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }

        try {
            out.println(q.dequeue() + " dequeued");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }


        out.println("Queue: " + q.displayQueue());

        out.println(q.enqueue(7) == 0 ? "7 enqueued" : "Queue full");

        out.println("Queue: " + q.displayQueue());


        try {
            out.println(q.dequeue() + " dequeued");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }

        try {
            out.println(q.dequeue() + " dequeued");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }

        try {
            out.println(q.dequeue() + " dequeued");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }
    }



    // instance variables
    ArrayList<Integer> queue = new ArrayList<>();
    int front = 0;
    int rear = -1;
    int elemCount = 0;
    int capacity;

    // constructors
    Queue() {
        this.capacity = Integer.MAX_VALUE;
    }

    Queue(int capacity) {
        this.capacity = capacity;
    }


    // returns whether queue is empty or not
    boolean isEmpty() {
        return (rear == front - 1 ? true : false);
    }

    // returns whether queue is full or not
    boolean isFull() {
        return (elemCount == capacity ? true : false);
    }

    // enqueue function: adds new element at rear of queue
    // returns -1 on full, else 0
    int enqueue(int value) {
        if (isFull())
            return -1;
        
        
        rear = (rear + 1) % capacity;
        try {
            queue.set(rear, Integer.valueOf(value));
        }
        catch (Exception e) {
            queue.add(rear, Integer.valueOf(value));
        }
        elemCount++;
        
        return 0;
    }

    // dequeue function: returns front entry while removing it
    // throws Exception if queue is empty
    int dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("Queue empty");
        
        int value = queue.get(front);
        front = (front + 1) % capacity;
        elemCount--;

        return value;
    }

    // peek function: returns top entry without removing it
    // throws Exception if stack is empty
    int peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack empty");

        return queue.get(front);
    }

    // returns stack elements as String from front to rear
    String displayQueue() {
        if (isEmpty())
            return "Queue empty";

        StringBuilder s = new StringBuilder();
        int temp = elemCount, pos = front;
        while (temp > 0) {
            s.append(queue.get(pos) + " ");
            pos = (pos + 1) % capacity;
            temp--;
        }
        
        return s.toString().trim();
    }
}