import java.util.*;
class river
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number : ");
        int n=sc.nextInt();
        for(int i=1;i<=3;i++)
        {
            int x=(int)Math.pow(3,(i-1));
            int s[]=new int[100],t[]=new int[100];
            System.arraycopy(generate(x),0,s,0,100);
            System.arraycopy(generate(n),0,t,0,100);
            qui:
            for(int j=0;j<100;j++)
            {
                for(int k=0;k<100;k++)
                {
                    if(t[k]==s[j])
                    {
                        System.out.println(x+"|"+t[k]+"|n"+k+"|s"+j);
                        break qui;
                    }
                }
            }
        }
    }
    static int[] generate(int n)
    {
        int s[]=new int[100];
        s[0]=n;
        for(int i=1;i<100;i++)
        {
            int a=n,c=0;
            while(a!=0)
            {    c+=a%10;a/=10;}
            n+=c;
            s[i]=n;
        }
        return s;
    }
}