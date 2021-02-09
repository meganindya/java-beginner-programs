import java.util.*;
class patt
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter order of matrix : ");
        int n=sc.nextInt();
        System.out.print("Enter element 1 : ");
        char n1=sc.next().charAt(0);
        System.out.print("Enter element 2 : ");
        char n2=sc.next().charAt(0);
        System.out.print("Enter element 3 : ");
        char n3=sc.next().charAt(0);
        char A[][]=new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                if(j==i || (n-j-1)==i)      A[i][j]=n3;
                else if(j>i && j<(n-i-1) && i<=n/2)   A[i][j]=n1;
                else if(j<i && j>(n-i-1) && i>=n/2)   A[i][j]=n1;
                else                        A[i][j]=n2;
            }
        System.out.println();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(A[i][j]+"  ");
            System.out.println();
        }
    }
}