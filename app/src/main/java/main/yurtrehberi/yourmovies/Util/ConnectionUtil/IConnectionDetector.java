package main.yurtrehberi.yourmovies.Util.ConnectionUtil;

import com.google.inject.Singleton;

/**
 * Created by gokhan on 1/15/15.
 */

@Singleton
public interface IConnectionDetector {

    public boolean isConnectingToInternet();
}
