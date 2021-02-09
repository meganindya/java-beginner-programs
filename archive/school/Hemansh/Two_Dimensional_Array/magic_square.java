package Two_Dimensional_Array;
class magic_square
{
    public static void main(int n)
    {
        int i = 0, j = n/2, z = 1, x, y, m, p;
        int k = n*n;
        int a[][] = new int [n][n];
        for(x = 0;x<n;x++)
          for(y = 0;y<n;y++)
             a[x][y] = 0;
        a[0][n/2] = 1;
        while(z<=k)
        {
             m = i-1;
             p = j+1;
             if(m>=0&&p<n&&a[m][p]==0)
             {
                 i = m;
                 j = p;

                }
             else if(m<0&&p<n&&a[n+m][p]==0)
             {
                 i = n + m;
                 j = p;
                }
             else if(m>=0&&p>=n&&a[m][n-p]==0)
             {
                 i = m;
                 j = n - p;
                }
             else if(m<0&&p>=n&&a[n+m][n-p]==0)
             {
                 i = n + m;
                 j = n - p;
                }
             else
             {
                 i++;
                 if(i>=n)
                 i = n - i;
                }
             a[i][j] = ++z; 
            }
        a[0][n/2] = 1;        
        for(x = 0;x<n;x++)
          {
            for(y = 0;y<n;y++)
               System.out.print(a[x][y]+ "\t");
            System.out.println("");
        }
    }
}
/*
Input - 3
Output - 
8 1 6 
3 5 7 
4 9 2

Input - 5
Output - 
17 24  1  8 15 
23  5  7 14 16 
 4  6 13 20 22 
10 12 19 21  3 
11 18 25  2  9

Input - 7
Output -  
30 39 48  1 10 19 28 
38 47  7  9 18 27 29 
46  6  8 17 26 35 37 
5  14 16 25 34 36 45 
13 15 24 33 42 44  4 
21 23 32 41 43  3 12 
22 31 40 49  2 11 20

Input - 11
Output - 
68 81 94 107 120 1 14 27 40 53 66 
80 93 106 119 11 13 26 39 52 65 67 
92 105 118 10 12 25 38 51 64 77 79 
104 117 9 22 24 37 50 63 76 78 91 
116 8 21 23 36 49 62 75 88 90 103 
7 20 33 35 48 61 74 87 89 102 115 
19 32 34 47 60 73 86 99 101 114 6 
31 44 46 59 72 85 98 100 113 5 18 
43 45 58 71 84 97 110 112 4 17 30 
55 57 70 83 96 109 111 3 16 29 42 
56 69 82 95 108 121 2 15 28 41 54 

 */
            
