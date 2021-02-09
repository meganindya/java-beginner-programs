package One_D_Sorting;

import java.io.*;
class array
{
    public static void main(int n) throws IOException
    {
        int p = 10, max = 0, j, i, x = 0;
        int a[] = new int[n];
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        System.out.println("Enter Array -"); 
        for(i = 0; i<n;i++)
         a[i]= Integer.parseInt(br.readLine());
        System.out.println("Sorted Array -"); 
        for(i = 0; i<n;i++)
        {
            for(j=0;j<n;j++)
            {
             if(a[j]>max&&a[j]!=Integer.MIN_VALUE)
             {
                max = a[j];
                x = j;
             }
            }
            p = x;
            a[x] = Integer.MIN_VALUE;
            System.out.println(max + " is rank " + (i+1));
            max = 0;
        }
    }
}