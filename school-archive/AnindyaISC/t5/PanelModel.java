import javax.swing.*;
import java.awt.*;

public class PanelModel extends JApplet {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel firstpanel = new JPanel(new GridLayout(4,4,4,4));
        JButton btn;
        for(int i=0 ; i<16 ; i++){
             btn = new JButton(String.valueOf(i));
            btn.setPreferredSize(new Dimension(40, 40));
            firstpanel.add(btn);
        }
        frame.setContentPane(firstpanel);
        frame.pack();
        frame.setVisible(true);
        
         JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new GridLayout(5, 13));
        for (int i=1; i<=5; i++) {
            for (int j=1; j<=13; j++) {
                btn = new JButton();
                btn.setPreferredSize(new Dimension(40, 40));
                secondPanel.add(btn);
            }
        }

        mainPanel.add(firstpanel);
        mainPanel.add(secondPanel);
        frame.add(mainPanel);

        frame.setSize(400,600);
        frame.setVisible(true);
    }
}