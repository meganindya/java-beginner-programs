import java.io.*;
class Spiral_matrix
{
    public static void main(String args[])throws IOException
    {
        int i,j,c=1;
        InputStreamReader x=new InputStreamReader(System.in);
        BufferedReader y=new BufferedReader(x);
        System.out.println("enter the dimension of your array");
        int n;
        n=Integer.parseInt(y.readLine());
        int a[][]=new int[n][n];
        int r=0,s=n-1;
        for(i=0;i < n;i++)
        {
            for(j=r;j < s;j++)
            {
                a[i][j]=c;
                c++;
            }
            for(j=r;j<=s-1;j++)
            {
                a[j][s]=c;
                c++;
            }
            for(j=s;j>=r;j--)
            {
                a[s][j]=c;
                c++;
            }
            for(j=(s-1);j>r;j--)
            {
                a[j][i]=c;
                c++;
            }
            r++;
            s--;
        }
        System.out.println("Spiral Matrix:");
        for(i=0;i < n;i++)
        {
            for(j=0;j < n;j++)
            {
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
}