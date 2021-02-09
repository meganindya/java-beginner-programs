import java.util.*;
class arrange2
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter capacity of array : ");
        int n=sc.nextInt(),a[]=new int[n],k,e,d;
        System.out.println("Enter the array of sorted numbers : ");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        if(n%2!=0)
        {
            k=0;d=(n/2)+1;
        }
        else
        {
            k=1;d=n/2;
        }
        for(e=0;e<d;e++)
        {
            int x=a[e];
            a[e]=a[k];
            a[k]=x;
            k+=2;
        }
        for(int i=0;i<a.length;i++)
        {
            for(int j=e+1;j<(a.length-i);j++)
            {
                if(a[j-1]<a[j])
                {
                    int q=a[j-1];
                    a[j-1]=a[j];
                    a[j]=q;
                }
            }
        }
        System.out.println("Arranged array : ");
        for(int i=0;i<n;i++)
            System.out.println(a[i]);
    }
}