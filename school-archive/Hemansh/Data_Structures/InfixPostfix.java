package Data_Structures;
//By Recursive Descent Parsing
class InfixPostfix
{  static String input;
   static int    current = 0;
   public static void main ( String[] args )
   {  String postfix;
      if ( args.length == 0 )
      {  java.util.Scanner console = new java.util.Scanner (System.in);
         System.out.print ("Enter the expression:  ");
         input = console.nextLine();
      }
      else
      {  input = args[0];
         System.out.println("Expression:  " + input + '\n');
      }
      postfix = expr();
      System.out.println("Equivalent postfix expression:  " + postfix);
   }
   static String expr()
   {  char nxt;
      String result;
      result = term();          
      if ( current >= input.length() )
         return result;
      nxt  = input.charAt(current);
      while ( nxt == '+' | nxt == '-' )
      {  current++;               
         result += term() + nxt;  
         if ( current >= input.length() )
            break;
         nxt  = input.charAt(current);
      }
      return result;
   }
   static String term()
   {  char nxt;
      String result;

      result = factor();
      if ( current >= input.length() )
         return result;
      nxt  = input.charAt(current);
      while ( nxt == '*' | nxt == '/' )
      {  current++;          
         result += factor() + nxt;
         if ( current >= input.length() )
            break;
         nxt  = input.charAt(current);
      }
      return result;
   }
   static String factor()
   {  char nxt;
      String result;

      result = primary();         
      if ( current >= input.length() )
         return result;
      nxt  = input.charAt(current);
      if ( nxt == '^' )
      {  current++;               
         result += factor() + nxt;
      }
      return result;
   }
   static String primary()
   {  char nxt;
      String result;
      if ( current >= input.length() )
         throw new RuntimeException("End of expr:  " + input);
      nxt = input.charAt(current++); 
      if ( nxt == '(' )
      {  result = expr();
         if ( current >= input.length() )
            throw new RuntimeException("No close paren in " + input);
         nxt = input.charAt(current++);
         if ( nxt != ')' )
            throw new RuntimeException("No close paren in " + input);
      }
      else if ( Character.isLetter(nxt) )
         result = Character.toString(nxt);
      else
         throw new RuntimeException (nxt + " is illegal in " + input);
      return result;
   }
}
/*
InfixPostfix.main({ });
Enter the expression:  A+B*C/Y*(X+Q/(A+B))^X-V*C
Equivalent postfix expression:  ABC*Y/XQAB+/+X^*+VC*-
InfixPostfix.main({ });
Enter the expression:  X^Y*Z-A+B*C/D-M
Equivalent postfix expression:  XY^Z*A-BC*D/+M-
InfixPostfix.main({ });
Enter the expression:  A+B-C+D-E
Equivalent postfix expression:  AB+C-D+E-
 */