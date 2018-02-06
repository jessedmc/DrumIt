package com.creation.diz.drumit.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.ToggleButton;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.events.BtnPauseClickEvent;
import com.creation.diz.drumit.events.BtnPlayClickEvent;
import com.creation.diz.drumit.events.BtnSampleClickEvent;
import com.creation.diz.drumit.handler.Handler;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 2/6/2018.
 */

public class PlayPauseButton extends ToggleButton {
    private static double screenWidth = 0.0, screenHeight = 0.0;
    private int type;
    private static final int PLAY = 0, PAUSE = 1;

    // for testing purposes, should be removed at some point
    MainActivity main;

    public PlayPauseButton(Context context, LinearLayout parent, MainActivity main, int type) {
        super(context);

        this.main = main;
        this.setTextOff("");
        this.setTextOn("");
        this.setText("");
        this.type = type;
        this.setSoundEffectsEnabled(false);

        // layout
        if (screenWidth == 0.0) {
            screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        }
        if (screenHeight == 0.0) {
            screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;
        }

        // -- add button to parent
        parent.addView(this);//, this.getLayoutParams());

        // -- sample button width, height
        this.setLayoutParams(new LinearLayout.LayoutParams(80, 80));


        // -- add a space after the button unless its the last button
        Space space = new Space(this.getContext());
        space.setMinimumWidth(80);
        space.setMinimumHeight(40);
        parent.addView(space);

        // -- background image and onclick
        if (this.type == PLAY) {
            this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.playoff));
            this.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Model.instance().toTextView("sample click");
                    Handler.instance().handleEvent(BtnPlayClickEvent.instance());
                }
            });
        }
        else if (this.type == PAUSE) {
            this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.pauseon));
            this.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Model.instance().toTextView("sample click");
                    Handler.instance().handleEvent(BtnPauseClickEvent.instance());
                }
            });
        }


    }
}
