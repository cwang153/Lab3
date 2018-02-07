import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Webscraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url){
        Scanner urlScanner;
        try{
            urlScanner=new Scanner(new URL(url).openStream(),"UTF-8");
        }catch(IOException e){
            return"";
        }
        String contents=urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] unused) {
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String textUpper = text.toUpperCase();
        String textNew = textUpper.replaceAll("[^a-zA-Z ]","");
        System.out.println(textNew);
        String[] textArray = textNew.split(" ");
        int count = 0;
        for (int i = 0; i < textArray.length; i++){
            if (textArray[i].equals("PRINCE")) {
                count += 1;
            }
        }
        System.out.println(count);

    }
}
