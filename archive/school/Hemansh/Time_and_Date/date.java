package Time_and_Date;

import java.io.*;
class date
{
    public static void main(int n)
    {
        int l, k, m, j, r = 0, i, z=0;
        if(n/10000>=1)
        {
            l = n%10000;
            System.out.println(l);
            k = n/10000;
            System.out.println(k);
            m = k%365;
            System.out.println(m);
            j = k/365;
            System.out.println(j);
            String s[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            int a[] = {0,31,59,90,120,151,181,212,243,273,304,334,365};
            System.out.println(l+j);
            if((l+j)%4==0)
            {
                for(i=2;i<13;i++)
                  a[i]++;
            }
            for(i=0;i<11;i++)
            {
                if(m>a[i]&&m<a[i+1])
                {
                    r = m - a[i];
                    System.out.println(i);
                    System.out.println(r);
                    break;
                }
                else if(m==a[i])
                {
                    r = a[i]-a[i-1];
                    z = 1;
                    System.out.println(i);
                    System.out.println(r);
                    break;                    
                }
            }
            if(z==1)
              i--;
            System.out.println(r+" "+s[i]+" "+(l+j));
        }
    }
}
            