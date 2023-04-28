import java.util.ArrayList;
public class StringTools {

    public ArrayList<String> findItalicized(String text){
        //int lastIndex = 0;
        String word;
        String choppedText = text;
        ArrayList<String> italicizedWords = new ArrayList<String>();
        while(choppedText.contains("<i>")){
            word = choppedText.substring(text.indexOf("<i>") + 3, text.indexOf("</i>"));
            italicizedWords.add(word);
            choppedText = choppedText.substring(choppedText.indexOf("</i>") + 4);
            System.out.println(choppedText);
        }
        return italicizedWords;
    }

    public String removeItalicized(String text){
        String newText = text.replaceAll("<i>", "");
        return newText.replaceAll("</i>", "");
    }

    public String fixPunctuation(String text){
        String mutableText = text.substring(0, text.length()-1);
        String endCharacter = text.substring(text.length() - 1);
        for(int i = 0; i < mutableText.length(); i++){
            //System.out.println(mutableText.substring(i, i+1).compareTo("?"));
            if((mutableText.substring(i, i+1).compareTo("?")) > 1000 ){
                mutableText = mutableText.replace(mutableText.substring(i, i+1), "\'");
            }
        }
        mutableText = mutableText.replace("amp;", "");
        return mutableText + endCharacter;
    }

    
}
