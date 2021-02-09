import java.io.*;
class Number_Break
{
        public static void main(String args[])throws IOException
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter a number : ");
            int n=Integer.parseInt(br.readLine());
             
            int sum=0,c=0,j=0;
            for(int i=1;i<n;i++)
            {
                sum=i;
                j=i+1;
 
                while(sum<n)
                {
                    sum=sum+j;
                    j++;
                }
 
                if(sum==n)
                    {
                        for(int k=i;k<j;k++)
                        {
                            if(k==i)
                                System.out.print(k);
                            else
                                System.out.print(" + "+k);
                        }
                     System.out.println();
                    }
            }
        }
}