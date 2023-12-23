import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WebCrawler {

    private Queue<String> urlQueue;
    private List<String> visitedURLs;

    public WebCrawler(){
        urlQueue = new LinkedList<>();
        visitedURLs = new ArrayList<>();
    }
}
