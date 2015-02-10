package main.yurtrehberi.yourmovies.Ui;

import android.app.ProgressDialog;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.easyandroidanimations.library.BounceAnimation;
import com.squareup.picasso.Picasso;

import main.yurtrehberi.yourmovies.ExternalLibrary.ShakeDetector;
import main.yurtrehberi.yourmovies.ExternalLibrary.SlidingUpPanel;
import main.yurtrehberi.yourmovies.Network.Client.MovieClient;
import main.yurtrehberi.yourmovies.Network.Request.MovieRequest;
import main.yurtrehberi.yourmovies.R;
import main.yurtrehberi.yourmovies.Util.ConnectionUtil.ConnectionDetector;
import main.yurtrehberi.yourmovies.Util.ConnectionUtil.IConnectionDetector;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity implements ShakeDetector.Listener {

    private boolean doubleBackToExitPressedOnce = false;
    ProgressDialog mProgressDialog = null;

    @InjectView(R.id.textTitle)
    TextView textTitle;


    @InjectView(R.id.textPlot)
    TextView textPlot;

    @InjectView(R.id.greenView1)
    TextView greenView1;

    @InjectView(R.id.textActors)
    TextView textActors;

    @InjectView(R.id.textGenre)
    TextView textGenre;

    @InjectView(R.id.textPoint)
    TextView imdbPoint;

    @InjectView(R.id.textRuntime)
    TextView textRuntime;

    @InjectView(R.id.textYear)
    TextView textYear;

    @InjectView(R.id.sliding_up_panel)
    SlidingUpPanel mSlidingUpPanel;

    @InjectView(R.id.image)
    ImageView image;

    @InjectResource(R.string.check_connection)
    String connection_check;

    @InjectResource(R.string.best_movie)
    String bestMovies;


    IConnectionDetector _connectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _connectionDetector = new ConnectionDetector((getApplicationContext()));

        if (_connectionDetector.isConnectingToInternet()) {
            SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
            ShakeDetector sd = new ShakeDetector(this);
            sd.start(sensorManager);
            Toast.makeText(getApplicationContext(), bestMovies.toString(), Toast.LENGTH_LONG).show();


        } else {
            Toast.makeText(getApplicationContext(), connection_check.toString(), Toast.LENGTH_LONG).show();
        }


        textGenre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                mSlidingUpPanel.closePanel();

            }
        });
    }


    public void getMovies() {

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.show();
        mProgressDialog.setContentView(R.layout.custom_layout);
        mProgressDialog.setCancelable(true);

        MovieClient.getWeather().movies(MovieClient.getRandomMovie(), new Callback<MovieRequest>() {
            @Override
            public void success(MovieRequest movieRequest, Response response) {
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();


                if (movieRequest.getPoster() != null) {
                    Picasso.with(getApplicationContext()).load(movieRequest.getPoster()).into(image);
                    textTitle.setText(movieRequest.getTitle());
                    textGenre.setText(movieRequest.getGenre());
                    textRuntime.setText(movieRequest.getRuntime());
                    textYear.setText(movieRequest.getYear());
                    imdbPoint.setText(movieRequest.getImdbRating());
                    textPlot.setText(movieRequest.getPlot());
                    textActors.setText(movieRequest.getActors());
                    if (movieRequest.getPlot() == "N/A") {
                        greenView1.setText("There is no Award");
                    }
                    greenView1.setText(movieRequest.getAwards());

                } else if (movieRequest.getPoster().equals("N/A")) {
                    Picasso.with(getApplicationContext()).load(R.drawable.shake).into(image);
                } else {
                    Picasso.with(getApplicationContext()).load(R.drawable.shake).into(image);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                if (mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
                //     Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public void hearShake() {
        new BounceAnimation(image).animate();

        getMovies();

        if (mProgressDialog.isShowing())
            mProgressDialog.dismiss();


    }

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
        mSlidingUpPanel.closePanel();
    }
}
