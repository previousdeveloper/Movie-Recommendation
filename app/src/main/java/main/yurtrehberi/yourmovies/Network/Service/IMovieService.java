package main.yurtrehberi.yourmovies.Network.Service;


import main.yurtrehberi.yourmovies.Network.Request.MovieRequest;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by gokhan on 1/19/15.
 */
public interface IMovieService {


    @GET("/")
    public void movies(@Query("t") String title, Callback<MovieRequest> callBackMovieRequest);
}
