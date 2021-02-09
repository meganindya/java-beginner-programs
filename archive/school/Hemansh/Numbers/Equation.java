package Numbers;
class Equation
{
    public static void main()
    {
        int i, j;
        for(i=10;i<99;i++)
        {
            if(i<rev(i))
             for(j=i+1;j<100;j++)
              if(j!=rev(i))
               if(i!=2*rev(j)&&i!=rev(j)*2/3)
                if(i*j==rev(i)*rev(j))
                  System.out.println(i+"*"+j+"="+rev(i)+"*"+rev(j));
            }
        }
    public static int rev(int n)
    {
        int rev=0;
        while(n>0)
        {
            rev=rev*10+n%10;
            n/=10;
        }
        return rev;
    }
}

                