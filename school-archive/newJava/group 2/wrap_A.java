/**
The number of letters to count is given by:
    RULE 1
Multiply its numerical value by 2
    RULE 2
Divide its numerical value by 3. Multiply the integer remainder by 5
    RULE 3
Divide its numerical value by 4. Multiply the integer part of the quotient by –8.
    RULE 4
Take the square root of the numerical value. Truncate the decimal part of the answer.
Multiply the resulting integer by –12.
    RULE 5
Find the sum of the factors of its numerical value. Multiply by 10.

For the first letter of each set, if the computed value is non-negative,
starting at A count the computed value to the right. For each additional
letter start at the current encoded letter. If the first computed value is negative,
starting at A count to the left which means wrapping around to the end of the alphabet.
For each additional letter start at the current encoded letter. As an example,
the input C, 1, B, 2, F, 3, $ would produce the encoded letters GQI. The C with a
numerical value of 3 evaluates to a 6, using rule 1. Always starting each new set at A,
and counting 6 letters to the right, the C encodes to an G. The B with a numerical
value of 2 evaluates to a 10. Counting down the alphabet 10 letters from G encodes the
B to a Q. The F with a numerical value of 6 evaluates to a –8, using rule 3. Counting
to the left 8 letters from Q encodes the F to an I. The final encoded value is GQI.

    SAMPLE INPUT                    SAMPLE OUTPUT
    ------ -----                    ------ ------
   C, 1, B,2, F,3, $                    GQI
   A,1,A,1,A,1,$                        CEG
   A,1,H,2,D,3 ,$                       CME
   T,5,S,4,$                            EI
   A,1,B,1,C,1,$                        CGM
   A,2,C,4,S,5,L,3,$                    FTLN
   C,5, P,4,L,3,U,2,S,1,$               OSUUG
   C,2,H,3,P,4,$                        AKO
   M,1,O,2,N,3,T,4,R,5,E,1,A,2,L,3,$    AACGGQVX
 */
import java.util.*;
class wrap_A
{
    void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter elements and rule no., $ to end : ");
        String s="";int k=0;char A,x='A',r;
        do
        {
            A=(sc.next()).charAt(0);
            if(k%2!=0)
                s+=","+Character.toString(A);
            else
                s+=" "+Character.toString(A);
            k++;
        }while(A!='$');
        s=(s.substring(1,s.length()-2)).toUpperCase();
        char b[][]=extract(s);
        System.out.print("Wrapped string : ");
        for(int i=0;i<b.length;i++)
        {
            r=position(x,compute(b[i][0],b[i][1]));
            x=r;
            System.out.print(r);
        }
    }
    char[][] extract(String s)
    {
        String a[]=s.split(" ");
        char b[][]=new char[a.length][2];
        for(int i=0;i<a.length;i++)
        {
            b[i][0]=a[i].charAt(0);
            b[i][1]=a[i].charAt(2);
        }
        return b;
    }
    int compute(char a,char b)
    {
        int n1=a-64,n2=b-48,r=0,s=0;
        switch(n2)
        {
            case 1:
                r=n1*2;
                break;
            case 2:
                r=(n1%3)*5;
                break;
            case 3:
                r=(n1/4)*(-8);
                break;
            case 4:
                r=(int)(Math.sqrt(n1))*(-12);
                break;
            case 5:
                for(int i=1;i<=n1;i++)
                {
                        if(n1%i==0)
                            s+=i;
                }
                r=s*10;
                break;
        }
        return r;
    }
    char position(char a,int n)
    {
        int m=((int)a-64)+(n%26);
        if(m>0 && m<27)
            return ((char)(m+64));
        else if(m<=0)
            return ((char)(m+90));
        else
            return ((char)(m+64-26));
    }
}
/**
 * Output
 * ------
 * Enter elements and rule no., $ to end : 
 * M|1|O|2|N|3|T|4|R|5|E|1|A|2|L|3|$
 * Wrapped string : AACGGQVX
 * ------
 * Enter elements and rule no., $ to end : 
 * C|5|P|4|L|3|U|2|S|1|$
 * Wrapped string : OSUUG
 */