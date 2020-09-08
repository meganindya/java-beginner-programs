class Lucky_number
{
   public static void main()throws java.lang.Exception
   {
      java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
      System.out.println("Enter : ");
      outer:
      for(int i = Integer.parseInt(br.readLine()); i>0; i--)
      {
         int n = Integer.parseInt(br.readLine());
         if(n==1) {System.out.println("Lucky Number");continue;}
         for(int j = 2; j<=(int)Math.sqrt(n); j++)
           if(n%j==0) {System.out.println("Sorry");continue outer;}
         System.out.println("Lucky Number");  
      }
      br.close();
   }
}
/*
 Enter : 
 2
 4
 Sorry
 13
 Lucky Number
 */