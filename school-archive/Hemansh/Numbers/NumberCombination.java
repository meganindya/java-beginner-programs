package Numbers;

import java.io.*;
class NumberCombination
{
    int no,sum=0,k,j,i;
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public void takeNumber()throws Exception
    {
        System.out.println("Enter the number:");
        no=Integer.parseInt(br.readLine());
        for(i=1;i<=no/2+1;i++)
        {
            sum=0;

            for(j=i;j<=no/2+1;j++)
            {
                sum=sum+j;
                if (sum==no)
                    break;
            }
            if(j<=no/2+1)
            {
                for(k=i;k<=j;k++)
                    System.out.print(" "+k);
                System.out.println();
            }
        }
    }

    public static void main(String args[])throws Exception
    {
        NumberCombination obj=new NumberCombination ();
        obj.takeNumber();
    }
}
/*
Output -

Enter the number:
27
2 3 4 5 6 7
8 9 10
13 14
Enter the number:
111
16 17 18 19 20 21
36 37 38
55 56
Enter the number:
2056
121 122 123 124 125 126 127 128 129 130 131 132 133 134 135 136
Enter the number:
1234
307 308 309 310
Enter the number:
456
15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33
21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36
151 152 153
 */

