
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Random;
import java.util.random.*;

public class QuestionGenerator {
    private static final String webURL = "https://www.apstudent.com/ushistory/cards.php";
    private static String[] link_arr = new String[32];
    public static String[] question_link_arr = new String[20];
    private static int index = 0;

    Random generator = new Random();

    private void generateLinks(){
        try{
            final Document document = Jsoup.connect(webURL).get();
            Elements links = document.select("a[href]");
            for (Element link : links) {
                if(link.text().contains("1")){
                    link_arr[index] = link.absUrl("href");
                    //System.out.println(link_arr[index]);
                    index++;
                }
            }

        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void randomizeQuestions(){
        for(int i = 0; i<20; i++){
            int selected = generator.nextInt(32);
            question_link_arr[i] = link_arr[selected];
        }
    }

    public void createLinkArray(){
        generateLinks();
        randomizeQuestions();
    }

    public static void main(String[] args){
        QuestionGenerator q = new QuestionGenerator();

        q.createLinkArray();
        
    }
    
}
