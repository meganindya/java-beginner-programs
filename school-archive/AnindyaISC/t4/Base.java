import java.util.*;
class Base
{
    int r,x;
    double to_dec(String no,double s,int i,int b)
    {
        if(no.equals(""))
            return s;
        else
        {
            int l=no.length();
            String z=no.substring(l-1);
            if(z.charAt(0)>=65 && z.charAt(0)<=70)
                x=(int)z.charAt(0)-55;
            else
                x=Integer.parseInt(z);
            return to_dec(no.substring(0,l-1),s+(x*Math.pow(b,i)),i+1,b);
        }
    }
    String to_other(int no,String res,int b)
    {
        if(no!=0)
        {
            r=no%b;
            if(r>9)
                return to_other(no/b,(char)(r+55)+res,b);
            else
                return to_other(no/b,r+res,b);
        }
        else
            return res;
    }
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number to be converted : ");
        String n=sc.next();
        System.out.print("Enter its base : ");
        int b1=sc.nextInt();
        System.out.print("Enter required base : ");
        int b2=sc.nextInt();
        Base ob=new Base();
        int dec=(int)ob.to_dec(n,0,0,b1);
        String ans=ob.to_other(dec,"",b2);
        System.out.print("\n"+n+"(base "+b1+") = "+ans+"(base "+b2+")");
    }
}
/**
 * Output
 * ------
Enter number to be converted : 4F
Enter its base : 16
Enter required base : 8

4F(base 16) = 117(base 8)
 */