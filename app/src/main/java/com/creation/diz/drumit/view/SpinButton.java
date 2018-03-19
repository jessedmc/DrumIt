package com.creation.diz.drumit.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.events.BtnBpmDownClickEvent;
import com.creation.diz.drumit.events.BtnBpmDownTouchUpEvent;
import com.creation.diz.drumit.events.BtnBpmUpClickEvent;
import com.creation.diz.drumit.events.BtnBpmUpTouchUpEvent;
import com.creation.diz.drumit.handler.Handler;

/**
 * Created by Diz on 3/3/2018.
 */

public class SpinButton extends ToggleButton {
    private final int UP = 100, DOWN = 101;
    private int index, type;

    public SpinButton(Context context, LinearLayout parent, int index, int type) {
        super(context);


        this.setTextOff("");
        this.setTextOn("");
        this.setText("");

        this.index = index;
        this.setSoundEffectsEnabled(false);

        // layout
        // -- add button to parent
        parent.addView(this);//, this.getLayoutParams());

        // -- button width, height
        this.setLayoutParams(new LinearLayout.LayoutParams(LayoutManager.UP_BUTTON_WIDTH, LayoutManager.UP_BUTTON_WIDTH));

        if (type == UP) {
            this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.upoff));
            this.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Handler.instance().handleEvent(BtnBpmUpClickEvent.instance());
                        break;
                    case MotionEvent.ACTION_UP:
                        Handler.instance().handleEvent(BtnBpmUpTouchUpEvent.instance());
                        break;
                }
                return true;
                }
            });
        }
        else if (type == DOWN) {
            this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.downoff));
            this.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Handler.instance().handleEvent(BtnBpmDownClickEvent.instance());
                        break;
                    case MotionEvent.ACTION_UP:
                        Handler.instance().handleEvent(BtnBpmDownTouchUpEvent.instance());
                        break;
                }
                return true;
                }
            });
        }


    }
}
