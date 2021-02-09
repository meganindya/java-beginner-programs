package Time_and_Date;
import java.io.*;
class TimeInWords
{
    public static void display_time()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter hours.....(1-12)");
        int hh=Integer.parseInt(br.readLine());
        System.out.println("Enter minutes.....(0-59)");
        int mm=Integer.parseInt(br.readLine());
        String a[]={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
                "Ten","Eleven","Twelve","Thirteen","Fourteen","Quarter","Sixteen","Seventeen",
                "Eighteen","Nineteen","Twenty","Twenty One","Twenty Two","Twenty Three",
                "Twenty Four","Twenty Five","Twenty Six","Twenty Seven","Twenty Eight",
                "Twenty Nine","Half"};
        String k = " past ";
        if(mm>30)
        {
            mm=60-mm;
            hh=hh+1;
            k=" to ";
            if(hh==13)
                hh=1;
        }
        if(mm==0)
            System.out.println(a[hh]+" o' clock");
        else if(mm%15==0)
            System.out.println(a[mm]+k+a[hh]);
        else
            System.out.println(a[mm]+" minutes"+k+a[hh]);
    }
}
