package com.creation.diz.drumit.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.ToggleButton;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.events.BtnSampleClickEvent;
import com.creation.diz.drumit.events.BtnSequencerClickEvent;
import com.creation.diz.drumit.handler.Handler;
import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.samples.SampleList;

/**
 * Created by Diz on 1/29/2018.
 */

public class SampleButton extends ToggleButton {
    private static double screenWidth = 0.0, screenHeight = 0.0;
    private int index;

    // for testing purposes, should be removed at some point
    MainActivity main;

    public SampleButton(Context context, LinearLayout parent, MainActivity main, int index) {
        super(context);

        this.main = main;
        this.setTextOff("");
        this.setTextOn("");
        this.setText("");
        this.index = index;
        this.setSoundEffectsEnabled(false);

        // -- add button to parent
        parent.addView(this);//, this.getLayoutParams());

        // -- sample button width, height
        this.setLayoutParams(new LinearLayout.LayoutParams(LayoutManager.SAMPLE_WIDTH, LayoutManager.SAMPLE_HEIGHT));



        // -- add a space after the button unless its the last button
        if (index < 9) {
            Space space = new Space(this.getContext());
            space.setMinimumWidth(LayoutManager.SAMPLE_GAP);
            space.setMinimumHeight(LayoutManager.SAMPLE_HEIGHT);
            parent.addView(space);
        }

        // -- background image
        //main.setTextView("this.index: " + this.index);
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

        // on click
        this.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               //Model.instance().toTextView("sample click");
                Handler.instance().handleEvent(BtnSampleClickEvent.instance(), ((SampleButton)view).index);
            }
        });

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
