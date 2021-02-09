/**
 * Returns whether a string is properly bracketed syntactically
 * (considering string has no spaces)
 */


import java.util.*;

class WellBracketed {
    public static void main(String args[]) {
        String str1 = "(A(B(CX)(DW)Z)Y)";
        String str2 = "MNO(A[B{CX}Y]Z)";
        String str3 = "(AB{CX)}";


        System.out.println(str1 + " is " +
            (isBracketed(str1) ? "well bracketed" : "not well bracketed"));
        
        System.out.println(str2 + " is " +
            (isBracketed(str2) ? "well bracketed" : "not well bracketed"));
        
        System.out.println(str3 + " is " +
            (isBracketed(str3) ? "well bracketed" : "not well bracketed"));
    }

    // returns if passed string is well bracketed
    static boolean isBracketed(String s) {
        boolean bracketed = true;

        Stack<Character> brackets = new Stack<>();

        loop:
        for (char c : s.toCharArray()) {
            // if ( / { / [ encountered, push to stack
            if (c == '(' || c == '{' || c == '[')
                brackets.push(Character.valueOf(c));
            
            // if ) / } / ] encountered, check stack top
            if (c == ')' || c == '}' || c == ']') {
                char t = brackets.peek();
                
                // if top is ( / { / [, pop it
                if (c == ')' && t == '(' ||
                    c == '}' && t == '{' ||
                    c == ']' && t == '[')
                    brackets.pop();

                // else string isn't well bracketed
                else {
                    bracketed = false;
                    break loop;
                }
            }
        }

        if (!brackets.empty())
            bracketed = false;


        return bracketed;
    }
}
