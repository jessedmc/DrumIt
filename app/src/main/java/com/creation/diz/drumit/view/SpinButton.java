package com.creation.diz.drumit.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

/**
 * Created by Diz on 3/3/2018.
 */

public class SpinButton extends ToggleButton {
    private int index;

    public SpinButton(Context context, LinearLayout parent, int index) {
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
        this.setLayoutParams(new LinearLayout.LayoutParams(LayoutManager.SEQ_CELL_WIDTH, LayoutManager.SEQ_CELL_HEIGHT));
    }
}
