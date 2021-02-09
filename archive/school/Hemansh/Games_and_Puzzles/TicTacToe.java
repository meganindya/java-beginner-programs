package Games_and_Puzzles;
//Owner: Hemansh Kashyap
import java.io.*;
class TicTacToe
 {
     public static void main() throws IOException
     {
         char a[]=new char[9];
         int i, k, c=0, p=0,ch=0, r, n, b=0, t=0, z=0, j;
         char cp=' ';
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        for(i=0;i<9;i++)
        a[i]=' ';
        System.out.println(" Here is your board -");
        System.out.println("|1 |2 |3 ");
        System.out.println("|4 |5 |6 ");
        System.out.println("|7 |8 |9 ");
        System.out.println("Do you want to begin?");
        String s = br.readLine();
        if(s.equals("Yes"))
        {
             System.out.println(" Please enter index of move -");
             ch = Integer.parseInt(br.readLine());
             a[ch-1]='X';
        }
        if(ch!=5)
        a[4]='O';
        else
        a[0]='O';
        for(r=0;r<3;r++)
             {
                 for(n=0;n<3;n++)
                 System.out.print("|"+a[r*3+n]+" ");
                 System.out.println();
            }
        for(i=1;i<=4;i++)
        {
            for(j=0;j<3;j++)
             if(a[j]==a[j+3]&&a[j]==a[j+6])
             { z=1; cp=a[j];} 
            for(j=0;j<7;j+=3)
             if(a[j]==a[j+1]&&a[j]==a[j+2])
             { z=1; cp=a[j];} 
            if(a[0]==a[4]&a[0]==a[8])
            {z=1;cp=a[2];}
            if(a[2]==a[4]&a[6]==a[4])
            {z=1;cp=a[2];}
            if(z==1&&cp!=' ')
            {
             System.out.println("Game won by "+ cp);
             for(r=0;r<3;r++)
             {
                 for(n=0;n<3;n++)
                 System.out.print("|"+a[r*3+n]+" ");
                 System.out.println();
             }
             return;
            }
            cp=' ';
            z=0;
            System.out.println("Enter choice");
            ch = Integer.parseInt(br.readLine());
            if(a[ch-1]==' ')
            a[ch-1]='X';
            else
            {
                System.out.println("Filled already. Enter again");
                ch = Integer.parseInt(br.readLine());
                a[ch-1]='X';
            }
            for(j=0;j<3;j++)
             if(a[j]==a[j+3]&&a[j]==a[j+6])
             { z=1; cp=a[j];} 
            for(j=0;j<7;j+=3)
             if(a[j]==a[j+1]&&a[j]==a[j+2])
             { z=1; cp=a[j];} 
            if(a[0]==a[4]&a[0]==a[8])
            {z=1;cp=a[j];}
            if(a[2]==a[4]&a[6]==a[4])
            {z=1;cp=a[j];}
            for(r=0;r<3;r++)
             {
                 for(n=0;n<3;n++)
                 System.out.print("|"+a[r*3+n]+" ");
                 System.out.println();
            }
            if(z==1&&cp!=' ')
            {
             System.out.println("Game won by "+ cp);
             for(r=0;r<3;r++)
             {
                 for(n=0;n<3;n++)
                 System.out.print("|"+a[r*3+n]+" ");
                 System.out.println();
             }
             return;             
            }
            cp=' ';
            z=0;
             System.out.println("Computer's move");
            c=0;
            for(k=0;k<3&&c!=1;k++)
            {
                if(a[k]==a[k+6]&&a[k+3]==' '&&a[k]!=' ')
                { a[k+3]='O';
                    c=1;
                    break;
                }
            }
            for(k=1;k<8&&c!=1;k+=3)
            {
                if(a[k]==a[k+1]&&a[k-1]==' '&&a[k]!=' ')
                { a[k-1]='O';
                    c=1;
                    break;
                }
                if(a[k]==a[k-1]&&a[k+1]==' '&&a[k]!=' ')
                { a[k+1]='O';
                    c=1;
                    break;
                }
            }
            for(k=3;k<6&&c!=1;k++)
            {
                if(a[k]==a[k+3]&&a[k-3]==' '&&a[k]!=' ')
                { a[k-3]='O';
                    c=1;
                    break;
                }
                if(a[k]==a[k-3]&&a[k+3]==' '&&a[k]!=' ')
                { a[k+3]='O';
                    c=1;
                    break;
                }
            }
            for(k=0;k<=6&&c!=1;k+=3)
            {
                if(a[k]==a[k+2]&&a[k+1]==' '&&a[k]!=' ')
                { a[k+1]='O';
                    c=1;
                    break;
                }
            }
            if(a[0]==a[8]&&a[0]=='X'&&a[4]=='O'&&c!=1&&a[1]==' ')
            {
               a[1]='O';
               c=1;
            }
            else if(a[2]==a[6]&&a[2]=='X'&&a[4]=='O'&&c!=1&&a[1]==' ')
            {
               a[1]='O';
               c=1;
            }
            if(a[2]==a[7]&&a[2]=='X'&&c!=1)
            {
               if(a[8]==' ')
               a[8]='O';
               else if(a[6]==' ')
               a[7]='O';               
               c=1;
            }
            else if(a[6]==a[5]&&a[5]=='X'&&c!=1)
            {
               if(a[8]==' ')
               a[8]='O';
               else if(a[2]==' ')
               a[2]='O';               
               c=1;
            }
            if(a[5]==a[7]&&a[5]=='X'&&c!=1&&a[8]==' ')
            {
                a[8]='O';
                c=1;
            }
            for(k=0;k<=8&&c!=1;k+=2)
            
                if(k!=4)
                 if(a[k]==a[4]&&a[k]!=' ')
                 {
                     p=k+(int)Math.abs(k-2)*4;
                    if(p>8)
                     p=p%8;
                     if(a[p]==' ')
                     {
                     a[p]='O';
                     c=1;
                     break;
                    }
                }
            for(k=0;k<=8&&c!=1;k+=2)
            {
                if(k==4&&a[k]==' ')
                {a[k]='O';
                    c=1;
                    break;
                }
                else if(a[k]==' ')
                {a[k]='O';
                    c=1;
                    break;
                }
            }
            for(r=0;r<9;r++)
            {
               if(a[r]!=' ')
                 b++;
               else
                 t=r;
            }
            if(b==8&&c!=1)
              a[t]='O';
            b=0;  
            for(r=0;r<3;r++)
             {
                 for(n=0;n<3;n++)
                 System.out.print("|"+a[r*3+n]+" ");
                 System.out.println();
            }
            }
        System.out.println("Draw");    
        for(r=0;r<3;r++)
             {
                 for(n=0;n<3;n++)
                 System.out.print("|"+a[r*3+n]+" ");
                 System.out.println();
            }
        }
    }