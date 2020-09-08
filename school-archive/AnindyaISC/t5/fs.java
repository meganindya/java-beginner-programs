import java.awt.*;
import javax.swing.*;

class fs extends JFrame
{
    public void init()
    {
        this.setSize(1400, 780);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null) ; 

        setLayout(null) ; 

        JPanel Panel1 = new JPanel() ;
        JPanel Panel2 = new JPanel () ; 
        JPanel Panel3 = new JPanel() ; 
        JPanel Panel4 = new JPanel() ; 

        JLabel Label1 = new JLabel ("Label1") ; 
        JLabel Label2 = new JLabel ("Label2") ; 
        JLabel Label3 = new JLabel ("Label3") ; 
        JLabel Label4 = new JLabel ("Label4") ; 

        Panel1.add(Label1) ; 
        Panel2.add(Label2) ; 
        Panel3.add(Label3) ; 
        Panel4.add(Label4) ; 

        // Panel 1 "About Me"
        Panel1.setSize(140,390) ; 
        Panel1.setLocation(0,0) ; 
        Panel1.setBackground(Color.red) ; 
        Panel1.setVisible(true) ; 
        this.add(Panel1) ; 

        // Panel 2 "MyHoppies" 
        Panel2.setSize(140,390) ; 
        Panel2.setLocation(0,700) ; 
        Panel2.setBackground(Color.yellow) ;
        Panel2.setVisible(true) ; 
        this.add(Panel2) ; 

        // Panel 3 "Photo Gallery"
        Panel3.setSize(140,390) ; 
        Panel3.setLocation(390,0) ; 
        Panel3.setBackground(Color.black) ;
        this.add(Panel3) ;

        // Panel 4 "Happey face" 
        Panel4.setSize(140,390) ;
        Panel4.setLocation(390,700) ; 
        Panel4.setBackground(Color.pink) ; 
        Panel4.setVisible(true) ; 
        this.add(Panel4) ; 
    }
}