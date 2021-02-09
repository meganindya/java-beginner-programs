import java.io.*;
import java.util.*;
class Antonym
{
    String a[][];int rnd[];
    Scanner sc=new Scanner(System.in);
    void main()throws IOException
    {
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Rosario/Desktop/Antonym/sm.txt")));
        System.out.print("\t@Anindya_Rosarío©"+"\n"+"Enter number of questions : ");
        int n=sc.nextInt();
        a=new String[n][7];
        rnd=new int [n];
        get_random(n);
        sort_random(rnd);
        get_elements(n);int c=0,l=0;
        for(int i=0;i<n;i++)
        {
            System.out.print("\f\t@Anindya_Rosarío©"+"\n"+"Choose correct antonym for the word -"+"\n");
            if(a[i][0].length()<8)
                pw.print(a[i][0]+"\t\t");
            else
                pw.print(a[i][0]+"\t");
            if(a[i][6].equals("a"))
            {    pw.print(a[i][1]);l=a[i][1].length();}
            if(a[i][6].equals("b"))
            {    pw.print(a[i][2]);l=a[i][2].length();}
            if(a[i][6].equals("c"))
            {    pw.print(a[i][3]);l=a[i][3].length();}
            if(a[i][6].equals("d"))
            {    pw.print(a[i][4]);l=a[i][4].length();}
            if(a[i][6].equals("e"))
            {    pw.print(a[i][5]);l=a[i][5].length();}
            System.out.println("\t"+"Question "+(i+1)+"\n\t----"+"\n>>>"+a[i][0]+" :");
            System.out.println("(a)"+a[i][1]+"\n(b)"+a[i][2]+"\n(c)"+a[i][3]+"\n(d)"+a[i][4]+"\n(e)"+a[i][5]);
            System.out.print("Enter your pick : ");
            char ch=(sc.next()).charAt(0);
            while(ch!='a' && ch!='b' && ch!='c' && ch!='d' && ch!='e')
            {
                System.out.print("Invalid Entry! Re-enter : ");
                ch=sc.next().charAt(0);
            }
            if(a[i][6].equals(Character.toString(ch)))
            {
                System.out.println("You are correct!"+"\n");
                c++;
                if(l<8)
                    pw.println("\t\t"+"Correct");
                else
                    pw.println("\t"+"Correct");
            }
            else
            {
                System.out.println("Sorry! Correct answer is ("+a[i][6]+")"+"\n");
                if(l<8)
                    pw.println("\t\t"+"Wrong");
                else
                    pw.println("\t"+"Wrong");
            }
            nxt();
        }
        pw.close();
        summary(c,n);
    }
    void get_random(int n)
    {
        for(int i=0;i<n;i++)
        {   rnd[i]=(int)(Math.ceil(Math.random()*1208));
            for(int j=0;j<i;j++)
                if(rnd[j]==rnd[i]) i--;
        }
    }
    void sort_random(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a.length-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int t=a[j];a[j]=a[j+1];a[j+1]=t;
                }
            }
        }
    }
    void get_elements(int n)throws IOException
    {
        BufferedReader br1=new BufferedReader(new FileReader("C:/Users/Rosario/Desktop/Antonym/antonym.txt"));
        BufferedReader br2=new BufferedReader(new FileReader("C:/Users/Rosario/Desktop/Antonym/ans.txt"));
        String r,s,f[][]=new String[n][2];int x=0;
        for(int i=0;i<n;i++)
        {
            do
            {
                s=br1.readLine();
                r=br2.readLine();
                x++;
            }while(rnd[i]!=x);
            f[i][0]=s;
            f[i][1]=r;
        }
        for(int i=0;i<n;i++)
        {
            StringTokenizer st=new StringTokenizer(f[i][0]," :: ");
            for(int j=0;j<6;j++)
                a[i][j]=st.nextToken();
            a[i][6]=f[i][1];
        }
    }
    void nxt()
    {
        System.out.print("Enter 0 to go to next page : ");
        if(sc.next().compareTo("0")!=0)
            this.nxt();
    }
    void summary(int c,int n)throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("C:/Users/Rosario/Desktop/Antonym/sm.txt"));
        System.out.print("\f\t@Anindya_Rosarío©"+"\n");
        System.out.println("Your Score : "+c+" out of "+n+"\n");
        System.out.println("   >>>Summary\n"+"Word"+"\t\t"+"Antonym"+"\t\t"+"Response");
        System.out.println("--- "+"\t\t"+"----   "+"\t\t"+"-----   ");
        String s;
        while((s=br.readLine())!=null)
            System.out.println(s);
    }
}