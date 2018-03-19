package com.creation.diz.drumit.view;

import android.util.DisplayMetrics;
import android.util.Log;

import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 2/21/2018.
 */

public class LayoutManager {
    private static LayoutManager instance;
    DisplayMetrics metrics = new DisplayMetrics();
    public static int SCREEN_WIDTH = 0, SCREEN_HEIGHT = 0;

    // sequencer horizontal, horizontal percent is 1.07772 of screen width (107.772 %)
    public static int SEQ_CELL_WIDTH = 0, SEQ_CELL_PADDING_LEFT = 0, SEQ_CELL_GAP = 0, SEQ_CELL_PADDING_BOTTOM = 0;
    public static int SEQ_CELL_GAP_SEPARATOR = 0, SEQ_CELL_SEPARATOR_WIDTH = 1, SEQ_CELL_HORIZONTAL = 0, SEQ_CELL_HEIGHT = 0;
    public static double SEQ_CELL_WIDTH_PERCENT = 0.05767, SEQ_CELL_WIDTH_PERCENT_TOTAL = 0.0;
    public static double SEQ_CELL_PADDING_LEFT_PERCENT = 0.013, SEQ_CELL_PADDING_LEFT_PERCENT_TOTAL = 0.0;
    public static double SEQ_CELL_GAP_PERCENT = 0.008, SEQ_CELL_GAP_PERCENT_TOTAL = 0.0;
    public static double SEQ_CELL_GAP_SEPARATOR_PERCENT = 0.0055, SEQ_CELL_GAP_SEPARATOR_PERCENT_TOTAL = 0.0;
    public static double SEQ_CELL_SEPARATOR_PERCENT = 0.0, SEQ_CELL_SEPARATOR_PERCENT_TOTAL = 0.0;
    public static double SEQ_CELL_HORIZONTAL_PERCENT_TOTAL = 0.0;
    public static double SEQ_CELL_PADDING_BOTTOM_PERCENT = 0.1, SEQ_CELL_HEIGHT_PERCENT = 0.135;

    // samples
    public static int SAMPLE_PADDING_BOTTOM = 0, SAMPLE_HEIGHT = 0;
    public static double SAMPLE_PADDING_BOTTOM_PERCENT = 0.1;
    public static int SAMPLE_WIDTH = 0, SAMPLE_PADDING_LEFT = 0, SAMPLE_GAP = 0, SAMPLE_HORIZONTAL = 0;
    public static double SAMPLE_WIDTH_PERCENT = 0.09, SAMPLE_PADDING_LEFT_PERCENT = 0.000, SAMPLE_GAP_PERCENT = 0.01;
    public static double SAMPLE_WIDTH_PERCENT_TOTAL = 0.0, SAMPLE_PADDING_LEFT_PERCENT_TOTAL = 0.0, SAMPLE_GAP_PERCENT_TOTAL = 0.0;
    public static double SAMPLE_HORIZONTAL_PERCENT_TOTAL = 0.0, SAMPLE_HEIGHT_PERCENT = 0.08;

    // play buttons
    public static int PLAY_BUTTON_WIDTH = 0, PLAY_BUTTON_SPACE = 0, PLAY_BUTTON_PADDING_LEFT = 0, PLAY_BUTTON_PADDING_BOTTOM = 0;
    public static double PLAY_BUTTON_WIDTH_PERCENT = 0.05, PLAY_BUTTON_SPACE_PERCENT = 0.03, PLAY_BUTTON_PADDING_LEFT_PERCENT = 0.06;
    public static double PLAY_BUTTON_PADDING_BOTTOM_PERCENT = 0.2;

    // up buttons
    public static int UP_BUTTON_WIDTH = 0, UP_BUTTON_SPACE = 0, UP_BUTTON_PADDING_LEFT = 0, UP_BUTTON_PADDING_BOTTOM = 0;
    public static double UP_BUTTON_WIDTH_PERCENT = 0.05, UP_BUTTON_SPACE_PERCENT = 0.03, UP_BUTTON_PADDING_LEFT_PERCENT = 0.1;
    public static double UP_BUTTON_PADDING_BOTTOM_PERCENT = 0.03;

    // down buttons
    public static int DOWN_BUTTON_WIDTH = 0, DOWN_BUTTON_SPACE = 0, DOWN_BUTTON_PADDING_LEFT = 0, DOWN_BUTTON_PADDING_BOTTOM = 0;
    public static double DOWN_BUTTON_PADDING_BOTTOM_PERCENT = 0.1;

