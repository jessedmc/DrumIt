package com.creation.diz.drumit.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        this.setLayoutParams(new LinearLayout.LayoutParams(60, 90));



        // -- add a space after the button unless its the last button
        if ((index == 3) || (index == 7) || (index == 11)) {
            // space
            Space space = new Space(this.getContext());
            space.setMinimumWidth(5);
            space.setMinimumHeight(20);
            parent.addView(space);

            // separator
            ImageView imgSeparator = new ImageView(this.getContext());
            imgSeparator.setImageDrawable(ContextCompat.getDrawable(this.getContext(), R.drawable.separator));
            parent.addView(imgSeparator);

            // space
            Space space2 = new Space(this.getContext());
            space2.setMinimumWidth(5);
            space2.setMinimumHeight(20);
            parent.addView(space2);
        }
        else {
            Space space = new Space(this.getContext());
            space.setMinimumWidth(10);
            space.setMinimumHeight(20);
            parent.addView(space);
        }

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
