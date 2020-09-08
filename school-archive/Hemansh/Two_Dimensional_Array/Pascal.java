package Two_Dimensional_Array;
class Pascal
{
    public static void main(int n)
    {
        int i, j;
       int a[][] = new int [n][2*n-1];
       a[0][n-1]=1;
       for(i=1;i<n;i++)
       {
           for(j=0;j<2*n-1;j++)
           {
              if(j!=0&&j!=2*n-2)
              {
              a[i][j]=a[i-1][j-1]+a[i-1][j+1];
            }
            }
        }
       a[n-1][0]=1;
       a[n-1][2*n-2]=1;
       for(i=0;i<n;i++)
       {
           for(j=0;j<2*n-1;j++)
           {
              if(a[i][j]==0)
                System.out.print("\t");
              else
                System.out.print(a[i][j]+"\t");
            }
           System.out.println("");
        }
    }
}
/*
Pascal.main(5);
				1					
			1		1				
		1		2		1			
	1		3		3		1		
1		4		6		4		1	
Pascal.main(3);
		1			
	1		1		
1		2		1	
Pascal.main(6);
					1						
				1		1					
			1		2		1				
		1		3		3		1			
	1		4		6		4		1		
1		5		10		10		5		1	
Pascal.main(7);
						1							
					1		1						
				1		2		1					
			1		3		3		1				
		1		4		6		4		1			
	1		5		10		10		5		1		
1		6		15		20		15		6		1	
 */