package Numbers;

class factorial
{
    public static void main(int n)
    {
        int j, p=0, i;
        int a[] = new int[5000];
        a[0]=1;
        for(i=n;i>1;i--)
        {
            for(j=0;j<5000;j++)
            {
                a[j] = p + a[j]*i;
                p = a[j]/10;
                a[j] = a[j]%10;
            }
        }
        for(j=4999;j>=0;j--)
        {
            if(a[j]!=0)
            break;
        }
        for(i=j;i>=0;i--)
        System.out.print(a[i]);
    }
}