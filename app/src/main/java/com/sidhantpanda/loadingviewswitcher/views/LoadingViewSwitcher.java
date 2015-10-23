package com.sidhantpanda.loadingviewswitcher.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.sidhantpanda.loadingviewswitcher.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sidhantpanda on 23/10/15.
 */
public class LoadingViewSwitcher extends RelativeLayout {

    private static final String TAG = "LoadingViewSwitcherV";

    private int child_count = -1;

    private Context context;

    private View childView;

    private View layoutLoading;

    private View layoutError;

    int id_layout_loading = -1, id_layout_error = -1;

    RelativeLayout thisLayout;

    public LoadingViewSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.view_loading_view_switcher, this);

        thisLayout = (RelativeLayout) findViewById(R.id.view_loading_view_switcher);

        layoutLoading = new LoadingView(context);
        layoutLoading.setLayoutParams(new LoadingView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        layoutError = new ErrorView(context);
        layoutError.setLayoutParams(new ErrorView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (child_count < 0) {
            child_count = this.getChildCount() - 1;
            if (child_count > 0) {
                childView = this.getChildAt(1);
                this.getChildAt(1).setVisibility(GONE);

                this.addView(layoutLoading);
                this.addView(layoutError);

                layoutLoading.setVisibility(VISIBLE);
                layoutError.setVisibility(GONE);
            }
        }
    }

    public void showLoading() {
        layoutLoading.setVisibility(VISIBLE);
        childView.setVisibility(GONE);
        layoutError.setVisibility(GONE);
    }

    public void showContent() {
        layoutLoading.setVisibility(GONE);
        childView.setVisibility(VISIBLE);
        layoutError.setVisibility(GONE);
    }

    public void showError() {
        layoutLoading.setVisibility(GONE);
        childView.setVisibility(GONE);
        layoutError.setVisibility(VISIBLE);
    }
}
