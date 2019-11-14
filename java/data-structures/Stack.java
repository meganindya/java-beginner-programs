/**
 * Stack implementation using ArrayList
 */


import java.util.*;

class Stack {
    // driver function
    public static void main(String args[]) {
        Stack s = new Stack(3);

        System.out.println(s.push(5) == 0 ? "5 pushed" : "Stack full");
        System.out.println(s.push(1) == 0 ? "1 pushed" : "Stack full");
        System.out.println(s.push(4) == 0 ? "4 pushed" : "Stack full");
        System.out.println(s.push(3) == 0 ? "3 pushed" : "Stack full");

        System.out.println("Stack top: " + (s.peek() != Integer.MIN_VALUE ? s.peek() : "Stack empty"));

        System.out.print("Stack: ");
        displayStack(s);

        int temp;
        System.out.println((temp = s.pop()) != Integer.MIN_VALUE ? temp + " popped" : "Stack empty");
        System.out.println((temp = s.pop()) != Integer.MIN_VALUE ? temp + " popped" : "Stack empty");
        System.out.println((temp = s.pop()) != Integer.MIN_VALUE ? temp + " popped" : "Stack empty");
        System.out.println((temp = s.pop()) != Integer.MIN_VALUE ? temp + " popped" : "Stack empty");

        System.out.println("Stack top: " + (s.peek() != Integer.MIN_VALUE ? s.peek() : "Stack empty"));
    }


    // displays stack from top to bottom
    // this method is not explicitly part of stack class
    static void displayStack(Stack s) {
        if (s.isEmpty()) {
            System.out.println("Empty");
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

    // push function: returns -1 on full, else 0
    // adds new element on top of stack
    int push(int value) {
        if (isFull())
            return -1;
        
        stack.add(Integer.valueOf(value));
        top++;
        
        return 0;
    }

    // pop function: returns Integer.MIN_VALUE on empty, else top value
    // removes top entry
    int pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        
        int value = stack.get(top);
        stack.remove(top);
        top--;

        return value;
    }

    // peek function: returns Integer.MIN_VALUE on empty, else top value
    // doesn't remove top entry
    int peek() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return stack.get(top);
    }
}