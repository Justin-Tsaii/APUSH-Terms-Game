import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main{
    private int count = 0;
    private JFrame jFrame;
    private JPanel jPanel;
    
    private static JPasswordField passwordText;
    private static JLabel passwordLabel;
    private static QuestionLinkGenerator m_QuestionLinkGenerator;

    public static void main(String[] args){
        m_QuestionLinkGenerator = new QuestionLinkGenerator();
        m_QuestionLinkGenerator.activate();
        TitleScreen m_TitleScreen = new TitleScreen();
        
    }

/* 
    JFrame jFrame = new JFrame();
        JPanel jPanel = new JPanel();

        
        jFrame.setSize(800, 500);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);

        jPanel.setLayout(null);

        username = new JLabel("UserName: ");
        username.setBounds(10, 20, 80, 25);
        jPanel.add(username);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        jPanel.add(userText);
        jFrame.setTitle("Game");

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(10, 50, 80, 25);
        jPanel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        jPanel.add(passwordText);

        JButton login = new JButton("Login");
        login.setBounds(10, 80, 80, 25);
        login.addActionListener(new Main());
        jPanel.add(login);

        //JLabel success = new JLabel("");
        //success.setBounds(count, count, count, count);

        jFrame.setVisible(true);
        */
}