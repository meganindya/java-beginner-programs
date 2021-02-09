import java.io.*;
import java.util.*;
class Meaning
{
    String a[][];int rnd[];
    void main()throws IOException
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("\t@Anindya_Rosarío©"+"\n"+"Enter number of questions : ");
        int n=sc.nextInt();
        rnd=new int[n*4];
        get_random(n);
        sort_random(rnd);
        a=new String[n][6];
        get_elements(n);
        produce(n);
        Meaning2 ob=new Meaning2();
        ob.main(n);
    }
    void get_random(int n)
    {
        for(int i=0;i<(n*4);i++)
        {   rnd[i]=(int)(Math.ceil(Math.random()*2938));
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
        BufferedReader br1=new BufferedReader(new FileReader("C:/Users/Rosario/Desktop/Meaning/words.txt"));
        String s,f[]=new String[n*4];int x=0;
        for(int i=0;i<n*4;i++)
        {
            do
            {
                s=br1.readLine();
                x++;
            }while(rnd[i]!=x);
            f[i]=s;
        }
        int ran[]=new int[n],g=0;
        for(int i=0;i<n;i++)
        {   ran[i]=new Random().nextInt(n*4);
            while(f[ran[i]]==null)
                ran[i]=new Random().nextInt(n*4);
            a[i][0]=f[ran[i]].substring(f[ran[i]].indexOf(" :: ")+4);
            a[i][ran[i]%4+1]=f[ran[i]].substring(0,(f[ran[i]].indexOf(" :: ")));
            if(ran[i]%4+1==1)
                a[i][5]="a";
            if(ran[i]%4+1==2)
                a[i][5]="b";
            if(ran[i]%4+1==3)
                a[i][5]="c";
            if(ran[i]%4+1==4)
                a[i][5]="d";
            f[ran[i]]=null;
        }
        String tem[]=new String[n*3];
        for(int i=0;i<n*4;i++)
        {
            if(f[i]!=null)
                tem[g++]=f[i].substring(0,f[i].indexOf(" :: "));
        }
        for(int i=0;i<n;i++)
        {
            for(int j=1;j<5;j++)
            {
                if(a[i][j]==null)
                {
                    int r=new Random().nextInt(n*3);
                    while(tem[r]==null)
                        r=new Random().nextInt(n*3);
                    a[i][j]=tem[r];
                    tem[r]=null;
                }
            }
        }
    }
    void produce(int n)throws IOException
    {
        PrintWriter pw1=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Rosario/Desktop/Meaning/meaning.txt")));
        PrintWriter pw2=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Rosario/Desktop/Meaning/ans.txt")));
        for(int i=0;i<n;i++)
        {
            pw1.print(a[i][0]);
            for(int j=1;j<5;j++)
            {
                pw1.print(" :: "+a[i][j]);
            }
            pw1.println();
            pw2.println(a[i][5]);
        }
        pw1.close();pw2.close();
    }
}