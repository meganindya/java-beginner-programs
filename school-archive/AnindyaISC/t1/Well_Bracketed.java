//(A(B(CX)(DW)Z)Y)
//(A(B(CX)Y)Z)
import java.util.*;
class Well_Bracketed
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s=sc.next(),r=s,t="";int c=0,f=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(Character.isUpperCase(x))
                t+=x;
        }
        while(t.length()>0 && f<(t.length()/2))
        {
            if((r.length()%2)!=0)
            {
                c++;break;
            }
            else if((((int)t.charAt(f))-65)==(90-((int)t.charAt(t.length()-f-1))) && (t.length()>2))
            {
                f++;continue;
            }
            else if((((int)t.charAt(f))-65)==(90-((int)t.charAt(f+1))))
            {
                t=t.substring(0,f)+t.substring(f+2);continue;
            }
            else if(((int)t.charAt(f))>77)
            {
                f--;continue;
            }
            else 
            {
                if(t.length()==0)
                    continue;
                else
                {
                    c++;break;
                }
            }
        }
        if(c==1)
            System.out.print(s+" is not well bracketed");
        else
            System.out.print(s+" is not well bracketed");
    }
}