import java.util.*;
class palindrome
{
    void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number : ");
        String n=sc.nextLine();
        System.out.print("Enter base : ");
        int b=sc.nextInt(),i;
        String sum=n;
        for(i=1;i<=10;i++)
        {
            if(sum.equals(reverse(sum)))
            {
                System.out.println(n+" is palindrome at step "+i);
                System.out.println("Palindrome number : "+sum);
                break;
            }
            else
            {
                sum=add(sum,reverse(sum),b);
            }
        }
        if(i==11)
        {
            System.out.println(n+" is not palindrome on 10 revisions");
            System.out.println("Last sum : "+sum);
        }
    }
    String reverse(String s)
    {
        StringBuffer sb=new StringBuffer(s);
        sb.reverse();
        return sb.toString();
    }
    String tobase(String n,int b)
    {
        int f=Integer.parseInt(n),r;String t="";
        do
        {
            r=f%b;f=f/b;
            if(r>9)
            t=Character.toString((char)(r+55))+t;
            else
            t=r+t;
        }while(f>=b);
        if(f==0) return t;
        else if(f>0 && f<10) return f+t;
        else return (char)(f+55)+t;
    }
    String todec(String n,int b)
    {
        int f=0,x;
        int l=n.length();
        for(int i=0;i<l;i++)
        {
            if(n.charAt(l-i-1)>=65 && n.charAt(l-i-1)<=70)
                x=(int)(n.charAt(l-i-1))-55;
            else
                x=(int)(n.charAt(l-i-1))-48;
            f+=(x*(Math.pow(b,i)));
        }
        return Integer.toString(f);
    }
    String add(String m,String n,int b)
    {
        int n1=Integer.parseInt(todec(m,b));
        int n2=Integer.parseInt(todec(n,b));
        int ds=n1+n2;
        return tobase(Integer.toString(ds),b);
    }
}
/**
 * Output
 * ------
 * Enter number : A23
 * Enter base : 16
 * A23 is palindrome at step 2
 * Palindrome number : D4D
 * ------
 * Enter number : A345
 * Enter base : 12
 * A345 is palindrome at step 4
 * Palindrome number : 9B4B9
 * ------
 * Enter number : 196
 * Enter base : 10
 * 196 is not palindrome on 10 revisions
 * Last sum : 18211171
 */