import java.io.*; 
class Wondrous_matrix
{
    public static void main(String arg[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,i,j,x1=1,sum1,sum2,x2=1,k,l,c;
        int a[][]=new int[10][10];
        int b[]=new int[100];
        double y;
        System. out.println("Enter size of an array");
        n=Integer.parseInt(br.readLine());
        System.out.println("Enter values for Wondrous Square");
        for(i=0;i<n;++i)
            for(j=0;j<n;++j)
                a[i][j]=Integer.parseInt(br.readLine());
        for(i=1; i<=n*n;++i)
            b[1]=0;
        for(i=0;i<n;++i)
            for(j=0;j<n;++j)
            {
                if(b[a[i][j]]==0)
                    b[a[i][j]]=1;
                else x1=0;
            }
        if(x1==0)
            System.out.println("NOT A WONDROUS SQUARE");
        else
        {
            y=0.5*n*(n*n+1);
            for(i=0;i<n;++i)
            {
                sum1=0;sum2=0;
                for(j=0;j<n;j++)
                {
                    sum1=sum1+a[i][j];
                    sum2=sum2+a[j][i];
                }
                if(sum1!=y || sum2!=y)
                    x2=0;
            }
            if(x2==0)
                System.out.println("NOT A WONDROUS SQUARE");
        } 
        if(x1==1 && x2==1)
            System.out.println("YES IT IS A WONDROUS SQUARE");
            System.out.println("PRIME \t ROW INDEX \t COLUMN INDEX");
            for(i=2;i<=n*n;++i)
            {
                c=0;
                for(k=1;k<=i;++k)
                    if(i%k==0)
                        c++;
                if(c==2)
                {
                    for(j=0;j<n;++j)
                        for(l=0;l<n;++l)
                            if(a[j][l]==i)
                                System.out.println(i+"\t \t"+j+"\t \t"+l);
                }
            }
    }
}