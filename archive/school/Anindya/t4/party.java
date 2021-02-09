import java.util.*;
class party
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of guests : ");
        int n=sc.nextInt(),x=0;
        char a[][]=new char[n][31];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter dates for guest "+(i+1));
            int p=sc.nextInt();
            if(p!=0)
            {
                do
                    {a[i][p-1]='*';p=sc.nextInt();}
                while(p!=0);
            }
        }
        System.out.println("Available dates : ");
        for(int i=0;i<31;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {if(a[j][i]=='*')  c++;}
            if(c==n)
            {    System.out.print((i+1)+"\t");x++;}
        }
        if(x==0)
            System.out.print("No suitable date available");
    }
}
/**
 * Output
 * ------
 * Enter no of guests : 2
 * Enter dates for guest 1
 * 7|8|9|13|16|22|27|31|0
 * Enter dates for guest 2
 * 9|16|21|30|31|0
 * Available dates : 
 * 9	16	31	
 */