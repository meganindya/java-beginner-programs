import java.util.*;
class long_comp_range
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number : ");
        int n=sc.nextInt(),x=0,y=0,b=n,a=n;
        for(int i=n-1;i>=1;i--)
            if(prime(i))
            {   
                x=a-i-1;a=i;
                if(x>y && x!=0) {y=x;b=i;}
            }
        if(b+y+1==n && prime(n)==false)   y++;
        System.out.println("Longest composite range : ");
        for(int i=b+1;i<=b+y;i++)    System.out.print(i+"\t");
    }
    static boolean prime(int n)
    {
        int c=0;
        for(int i=1;i<=n;i++)
            if(n%i==0)
                c++;
        if(c==2)    return true;
        else        return false;
    }
}