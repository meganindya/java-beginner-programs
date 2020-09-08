package Two_Dimensional_Array;
import java.io.*;
class Wondrous_Square
 {
  int arr[][],arr1[];;
  int n,i,j,x=0,r,c;
  int flag;
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  public void take()throws Exception
  {
   System.out.println("\nEnter the size of array(row and column same):");
   n=Integer.parseInt(br.readLine().trim());
   arr=new int[n][n];
   arr1=new int[2*n];
   for(i=0;i< n;i++)
   {
   for(j=0;j< n;j++)
   {
     System.out.println("\nEnter the value:");
     arr[i][j]=Integer.parseInt(br.readLine());
     }
     }
   System.out.println("\nThe matrix is\n"); 
   for(i=0;i< n;i++)
     {
     r=0;
     c=0;
      for(j=0;j< n;j++)
      {
      System.out.print(arr[i][j]+" ");
       r=r+arr[i][j];
       c=c+arr[j][i];
       }
        System.out.println();
       arr1[x]=r;
       arr1[x+n-1]=c;
       x++;
       r = 0;
       c = 0;
       }
   for(i=0;i< x;i++)
       {
        if(arr1[i]!= 0.5 * n * (n*n + 1))
        break;
        }
   if(i==x)
        System.out.println("YES IT REPRESENTS A WONDROUS SQUARE.");
    else
        System.out.println("IT IS NOT A WONDROUS SQUARE.");
        System.out.println("PRIME  ROW  COLUMN");
   for(i=0;i< n;i++)
        {
         for(j=0;j< n;j++)
         {
         if(prime(arr[i][j]))
         System.out.println(arr[i][j]+ "   "+i+ "   "+j);
        }
        }
        }
  private boolean prime(int no)
        {
         int index;
         for(index=2;index< no;index++)
         {
          if(no%index==0)
          break;
         }
         if(index==no)
         return true;
         else
         return false;
        }
  public static void main(String args[])throws Exception
     {
      Wondrous_Square ob=new Wondrous_Square();
      ob.take();
      }
      }
/*
 Output -
- Enter the size of array(row and column same):
4

Enter the value:
16

Enter the value:
15

Enter the value:
1

Enter the value:
2

Enter the value:
6

Enter the value:
4

Enter the value:
10

Enter the value:
14

Enter the value:
9

Enter the value:
8

Enter the value:
12

Enter the value:
5

Enter the value:
3

Enter the value:
7

Enter the value:
11

Enter the value:
13

The matrix is

16 15 1 2 
6 4 10 14 
9 8 12 5 
3 7 11 13 
YES IT REPRESENTS A WONDROUS SQUARE.
PRIME  ROW  COLUMN
2      0    3
5      2    3
3      3    0
7      3    1
11     3    2
13     3    3

- Enter the size of array(row and column same):
4

Enter the value:
2

Enter the value:
1

Enter the value:
4

Enter the value:
23

Enter the value:
12

Enter the value:
45

Enter the value:
6

Enter the value:
74

Enter the value:
21

Enter the value:
33

Enter the value:
22

Enter the value:
11

Enter the value:
36

Enter the value:
47

Enter the value:
42

Enter the value:
1

The matrix is

2 1 4 23 
12 45 6 74 
21 33 22 11 
36 47 42 1 
IT IS NOT A WONDROUS SQUARE.
PRIME  ROW  COLUMN
2      0    0
23     0    3
11     2    3
47     3    1 
*/