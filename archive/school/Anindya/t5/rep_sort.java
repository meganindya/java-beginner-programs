import java.util.*;
class rep_sort
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no of elements : ");
        int n=sc.nextInt();
        System.out.println("Enter array elements : ");
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println();
        for(int i=0;i<n;i++)
        {
            int x=a[i],y=i;
            for(int j=i+1;j<n;j++)
            {
                if(a[j]<x)  {x=a[j];y=j;}
            }
            int t=a[i];a[i]=x;a[y]=t;
        }
        for(int i=0;i<n;i++)
            System.out.println(a[i]);
    }
}