package Numbers;
class Armstrong
{
    public static int sum_of_digits(int n, int k)
    {
        if(n==0)
          return 0;
        else
          return power(n%10,k) + sum_of_digits(n/10,k);
     }
    public static int power(int n, int k)
    {
        if(k==0)
         return 1;
        else
         return n*power(n,k-1);
        }
    public static void main(int m, int n)
    {
        for(int i=m;i<n;i++)
        {
            int temp =i;
            int k = 0;
            while(temp>0)
            {
                temp/=10;
                k++;
            }
            if(sum_of_digits(i,k)==i)
              System.out.println(i);
            }
        }
    }
 /*
   Armstrong.main(0, 1000000);
   0
   1
   2
   3   
   4
   5
   6
   7
   8
   9
   153
   370
   371
   407
   1634
   8208
   9474
   54748
   92727
   93084
   548834
*/