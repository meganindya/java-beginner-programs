import java.util.*;
class RecNumbers
{
    int n;
    public int prime(int factor)
    {
        if(factor>(n/2)) return 1;
        else if((n%factor)==0) return 0;
        else return prime(factor+1);
    }
    public int palindrome(String st)
    {
        if(st.length()<=1) return 1;
        if(st.charAt(0)==st.charAt(st.length()-1))
          return palindrome(st.substring(1,st.length()-1));
        else return 0;
    }
    public int armstrong(int no,int s)
    {
        if(no!=0) return armstrong((no/10),(s+(int)Math.pow((no%10),3)));
        if(s==n) return 1;
        else return 0;
    }
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("for PRIME CHECK                  enter 1");
        System.out.println("for PALINDROME STRING CHECK      enter 2");
        System.out.println("for ARMSTRONG NO. CHECK          enter 3");
        System.out.print("\nEnter your choice : ");
        int choice=sc.nextInt();
        RecNumbers ob=new RecNumbers(); int p=0;
        switch(choice)
        {
            case 1:
                System.out.print("\f"+"Enter the number : ");
                ob.n=sc.nextInt();
                p=ob.prime(2);
                if(p==1)
                  System.out.println("\n"+ob.n+" is a Prime number!");
                else
                  System.out.println("\n"+ob.n+" is not a Prime number!");
            break;
            case 2:
                System.out.print("\f"+"Enter the string : ");
                String s=sc.next()+sc.nextLine();
                p=ob.palindrome(s.toUpperCase());
                if(p==1)
                  System.out.println("\n"+s+" is a Palindrome string!");
                else
                  System.out.println("\n"+s+" is not a Palindrome string!");
            break;
            case 3:
                System.out.print("\f"+"Enter the number : ");
                ob.n=sc.nextInt();
                p=ob.armstrong(ob.n,0);
                if(p==1)
                  System.out.println("\n"+ob.n+" is an Armstrong number!");
                else
                  System.out.println("\n"+ob.n+" is not an Armstrong number!");
            break;
            default:
                System.out.println("Wrong choice!!");
        }
    }
}
/**
 * Output
 * ------
for PRIME CHECK                  enter 1
for PALINDROME STRING CHECK      enter 2
for ARMSTRONG NO. CHECK          enter 3

Enter your choice : 1

Enter the number : 13

13 is a Prime number!
-----------------------------------------
Enter your choice : 2

Enter the string : TerrorismsirorreT

TerrorismsirorreT is a Palindrome string!
-----------------------------------------
Enter your choice : 3

Enter the number : 153

153 is an Armstrong number!
 */
