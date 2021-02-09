package Patterns;
class arrowhead
{
    public static void main(int n, int i)
    {
        if(i==0)
        {
           print(n,i);
        }
        else
        {
            print(n,i);
            main(n,i-1);
            print(n,i);
        }
    }
    public static void print(int n, int i)
    {
        System.out.println();
        for(int j=i;j<=n;j++)
          System.out.print(" ");
        for(int j=i;j<n;j++)
          System.out.print("*");
    }
}