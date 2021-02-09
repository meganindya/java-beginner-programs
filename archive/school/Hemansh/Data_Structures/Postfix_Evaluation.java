package Data_Structures;
import java.io.*;
class Postfix_Evaluation{  
   public int calculate(String s)  
   {  
     int n,r=0;  
     n=s.length();  
     Stack a=new Stack(n);  
     for(int i=0;i<n;i++)  
     {  
       char ch=s.charAt(i);  
       if(ch>='0'&&ch<='9')  
         a.push((int)(ch-'0'));  
       else  
       {  
         int x=a.pop();  
         int y=a.pop();  
         switch(ch)  
         {  
           case '+':r=x+y;  
              break;  
           case '-':r=y-x;  
              break;  
           case '*':r=x*y;  
              break;  
           case '/':r=y/x;  
              break;  
           default:r=0;  
         }  
         a.push(r);  
       }  
     }  
     r=a.pop();  
     return(r);  
   }  
}    
class Stack  
{  
   private int[] a;  
   private int top,m;  
   public Stack(int max)  
   {  
     m=max;  
     a=new int[m];  
     top=-1;  
   }  
   public void push(int key)  
   {  
     a[++top]=key;  
   }  
   public int pop()  
   {  
     return(a[top--]);  
   }  
}  
/*
 * 53*2-
 * 13
 * 24+3/
 * 2
 */