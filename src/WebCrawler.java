import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

    private Queue<String> urlQueue;
    private List<String> visitedURLs;

    public WebCrawler(){
        urlQueue = new LinkedList<>();
        visitedURLs = new ArrayList<>();
    }
 private int getMaxUrls(int maxNumUrls, Matcher matcher) {
     while (matcher.find()) {
         String realUrl = matcher.group();

         if (!visitedURLs.contains(realUrl)) {
             visitedURLs.add(realUrl);
             System.out.println("Website found with url " + realUrl);
             urlQueue.add(realUrl);
         }

         //Exit the loop if we reached max num urls
         if (maxNumUrls == 0) {
             break;
         }
         maxNumUrls--;
     }
     return maxNumUrls;
 }
    public void crawl(String rootURL, int maxNumUrls){
        urlQueue.add(rootURL);
        visitedURLs.add(rootURL);

        while(!urlQueue.isEmpty()){
            String s = urlQueue.remove();  // the url at the front of the queue
            String rawHtml = "";

            try{
                URL url = new URL(s); // covert the string to be a URL object
                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                String inputLine = in.readLine();

                //read all lines of the HTML
                while(inputLine != null){
                    rawHtml += inputLine;
                    inputLine = in.readLine();
                }
                in.close();
            }catch(Exception e){
                e.printStackTrace();

            }
            String urlPattern = "(www|http:|https:)+[^\s]+[\\w]";
            Pattern pattern = Pattern.compile(urlPattern);
            Matcher matcher = pattern.matcher(rawHtml);

            //matching urls to the regex are added to the queue
            maxNumUrls = getmaxUrls(maxNumUrls, matcher);

            if(maxNumUrls == 0){
                break;
            }
        }
    }
}
