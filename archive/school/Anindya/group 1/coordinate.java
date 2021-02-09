/** 77  78  79  80  49  50  51  52  53
 *  76  46  47  48  25  26  27  28  54
 *  75  45  23  24  09  10  11  29  55
 *  74  44  22  08  01  02  12  30  56
 *  73  43  21  07  00  03  13  31  57
 *  72  42  20  06  05  04  14  32  58
 *  71  41  19  18  17  16  15  33  59
 *  70  40  39  38  37  36  35  34  60
 *  69  68  67  66  65  64  63  62  61  */

import java.util.*;
class coordinate
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number : ");
        int n=sc.nextInt(),m;
        int k=0,r=0,h=(int)Math.sqrt(n);
        if(h%2==0)
            m=h+1;
        else
            m=h+2;
        int c=(m/2),rx=c,cx=c;
        int a[][]=new int[m][m];
        int q,e=-1,f=0,j,px=c,py=c;
        qui:
        for(int i=1;i<m;i++)
        {
            if(r%4==0){e=0;f=1;}
            if(r%4==1){e=1;f=0;}
            if(r%4==2){e=0;f=-1;}
            if(r%4==3){e=-1;f=0;}
            for(j=1;j<=i;j++)
            {
                if(rx==c && cx==c)
                {    
                    rx-=1;
                    a[rx][cx]=++k;
                    py=rx;px=cx;
                    if(k==n) break qui;
                }
                if((cx+(f*j))==c && r%4==0)
                    rx-=1;
                a[rx+(e*j)][cx+(f*j)]=++k;
                py=rx+(e*j);px=cx+(f*j);
                if(k==n) break qui;
            }
            rx+=(e*(j-1));cx+=(f*(j-1));
            if(r%4==1 || r%4==2)  i--;  r++;
            if(r%4==0 && i==m-1)
            {
                for(j=1;j<=i;j++)
                {
                    a[rx][cx+j]=++k;
                    py=rx;px=cx+j;
                    if(k==n) break qui;
                }
            }
        }
        System.out.print("Coordinates of "+n+" are:");
        System.out.print(" "+(px-c)+","+(c-py));
    }
}
/**
 * Output
 * ------
 * Enter number : 48
 * Coordinates of 48 are: -1,3
 * ------
 * Enter number : 234
 * Coordinates of 234 are: 8,7
 * ------
 * Enter number : 48
 * Coordinates of 48 are: -1,1
 */