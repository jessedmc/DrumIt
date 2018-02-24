package com.creation.diz.drumit.view;

import android.util.DisplayMetrics;

/**
 * Created by Diz on 2/21/2018.
 */

public class LayoutManager {
    private static LayoutManager instance;
    DisplayMetrics metrics = new DisplayMetrics();
    int screenWidth = 0, screenHegiht = 0;

    // singleton constructor
    private LayoutManager() {

    }

    // singleton instance
    public static LayoutManager instance() {
        if (instance == null) {
            instance = new LayoutManager();
        }
        return instance;
    }

    public void initialize(MainActivity mainActivity) {
        mainActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        this.screenHegiht = metrics.heightPixels;
        this.screenWidth = metrics.widthPixels;
    }
}
