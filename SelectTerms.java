import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import java.util.random.*;
public class SelectTerms {

    private String termURL;
    private static String[] question_set_arr = new String[53];
    private static String[] answer_set_arr = new String[53];
    public static String[] question_list = new String[20];
    public static String[] answer_list = new String[20];
    private String question;
    private String answer;
    private String wholeText;
    private String textSplit;
    private Random generator = new Random();
    public static String[] m_question_link_arr = QuestionLinkGenerator.question_link_arr;


    public void makeQuestionAnswerList(StringTools strTools){
        String thisquestion = "";
        String ans = "";
        int paragraphNum = 0;
        for(int i = 0; i<m_question_link_arr.length; i++){
            termURL = m_question_link_arr[i];
            try{
                final Document termDoc = Jsoup.connect(termURL).get();
                Elements paragraph = termDoc.getElementsByTag("p");
                for (int par=0; par < paragraph.size() -1; par++){
                    paragraphNum = par;
                    wholeText = paragraph.get(par).html();
                    //System.out.println(wholeText);
                    //System.out.println(countBreakTags(wholeText));
                    if(wholeText.contains("<br>") && !breakTagAtEnd(wholeText)){
                        textSplit = wholeText.replaceAll("<br>", "\n");
                    }
                    else if(wholeText.contains("1153.")){
                        textSplit = wholeText.replace(") ", " \n ");
                        //System.out.println(textSplit);
                    }
                    else if(wholeText.contains("888.")){
                        textSplit = wholeText.replace("\" ", "\n");
                    }
                    else if(wholeText.contains("Ablemann")){
                        textSplit = wholeText.replace("&lt;", "");
                        textSplit = textSplit.replace("br&gt;", "\n");
                        //textSplit = wholeText.replaceAll("<br>", "");
                    }
                    else if(wholeText.contains(" - ")){
                        textSplit = wholeText.replaceAll(" - ", "\n");
                    }
                    else{
                        textSplit = wholeText;
                    }
    
                    thisquestion = textSplit.substring(textSplit.indexOf("\n")).trim();
                    thisquestion = strTools.removeItalicized(thisquestion);
                    thisquestion = strTools.fixPunctuation(thisquestion);
                    
                    question_set_arr[par] = thisquestion;
                    ans = textSplit.substring(textSplit.indexOf(".") + 1, textSplit.indexOf("\n")).trim();
                    ans = strTools.removeItalicized(ans);
                    ans = strTools.fixPunctuation(ans);
                    answer_set_arr[par] = ans;
                }
                int selectedIndex = generator.nextInt(paragraph.size() - 1);  
                question_list[i] = question_set_arr[selectedIndex];
                answer_list[i] = answer_set_arr[selectedIndex];
            }
            catch(Exception e){
                System.out.println("not here" + paragraphNum);

            }
        }
    }

    public static boolean breakTagAtEnd(String str){
        int lastIndex = 0;
        String findStr = "<br>";
        while(lastIndex < str.length() - 4){
            lastIndex = str.indexOf(findStr, lastIndex);
            if(lastIndex < str.length() - 5){
                return false;
            }
        }
        return true;
    }

    public String getQuestion(int index){
        return question_list[index];
    }

    public String getAnswer(int index){
        return answer_list[index];
    }

    public void test(StringTools strTools){
        int count = 0;
        String ans;
        String question;
        
        try{
            final Document termDoc = Jsoup.connect("https://www.apstudent.com/ushistory/cards/cards32.html").get();
            Elements paragraph = termDoc.getElementsByTag("p");
            for (int par=0; par < paragraph.size() -1; par++){
                wholeText = paragraph.get(par).html();
                //System.out.println(wholeText);
                //System.out.println(countBreakTags(wholeText));
                //System.out.println(wholeText);
                if(wholeText.contains("<br>") && !breakTagAtEnd(wholeText)){
                    textSplit = wholeText.replaceAll("<br>", "\n");
                }
                else if(wholeText.contains("1153.")){
                    textSplit = wholeText.replace(") ", " \n ");
                    //System.out.println(textSplit);
                }
                else if(wholeText.contains("888.")){
                    textSplit = wholeText.replace("\" ", "\n");
                }
                else if(wholeText.contains("Ablemann")){
                    textSplit = wholeText.replace("&lt;", "");
                    textSplit = textSplit.replace("br&gt;", "\n");
                    //textSplit = wholeText.replaceAll("<br>", "");
                }
                else if(wholeText.contains(" - ")){
                    textSplit = wholeText.replaceAll(" - ", "\n");
                }
                else{
                    textSplit = wholeText;
                }
                count++;
                
                question = textSplit.substring(textSplit.indexOf("\n")).trim();
                question = strTools.removeItalicized(question);
                question = strTools.fixPunctuation(question);
                question_set_arr[par] = question;
                ans = textSplit.substring(textSplit.indexOf(".") + 1, textSplit.indexOf("\n")).trim();
                ans = strTools.removeItalicized(ans);
                ans = strTools.fixPunctuation(ans);
                //System.out.println(ans);
            }
            int selectedIndex = generator.nextInt(paragraph.size() - 1);
            //System.out.println(question_arr.length);
            //for(String q: question_arr){
              //  System.out.println(q);
            //}
            question = question_set_arr[selectedIndex];
            System.out.println(question);
        }
        catch(Exception e){
            System.out.println("not here");
        }
    }

    public static void main (String[] args){
        SelectTerms select = new SelectTerms();
        StringTools st = new StringTools();
        //select.makeQuestionAnswerList();
        select.test(st);
        
    }

    
}
