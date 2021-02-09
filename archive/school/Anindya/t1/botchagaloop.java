import java.util.*;
class botchagaloop
{
    Scanner sc=new Scanner(System.in);
    void main()
    {
        System.out.print("Enter number : ");
        String s=sc.nextLine();
        String s1=tooct(s),s2=sort(s1);
        for(int i=0;i<5;i++)
        {
            if(s1.equals(s2))
                break;
            s1=sub(s1,s2);
            s2=sort(s1);
        }
        s1=todec(s1);
        System.out.print("Botchagaloop of "+s+" is : "+s1);
    }
    String tooct(String n)
    {
        int f=Integer.parseInt(n),r;String t="";
        do
        {
            r=f%8;f=f/8;
            t=r+t;
        }while(f>=8);
        if(f==0) return t;
        else return f+t;
    }
    String todec(String n)
    {
        int f=0,x;
        int l=n.length();
        for(int i=0;i<l;i++)
        {
            if(n.charAt(l-i-1)>=65 && n.charAt(l-i-1)<=70)
                x=(int)(n.charAt(l-i-1))-55;
            else
                x=(int)(n.charAt(l-i-1))-48;
            f+=(x*(Math.pow(8,i)));
        }
        return Integer.toString(f);
    }
    String sort(String n)
    {
        int l=n.length();
        char a[]=n.toCharArray();
        for(int i=0;i<l;i++)
        {
            for(int j=0;j<l-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    char x=a[j];
                    a[j]=a[j+1];
                    a[j+1]=x;
                }
            }
        }
        return new String(a);
    }
    String sub(String m,String n)
    {
        int n1=Integer.parseInt(todec(m));
        int n2=Integer.parseInt(todec(n));
        int ds=n1-n2;
        return tooct(Integer.toString(ds));
    }
}
/**
 * Output
 * ------
 * Enter number : 5049
 * Botchagaloop of 5049 is : 301
 * ------
 * Enter number : 199697
 * Botchagaloop of 199697 is : 95844
 * ------
 * Enter number : 3418
 * Botchagaloop of 3418 is : 1008
 */