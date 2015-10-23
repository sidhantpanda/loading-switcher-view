package com.sidhantpanda.loadingviewswitcher.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.sidhantpanda.loadingviewswitcher.R;

/**
 * Created by sidhantpanda on 23/10/15.
 */
public class LoadingView extends RelativeLayout {

    private Context context;

    public LoadingView(Context context) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_loading, this);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_loading, this);
    }
}
