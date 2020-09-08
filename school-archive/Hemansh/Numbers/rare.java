package Numbers;
class rare
{
    public static void main()
    {
        int i, k, m;
        for(i=10;i<=10000;i++)
        {
            k = rev(i);
            if(i<=k)
            {
              m = i + k;
              if(Math.pow((int)Math.sqrt(m),2)==m)
              {
                  System.out.println(i+" + "+k+" = "+m);
                }
            }
        }
    }
    public static int rev(int n)
    {
       int rev =0; 
        while(n>0)
        {
        rev = rev*10 + n%10;
        n/=10;
       }
       return rev;
    }
}
