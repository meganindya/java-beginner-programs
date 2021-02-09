package Two_Dimensional_Array;
class n_sons
{
    public static void main(int n)
    {
        int k = 0;
        int i,j;
        int a[][]=new int [n][n];
        for(i=0;i<n;i++)
         a[0][i]=i+1;
        for(i=1;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(a[i-1][j]%n==1)
                 a[i][j]=(i+1)*n;
                else
                 a[i][j]=a[i-1][j]+n-1;
                }
            }
        for(i=0;i<n;i++)
        {
           for(j=0;j<n;j++)
              System.out.print(a[i][j]+"\t");
           System.out.println();
        }
        System.out.println(" The sons get ");
        for(i=0;i<n;i++)
        {
           for(j=0;j<n;j++)
              k = k + a[j][i];
           System.out.print(k+"\t");
           k=0;
        }
    }
}
        
                