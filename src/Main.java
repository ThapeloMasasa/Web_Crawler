public class Main {
    public static void main(String[] args) {
    WebCrawler crawler = new WebCrawler();
    String rootUrl = "https://www.nytimes.com/";
    crawler.crawl(rootUrl, 100);
    }
}