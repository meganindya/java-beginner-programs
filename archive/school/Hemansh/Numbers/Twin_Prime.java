package Numbers;
class Twin_Prime
{
    public static void main( int n)
    {
        int i = 0, j = 0, k = 0;
        for(i=2;i<=n;i++)
        {
            if(checkprime(i)==2&&checkprime(i+2)==2)
            {
                    k = i;
                    j = i + 2;
            }
        }
        for(i=n+1;;i++)
        {
            if(checkprime(i)==2&&checkprime(i+2)==2)
             break;
        }
        if(n-k<i-n)
        System.out.println(k + " " + j);
        else
        System.out.println(i + " " + (i+2));
    }
    public static int checkprime(int n)
    {
        int c = 0;
        for(int i = 1; i<= n; i++)
        {
            if(n%i==0)
            c++;
        }
        return c;
    }
}
