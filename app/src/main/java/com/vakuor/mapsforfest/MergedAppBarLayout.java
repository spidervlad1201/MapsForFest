package com.vakuor.mapsforfest;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by miguel.hincapie on 20/01/2018
 */

public class MergedAppBarLayout extends AppBarLayout {

    protected Toolbar toolbar;
    protected View background;

    public MergedAppBarLayout(Context context) {
        super(context);
        init();
    }

    public MergedAppBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), com.mahc.custombottomsheetbehavior.R.layout.mergedappbarlayout, this);
        //to avoid expose xml attributes to the final programmer user, I added some of them here
        setBackgroundColor(ContextCompat.getColor(getContext(), android.R.color.transparent));
        getContext().setTheme(com.mahc.custombottomsheetbehavior.R.style.AppTheme_AppBarOverlay);

        toolbar = findViewById(com.mahc.custombottomsheetbehavior.R.id.expanded_toolbar);
        background = findViewById(com.mahc.custombottomsheetbehavior.R.id.background);
    }
}
