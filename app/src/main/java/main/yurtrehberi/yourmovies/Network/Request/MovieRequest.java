package main.yurtrehberi.yourmovies.Network.Request;

/**
 * Created by gokhan on 1/19/15.
 */
public class MovieRequest {

    private String Title;
    private String Year;
    private String Released;
    private String Runtime;
    private String Genre;
    private String Actors;
    private String Plot;

    public String getImdbRating() {
        return imdbRating;
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getReleased() {
        return Released;
    }

    public String getRuntime() {
        return Runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public String getActors() {
        return Actors;
    }

    public String getPlot() {
        return Plot;
    }

    public String getPoster() {
        return Poster;
    }

    public String getAwards() {
        return Awards;
    }

    private String imdbRating;
    private String Poster;
    private String Awards;
}
