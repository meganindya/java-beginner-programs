package Time_and_Date;

import java.io.*;
class party
{
    public static void main(int n) throws IOException
    {
        int i, j, k, l = 0, m = 0, t = 0;
        String str = "", wrd = "", str2 = "";
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        String a[] = new String[n];
        for(i = 0; i<n;i++)
        {
            System.out.println("Enter the free days, seperated with commas, for guest #" + (i+1));
            a[i] = br.readLine();
            a[i] = a[i] + ",";
        }
        for(i = 0; i<a[0].length();i++)
        {
            if(a[0].charAt(i)==',')
            {
                str = a[0].substring(m,i);
                //System.out.println(str);
                for(j=1;j<n;j++)
                {
                    for(k=0;k<a[j].length();k++)
                    {
                        if(a[j].charAt(k)==',')
                        {
                            //System.out.println(l+" "+k);
                            str2 = a[j].substring(l,k);
                            if(str.equals(str2))
                            {
                                t++;
                                break;
                            }
                            l = k + 1;
                        }
                    }
                    l = 0;
                }
                if(t==n-1)
                wrd = wrd + str + ",";
                t = 0;
                m = i+1;
            }
        }
        System.out.println("The possible days are - ");
        System.out.println(wrd);
    }
}
