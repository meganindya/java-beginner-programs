  import javax.swing.*;
   import java.awt.*;
   class MainGui extends JFrame{
         JFrame frame = new JFrame();
         JPanel mainPanel = new JPanel();
         JButton newBut = new JButton("New Game");
         JButton continueBut = new JButton("Continue");
         JButton exitBut = new JButton("Exit");
         JLabel backImage = new JLabel(new ImageIcon("C:/Users/Anindya/Desktop/12039683_10153934819864578_5225944086907602778_n.jpg"));
         public MainGui(){
             frame.setSize(600,800);
             frame.setVisible(true);
             frame.setResizable(false);
             setButtonSize();
             frame.setLayout(new BorderLayout());
             frame.setContentPane(backImage);
             frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(),BoxLayout.Y_AXIS));
             insertBlankArea(frame);
             frame.getContentPane().add(newBut);
             insertBlankArea(frame);
             frame.getContentPane().add(continueBut);
             insertBlankArea(frame);
             frame.getContentPane().add(exitBut);
             frame.setSize(799,800);

      }
      public void insertBlankArea(JFrame frame){
            frame.getContentPane().add(Box.createRigidArea(new Dimension(280,155)));
      }
      public void setButtonSize(){
            Dimension dim = new Dimension(100,100);//here is the problem,i am not getting the desired dimension and the size of buttons remains the default.
            newBut.setPreferredSize(dim);
            continueBut.setPreferredSize(dim);
            exitBut.setPreferredSize(dim);
      }

      public static void main(String[] args) {
            MainGui mainGui = new MainGui();
      }
  }