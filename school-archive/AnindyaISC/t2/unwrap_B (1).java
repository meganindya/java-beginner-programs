import java.util.*;
class unwrap_B
{
    void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter coded string : ");
        String s=sc.next()+sc.nextLine();
        s=("A"+s).toUpperCase();
        String a[][]=new String[s.length()-1][4];
        char b[]=new char[4];int c=0,q=0,r=1,m=1;
        for(int i=0;i<s.length()-1;i++)
        {
            b=predict(s.charAt(i),s.charAt(i+1));
            for(int j=0;j<b.length;j++)
            {
                if(b[j]!=0)
                    a[i][j]=Character.toString(b[j]);
                else
                    a[i][j]=" ";
            }
        }
        System.out.print("\t"+"Options : "+"\n\t-------");
        for(int i=0;i<s.length()-1;i++)
        {
            System.out.print("\n"+"Letter "+(i+1)+"|\t");
            for(int j=0;j<b.length;j++)
                System.out.print(a[i][j]+"\t");
        }
        
        String t[]=combinations(a).split(" ");
        r=t.length;
        System.out.println("\n\n"+"Possible number of words : "+r);
        int h=0,y=t.length;
        System.out.println("Possible Words :\n-------- -----");
        while(y!=0)
        {
            System.out.print(t[h++]+"\t");y--;
            if(h%8==0)
                System.out.println();
        }
    }
    char[] predict(char a,char c)
    {
        int d,k=0;
        if(c<a)
            d=26-(Math.abs(c-a));
        else
            d=c-a;
        char b[]=new char[4];
        int p[]={d,d+26,d+52,d+78,d+104,d+130};
        if((d/2)<=5 && (d/2)>=1)
            b[k++]=(char)((d/2)+64);
        if(d==0)
        {    b[k++]='F';b[k++]='I';}
        else if(d==5)
        {    b[k++]='G';b[k++]='J';}
        else if(d==10)
            b[k++]='H';
        if((((d/8)*4)+3)>=11 && (((d/8)*4)+3)<=15)
        {
            if(d/8==2)
                b[k++]='K';
            else
            {
                b[k++]='L';b[k++]='M';
                b[k++]='N';b[k++]='O';
            }
        }
        if(d+52==70)
            b[k++]='P';
        else if(d+78==80)
            b[k++]='Q';
        else if(d+78==90)
            b[k++]='R';
        else if(d+78==100)
            b[k++]='S';
        else if(d==20)
            b[k++]='T';
        int z[]={7*12,11*12,1*12,12*12,5*12,13*12};
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(z[j]==p[i])
                    b[k++]=(char)(21+j+64);
            }
        }
        return b;
    }
    String combinations(String A[][])
    {
        int l[] = new int[A.length];
        int c[] = new int[A.length];
        int total = 1,v=0;String t="";
        for(int i = 0; i < A.length; ++i)
        {
            l[i] = A[i].length;
            total*= A[i].length;
        }
        ArrayList<String> J = new ArrayList<String>();
        StringBuilder sb;
        for (int u = total; u > 0; --u)
        {
            sb = new StringBuilder();
            for(int i = 0; i < A.length; ++i)
                sb.append(A[i][c[i]]);
            J.add(sb.toString());
            for(int x = A.length - 1; x >= 0; --x)
            {
                if(c[x] + 1 < l[x])
                {   ++c[x];break;}
                c[x] = 0;
            }
        }
        for(int i=0;i<J.size();i++)
        {    
            int g=0;
            String e=J.get(i).toString();
            for(int j=0;j<e.length();j++)
            {
                if(e.charAt(j)==32)
                {    g++;break;}
            }
            if(g==1)
                continue;
            else
                t+=" "+e;
        }
        return (t.trim());
    }
}
/**
 * Output
 * ------
 * Enter coded string : YEKA
 * Possible number of words : 16
 * Possible Words : 
 * LCCK    LCUK    LUCK    LUUK    
 * MCCK    MCUK    MUCK    MUUK    
 * NCCK    NCUK    NUCK    NUUK    
 * OCCK    OCUK    OUCK    OUUK    
 */