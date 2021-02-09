import java.lang.*;
import java.util.Scanner;
import java.util.StringTokenizer;
class String_Tokenizer
{
    String s;
    Scanner sc=new Scanner(System.in);
    StringTokenizer st;
    String_Tokenizer()
    {
        s="";
    }
    void input()
    {
        System.out.print("Enter a String : ");
        s=sc.nextLine();
    }
    int count(StringTokenizer st)
    {
        return st.countTokens();
    }
    void main()
    {
        st=new StringTokenizer(s);
    }
}