    // changing text
    public static int CHANGING_TEXT_PADDING_BOTTOM = 0, CHANGING_TEXT_FONT_SIZE = 14;
    public static double CHANGING_TEXT_PADDING_BOTTOM_PERCENT = 0.04;

    // up text
    public static int UP_TEXT_PADDING_BOTTOM = 0, UP_TEXT_FONT_SIZE = 14;
    public static double UP_TEXT_PADDING_BOTTOM_PERCENT = 0.04;


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
        SCREEN_HEIGHT = metrics.heightPixels;
        SCREEN_WIDTH = metrics.widthPixels;

        // sequencer horizontal
            // percent totals
        SEQ_CELL_WIDTH_PERCENT_TOTAL = SEQ_CELL_WIDTH_PERCENT * 16.0;
        SEQ_CELL_PADDING_LEFT_PERCENT_TOTAL = SEQ_CELL_PADDING_LEFT_PERCENT * 2.0;
        SEQ_CELL_GAP_PERCENT_TOTAL = SEQ_CELL_GAP_PERCENT * 12.0;
        SEQ_CELL_GAP_SEPARATOR_PERCENT_TOTAL = SEQ_CELL_GAP_SEPARATOR_PERCENT * 6.0;

            // separator percent
        SEQ_CELL_SEPARATOR_PERCENT = SEQ_CELL_SEPARATOR_WIDTH / SCREEN_WIDTH;
        SEQ_CELL_SEPARATOR_PERCENT_TOTAL = SEQ_CELL_SEPARATOR_PERCENT * 3.0;

            // calculate values from percents
        SEQ_CELL_WIDTH = (int)(SEQ_CELL_WIDTH_PERCENT * SCREEN_WIDTH);
        SEQ_CELL_PADDING_LEFT = (int)(SEQ_CELL_PADDING_LEFT_PERCENT * SCREEN_WIDTH);
        SEQ_CELL_GAP = (int)(SEQ_CELL_GAP_PERCENT * SCREEN_WIDTH);
        SEQ_CELL_GAP_SEPARATOR = (int)(SEQ_CELL_GAP_SEPARATOR_PERCENT * SCREEN_WIDTH);
        SEQ_CELL_PADDING_BOTTOM = (int)(SEQ_CELL_PADDING_BOTTOM_PERCENT * SCREEN_HEIGHT);
        SEQ_CELL_HEIGHT = (int)(SEQ_CELL_HEIGHT_PERCENT * SCREEN_HEIGHT);


            // horizontal in pixels
        SEQ_CELL_HORIZONTAL = (SEQ_CELL_PADDING_LEFT * 2) + (SEQ_CELL_WIDTH * 16) + (SEQ_CELL_GAP * 12) + (SEQ_CELL_GAP_SEPARATOR * 6) + (SEQ_CELL_SEPARATOR_WIDTH * 3);

            // horizontal in percent
        SEQ_CELL_HORIZONTAL_PERCENT_TOTAL = SEQ_CELL_PADDING_LEFT_PERCENT_TOTAL + SEQ_CELL_WIDTH_PERCENT_TOTAL + SEQ_CELL_GAP_PERCENT_TOTAL + SEQ_CELL_GAP_SEPARATOR_PERCENT_TOTAL + SEQ_CELL_SEPARATOR_PERCENT_TOTAL;

        // samples
            // percent totals
        SAMPLE_PADDING_BOTTOM =  (int)(SAMPLE_PADDING_BOTTOM_PERCENT * SCREEN_HEIGHT);
        SAMPLE_WIDTH_PERCENT_TOTAL = (SAMPLE_WIDTH_PERCENT * 10);
        SAMPLE_PADDING_LEFT_PERCENT_TOTAL = (SAMPLE_PADDING_LEFT_PERCENT * 2);
        SAMPLE_GAP_PERCENT_TOTAL = (SAMPLE_GAP_PERCENT * 9);
        SAMPLE_HORIZONTAL_PERCENT_TOTAL =  SAMPLE_WIDTH_PERCENT_TOTAL + SAMPLE_PADDING_LEFT_PERCENT_TOTAL + SAMPLE_GAP_PERCENT_TOTAL;

