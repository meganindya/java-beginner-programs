package Two_Dimensional_Array;
import java.io.*;
class spiral_matrix
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
/*
enter the dimension of your array
4
Spiral Matrix:
1	2	3	4	
12	13	14	5	
11	16	15	6	
10	9	8	7	

enter the dimension of your array
5
Spiral Matrix:
1	2	3	4	5	
16	17	18	19	6	
15	24	25	20	7	
14	23	22	21	8	
13	12	11	10	9	

enter the dimension of your array
3
Spiral Matrix:
1	2	3	
8	9	4	
7	6	5	

enter the dimension of your array
7
Spiral Matrix:
1	2	3	4	5	6	7	
24	25	26	27	28	29	8	
23	40	41	42	43	30	9	
22	39	48	49	44	31	10	
21	38	47	46	45	32	11	
20	37	36	35	34	33	12	
19	18	17	16	15	14	13	
 */


