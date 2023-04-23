
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Random;
import java.util.random.*;

public class QuestionLinkGenerator {
    private SelectTerm m_SelectTerm = new SelectTerm();
    private static final String webURL = "https://www.apstudent.com/ushistory/cards.php";
    private static String[] link_arr = new String[31];
    public static String[] question_link_arr = new String[20];
    private static int index = 0;

    Random generator = new Random();

    private void generateLinks(){
        try{
            final Document document = Jsoup.connect(webURL).get();
            Elements links = document.select("a[href]");
            for (Element link : links) {
                if(link.text().contains("1") && !link.text().contains("1603")){
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
            int selected = generator.nextInt(30);
            question_link_arr[i] = link_arr[selected];
            System.out.println(selected);
        }
    }

    public void createLinkArray(){
        generateLinks();
        randomizeQuestions();
    }

    public void generateTerm(){
        m_SelectTerm.selectQuestion();
    }

    public static void main(String[] args){
        QuestionLinkGenerator q = new QuestionLinkGenerator();

        q.createLinkArray();
        q.generateTerm();
        
    }
    
}
