import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class EndScreen {
    JFrame frame = new JFrame();
    JTextArea endMessage = new JTextArea();

    public EndScreen(int finalScore){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 825);
        frame.setLayout(null);
        frame.setResizable(false);

        endMessage.setBounds(450, 300, 700, 300);
        endMessage.setLineWrap(true);
        endMessage.setWrapStyleWord(true);
        endMessage.setFont(new Font("Lucida Sans", Font.PLAIN, 28));
        endMessage.setOpaque(false);
        endMessage.setText("Thank you for playing, your final score was: " + finalScore);
        endMessage.setEditable(false);

        frame.add(endMessage);
        frame.setVisible(true);
    }
    
}
