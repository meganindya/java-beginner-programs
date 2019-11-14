/**
 * Stack implementation using ArrayList
 */


import java.util.*;
import static java.lang.System.*;

class Stack {
    // driver function
    public static void main(String args[]) {
        Stack s = new Stack(3);

        // push
        out.println(s.push(5) == 0 ? "5 pushed" : "Stack full");
        out.println(s.push(1) == 0 ? "1 pushed" : "Stack full");
        out.println(s.push(4) == 0 ? "4 pushed" : "Stack full");
        out.println(s.push(3) == 0 ? "3 pushed" : "Stack full");


        try {
            out.println("Stack top: " + s.peek());
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }


        out.print("Stack: ");
        displayStack(s);


        // pop
        try {
            out.println(s.pop() + " popped");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }

        try {
            out.println(s.pop() + " popped");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }

        try {
            out.println(s.pop() + " popped");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }

        try {
            out.println(s.pop() + " popped");
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }
    }


    // displays stack from top to bottom
    // this method is not explicitly part of stack class
    static void displayStack(Stack s) {
        if (s.isEmpty()) {
            System.out.println("Stack empty");
            return;
        }

        for (Integer i : s.stack)
            System.out.print(i.intValue() + " ");
        System.out.println();
    }



    // instance variables
    ArrayList<Integer> stack = new ArrayList<>();
    int top = -1;
    int capacity;

    // constructors
    Stack() {
        this.capacity = Integer.MAX_VALUE;
    }

    Stack(int capacity) {
        this.capacity = capacity;
    }


    // returns whether stack is empty or not
    boolean isEmpty() {
        return (top == -1 ? true : false);
    }

    // returns whether stack is full or not
    boolean isFull() {
        return (top == capacity - 1 ? true : false);
    }

    // push function: adds new element on top of stack
    // returns -1 on full, else 0
    int push(int value) {
        if (isFull())
            return -1;
        
        stack.add(Integer.valueOf(value));
        top++;
        
        return 0;
    }

    // pop function: returns top entry while removing it
    // throws Exception if stack is empty
    int pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack empty");
        
        int value = stack.get(top);
        stack.remove(top);
        top--;

        return value;
    }

    // pop function: returns top entry without removing it
    // throws Exception if stack is empty
    int peek() throws Exception {
        if (isEmpty())
            throw new Exception("Stack empty");

        return stack.get(top);
    }
}