import java.io.*;
class chk2
{
    void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("C:/Users/Rosario/Desktop/Eng/antonym.txt"));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Rosario/Desktop/Eng/ans.txt")));
        PrintWriter pw2=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Rosario/Desktop/Eng/antonym1.txt")));
        String s;
        while((s=br.readLine())!=null)
        {
            s=s.trim();
            pw.println(s.substring(s.length()-1));
            pw2.println(s.substring(0,s.length()-5));
        }
        pw.close();
        pw2.close();
    }
}