package main.yurtrehberi.yourmovies.HtmlParser;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gokhan on 1/24/15.
 */
public class MoviesParseImpl implements IParse {
    ArrayList<String> allLinks = null;
    Random random = null;
    Document doc = null;
    String randomMovie = null;

    @Override
    public String getRandomMoviesLink() {


        try {
            allLinks = new ArrayList<String>();
            random = new Random();
            allLinks.add(MovieLinkConstans.URL_2006);
            allLinks.add(MovieLinkConstans.URL_2007);
            allLinks.add(MovieLinkConstans.URL_2008);
            allLinks.add(MovieLinkConstans.URL_2009);
            allLinks.add(MovieLinkConstans.URL_2010);
            allLinks.add(MovieLinkConstans.URL_2011);
            allLinks.add(MovieLinkConstans.URL_2012);
            allLinks.add(MovieLinkConstans.URL_2013);
            // allLinks.add(MovieLinkConstans.URL_2014);
            // allLinks.add(MovieLinkConstans.URL_2015);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return allLinks.get(0 + random.nextInt(allLinks.size()));
    }

    @Override
    public String getMoviesName() {
        try {


            doc = Jsoup.connect(getRandomMoviesLink())
                    .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").method(Connection.Method.GET).get();
            Elements links = doc.select("a>h3");
            randomMovie = links.get(random.nextInt(links.size() - 1)).text();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return randomMovie;

    }

    public String getAllMovies() {
        try {


            doc = Jsoup.connect(getRandomMoviesLink())
                    .header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X; de-de) AppleWebKit/523.10.3 (KHTML, like Gecko) Version/3.0.4 Safari/523.10").method(Connection.Method.GET).get();
            Elements links = doc.select("a>h3");

            randomMovie = links.get(1).text();

            System.out.println(randomMovie.length());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return randomMovie;

    }

}
