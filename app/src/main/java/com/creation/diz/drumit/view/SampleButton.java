package com.creation.diz.drumit.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.ToggleButton;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.events.BtnSequencerClickEvent;
import com.creation.diz.drumit.handler.Handler;

/**
 * Created by Diz on 1/29/2018.
 */

public class SampleButton extends ToggleButton {
    private static int rollingIndex = -1;
    private static double screenWidth = 0.0, screenHeight = 0.0;
    private int index;



    public SampleButton(Context context, LinearLayout parent, MainActivity main) {
        super(context);

        this.setTextOff("");
        this.setTextOn("");
        this.setText("");
        SampleButton.rollingIndex += 1;
        this.index = SampleButton.rollingIndex;
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
        this.setLayoutParams(new LinearLayout.LayoutParams(100, 50));

        // -- add a space after the button unless its the last button
        Space space = new Space(this.getContext());
        space.setMinimumWidth(10);
        space.setMinimumHeight(20);
        parent.addView(space);

        // -- background image
        main.setTextView("this.index: " + this.index);
        // setBackgroundImage() is not working for some reason
      //  this.setBackgroundImage();

        // however this works
        this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample1));

        // on click
        this.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Handler.instance().handleEvent(BtnSamplerClickEvent.instance(), index);
            }
        });
    }

    public void setBackgroundImage() {

        if (this.index == 0)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample0));
        if (this.index == 1)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample1));
        if (this.index == 2)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample2));
        if (this.index == 3)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample3));
        if (this.index == 4)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample4));
        if (this.index == 5)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample5));
        if (this.index == 6)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample6));
        if (this.index == 7)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample7));
        if (this.index == 8)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample8));
        if (this.index == 9)  this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.sample9));
    }

    public static double getScreenWidth() {
        return screenWidth;
    }

    public static double getScreenHeight() {
        return screenHeight;
    }

    public int getIndex() {
        return index;
    }

}
