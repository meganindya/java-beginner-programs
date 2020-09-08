import java.util.*;
class InfixPostfix
{
    String s;
    char stack[]; 
    int top;
    Scanner sc= new Scanner(System.in);
    public void main()
    {
        System.out.print("Enter Stack Length : ");
        int l=sc.nextInt(); 
        stack=new char[l];
        top=-1;
        System.out.print("\n"+"Enter Infix Expression : ");
        s=sc.next();
        String y="";
        char z=' ';
        s='('+ s+')';
        for(int x=0;x<s.length();x++)
        {
            z = s.charAt(x);
            if(z == '(')
                push(z);
            else if(isOperator(z))
            {
                while(precedence(stack[top])>=precedence(z))
                    y=y+pop()+" ";
                push(z);
            }   
            else if(z == ')')
            {
                while(stack[top]!='(')
                    y=y+pop()+" ";
                top=top-1;
            }
            else
            {
                if(Character.isDigit(z)&&Character.isDigit(s.charAt(x+1)))
                    y=y+z;
                else if(Character.isDigit(z)||Character.isLetter(z))
                    y=y+z+" ";
            }
        }
        System.out.println("\n"+"Postfix Expression is : "+y);
    }
    int precedence(char op)
    {
        if(op == '+' || op =='-')
            return 1;
        else if(op == '*' || op == '/')
            return 2;
        else if(op == '%' )
            return 3;
        else if(op == '^' )
            return 4;
        else
            return 0;
    }
    public boolean isOperator(char q)
    {
        if(q =='*'||q=='-'||q=='/'||q=='+'||q=='^')
            return true;
        else
            return false;
    }
    public char peek()
    { return stack[top];}
    public void push(char j)
    {
        stack[++top]=j;
    }     
    public char pop()
    {
        return stack[top--];
    }
}
/**
 * Output
 * ------
Enter Stack Length : 11

Enter Infix Expression : ((A+B)*C)/D

Postfix Expression is : A B + C * D / 
 */