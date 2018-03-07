package com.creation.diz.drumit.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.ToggleButton;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.events.BtnExportClickEvent;
import com.creation.diz.drumit.events.BtnNewClickEvent;
import com.creation.diz.drumit.events.BtnNewTouchEvent;
import com.creation.diz.drumit.events.BtnPauseClickEvent;
import com.creation.diz.drumit.events.BtnPlayClickEvent;
import com.creation.diz.drumit.events.BtnSampleClickEvent;
import com.creation.diz.drumit.handler.Handler;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 2/6/2018.
 */

public class PlayButton extends ToggleButton {
    private static double screenWidth = 0.0, screenHeight = 0.0;
    private int type;
    private static final int PLAY = 0, PAUSE = 1, NEW_BUTTON = 2, EXPORT = 3;


    public PlayButton(Context context, LinearLayout parent, int type) {
        super(context);

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
        this.setLayoutParams(new LinearLayout.LayoutParams(LayoutManager.PLAY_BUTTON_WIDTH, LayoutManager.PLAY_BUTTON_WIDTH));


        // -- add a space after the button unless its the last button
        if (this.type < 4) {
            Space space = new Space(this.getContext());
            space.setMinimumWidth(LayoutManager.PLAY_BUTTON_SPACE);
            space.setMinimumHeight(LayoutManager.PLAY_BUTTON_WIDTH);
            parent.addView(space);
        }

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
        else if (this.type == NEW_BUTTON) {
            this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.newoff));
            this.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            Handler.instance().handleEvent(BtnNewTouchEvent.instance());
                            break;
                        case MotionEvent.ACTION_UP:
                            Handler.instance().handleEvent(BtnNewClickEvent.instance());
                            break;
                    }
                    return true;
                }
            });
        }
        else if (this.type == EXPORT) {
            this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.exportoff));
            this.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    // Model.instance().toTextView("sample click");
                    Handler.instance().handleEvent(BtnExportClickEvent.instance());
                }
            });
        }




    }
}
