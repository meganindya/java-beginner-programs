package One_D_Sorting;

class Pendulum
{
   public static void main(int a[])
   {
       int t, p, k=0, min = Integer.MAX_VALUE, r, i, j, m;
       int n = a.length;
       for(i=0;i<n;i++)
          if(a[i]<min)
          {
              min = a[i];
              k = i;
            }
       t = a[n/2];
       a[n/2] = a[k];
       a[k] = t;
       p = a[n/2];
       min = Integer.MAX_VALUE;
       for(i = 2;i<=n;i++)
       {
           for(j=0;j<n;j++)
           {
               if(a[j]<min&&a[j]>p)
               {
                   min = a[j];
                   k=j;
                }
            }
           p = min;
           r = n/2 + (int)Math.pow(-1,i-1)*i/2;
           t = a[r];
           a[r] = a[k];
           a[k] = t;
           min = Integer.MAX_VALUE;
        }
       for(i=0;i<n;i++)
         System.out.print(a[i]+" ");
    }
}