package com.creation.diz.drumit.view;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.samples.Sample;

public class MainActivity extends AppCompatActivity {

    // XML controls
    TextView textView;
    LinearLayout linearLayoutSample;
    LinearLayout linearLayoutSequencer;
    Space sampleSelector;

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
        this.sampleSelector = (Space)findViewById(R.id.sampleSelector);
        this.linearLayoutSequencer = (LinearLayout)findViewById(R.id.linearLayoutSequencer);

        // create sequencer buttons for GUI
        this.btnSequencer = new SequencerButton[Controller.instance().getNumOfSequencerCells()];
        for (int i = 0; i < Controller.instance().getNumOfSequencerCells(); i++) {
            this.btnSequencer[i] = new SequencerButton(this.getApplicationContext(), this.linearLayoutSequencer, i);
        }


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

        // sample selector Space
        this.sampleSelector.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleselectortrans));
        //this.sampleSelector.setVisibility(View.INVISIBLE);
        //this.sampleSelector.setLayoutParams(new ViewGroup.LayoutParams(100, 50));
        this.sampleSelector.setLeft(100);
        this.sampleSelector.setTop(300);


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
        if (Controller.instance().getCurrentSample().hasChanged()) {
            this.textView.setText(this.textView.getText() + "  entered sample update");
            int sampleIndex = -1;
            sampleIndex = Controller.instance().getCurrentSample().getIndex();
            int left = 0, top = 0;

            left = this.btnSample[sampleIndex].getLeft();
            top = this.btnSample[sampleIndex].getTop();

           // this.sampleSelector.setLeft(left - 10);
           // this.sampleSelector.setTop(top - 10);
            this.sampleSelector.setLeft(100);
            this.sampleSelector.setTop(300);
            this.sampleSelector.setVisibility(View.VISIBLE);
            this.sampleSelector.bringToFront();

        }
    }

    public void setTextView(String str) {
        textView.setText(str);
    }

}
