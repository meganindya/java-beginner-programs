import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class mines extends Applet implements ActionListener
{
    Button buttons[][]=new Button[8][8];
    Label labels[][]=new Label[8][8];
    public void init()
    {
        setLayout(null);int k=0;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                buttons[j][i] = new Button(Integer.toString(++k));
                labels[j][i] = new Label(Integer.toString(k),Label.CENTER);
            }
        }
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                buttons[i][j].setBounds(32*i,32*j,32,32);
                labels[i][j].setBounds(32*i,32*j,32,32);
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
                    if(buttons[i][j].getLabel().equals("X"))
                        buttons[i][j].setLabel(Integer.toString(8*j+i+1));
                    else{
                        buttons[i][j].setVisible(false);
                        labels[i][j].setVisible(true);
                    }
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
                                buttons[i][j].setLabel(Integer.toString(8*j+i+1));
                            else
                                buttons[i][j].setLabel("X");
                        }
                    }
                }
            }
        }
    }
}