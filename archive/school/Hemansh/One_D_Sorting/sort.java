package One_D_Sorting;

import java.io.*;
class sort
{
    public static void main() throws IOException
    {
        int p = 10, max = 0, j, i, x = 0;
        int a[] = new int[10];
        BufferedReader br = new BufferedReader( new InputStreamReader( System.in));
        System.out.println("Enter Array -"); 
        for(i = 0; i<10;i++)
         a[i]= Integer.parseInt(br.readLine());
        System.out.println("Sorted Array -"); 
        for(i = 0; i<10;i++)
        {
            for(j=0;j<10;j++)
            {
             if(a[j]>max&&j!=p&&a[j]!=Integer.MIN_VALUE)
             {
                max = a[j];
                x = j;
             }
            }
            p = x;
            a[x] = Integer.MIN_VALUE;
            System.out.println(max);
            max = 0;
        }
    }
}
/*
Enter Array -
3
2
6
5
3
1
3
5
6
7
Sorted Array -
7
6
6
5
5
3
3
3
2
1

Enter Array -
23
56
34
2
12
12
46
42
12
64
Sorted Array -
64
56
46
42
34
23
12
12
12
2
 */
            