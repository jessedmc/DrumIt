package com.creation.diz.drumit.view;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.samples.Sample;

public class MainActivity extends AppCompatActivity {
    // XML controls
    TextView textView;
    LinearLayout linearLayoutSample;

    // dynamic controls
    SequencerButton btnSequencer[];
    SampleButton btnSample[];

    // data



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // default, keep these two lines first
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate Model
        Model.instance();

        // set horizontal
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // set display in controller
        Controller.instance().setDisplay(this);

        // identify xml controls, controls from design view
        textView = (TextView)findViewById(R.id.textView);
        this.linearLayoutSample = (LinearLayout)findViewById(R.id.linearLayoutSample);
/*
        // create sequencer buttons for GUI
        this.btnSequencer = new SequencerButton[Controller.instance().getNumOfSequencerCells()];
        for (int i = 0; i < Controller.instance().getNumOfSequencerCells(); i++) {
            this.btnSequencer[i] = new SequencerButton(this.getApplicationContext());
        }
        */

        // create sample buttons for GUI
        this.btnSample = new SampleButton[Controller.instance().getNumOfSamples()];
        for (int i = 0; i < Controller.instance().getNumOfSamples(); i++) {
            this.btnSample[i] = new SampleButton(this.getApplicationContext(), linearLayoutSample, this, i);
            //this.textView.setText("btnSample[i] got to i = " + i);
        }
        //this.linearLayoutSample.setTop((int)(0.2 * SampleButton.getScreenHeight()));

        // move the sample linear layout right a little
        this.linearLayoutSample.setPadding(20, 0, 0, 0);

     //   this.textView.setText("screenWidth: " + SampleButton.getScreenWidth() + "  screenHeight: " + SampleButton.getScreenHeight() + "  btnSample1.left: " + this.btnSample[1].getLeft());



    } // end onCreate()

    public void update() {
        // play / pause modes
        if (Model.instance().getPlayMode().hasChanged()) {
            if (Model.instance().getPlayMode().isInPlayMode()) {    // just entered play mode
                // MediaPlayer plays through SequencerCellList.sample here
            }
        }
        if (Model.instance().getPauseMode().hasChanged()) {
            if (Model.instance().getPauseMode().isInPauseMode()) {
                // pause mode
            }
        }

        // sample selected
        if (Model.instance().getCurrentSample().hasChanged()) {

        }
    }

    public void setTextView(String str) {
        textView.setText(str);
    }

}
