import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import java.util.random.*;
public class SelectTerm {

    private String termURL;
    public static String[] question_arr = new String[50];
    private String question;
    private String wholeText;
    private String textSplit;
    private Random generator = new Random();
    public static String[] m_question_link_arr = QuestionLinkGenerator.question_link_arr;


    public void selectQuestion(){
        for(int i = 0; i<m_question_link_arr.length; i++){
            termURL = m_question_link_arr[i];
            try{
                final Document termDoc = Jsoup.connect(termURL).get();
                Elements paragraph = termDoc.getElementsByTag("p");
                for (int par=0; par < paragraph.size() -1; par++){
                    wholeText = paragraph.get(par).html();
                    //System.out.println(wholeText);
                    //System.out.println(countBreakTags(wholeText));
                    if(wholeText.contains("<br>") && !breakTagatEnd(wholeText)){
                        textSplit = wholeText.replaceAll("<br>", "\n");
                    }
                    else if(wholeText.contains("1153.")){
                        textSplit = wholeText.replace(") ", " \n ");
                        //System.out.println(textSplit);
                    }
                    else if(wholeText.contains("br>")){
                        textSplit = wholeText.replaceAll("br>", "\n");
                    }
                    else{
                        textSplit = wholeText.replaceAll(" - ", "\n");
                    }
    
                    question_arr[par] = textSplit.substring(textSplit.indexOf("\n"));
                    //System.out.println(textSplit.substring(textSplit.indexOf("\n")));
                }
                int selectedIndex = generator.nextInt(question_arr.length);  
                question = question_arr[selectedIndex];
                System.out.println(question + "\n");
            }
            catch(Exception e){
                System.out.println("not here");

            }
        }
    }

    private int countBreakTags(String str){
        int lastIndex = 0;
        String findStr = "<br>";
        int count = 0;
        while (lastIndex < str.length()) {
            lastIndex = str.indexOf(findStr,lastIndex);
            
            if( lastIndex != -1){
                count++;
            }     
            lastIndex += findStr.length();
        }
        return count;
    }

    private boolean breakTagatEnd(String str){
        int lastIndex = 0;
        String findStr = "<br>";
        while(lastIndex < str.length()){
            lastIndex = str.indexOf(findStr, lastIndex);
            if(lastIndex < str.length()){
                return false;
            }
        }
        return true;
    }

    public void test(){
        int count = 0;
        try{
            final Document termDoc = Jsoup.connect("https://www.apstudent.com/ushistory/cards/cards15.html").get();
            Elements paragraph = termDoc.getElementsByTag("p");
            for (int par=0; par < paragraph.size() -1; par++){
                wholeText = paragraph.get(par).html();
                //System.out.println(wholeText);
                //System.out.println(countBreakTags(wholeText));
                //System.out.println(wholeText);
                if(wholeText.contains("<br>") && !breakTagatEnd(wholeText)){
                    textSplit = wholeText.replaceAll("<br>", "\n");
                }
                else if(wholeText.contains("1153.")){
                    textSplit = wholeText.replace(") ", " \n ");
                    //System.out.println(textSplit);
                }
                else if(wholeText.contains("br>")){
                    textSplit = wholeText.replaceAll("br>", "\n");
                }
                else if(wholeText.contains(" - ")){
                    textSplit = wholeText.replaceAll(" - ", "\n");
                }
                else{
                    textSplit = wholeText;
                }
                count++;

                question_arr[par] = textSplit.substring(textSplit.indexOf("\n"));
                //System.out.println(textSplit.substring(textSplit.indexOf("\n")) + par);
            }
            int selectedIndex = generator.nextInt(question_arr.length);
            //System.out.println(question_arr.length);
            //for(String q: question_arr){
              //  System.out.println(q);
            //}
            question = question_arr[selectedIndex];
            System.out.println(question + "\n");
        }
        catch(Exception e){
            System.out.println("not here");
        }
    }

    public static void main (String[] args){
        SelectTerm select = new SelectTerm();
        select.selectQuestion();
        //select.test();
    }

    
}
