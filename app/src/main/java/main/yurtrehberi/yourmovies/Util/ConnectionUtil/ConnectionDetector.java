package main.yurtrehberi.yourmovies.Util.ConnectionUtil;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by gokhan on 1/15/15.
 */
public class ConnectionDetector implements IConnectionDetector {

    private Context _context;


    public ConnectionDetector(Context _context) {
        this._context = _context;
    }


    @Override
    public boolean isConnectingToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo[] info = connectivityManager.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }


        }
        return false;
    }
}
