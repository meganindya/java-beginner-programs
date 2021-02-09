package Number_Systems;

import java.io.*;
class parity
{
    public static void main(int n) throws IOException
    {
        long k, m = 0, t = 0, p, temp;
        int i, j, l;
        long a[] = new long[n];
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        System.out.println("Enter Array -"); 
       for(i = 0; i<n;i++)
           a[i]= Long.parseLong(br.readLine());
       for ( i= 0;i<n;i++)
       {
           if(digits(a[i])%8==0&&digits(a[i])<=16)
           {
               k = digits(a[i])/8;
               temp = a[i];
               for(j=1;j<=k;j++)
               {
                   p = temp%(long)Math.pow(10,8);
                   for(l=1;l<=8;l++)
                   {
                       if(p%10==1)
                       t++;
                       p/=10;
                    }
                   if(t%2!=0)
                   m++;
                   temp = temp/(long)Math.pow(10,8);
                   t = 0;
                }
               System.out.println("There are " + m + " errors");
               m = 0;
            }
            else
            System.out.println("Invalid");
        }
    }
    public static long digits(long n) throws IOException
    {
        long temp = n, s = 0;
        while(temp>0)
        {
            temp/=10;
            s++;
        }
        return s;
    }
}
        