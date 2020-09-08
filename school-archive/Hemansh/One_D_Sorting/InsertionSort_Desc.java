package One_D_Sorting;
class InsertionSort_Desc
{
    public static void main( int a[])
    {
        int temp, p, i;
        for(i=1;i<a.length;i++)
        {
            temp = a[i];
            p=i-1;
            while(p>-1&&a[p]<temp)
            {
                a[p+1]=a[p];
                p--;
            }
            a[p+1]=temp;
        }
        for(i=0;i<a.length;i++)
          System.out.print(a[i]+" ");
    }
}