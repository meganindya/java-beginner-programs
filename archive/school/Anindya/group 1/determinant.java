import java.util.*;
class determinant
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter order of square matrix : ");
        int n=sc.nextInt();int a[][]=new int[n][n];
        System.out.println("Enter Array Elements row-wise as (a|b|c) :");
        for(int i=0;i<n;i++)
        {
            int k=0;String s=sc.next()+sc.nextLine();
            StringTokenizer st=new StringTokenizer(s,"|");
            while(st.hasMoreTokens())
                a[i][k++]=Integer.parseInt(st.nextToken());
        }
        System.out.println("\n"+"Determinant : "+deter(a,n));
    }
    static int deter(int a[][],int n)
    {
        int z=0;
        if(n==1)    return a[0][0];
        else
        {
            for(int i=0;i<n;i++)
            {
                int r[][]=new int[n-1][n-1];
                for(int m=1;m<=r.length;m++)
                {
                    int k=0;
                    for(int t=0;t<=r.length;t++)
                    {
                        if(t==i)    continue;
                        r[m-1][k++]=a[m][t];
                    }
                }
                z+=a[0][i]*Math.pow((-1),i)*deter(r,n-1);
            }
        }
        return z;
    }
}
/**
 * Output
 * ------
 * Enter order of square matrix : 3
 * Enter Array Elements row-wise as (a|b|c) :
 *   1|1|1
 *   2|1|3
 *   1|5|1
 * Determinant : -4
 */