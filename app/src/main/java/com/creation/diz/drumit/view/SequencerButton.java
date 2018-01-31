package com.creation.diz.drumit.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.ToggleButton;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.events.BtnSequencerClickEvent;
import com.creation.diz.drumit.handler.Handler;

/**
 * Created by Diz on 1/27/2018.
 */

public class SequencerButton extends ToggleButton {

    private int index;

    public SequencerButton(Context context, LinearLayout parent, int index) {
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
        this.setLayoutParams(new LinearLayout.LayoutParams(70, 100));

        // -- add a space after the button unless its the last button
        Space space = new Space(this.getContext());
        space.setMinimumWidth(10);
        space.setMinimumHeight(20);
        parent.addView(space);

        // -- background image
        //main.setTextView("this.index: " + this.index);
        this.setBackground(ContextCompat.getDrawable(this.getContext(), R.drawable.emptycell));

        // on click
        this.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Handler.instance().handleEvent(BtnSequencerClickEvent.instance(), ((SequencerButton)view).index);
            }
        });
    }
}
