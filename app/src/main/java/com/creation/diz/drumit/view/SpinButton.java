package com.creation.diz.drumit.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.ToggleButton;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.events.BtnBpmDownClickEvent;
import com.creation.diz.drumit.events.BtnBpmDownTouchUpEvent;
import com.creation.diz.drumit.events.BtnBpmUpClickEvent;
import com.creation.diz.drumit.events.BtnBpmUpTouchUpEvent;
import com.creation.diz.drumit.events.BtnPitchDownClickEvent;
import com.creation.diz.drumit.events.BtnPitchDownTouchUpEvent;
import com.creation.diz.drumit.events.BtnPitchUpClickEvent;
import com.creation.diz.drumit.events.BtnPitchUpTouchUpEvent;
import com.creation.diz.drumit.events.BtnVolumeDownClickEvent;
import com.creation.diz.drumit.events.BtnVolumeDownTouchUpEvent;
import com.creation.diz.drumit.events.BtnVolumeUpClickEvent;
import com.creation.diz.drumit.events.BtnVolumeUpTouchUpEvent;
import com.creation.diz.drumit.handler.Handler;

/**
 * Created by Diz on 3/3/2018.
 */

public class SpinButton extends ToggleButton {
    private final int UP = 50, DOWN = 51;
    private final int BPM = 100, VOLUME = 200, PITCH = 300;;
    private int index;

    public SpinButton(Context context, LinearLayout parent, int index, int upDownType, final int controlType) {
        super(context);
        // 50 up , 51 , down , 100 bpm , 300 pitch , 200 volume

        this.setTextOff("");
        this.setTextOn("");
        this.setText("");

        this.index = index;
        this.setSoundEffectsEnabled(false);

        // layout
        // -- add button to parent
        parent.addView(this);//, this.getLayoutParams());
       // if (upDownType == UP) {
            Space space = new Space(this.getContext());
            space.setMinimumWidth(LayoutManager.SPIN_BUTTON_SPACE);
            space.setMinimumHeight(10);
            parent.addView(space);
      //  }

        // -- button width, height
        this.setLayoutParams(new LinearLayout.LayoutParams(LayoutManager.UP_BUTTON_WIDTH, LayoutManager.UP_BUTTON_WIDTH));

        if (upDownType == UP) {
            this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.upoff));
            this.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (controlType == BPM) {
                            Handler.instance().handleEvent(BtnBpmUpClickEvent.instance());
                        }
                        else if (controlType == PITCH) {
                            Handler.instance().handleEvent(BtnPitchUpClickEvent.instance());
                        }
                        else if (controlType == VOLUME) {
                            Handler.instance().handleEvent(BtnVolumeUpClickEvent.instance());
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (controlType == BPM) {
                            Handler.instance().handleEvent(BtnBpmUpTouchUpEvent.instance());
                        }
                        else if (controlType == PITCH) {
                            Handler.instance().handleEvent(BtnPitchUpTouchUpEvent.instance());
                        }
                        else if (controlType == VOLUME) {
                            Handler.instance().handleEvent(BtnVolumeUpTouchUpEvent.instance());
                        }
                        break;
                }
                return true;
                }
            });
        }
        else if (upDownType == DOWN) {
            this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.downoff));
            this.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        if (controlType == BPM) {
                            Handler.instance().handleEvent(BtnBpmDownClickEvent.instance());
                        }
                        else if (controlType == PITCH) {
                            Handler.instance().handleEvent(BtnPitchDownClickEvent.instance());
                        }
                        else if (controlType == VOLUME) {
                            Handler.instance().handleEvent(BtnVolumeDownClickEvent.instance());
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (controlType == BPM) {
                            Handler.instance().handleEvent(BtnBpmDownTouchUpEvent.instance());
                        }
                        else if (controlType == PITCH) {
                            Handler.instance().handleEvent(BtnPitchDownTouchUpEvent.instance());
                        }
                        else if (controlType == VOLUME) {
                            Handler.instance().handleEvent(BtnVolumeDownTouchUpEvent.instance());
                        }

                        break;
                }
                return true;
                }
            });
        }


    }
}
