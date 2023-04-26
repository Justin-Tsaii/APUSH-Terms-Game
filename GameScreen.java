import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class GameScreen implements ActionListener{
    JFrame frame = new JFrame();
    JLabel questionText = new JLabel();
    JLabel scoreBlue = new JLabel();
    JLabel scoreRed = new JLabel();
    JLabel scoreGreen = new JLabel();
    JLabel scoreYellow = new JLabel();
    JTextField textField = new JTextField();
    JTextArea textArea = new JTextArea();
    JButton blueButton = new JButton();
    JButton redButton = new JButton();
    JButton greenButton = new JButton();
    JButton yellowButton = new JButton();

    private int question_num = 1;
    private int answerInput = -2;
    private int startTime;
    private int endTime;
    private int elapsedTime;
    public int questionScore;
    public int totalScore = 0;
    private final int kTotalquestions = 20;
    String[] fake_real_Answers;

    Randomizer m_Randomizer = new Randomizer();
    SelectTerms m_SelectTerms = new SelectTerms();

    public GameScreen(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 825);
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(50, 0, 1400, 75);
        textField.setBackground(new Color(240, 240, 200));
        textField.setFont(new Font("Lucida Sans", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
        textField.setEditable(false);

        textArea.setBounds(50, 75, 1400, 300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setFont(new Font("Lucida Sans", Font.PLAIN, 24));
        textArea.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
        textArea.setEditable(false);
        
        blueButton.setBounds(0, 375, 750, 200);
        blueButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        blueButton.setHorizontalTextPosition(JButton.CENTER);
        blueButton.setBackground(new Color(150, 150, 250));
        blueButton.addActionListener(this);

        redButton.setBounds(750, 375, 750, 200);
        redButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        redButton.setHorizontalTextPosition(JButton.CENTER);
        redButton.setBackground(new Color(250, 150, 150));
        redButton.addActionListener(this);

        greenButton.setBounds(0, 575, 750, 200);
        greenButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        greenButton.setHorizontalTextPosition(JButton.CENTER);
        greenButton.setBackground(new Color(150, 250, 150));
        greenButton.addActionListener(this);

        yellowButton.setBounds(750, 575, 750, 200);
        yellowButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        yellowButton.setHorizontalTextPosition(JButton.CENTER);
        yellowButton.setBackground(new Color(250, 250, 150));
        yellowButton.addActionListener(this);

        scoreBlue.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        scoreBlue.setBackground(Color.black);
        scoreBlue.setOpaque(true);
        scoreBlue.setText("+90");
        scoreBlue.setBounds(75, 460, 150, 300);
        
        frame.add(textArea);
        frame.add(textField);
        frame.add(blueButton);
        frame.add(redButton);
        frame.add(greenButton);
        frame.add(yellowButton);
        frame.add(scoreBlue);
        frame.setVisible(true);
        
        nextQuestion();
    }

    public void nextQuestion(){
        if(question_num > kTotalquestions){
            endScreen();
        }
        else{
            startTime = (int) System.currentTimeMillis() / 750;
            fake_real_Answers = m_Randomizer.RandomizeAnswers(question_num, m_SelectTerms.getAnswer(question_num-1));
            System.out.println("Time: " + startTime);
            textField.setText("Question " + question_num);
            textArea.setText(m_SelectTerms.getQuestion(question_num-1));
            blueButton.setText(fake_real_Answers[0]);
            redButton.setText(fake_real_Answers[1]);
            greenButton.setText(fake_real_Answers[2]);
            yellowButton.setText(fake_real_Answers[3]);

        }

    }

    public void endScreen(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        blueButton.setEnabled(false);
        redButton.setEnabled(false);
        greenButton.setEnabled(false);
        yellowButton.setEnabled(false);
        

        if(e.getSource() == blueButton){
            answerInput = 0;
            endTime = (int) System.currentTimeMillis() / 750;
            System.out.println("End Time: " + endTime);
            if(answerInput == m_Randomizer.getAnswerNum()){
                questionScore = (100) - (endTime - startTime);
                totalScore += questionScore;
                System.out.println(questionScore);
            }
        }
        if(e.getSource() == redButton){
            answerInput = 1;
            endTime = (int) System.currentTimeMillis() / 750;
            System.out.println(m_Randomizer.getAnswerNum());
            if(answerInput == m_Randomizer.getAnswerNum()){
                questionScore = (100) - (endTime - startTime);
                totalScore += questionScore;
                System.out.println(questionScore);
            }
        }
        if(e.getSource() == greenButton){
            answerInput = 2;
            endTime = (int) System.currentTimeMillis() / 750;
            System.out.println(m_Randomizer.getAnswerNum());
            if(answerInput == m_Randomizer.getAnswerNum()){
                questionScore = (100) - (endTime - startTime);
                totalScore += questionScore;
                System.out.println(questionScore);
            }
        }
        if(e.getSource() == yellowButton){
            answerInput = 3;
            endTime = (int) System.currentTimeMillis() / 750;
            System.out.println(m_Randomizer.getAnswerNum());
            if(answerInput == m_Randomizer.getAnswerNum()){
                questionScore = (100) - (endTime - startTime);
                totalScore += questionScore;
                System.out.println(questionScore);
            }
        }
        displayAnswer();

    }

    public void displayAnswer(){
        blueButton.setEnabled(false);
        redButton.setEnabled(false);
        greenButton.setEnabled(false);
        yellowButton.setEnabled(false);
        
        if(answerInput == 1){
            if(answerInput == m_Randomizer.getAnswerNum()){

            }
        }

        Timer pause = new Timer(2000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){

            }
        
        });

        

    }

    
    
}
