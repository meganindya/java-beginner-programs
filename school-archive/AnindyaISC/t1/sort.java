import java.util.*;
class sort
{
    int a[];
    void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter capacity of array : ");
        int n=sc.nextInt();a=new int[n];
        System.out.println("Enter the array : ");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<a.length;i++)
        {
            for(int j=1;j<(a.length-i);j++)
            {
                if(a[j-1]<a[j])
                {
                    int q=a[j-1];
                    a[j-1]=a[j];
                    a[j]=q;
                }
            }
        }
        for(int i=0;i<n;i++)
            System.out.println(a[i]);
    }
}