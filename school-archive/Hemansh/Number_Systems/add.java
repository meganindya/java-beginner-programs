package Number_Systems;

class add
{
    public static void main( String a, String b, int bs)
    {
       int p,q,d,c=0;
       String tmp=a;
       String s = "";
       a=(a.length()>b.length())?tmp:b;
       b=(a.length()>b.length())?b:tmp;
       for(int i=b.length();i<a.length();i++)
       b="0"+b;
       System.out.println(" "+a);
       System.out.println("+"+b);
       for(int i=a.length()-1;i>=0;i--)
       {
           p = ((int)a.charAt(i)>=65)?((int)a.charAt(i)-55):((int)a.charAt(i)-48);
           q = ((int)b.charAt(i)>=65)?((int)b.charAt(i)-55):((int)b.charAt(i)-48);
           d=p+q+c;
           c=d/bs;
           d=d%bs;
           if(d>9)
            s=(char)(d+55)+s;
           else
            s=d+s;
        }
       s=c+s;
       System.out.println(s);
    }
}
           