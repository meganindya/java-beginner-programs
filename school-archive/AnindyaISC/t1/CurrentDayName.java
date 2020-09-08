import java.util.*;
class CurrentDayName
{
public static void main (String args[])
throws InputMismatchException
{
Scanner scan = new Scanner(System.in);

int i,dd,mm,yy,tdays, index,r;
String date,dayName;

System.out.println("Enter a date in the string format dd/mm/yyyy: ");
System.out.println("If the date is 9th February,2013 enter it as 09/02/2013. ");
    date = scan.next();

    dd=mm=yy=0;
    try{
       dd = Integer.parseInt(date.substring(0,2));
       mm = Integer.parseInt(date.substring(3,5));
       yy = Integer.parseInt(date.substring(6));   
       
       System.out.println("Enter the name of the day on 1st of January ");
        dayName = scan.next();
        
     int dom[] = {31,28,31,30,31,30,31,31,30,31,30,31};
      
        if(yy%4 == 0)
            dom[1] = 29;      
       
      if(dd < 0 || dd > dom[mm-1]){
        System.out.println("Invalid date.");
        }else{       
      String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday",
      "Friday", "Saturday", "Sunday"};
      
          
     tdays = 0;
         for(i=0; i < mm-1; i++)
            tdays+=dom[i];

     tdays+=dd;
        
    index = 0;
    for(i=0; i < 7; i++)
    {
        if(dayName.equalsIgnoreCase(days[i])){
            index = i;
            break;
        }
            
    }
    
        r = tdays%7 + index - 1;
        
        if( r >= 7)
            r -= 7;
            
        System.out.println("Day on " + date + " : " + days[r]);
     }
     
       }catch(Exception e){
            System.out.println("Please enter the date in the specified format.");
            System.out.println("Error : "+e);
    }     
    
    }
}