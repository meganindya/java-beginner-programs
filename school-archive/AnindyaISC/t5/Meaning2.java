import java.io.*;
import java.util.*;
class Meaning2
{
    String a[][];int rnd[];
    Scanner sc=new Scanner(System.in);
    void main(int n)throws IOException
    {
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Anindya/Desktop/Meaning/sm.txt")));
        a=new String[n][6];
        get_elements(n);int c=0,l=0;
        for(int i=0;i<n;i++)
        {
            System.out.print("\f\t@Anindya_Rosarío©"+"\n"+"Choose appropriate word for the meaning -"+"\n");
            if(a[i][5].equals("a"))
            {    pw.print(a[i][1]);l=a[i][1].length();}
            if(a[i][5].equals("b"))
            {    pw.print(a[i][2]);l=a[i][2].length();}
            if(a[i][5].equals("c"))
            {    pw.print(a[i][3]);l=a[i][3].length();}
            if(a[i][5].equals("d"))
            {    pw.print(a[i][4]);l=a[i][4].length();}
            System.out.println("\t"+"Question "+(i+1)+"\n\t----"+"\n>>>"+a[i][0]+" :");
            System.out.println("(a)"+a[i][1]+"\n(b)"+a[i][2]+"\n(c)"+a[i][3]+"\n(d)"+a[i][4]);
            System.out.print("Enter your pick : ");
            char ch=(sc.next()).charAt(0);
            while(ch!='a' && ch!='b' && ch!='c' && ch!='d')
            {
                System.out.print("Invalid Entry! Re-enter : ");
                ch=sc.next().charAt(0);
            }
            if(a[i][5].equals(Character.toString(ch)))
            {
                System.out.println("You are correct!"+"\n");
                c++;
            }
            else
                System.out.println("Sorry! Correct answer is ("+a[i][5]+")"+"\n");
            if(l<8)
                pw.println("\t\t"+a[i][0]);
            else
                pw.println("\t"+a[i][0]);
            nxt();
        }
        pw.close();
        summary(c,n);
    }
    void get_elements(int b)throws IOException
    {
        BufferedReader br1=new BufferedReader(new FileReader("C:/Users/Anindya/Desktop/Meaning/meaning.txt"));
        BufferedReader br2=new BufferedReader(new FileReader("C:/Users/Anindya/Desktop/Meaning/ans.txt"));
        String s;
        for(int i=0;i<b;i++)
        {
            s=br1.readLine();
            a[i][5]=br2.readLine();
            a[i][0]=s.substring(0,s.indexOf(" :: "));
            StringTokenizer st=new StringTokenizer(s.substring(s.indexOf(" :: ")+4)," :: ");
            for(int j=1;j<5;j++)
                a[i][j]=st.nextToken();
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
        BufferedReader br=new BufferedReader(new FileReader("C:/Users/Anindya/Desktop/Meaning/sm.txt"));
        System.out.print("\f\t@Anindya_Rosarío©"+"\n");
        System.out.println("Your Score : "+c+" out of "+n+"\n");
        System.out.println("   >>>Summary\n"+"Word"+"\t\t"+"Meaning");
        System.out.println("--- "+"\t\t"+"-----   ");
        String s;
        while((s=br.readLine())!=null)
            System.out.println(s);
    }
}

/**
 * Output
 * ------
 * Enter number of questions : 5
 * 
 * Choose appropriate word for the meaning -
 * 	Question 1
 * 	----
 * >>>entire range :
 * (a)gamut
 * (b)interdict
 * (c)equanimity
 * (d)pachyderm
 * Enter your pick : d
 * Sorry! Correct answer is (a)
 * 
 * Enter 0 to go to next page : 0
 * 
 * Choose appropriate word for the meaning -
 * 	Question 2
 * 	----
 * >>>pale; wan :
 * (a)decorous
 * (b)voracious
 * (c)pallid
 * (d)prehensile
 * Enter your pick : a
 * Sorry! Correct answer is (c)
 * 
 * Enter 0 to go to next page : 0
 * 
 * Choose appropriate word for the meaning -
 * 	Question 3
 * 	----
 * >>>trying to please; obliging :
 * (a)complaisant
 * (b)allocate
 * (c)desecrate
 * (d)spume
 * Enter your pick : a
 * You are correct!
 * 
 * Enter 0 to go to next page : 0
 * 
 * Choose appropriate word for the meaning -
 * 	Question 4
 * 	----
 * >>>insignificant; petty :
 * (a)complement
 * (b)squander
 * (c)teleology
 * (d)paltry
 * Enter your pick : d
 * You are correct!
 * 
 * Enter 0 to go to next page : 0
 * 
 * Your Score : 2 out of 4
 * 
 *    >>>Summary
 * Word		Meaning
 * --- 		-----   
 * gamut		entire range
 * pallid		pale; wan
 * complaisant	trying to please; obliging
 * paltry		insignificant; petty
 */