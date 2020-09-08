import java.util.*;
class wrap_B
{
    void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string to wrap : ");
        String s=sc.next()+sc.nextLine();
        int k=0;char A,x='A',r;
        s=s.toUpperCase();
        char b[]=s.toCharArray();
        System.out.print("Wrapped string : ");
        for(int i=0;i<b.length;i++)
        {
            r=position(x,compute(b[i]));
            x=r;
            System.out.print(r);
        }
    }
    int compute(char a)
    {
        int n=a-64,r=0,s=0,k=n-1,l=n;
        if(n>=1 && n<=5)
            r=n*2;
        else if(n>=6 && n<=10)
            r=(n%3)*5;
        else if(n>=11 && n<=15)
            r=(n/4)*8;
        else if(n>=16 && n<=20)
        {
            while(l!=0)
            {
                s+=(l%10);
                l/=10;
            }
            r=s*10;
        }
        else
        {
            while((n%k)!=0)
                k--;
            r=k*12;
        }
        return r;
    }
    char position(char a,int n)
    {
        int m=((int)a-64)+(n%26);
        if(m>0 && m<27)
            return ((char)(m+64));
        else if(m<=0)
            return ((char)(m+90));
        else
            return ((char)(m+64-26));
    }
}
/**
 * Output
 * ------
 * Enter string to wrap : CATASTROPHE
 * Wrapped string : GICEAUGEWGQ
 * ------
 * Enter string to wrap : MONTREAL
 * Wrapped string : YWUOAKMK
 * ------
 * Enter string to wrap : LUCK
 * Wrapped string : YEKA
 */