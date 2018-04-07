import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArticleParser {

    public static void main(String[] args) {
        ArticleParser parser = new ArticleParser();
        Document searchResults = parser.parseUrl("https://index.hu/24ora/?word=1&pepe=1&tol=1999-01-01&ig=2018-04-07&s=soros+gy%C3%B6rgy");
        Elements articles = parser.getArticles(searchResults);
        ArrayList<String> articleUrls = parser.getUrlList(articles);
        parser.parseArticles(articleUrls);
    }

    public Document parseUrl(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public Elements getArticles(Document doc) {
        return doc.getElementsByClass("datum cikk-date-label");
    }

    public ArrayList<String> getUrlList(Elements linkTags) {
        ArrayList<String> urlList = new ArrayList<>();
        for (Element element: linkTags) {
            urlList.add(element.attr("href"));
        }
        return urlList;
    }

    public void writeArticles(String path, String content) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(path, true));
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void parseArticles(ArrayList<String> urls) {
        for(int i = 0; i < urls.size(); i++) {
            Document doc = parseUrl(urls.get(i));
            writeArticles("/home/papp/articles/article" + (i + 1) + ".txt", doc.title() + "\n");
            writeArticles("/home/papp/articles/article" + (i + 1) + ".txt", doc.getElementsByClass("cikk-torzs").text());
        }
    }
}
