package main.yurtrehberi.yourmovies.HtmlParser;

import java.io.IOException;

import main.yurtrehberi.yourmovies.Network.Client.MovieClient;

/**
 * Created by gokhan on 1/24/15.
 */
public class main {
    public static void main(String[] args) throws IOException {

        MoviesParseImpl _iparse = new MoviesParseImpl();
        System.out.println(_iparse.getAllMovies());

        System.out.println(MovieClient.getRandomMovie());

    }
}
