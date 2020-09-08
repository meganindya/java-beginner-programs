import java.util.*;
class equation
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of variables : ");
        int n=sc.nextInt(),d;
        System.out.println("Enter equations as \"Ax+By+Cz=Q1\" :");
        int a[][]=new int[n][n],b[]=new int[n];String ax[][]=new String[n][n];
        for(int i=0;i<n;i++)
        {
            String s=sc.next()+sc.nextLine();int q=0;
            int l=s.length();int v=0;
            while(v!=l)
            {
                if(s.charAt(v)=='-')
                    s=s.substring(0,v)+"+-"+s.substring(v+++1);
                v++;
            }
            s=(s.replaceAll("\\+",".").replaceAll("\\=","."));
            StringTokenizer st=new StringTokenizer(s,".");
            for(int j=0;j<n;j++)
            {
                String t=st.nextToken();
                for(int k=0;k<t.length();k++)
                    if((t.charAt(k)<48 || t.charAt(k)>57) && t.charAt(k)!='-')
                    {q=k;break;}
                if(t.substring(0,q).equals(""))   a[i][j]=1;
                else if(t.substring(0,q).equals("-"))   a[i][j]=-1;
                else a[i][j]=Integer.parseInt(t.substring(0,q));
                ax[i][j]=t.substring(q);
            }
            b[i]=Integer.parseInt(st.nextToken());
        }
        d=deter(a,n);System.out.print("\n"+"||  ");
        for(int i=0;i<n;i++)
        {
            int z[][]=new int[n][n];
            for(int j=0;j<n;j++)
                for(int k=0;k<n;k++)
                    z[j][k]=a[j][k];
            for(int j=0;j<n;j++)
                z[j][i]=b[j];
            System.out.print(ax[0][i]+" = "+(deter(z,n)/d)+"  ||  ");
        }
    }
    static int deter(int a[][],int n)
    {
        int z=0;
        if(n==1)    return a[0][0];
        else
        {
            for(int i=0;i<n;i++)
            {
                int r[][]=new int[n-1][n-1];
                for(int m=1;m<=r.length;m++)
                {
                    int k=0;
                    for(int t=0;t<=r.length;t++)
                    {
                        if(t==i)    continue;
                        r[m-1][k++]=a[m][t];
                    }
                }
                z+=a[0][i]*Math.pow((-1),i)*deter(r,n-1);
            }
        }
        return z;
    }
}
/**
 * Output
 * ------
 * Enter no of variables : 3
 * Enter equations as "Ax+By+Cz=Q1" :
 * -4x+2y-9z=2
 * 3x+4y+z=5
 * x-3y+2z=8
 * ||  x = 7  ||  y = -3  ||  z = -4  ||
 * ------
 * Enter no of variables : 3
 * Enter equations as "Ax+By+Cz=Q1" :
 * 2x-3y+0z=1
 * x+0y+3z=11
 * x+2y+z=7
 * ||  x = 2  ||  y = 1  ||  z = 3  ||
 */