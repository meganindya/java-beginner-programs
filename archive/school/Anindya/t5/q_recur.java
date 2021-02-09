import java.text.*;
import java.util.*;
class q_recur
{
    static void main(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Installment figure : ");
        int p=sc.nextInt();
        System.out.print("Installment period in months : ");
        int t=sc.nextInt();
        System.out.print("Interest rate : ");
        int r=sc.nextInt();
        double a=0,i;
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        for(int x=1;x<=t;x++){
            i=0;
            a+=p;
            if(x%3==0){
                i=r*p;i/=100;
                i=Double.parseDouble(numberFormat.format(i));
            }
            System.out.println("--------"+i);
            a=Double.parseDouble(numberFormat.format(a+i));
        }
        System.out.println((p*t)+"|"+a+"|"+(a-(p*t)));
    }
}