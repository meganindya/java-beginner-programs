package Two_Dimensional_Array;
import java.io.*;
class saddle_point
{
    public static void main(int m, int n) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i, j, k = 0, t = 0, r=0, z=0, p;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int a[][] = new int [m][n];
        for(i=0;i<m;i++)
            for(j=0;j<n;j++)
               a[i][j] = Integer.parseInt(br.readLine());
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
               System.out.print(a[i][j]+ "\t");
             System.out.println("");
        }
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i][j]<min)
                {
                    min = a[i][j];
                    k=j;
                 }
                if(a[i][j]>max)
                {
                    max = a[i][j];
                    r = j;
                }   
            }
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for(p=0;p<m;p++)
            {
                if(a[p][k]>max)
                {
                    max = a[p][k];
                    t = p;
                }
                if(a[p][r]<min)
                {
                    min = a[p][r];
                    z = p;
                }
            }
            if(t==i)
            System.out.println("Saddle pt = " + "(" + t + "," + k + ") and the element = " + a[t][k]);
            if(z==i)
            System.out.println("Saddle pt = " + "(" + z + "," + r + ") and the element = " + a[z][r]);
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
        }
    }
}