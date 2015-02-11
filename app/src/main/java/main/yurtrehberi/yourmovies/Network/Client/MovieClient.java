package main.yurtrehberi.yourmovies.Network.Client;

import java.util.Random;

import main.yurtrehberi.yourmovies.HtmlParser.MovieLinkConstans;
import main.yurtrehberi.yourmovies.Network.Constants.ApiConstants;
import main.yurtrehberi.yourmovies.Network.Service.IMovieService;
import retrofit.RestAdapter;

/**
 * Created by gokhan on 1/19/15.
 */
public class MovieClient {

    private static IMovieService _movieService;

    public static IMovieService getWeather() {
        RestAdapter restAdapter = new RestAdapter.Builder().setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ApiConstants.APIURL)
                .build();
        _movieService = restAdapter.create(IMovieService.class);

        return _movieService;
    }

    public static String getRandomMovie() {
        String randomMovie = null;
        Random random = new Random();

        int getMoviesLength = MovieLinkConstans.movies.length;
        randomMovie = MovieLinkConstans.movies[random.nextInt(getMoviesLength)];

        return randomMovie;


    }
}
