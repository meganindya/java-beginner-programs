import java.util.*;
class minesw
{
    static void main()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter no of horizontal rows : ");
            int r=sc.nextInt();
            System.out.print("Enter no of vertical columns : ");
            int c=sc.nextInt();
            System.out.print("Enter no of mines : ");
            int m=sc.nextInt();
            char board[][]=new char[r][c];
        while(true)
        {
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                    board[i][j]='\u0000';
            }
            int mr=m;
            while(mr!=0)
            {
                int r1=(int)(r*Math.random());
                int c1=(int)(c*Math.random());
                if(board[r1][c1]=='\u0000')
                {
                    board[r1][c1]='*';
                    mr--;
                }
            }
            
            for(int i=0;i<r;i++)
            {
                System.out.print("|");
                for(int j=0;j<c;j++)
                {
                    if(board[i][j]=='*')
                        System.out.print("  "+board[i][j]+"  |");
                    else
                        System.out.print("     |");
                }
                System.out.println();
            }
            
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    int df=0;
                    if(board[i][j]!='*')
                    {
                        for(int i1=-1;i1<=1;i1++)
                        {
                            for(int j1=-1;j1<=1;j1++)
                            {
                                System.out.print(i+"|"+j+"|"+i1+"|"+j1+"|"+(i+i1)+"|"+(j+j1)+"|");
                                if((i+i1)>=0 && (j+j1)>=0 && (i+i1)<r && (j+j1)<c)
                                {
                                    if(board[i+i1][j+j1]=='*')  {df++;System.out.print("true");}
                                }
                                System.out.println("--|"+df);
                            }
                        }
                        board[i][j]=(char)(df+48);
                    }
                }
            }
            
            for(int i=0;i<r;i++)
            {
                System.out.print("|");
                for(int j=0;j<c;j++)
                    System.out.print("  "+board[i][j]+"  |");
                System.out.println();
            }
            System.out.print("Continue : ");
            if(sc.nextInt()==0) System.exit(0);
        }
    }
}