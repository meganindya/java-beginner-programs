package Numbers;
class Palindrome_Gen
{
    static int c = 0;
    public static void main(String n, int b)
    {
        if(rev(n).equals(n))
         {System.out.println("Palindrome - " + n + " found after " + c + " iterations"); c=0;}
        else if(c==10)
        {System.out.println("Exceeded 10 times - " + n); c=0;}
        else
         {  c++; main(add(rev(n),n,b),b);}
        }
    public static String add(String a, String b, int bs)
    {
       int p,q,d,c=0;
       String tmp=a;
       String s = "";
       a=(a.length()>b.length())?tmp:b;
       b=(a.length()>b.length())?b:tmp;
       for(int i=b.length();i<a.length();i++)
       b="0"+b;
       for(int i=a.length()-1;i>=0;i--)
       {
           p = ((int)a.charAt(i)>=65)?((int)a.charAt(i)-55):((int)a.charAt(i)-48);
           q = ((int)b.charAt(i)>=65)?((int)b.charAt(i)-55):((int)b.charAt(i)-48);
           d=p+q+c; c=d/bs; d=d%bs;
           if(d>9)
            s=(char)(d+55)+s;
           else
            s=d+s;
        }
       if(c!=0)
       s=c+s;
       return s;
    }
    public static String rev(String a)
    {
        if(a.length()==1)
         return a;
        else
         return a.charAt(a.length()-1)+rev(a.substring(0,a.length()-1));
     }
    }