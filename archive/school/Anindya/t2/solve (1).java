/**
 * XYZ   + XY    = 6QQ
 * 3BBCC + 58DC3 = CDEC2
 * AA6C5 + 62AC  = ACD9F     */
 
import java.util.*;
class solve
{
    public static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first string  : ");
        String s1=sc.next()+sc.nextLine();
        int l1=s1.length();s1=s1.toUpperCase();
        System.out.print("Enter second string : ");
        String s2=sc.next()+sc.nextLine();
        int l2=s2.length();s2=s2.toUpperCase();
        System.out.print("Enter result string : ");
        String s3=sc.next()+sc.nextLine();
        int l3=s3.length();s3=s3.toUpperCase();
        int w=0,w1=0,z1=0,z2=0,z3=0;String y="";
        String a[][]=new String[l1+l2+l3][l1+l2+l3+2];
        for(int i=0;i<l1;i++)
        {
            int x=0;char v=s1.charAt(i);
            for(int j=0;j<y.length();j++)
            {
                if(v==y.charAt(j))
                {
                    x=1;w1=j;break;
                }
            }
            if(x==0)
            {
                y+=v;z1++;
                a[w][0]=Character.toString(v);
                a[w][i+1]="*";w++;
            }
            else
                a[w1][i+1]="*";
        }
        for(int i=0;i<l2;i++)
        {
            int x=0;char v=s2.charAt(i);
            for(int j=0;j<y.length();j++)
            {
                if(v==y.charAt(j))
                {
                    x=1;w1=j;break;
                }
            }
            if(x==0)
            {
                y+=v;z2++;
                a[w][0]=Character.toString(v);
                a[w][i+1+l1]="*";w++;
            }
            else
                a[w1][i+1+l1]="*";
        }
        for(int i=0;i<l1;i++)
        {
            int x=0;char v=s3.charAt(i);
            for(int j=0;j<y.length();j++)
            {
                if(v==y.charAt(j))
                {
                    x=1;w1=j;break;
                }
            }
            if(x==0)
            {
                y+=v;z3++;
                a[w][0]=Character.toString(v);
                a[w][i+1+l1+l2]="*";w++;
            }
            else
                a[w1][i+1+l1+l2]="*";
        }
        int z=z1+z2+z3,e=z,r=0,c=0;
        char b[]=new char[z];
        for(int i=0;i<z;i++)
        {
            char u=a[i][0].charAt(0);
            if(u>=48 && u<=57)
            {    b[i]=u;a[i][l1+l2+l3+1]="X";e--;}
        }
        int tu=(int)Math.pow(10,e-1),tv=(int)Math.pow(10,e);
        char ton[][]=new char[(int)Math.pow(10,e-1)*9][3];
        for(int i3=tu;i3<tv;i3++)
        {
            int n1=0,n2=0,n3=0,n=i3,tp=0;
            String ref=Integer.toString(i3);
            for(int i=0;i<e;i++)
            {
                for(int j=i+1;j<e;j++)
                {
                    if(ref.charAt(i)==ref.charAt(j))
                        tp=1;
                }
            }
            if(tp==1)
                continue;
            for(int q=z-1;q>=0;q--)
            {
                if(!"X".equals(a[q][l1+l2+l3+1]))
                {   b[q]=(char)((n%10)+48);n/=10;}
            }
            for(int i=0;i<z;i++)
            {
                for(int j=1;j<=l1;j++)
                {
                    if(a[i][j]!=null)
                        n1+=Math.pow(10,(l1-j))*(b[i]-48);
                }
            }
            for(int i=0;i<z;i++)
            {
                for(int j=1;j<=l2;j++)
                {
                    if(a[i][j+l1]!=null)
                        n2+=Math.pow(10,(l2-j))*(b[i]-48);
                }
            }
            for(int i=0;i<z;i++)
            {
                for(int j=1;j<=l3;j++)
                {
                    if(a[i][j+l1+l2]!=null)
                        n3+=Math.pow(10,(l3-j))*(b[i]-48);
                }
            }
            int n2l=(Integer.toString(n2)).length();
            int n3l=(Integer.toString(n3)).length();
            if(n2l!=l2 || n3l!=l3)
                continue;
            if((n1+n2)==n3)
            {   
                ton[r][0]=(char)(n1);
                ton[r][1]=(char)(n2);
                ton[r++][2]=(char)(n3);
            }
        }
        System.out.println("\t----------");
        for(int i=0;i<ton.length;i++)
        {
            int m1=ton[i][0];
            int m2=ton[i][1];
            int m3=ton[i][2];
            if(m1!=0)
            {
                System.out.println("\t"+m1+"+"+m2+"="+m3);
                c++;
            }
        }
        System.out.print("\n  No of solutions : "+c);
    }
}
/**
 * Output
 * ------
 * Enter first string  : XYZ
 * Enter second string : XY
 * Enter result string : 6QQ
 * 	----------
 * 	546+54=600
 * 	576+57=633
 * 	586+58=644
 * 
 *   No of solutions : 3
 * ------
 * Enter first string  : AA6C5
 * Enter second string : 62AC
 * Enter result string : ACD9F
 * 	----------
 * 	11675+6217=17892
 * 
 *   No of solutions : 1
 * ------
 */