            // calculate values from percents
        SAMPLE_WIDTH = (int)(SAMPLE_WIDTH_PERCENT * SCREEN_WIDTH);
        SAMPLE_PADDING_LEFT = (int)(SAMPLE_PADDING_LEFT_PERCENT * SCREEN_WIDTH);
        SAMPLE_GAP = (int)(SAMPLE_GAP_PERCENT * SCREEN_WIDTH);
        SAMPLE_HORIZONTAL = (SAMPLE_WIDTH * 10) + (SAMPLE_PADDING_LEFT * 2) + (SAMPLE_GAP * 9);
        SAMPLE_HEIGHT = (int)(SAMPLE_HEIGHT_PERCENT * SCREEN_HEIGHT);


        // play buttons
        PLAY_BUTTON_WIDTH = (int)(PLAY_BUTTON_WIDTH_PERCENT * SCREEN_WIDTH);
        PLAY_BUTTON_SPACE = (int)(PLAY_BUTTON_SPACE_PERCENT * SCREEN_WIDTH);
        PLAY_BUTTON_PADDING_LEFT = (int)(PLAY_BUTTON_PADDING_LEFT_PERCENT * SCREEN_WIDTH);
        PLAY_BUTTON_PADDING_BOTTOM = (int)(PLAY_BUTTON_PADDING_BOTTOM_PERCENT * SCREEN_HEIGHT);

        // up buttons
        UP_BUTTON_WIDTH = (int)(UP_BUTTON_WIDTH_PERCENT * SCREEN_WIDTH);
        UP_BUTTON_PADDING_BOTTOM = (int)(UP_BUTTON_PADDING_BOTTOM_PERCENT * SCREEN_HEIGHT);
        UP_BUTTON_PADDING_LEFT = (int)(UP_BUTTON_PADDING_LEFT_PERCENT * SCREEN_WIDTH);
        UP_BUTTON_SPACE = (int)(UP_BUTTON_SPACE_PERCENT * SCREEN_WIDTH);

        // down buttons
        DOWN_BUTTON_WIDTH = UP_BUTTON_WIDTH;
        DOWN_BUTTON_PADDING_LEFT = UP_BUTTON_PADDING_LEFT;
        DOWN_BUTTON_SPACE = UP_BUTTON_SPACE;
        DOWN_BUTTON_PADDING_BOTTOM = (int)(DOWN_BUTTON_PADDING_BOTTOM_PERCENT * SCREEN_HEIGHT);

        // changing text
        CHANGING_TEXT_PADDING_BOTTOM = (int)(CHANGING_TEXT_PADDING_BOTTOM_PERCENT * SCREEN_HEIGHT);

        // up text
        UP_TEXT_PADDING_BOTTOM = (int)(UP_TEXT_PADDING_BOTTOM_PERCENT * SCREEN_HEIGHT);


        // print stuff
        //this.printSamples();




    }

    public void printSequencer() {
        Model.instance().toTextView("seq cell width percent total: " + SEQ_CELL_WIDTH_PERCENT_TOTAL + "   seq cell left padding percent total: " + SEQ_CELL_PADDING_LEFT_PERCENT_TOTAL +
                "   seq cell horizontal: " + SEQ_CELL_HORIZONTAL +  "   screen width: " + SCREEN_WIDTH + "   seq cell horizontal percent total: " + SEQ_CELL_HORIZONTAL_PERCENT_TOTAL +
                "   seq cell gap percent total: " + SEQ_CELL_GAP_PERCENT_TOTAL + "   seq cell separator gap percent total: " + SEQ_CELL_GAP_SEPARATOR_PERCENT_TOTAL + "   seq cell separator percent total: " + SEQ_CELL_SEPARATOR_PERCENT_TOTAL);
    }

    public void printSamples() {
        Model.instance().toTextView("sample width percent total: " + SAMPLE_WIDTH_PERCENT_TOTAL + "   sample left padding percent total: " + SAMPLE_PADDING_LEFT_PERCENT_TOTAL +
                "   sample horizontal: " + SAMPLE_HORIZONTAL +  "   screen width: " + SCREEN_WIDTH + "   sample horizontal percent total: " + SAMPLE_HORIZONTAL_PERCENT_TOTAL +
                "   sample gap percent total: " + SAMPLE_GAP_PERCENT_TOTAL);
    }




}
