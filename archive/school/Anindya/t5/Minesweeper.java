import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.border.*;

public class Minesweeper extends JApplet implements ActionListener
{
    JButton buttons[][];
    JLabel labels[][];
    int r,c,m;
    char board[][];
    public void init()
    {
        /*Scanner sc=new Scanner(System.in);
            System.out.print("Enter no of horizontal rows : ");
            r=sc.nextInt();
            System.out.print("Enter no of vertical columns : ");
            c=sc.nextInt();
            System.out.print("Enter no of mines : ");
            m=sc.nextInt();*/
            m=10;
            board=new char[8][8];
            buttons=new JButton[8][8];
            labels=new JLabel[8][8];
        int mr=m;
        while(mr!=0)
        {
            int r1=(int)(8*Math.random());
            int c1=(int)(8*Math.random());
            if(board[r1][c1]=='\u0000')
            {
                board[r1][c1]='*';
                mr--;
            }
        }
            
        /*for(int i=0;i<r;i++)
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
        }*/
            
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                int df=0;
                if(board[i][j]!='*')
                {
                    for(int i1=-1;i1<=1;i1++)
                    {
                        for(int j1=-1;j1<=1;j1++)
                        {
                            if((i+i1)>=0 && (j+j1)>=0 && (i+i1)<8 && (j+j1)<8)
                            {
                                if(board[i+i1][j+j1]=='*')  df++;
                            }
                        }
                    }
                    board[i][j]=(char)(df+48);
                }
            }
        }
            
        /*for(int i=0;i<r;i++)
        {
            System.out.print("|");
            for(int j=0;j<c;j++)
                System.out.print("  "+board[i][j]+"  |");
            System.out.println();
        }*/
        setLayout(null);
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                buttons[j][i] = new JButton(" ");
                Border border = BorderFactory.createLineBorder(Color.blue);
                labels[j][i].setBorder(border);
                labels[j][i] = new JLabel(Character.toString(board[i][j]),Label.CENTER);
            }
        }
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                buttons[i][j].setBounds(25*i,25*j,25,25);
                labels[i][j].setBounds(25*i,25*j,25,25);
            }
        }
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                add(buttons[i][j]);
                buttons[i][j].addActionListener(this);
                buttons[i][j].addMouseListener(new RightClicker());
                add(labels[i][j]);
                labels[i][j].setVisible(false);
            }
        }
    }
    public void actionPerformed(ActionEvent evt)  
    { 
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if (evt.getSource() == buttons[i][j])
                {
                    buttons[i][j].setVisible(false);
                    labels[i][j].setVisible(true);
                }
            }
        }
    }
    
    private class RightClicker extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            for(int i=0;i<8;i++)
            {
                for(int j=0;j<8;j++)
                {
                    if (e.isMetaDown()) 
                    {
                        if (e.getSource() == buttons[i][j])
                        {
                            if(buttons[i][j].getLabel().equals("X"))
                                buttons[i][j].setLabel(" ");
                            else
                                buttons[i][j].setLabel("X");
                        }
                    }
                }
            }
        }
    }
}