import java.util.*;
class rec
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Principal : ");
        int p=sc.nextInt();
        System.out.print("Rate : ");
        double r=sc.nextDouble();
        double s=0;double fig=0;
        System.out.println();
        for(int i=12;i>=1;i--)
        {
            s=((13-i)*p+s)*(r/(100*i));
            s=Math.round(s*100)/100.0;fig+=s;
            System.out.println("Month "+(13-i)+" : "+s);
        }
        System.out.print("\n"+"Total Interest : "+fig+"\n"+"Amount : "+(fig+(12*p)));
    }
}