import java.util.*;
class Postfix_eval
{
    int n,top,Stack[];
    Scanner c=new Scanner(System.in);
    void main()
    {
        System.out.print("Enter Stack Length : ");
        int l=c.nextInt(); 
        Stack=new int[l];
        top=-1;
        System.out.print("\n"+"Enter Postfix Expression : "); 
        String s=c.next()+c.nextLine();
        Scanner sc=new Scanner(s);
        while(sc.hasNext())
        {
            if(sc.hasNextInt())
            {
                n=sc.nextInt();
                push(n);
                continue;
            }
            int b=pop();
            int a=pop();
            char op=sc.next().charAt(0);
            if      (op == '+') push(a + b);
            else if (op == '-') push(a - b);
            else if (op == '*') push(a * b);
            else if (op == '/') push(a / b);
            else if (op == '%') push(a % b);
        }
        System.out.print("\n"+"Infix Expression is : "+pop());
    }
    void push(int j)
    {
        Stack[++top]=j;
    }     
    int pop()
    {
        return Stack[top--];
    }
}
/**
 * Output
 * ------
Enter Stack Length : 15

Enter Postfix Expression : 15 10 4 2 * - *

Infix Expression is : 30
 */