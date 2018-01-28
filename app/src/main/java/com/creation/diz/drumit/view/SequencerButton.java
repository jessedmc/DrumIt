package com.creation.diz.drumit.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.creation.diz.drumit.events.BtnSequencerClickEvent;
import com.creation.diz.drumit.handler.Handler;

/**
 * Created by Diz on 1/27/2018.
 */

public class SequencerButton extends ToggleButton {
    private static int rollingIndex = -1;
    private int index;

    public SequencerButton(Context context) {
        super(context);
       // parent.addView(this);
        this.setLayoutParams(new LinearLayout.LayoutParams(80, 100));
        this.setTextOff("");
        this.setTextOn("");
        this.setText("");
        SequencerButton.rollingIndex++;
        this.index = SequencerButton.rollingIndex;
        this.setSoundEffectsEnabled(false);
        //this.setBackground(Drawable.createFromPath("@drawable/sequencercellcustom"));
        this.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Handler.instance().handleEvent(BtnSequencerClickEvent.instance(), index);
            }
        });
    }
}
