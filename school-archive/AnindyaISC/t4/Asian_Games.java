import java.io.*;
class Asian_Games
{
    static void main()throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("C:/Users/Anindya/Desktop/in3.txt"));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Anindya/Desktop/out3.txt")));
        int n=Integer.parseInt(br.readLine());
        for(int z=0;z<n;z++)
        {
            String s=br.readLine();
            int m=Integer.parseInt(s),t=m/5,c=1;
            for(int i=1;i<t;i++)
            {
                int a[]=new int[i+1],st=m,r=i;
                for(int j=0;j<i+1;j++)
                {
                    a[j]=st-(5*(r--));
                    st=st-a[j];
                }
                c=follow(0,a,m,1,i,c);
            }
            pw.println(c);
        }pw.close();
    }
    static int follow(int x,int a[],int n,int u,int i,int c)
    {
        if(u==(i+1))
            return c;
        else
        {
            if(x==1)
            {
                if(n-(((i-u)*5)+a[u]+1)>=((a[u]+1)*u))
                {
                    a[u]++;
                    for(int g=u-1;g>0;g--)
                        a[g]=a[u];
                    a[0]=n-((5*(i-u))+(a[u]*u));c++;
                }
            }
            else
            {   x++;c++;}
            while(true)
            {
                if(a[1]<a[0] && a[0]-a[1]!=1)
                {   a[1]++;a[0]--;c++;}
                else    break;
            }
            if(n-(((i-u)*5)+a[u]+1)>=((a[u]+1)*u))
                return follow(1,a,n,u,i,c);
            else
                return follow(1,a,n,u+1,i,c);
        }
    }
}
/**
 * Output
 * ------
 *  (File Input)
 * 4|16|17|20
 *  (File Output)
 * 6|7|13
 */