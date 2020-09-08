package Time_and_Date;

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
    System.out.println("If the date is 9th Februaray,2013 enter it as 09/02/2013. ");
    date = scan.next();
    dd=mm=yy=0;
    // Convert the date in string format to day, month and year
   try{
       dd = Integer.parseInt(date.substring(0,2));
       mm = Integer.parseInt(date.substring(3,5));
       yy = Integer.parseInt(date.substring(6));   
       System.out.println("Enter the name of the day on 1st of January ");
       dayName = scan.next();
       //Store the days of the months   
       int dom[] = {31,28,31,30,31,30,31,31,30,31,30,31};
       //If it is a leap year, februrary should have 29 days.     
        if(yy%4 == 0)
            dom[1] = 29;      
      if(dd < 0 || dd > dom[mm-1]){
        System.out.println("Invalid date.");
        }else{       
      //Store the day names of the week
      String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday",
      "Friday", "Saturday", "Sunday"};
      //Find the corresponding day of the year
      tdays = 0;
       //Add the days of the month
       for(i=0; i < mm-1; i++)
            tdays+=dom[i];
      //Add the days of the current month
        tdays+=dd;
        index = 0;
        //Find the index of the entered day name in the day names array
        for(i=0; i < 7; i++)
       {
           if(dayName.equalsIgnoreCase(days[i])){
              index = i;
              break;
          }
      }
      //find the index of the day in the day names array for the current day
        r = tdays%7 + index - 1;
        if( r >= 7)
            r -= 7;
        System.out.println("Day on " + date + " : " + days[r]);
     } // else
     }catch(Exception e){
            System.out.println("Please enter the date in the specified format.");
            System.out.println("Error : "+e);
    }     
   }//end of main
}//end of class
/*
Enter a date in the string format dd/mm/yyyy: 
If the date is 9th Februaray,2013 enter it as 09/02/2013. 
12/06/2012
Enter the name of the day on 1st of January 
Sunday
Day on 12/06/2012 : Tuesday

Enter a date in the string format dd/mm/yyyy: 
If the date is 9th Februaray,2013 enter it as 09/02/2013. 
11/02/2008
Enter the name of the day on 1st of January 
Friday
Day on 11/02/2008 : Thursday

Enter a date in the string format dd/mm/yyyy: 
If the date is 9th Februaray,2013 enter it as 09/02/2013. 
31/03/2004
Enter the name of the day on 1st of January 
Wednesday
Day on 31/03/2004 : Tuesday

Enter a date in the string format dd/mm/yyyy: 
If the date is 9th Februaray,2013 enter it as 09/02/2013. 
32/04/2001
Enter the name of the day on 1st of January 
Saturday
Invalid date.
*/