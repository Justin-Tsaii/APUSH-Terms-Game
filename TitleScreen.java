import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TitleScreen implements ActionListener{
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton startButton = new JButton("Start Game");

    private static JTextField userText;
    private static JLabel nameLabel;

    public static String username;

    public TitleScreen(){

        
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        nameLabel = new JLabel("UserName: ");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        startButton.setBounds(100, 160, 100, 40);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        panel.add(startButton);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == startButton){
            String name = userText.getText();
            frame.setVisible(false);
            NewGame m_NewGame = new NewGame();
        }
    }
    
}
