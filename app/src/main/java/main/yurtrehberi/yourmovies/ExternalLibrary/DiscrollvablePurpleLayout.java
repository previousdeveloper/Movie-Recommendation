package main.yurtrehberi.yourmovies.ExternalLibrary;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.flavienlaurent.discrollview.lib.Discrollvable;


/**
 *
 */
public class DiscrollvablePurpleLayout extends LinearLayout implements Discrollvable {

    private static final String TAG = "DiscrollvablePurpleLayout";


    private float mPurpleView1TranslationX;
    private float mPurpleView2TranslationX;

    public DiscrollvablePurpleLayout(Context context) {
        super(context);
    }

    public DiscrollvablePurpleLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DiscrollvablePurpleLayout(Context context, AttributeSet attrs, int defStyle) {
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
