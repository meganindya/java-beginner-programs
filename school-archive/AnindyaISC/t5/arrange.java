import java.util.*;
class arrange
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter capacity of array : ");
        int n=sc.nextInt(),a[]=new int[n],b[]=new int[n];
        System.out.println("Enter the array of sorted numbers : ");
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        for(int i=n-1;i>=0;i--)
            b[((n-1)/2)-((int)Math.pow(-1,(n-i-1))*((n-i)/2))]=a[i];
        System.out.println("Arranged array : ");
        for(int i=0;i<n;i++)
            System.out.println(b[i]);
    }
}