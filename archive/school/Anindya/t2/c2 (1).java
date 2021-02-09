import java.util.*;
class c2
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string : ");
        String s=sc.nextLine();
        StringTokenizer st=new StringTokenizer(s);
        int i=0;String o="";
        while(st.hasMoreTokens())
        {
            String e=st.nextToken(),d=e.toLowerCase();
            for(int f=0;f<d.length();f++)
            {
                int c=0;
                for(int y=0;y<d.length();y++)
                {
                    if(d.charAt(f)==d.charAt(y))
                        c++;
                }
                o+=Character.toString(e.charAt(f))+c;
            }
            o+=" ";
        }
        o=o.trim();
        System.out.print(o);
    }
}