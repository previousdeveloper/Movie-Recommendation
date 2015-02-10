package main.yurtrehberi.yourmovies.ExternalLibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.flavienlaurent.discrollview.lib.Discrollvable;

/**
 *
 */
public class DiscrollvableLastLayout extends RelativeLayout implements Discrollvable {

    private static final String TAG = "DiscrollvableLastLayout";


    private float mLastView1TranslationX;
    private float mLastView2TranslationX;
    private float mLastView3TranslationX;

    private float mLastView1TranslationY;
    private float mLastView2TranslationY;
    private float mLastView3TranslationY;

    public DiscrollvableLastLayout(Context context) {
        super(context);
    }

    public DiscrollvableLastLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscrollvableLastLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();


    }

    @Override
    public void onResetDiscrollve() {

    }

    @Override
    public void onDiscrollve(float ratio) {
    }
}
