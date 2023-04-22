import javax.swing.JFrame;
import javax.swing.JLabel;

public class NewGame {
    JFrame frame = new JFrame();
    JLabel label = new JLabel("Hello there");

    public NewGame(){
        label.setBounds(0, 0, 100, 50);

        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
}
