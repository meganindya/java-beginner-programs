import java.util.*;
import java.io.*;
class output
{
    static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("C:/Users/Anindya/Desktop/out1.dat"));
        String s;
        while((s=br.readLine())!=null)
            System.out.println(s);
    }
}