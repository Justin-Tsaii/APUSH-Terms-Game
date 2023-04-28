import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;

public class GameScreen implements ActionListener{
    JFrame frame = new JFrame();
    JLabel scoreBlue = new JLabel();
    JLayeredPane blueLayer = new JLayeredPane();
    JLabel scoreRed = new JLabel();
    JLayeredPane redLayer = new JLayeredPane();
    JLabel scoreGreen = new JLabel();
    JLayeredPane greenLayer = new JLayeredPane();
    JLabel scoreYellow = new JLabel();
    JLayeredPane yellowLayer = new JLayeredPane();
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
    StringTools m_StringTools = new StringTools();

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

        SimpleAttributeSet attr = new SimpleAttributeSet();
        textArea.setBounds(50, 75, 1400, 300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(255, 255, 255));
        textArea.setFont(new Font("Lucida Sans", Font.PLAIN, 24));
        textArea.setBorder(BorderFactory.createLineBorder(new Color(255, 0, 0)));
        textArea.setEditable(false);
        
        blueButton.setBounds(0, 0, 750, 200);
        blueButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        blueButton.setHorizontalTextPosition(JButton.CENTER);
        blueButton.setBackground(new Color(150, 150, 250));
        blueButton.addActionListener(this);

        redButton.setBounds(0, 0, 750, 200);
        redButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        redButton.setHorizontalTextPosition(JButton.CENTER);
        redButton.setBackground(new Color(250, 150, 150));
        redButton.addActionListener(this);

        greenButton.setBounds(0, 0, 750, 200);
        greenButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        greenButton.setHorizontalTextPosition(JButton.CENTER);
        greenButton.setBackground(new Color(150, 250, 150));
        greenButton.addActionListener(this);

        yellowButton.setBounds(0, 0, 750, 200);
        yellowButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        yellowButton.setHorizontalTextPosition(JButton.CENTER);
        yellowButton.setBackground(new Color(250, 250, 150));
        yellowButton.addActionListener(this);

        scoreBlue.setBounds(350, 5, 150, 300);
        scoreBlue.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        scoreBlue.setForeground(new Color(0, 180, 0));
        scoreBlue.setHorizontalTextPosition(JLabel.CENTER);
        scoreBlue.setOpaque(false);
        //scoreBlue.setText("Helllo");
        
        scoreRed.setBounds(350, 5, 150, 300);
        scoreRed.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        scoreRed.setForeground(new Color(0, 180, 0));
        scoreRed.setHorizontalTextPosition(JLabel.CENTER);
        scoreRed.setOpaque(false);
        //scoreRed.setText("Helllo");

        scoreGreen.setBounds(350, 5, 150, 300);
        scoreGreen.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        scoreGreen.setForeground(new Color(0, 180, 0));
        scoreGreen.setHorizontalTextPosition(JLabel.CENTER);
        scoreGreen.setOpaque(false);
        //scoreGreen.setText("+90");

        scoreYellow.setBounds(350, 5, 150, 300);
        scoreYellow.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        scoreYellow.setForeground(new Color(0, 180, 0));
        scoreYellow.setHorizontalTextPosition(JLabel.CENTER);
        scoreYellow.setOpaque(false);
        //scoreYellow.setText("+90");

        blueLayer.setBounds(0, 375, 750, 200);
        blueLayer.add(blueButton, Integer.valueOf(1));
        blueLayer.add(scoreBlue, Integer.valueOf(0));

        redLayer.setBounds(750, 375, 750, 200);
        redLayer.add(redButton, Integer.valueOf(1));
        redLayer.add(scoreRed, Integer.valueOf(0));

        greenLayer.setBounds(0, 575, 750, 200);
        greenLayer.add(greenButton, Integer.valueOf(1));
        greenLayer.add(scoreGreen, Integer.valueOf(0));

        yellowLayer.setBounds(750, 575, 750, 200);
        yellowLayer.add(yellowButton, Integer.valueOf(0));
        yellowLayer.add(scoreYellow, Integer.valueOf(1));

