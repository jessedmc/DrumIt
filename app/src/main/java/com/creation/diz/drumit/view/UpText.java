package com.creation.diz.drumit.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Space;

/**
 * Created by Diz on 3/19/2018.
 */

public class UpText extends android.support.v7.widget.AppCompatTextView {
    private static final int BPM = 100, VOLUME = 200, PITCH = 300;;
    private int type = 0;



    public UpText(Context context, int type, LinearLayout parent) {
        super(context);
        this.type = type;

        // -- add button to parent
        parent.addView(this);
        Space space = new Space(this.getContext());
        space.setMinimumWidth(LayoutManager.SPIN_BUTTON_SPACE);
        space.setMinimumHeight(10);
        parent.addView(space);

       this.setTextSize(LayoutManager.UP_TEXT_FONT_SIZE);

        switch (type) {
            case BPM:
                this.setText("BPM");
                break;
            case PITCH:
                this.setText("Volume");
                break;
            case VOLUME:
                this.setText("Pitch");
                break;
        }
    }


}
