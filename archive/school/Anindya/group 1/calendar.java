import java.util.*;
class calendar
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter day of 1st January : ");
        String s=sc.nextLine();s=s.toLowerCase();int f;
        String dy[]={"sunday","monday","tuesday","wednesday","thursday","friday","saturday"};
        System.out.print("Is it a leap year - | 1 for YES | 0 for NO | : ");
        int n=sc.nextInt();
        for(f=0;f<dy.length;f++)    if(dy[f].equals(s)) break;
        int dt[]={0,31,28+n,31,30,31,30,31,31,30,31,30,31};
        System.out.print("Enter required month : ");
        String m=sc.next()+sc.nextLine();m=m.toLowerCase();
        String mn[]={"january","february","march","april","may","june","july","august","september","october","november","december"};
        System.out.println("\n"+"SUN\t"+"MON\t"+"TUE\t"+"WED\t"+"THU\t"+"FRI\t"+"SAT");
        System.out.println("---------------------------------------------------");
        for(int i=0;i<mn.length;i++)
            if(mn[i].equals(m))
            {
                int x=0;
                for(int j=0;j<=i;j++)   x+=dt[j];
                x%=7;x=(x+f)%7;
                int cal[]=new int[x+dt[i+1]];
                int q=cal.length,k=0;
                for(int j=1;j<=dt[i+1];j++)
                    cal[q-j]=dt[i+1]-j+1;
                qui:
                while(q>0)
                {    
                    for(int t=0;t<7;t++)
                    {
                        if(k<cal.length)
                        {
                            if(cal[k]!=0)   System.out.print(cal[k++]+"\t");
                            else            {k++;System.out.print("\t");}
                        }
                        else break qui;
                    }
                    System.out.println();q-=7;
                }
            }
    }
}
/**
 * Output
 * ------
 * Enter day of 1st January : Thursday
 * Is it a leap year - | 1 for YES | 0 for NO | : 0
 * Enter required month : April
 * 
 * SUN	MON	TUE	WED	THU	FRI	SAT
 * ----------------------------
 * 			    1	2	3	4	
 * 5	6	7	8	9	10	11	
 * 12	13	14	15	16	17	18	
 * 19	20	21	22	23	24	25	
 * 26	27	28	29	30
 * 
 * -----------------------------------------------
 * 
 * Enter day of 1st January : Friday
 * Is it a leap year - | 1 for YES | 0 for NO | : 1
 * Enter required month : February
 * 
 * SUN	MON	TUE	WED	THU	FRI	SAT
 * ---------------------------
 *  	1	2	3	4	5	6	
 * 7	8	9	10	11	12	13	
 * 14	15	16	17	18	19	20	
 * 21	22	23	24	25	26	27	
 * 28	29	
 */