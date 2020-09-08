import java.util.*;
class ads
{
    void sort_random()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("");
        int a[]=new int[5];
        for(int i=0;i<a.length;i++)
            a[i]=sc.nextInt();
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a.length-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int t=a[j];a[j]=a[j+1];a[j+1]=t;
                }
            }
        }
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }
}