package com.sidhantpanda.loadingviewswitcher.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.sidhantpanda.loadingviewswitcher.R;

/**
 * Created by sidhantpanda on 23/10/15.
 */
public class ErrorView extends RelativeLayout {

    private Context context;

    public ErrorView(Context context) {
        super(context);
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_error, this);
    }

    public ErrorView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.layout_error, this);
    }
}
