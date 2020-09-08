import java.util.*;
class decoding
{
    Scanner sc=new Scanner(System.in);String t="";
    void main()
    {
        System.out.print("Enter string to be decoded : ");
        String s=sc.next()+sc.nextLine();
        decode(s+"0",0,s.length());
        System.out.print("Decoded string : "+adjust(t));
        t="";
    }
    void decode(String s,int f,int l)
    {
        if(f>=l)
            return;
        else
        {
            int k=Integer.parseInt(s.substring(f,f+2));
            int h=Integer.parseInt(s.substring(f,f+3));
            if((k>=65 && k<=90)||(k>=97 && k<=99)||k==32)
                t+=Character.toString((char)k);
            else if(h>=100 && h<=122)
            {    
                t+=Character.toString((char)h);f++;
            }
            decode(s,f+2,l);
        }
    }
    String adjust(String r)
    {
        r=r.trim();
        r=r.toLowerCase();
        r=r.replaceAll("\\s+"," ");
        r=(char)(r.charAt(0)-32)+r.substring(1);
        char a[]=r.toCharArray();
        for(int i=1;i<a.length;i++)
        {
            if(a[i-1]==32)
                a[i]=Character.toUpperCase(a[i]);
        }
        r=new String(a);
        return r;
    }
}
/** Output
 *  ------
 *  Enter string to be decoded : 10665771011153266797868
 *  Decoded string : James Bond
 *  ------  
 *  Enter string to be decoded : 32766532321026982114658273
 *  Decoded string : La Ferrari
 *  ------
 *  Enter string to be decoded : 78487367421013232321006589
 *  Decoded string : Nice Day
 */