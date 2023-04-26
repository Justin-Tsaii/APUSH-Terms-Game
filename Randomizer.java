import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class Randomizer {
    public static String[] m_QuestionLinkArr = QuestionLinkGenerator.question_link_arr;
    public static int AnswerNum = -1;
    Random selector = new Random();

    public String[] RandomizeAnswers(int questionNum, String answer){
        String[] answerList = createAnswerList(m_QuestionLinkArr[questionNum-1]);
        String[] selectedAnswers = new String[] {"", "", "", ""};
        String chosenAnswer;
        int index;
        selectedAnswers[0] = answer;
        for(int i = 1; i<selectedAnswers.length; i++){
            index = selector.nextInt(50);
            chosenAnswer = answerList[index];
            //System.out.println("working");
            while(isInArray(selectedAnswers, chosenAnswer)){
                index = selector.nextInt(50);
                chosenAnswer = answerList[index];
            }
            selectedAnswers[i] = answerList[index];
        }
        index = selector.nextInt(0, 4);
        swapElements(selectedAnswers, 0, index);
        setAnswerNum(index);

        return selectedAnswers;
    }

    private String[] createAnswerList(String termLink){
        String[] answerList = new String[50];
        String wholeText, textSplit;
        try{
            final Document termDoc = Jsoup.connect(termLink).get();
            Elements paragraph = termDoc.getElementsByTag("p");
            for (int par=0; par < paragraph.size() -1; par++){
                wholeText = paragraph.get(par).html();
                if(wholeText.contains("<br>") && !SelectTerms.breakTagAtEnd(wholeText)){
                    answerList[par] = wholeText.substring(wholeText.indexOf(". ") + 2, wholeText.indexOf("<br>"));
                    //textSplit = wholeText.replaceAll("<br>", "\n");
                }
                else if(wholeText.contains("1153.")){
                    answerList[par] = wholeText.substring(wholeText.indexOf(". ") + 2, wholeText.indexOf(") "));
                    //textSplit = wholeText.replace(") ", " \n ");
                    //System.out.println(textSplit);
                }
                else if(wholeText.contains("888.")){
                    answerList[par] = wholeText.substring(wholeText.indexOf(". ") + 2, wholeText.indexOf("\" "));
                }
                else if(wholeText.contains("br>")){
                    answerList[par] = wholeText.substring(wholeText.indexOf(". ") + 2, wholeText.indexOf("br>"));
                    //textSplit = wholeText.replaceAll("br>", "\n");
                }
                else{
                    answerList[par] = wholeText.substring(wholeText.indexOf(". ") + 2, wholeText.indexOf(" - "));
                    //textSplit = wholeText.replaceAll(" - ", "\n");
                }
            }
        }
        catch(Exception e){
            System.out.println("not here");
            return answerList;

        }
        return answerList;
    }

    private boolean isInArray(String[] arr, String str){
        for(String s: arr){
            if(s.equals(str)){
                return true;
            }
        }
        return false;
    }

    private void setAnswerNum(int num){
        AnswerNum = num;
    }

    public int getAnswerNum(){
        return AnswerNum;
    }

    private void swapElements(String[] arr, int indexA, int indexB){
        String temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }

    public static void main(String[] args){
        Randomizer r = new Randomizer();
        String[] s = r.RandomizeAnswers(5, "John Brown's Raid");
        for(String str : s){
            System.out.println(str + "\n");
        }
    }
    
}
