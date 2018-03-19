package com.creation.diz.drumit.view;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.creation.diz.drumit.changeable.Changeable;

/**
 * Created by Diz on 3/19/2018.
 */

public class ChangingText extends android.support.v7.widget.AppCompatTextView {
    private static final int BPM = 100;
    private int type = 0;



    public ChangingText(Context context, int type, LinearLayout parent) {
        super(context);
        this.type = type;

        // -- add button to parent
        parent.addView(this);

        this.setTextSize(LayoutManager.CHANGING_TEXT_FONT_SIZE);

        switch (type) {
            case BPM:
                this.setText("120");
                break;
        }
    }


}
