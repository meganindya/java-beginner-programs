import java.util.*;
class mat_mult
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of columns of Matrix A : ");
        int c1=sc.nextInt(),r2=c1;
        System.out.print("Enter no of rows of Matrix A : ");
        int r1=sc.nextInt();
        System.out.print("Enter no of columns of Matrix B : ");
        int c2=sc.nextInt();
        int A[][]=new int[r1][c1],B[][]=new int[r2][c2];
        int C[][]=new int[r1][c2];
        System.out.println("\n"+"Enter elements of matrix A :");
        for(int i=0;i<r1;i++)
            for(int j=0;j<c1;j++)
                A[i][j]=sc.nextInt();
        System.out.println("\n"+"Enter elements of matrix B :");
        for(int i=0;i<r2;i++)
            for(int j=0;j<c2;j++)
                B[i][j]=sc.nextInt();
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c2;j++)
            {
                int s=0;
                for(int k=0;k<c1;k++)
                    s+=A[i][k]*B[k][j];
                C[i][j]=s;
            }
        }
        System.out.println("\n"+"Matrix A : ");
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c1;j++)
                System.out.print(A[i][j]+"\t");
            System.out.println();
        }
        System.out.println("\n"+"Matrix B : ");
        for(int i=0;i<r2;i++)
        {
            for(int j=0;j<c2;j++)
                System.out.print(B[i][j]+"\t");
            System.out.println();
        }
        System.out.println("\n"+"A X B = ");
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c1;j++)
                System.out.print(C[i][j]+"\t");
            System.out.println();
        }
    }
}
/**
 * Enter no of columns of Matrix A : 2
 * Enter no of rows of Matrix A : 2
 * Enter no of columns of Matrix B : 2
 * 
 * Enter elements of matrix A :
 * 1
 * 2
 * 3
 * 4
 * 
 * Enter elements of matrix B :
 * 1
 * 0
 * 0
 * 1
 * 
 * Matrix A : 
 * 1	2	
 * 3	4	
 * 
 * Matrix B : 
 * 1	0	
 * 0	1	
 * 
 * A X B = 
 * 1	2	
 * 3	4	
 */