        frame.add(blueLayer);
        frame.add(redLayer);
        frame.add(greenLayer);
        frame.add(yellowLayer);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);
        
        nextQuestion();
    }

    public void nextQuestion(){
        if(question_num > kTotalquestions){
            endScreen(totalScore);
        }
        else{
            startTime = (int) System.currentTimeMillis() / 600;
            fake_real_Answers = m_Randomizer.RandomizeAnswers(question_num, m_SelectTerms.getAnswer(question_num-1), m_StringTools);
            textField.setText("Question " + question_num);
            textArea.setText(m_SelectTerms.getQuestion(question_num-1));
            blueButton.setText(fake_real_Answers[0]);
            redButton.setText(fake_real_Answers[1]);
            greenButton.setText(fake_real_Answers[2]);
            yellowButton.setText(fake_real_Answers[3]);

        }

    }

    public void endScreen(int finalScore){
        frame.setVisible(false);
        EndScreen m_EndScreen = new EndScreen(finalScore);
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
            endTime = (int) System.currentTimeMillis() / 600;
            if(answerInput == m_Randomizer.getAnswerNum()){
                questionScore = (100) - (endTime - startTime);
                totalScore += questionScore;
            }
            displayAnswer();
        }
        if(e.getSource() == redButton){
            answerInput = 1;
            endTime = (int) System.currentTimeMillis() / 600;
            if(answerInput == m_Randomizer.getAnswerNum()){
                questionScore = (100) - (endTime - startTime);
                totalScore += questionScore;
            }
            displayAnswer();
        }
        if(e.getSource() == greenButton){
            answerInput = 2;
            endTime = (int) System.currentTimeMillis() / 600;
            if(answerInput == m_Randomizer.getAnswerNum()){
                questionScore = (100) - (endTime - startTime);
                totalScore += questionScore;
            }
            displayAnswer();
        }
        if(e.getSource() == yellowButton){
            answerInput = 3;
            endTime = (int) System.currentTimeMillis() / 600;
            if(answerInput == m_Randomizer.getAnswerNum()){
                questionScore = (100) - (endTime - startTime);
                totalScore += questionScore;
            }
            displayAnswer();
        }

    }

    public void displayAnswer(){
        blueButton.setEnabled(false);
        redButton.setEnabled(false);
        greenButton.setEnabled(false);
        yellowButton.setEnabled(false);
        //scoreBlue.setVisible(true);
        //scoreRed.setVisible(true);
        
        if(answerInput == 0){
            if(answerInput == m_Randomizer.getAnswerNum()){
                scoreBlue.setText("+" + questionScore);
            }
            else{
                scoreBlue.setText("+0");
            }
            blueLayer.setLayer(scoreBlue, Integer.valueOf(1));
            blueLayer.setLayer(blueButton, Integer.valueOf(0));
        }
        else if(answerInput == 1){
            if(answerInput == m_Randomizer.getAnswerNum()){
                scoreRed.setText("+" + questionScore);
                //scoreRed.setVisible(true);
            }
            else{
                scoreRed.setText("+0");
                //scoreRed.setVisible(true);
            }
            redLayer.setLayer(scoreRed, Integer.valueOf(1));
            redLayer.setLayer(redButton, Integer.valueOf(0));
        }
        else if(answerInput == 2){
            if(answerInput == m_Randomizer.getAnswerNum()){
                scoreGreen.setText("+" + questionScore);
                //scoreGreen.setVisible(true);
            }
            else{
                scoreGreen.setText("+0");
                //scoreGreen.setVisible(true);
            } 
            greenLayer.setLayer(scoreGreen, Integer.valueOf(1));
            greenLayer.setLayer(greenButton, Integer.valueOf(0));
        }
        else if(answerInput == 3){
            if(answerInput == m_Randomizer.getAnswerNum()){
                scoreYellow.setText("+" + questionScore);
                //scoreYellow.setVisible(true);
            }
            else{
                scoreYellow.setText("+0");
                //scoreYellow.setVisible(true);
            }
            yellowLayer.setLayer(scoreYellow, Integer.valueOf(1));
            yellowLayer.setLayer(yellowButton, Integer.valueOf(0));
        }

        Timer pause = new Timer(2000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e){
                blueLayer.setLayer(scoreBlue, Integer.valueOf(0));
                blueLayer.setLayer(blueButton, Integer.valueOf(1));
                redLayer.setLayer(scoreRed, Integer.valueOf(0));
                redLayer.setLayer(redButton, Integer.valueOf(1));
                greenLayer.setLayer(scoreGreen, Integer.valueOf(0));
                greenLayer.setLayer(greenButton, Integer.valueOf(1));
                yellowLayer.setLayer(scoreYellow, Integer.valueOf(0));
                yellowLayer.setLayer(yellowButton, Integer.valueOf(1));
                answerInput = -2;
                question_num++;

                blueButton.setEnabled(true);
                redButton.setEnabled(true);
                greenButton.setEnabled(true);
                yellowButton.setEnabled(true);
                nextQuestion();

            }
        
        });
        pause.setRepeats(false);
        pause.start();
        

    }

    
    
}
