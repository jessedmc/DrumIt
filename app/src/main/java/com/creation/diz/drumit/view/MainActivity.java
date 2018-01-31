package com.creation.diz.drumit.view;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
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
    ImageView sampleSelector;
    ConstraintLayout rootLayout;

    // dynamic controls
    SequencerButton btnSequencer[];
    SampleButton btnSample[];


    // data
    MediaPlayer mediaPlayer = new MediaPlayer();


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
        this.sampleSelector = (ImageView)findViewById(R.id.sampleSelector);
        this.linearLayoutSequencer = (LinearLayout)findViewById(R.id.linearLayoutSequencer);
        this.rootLayout = (ConstraintLayout)findViewById(R.id.rootLayout);

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

        this.linearLayoutSequencer.setPadding(10, 0, 10, 50);

     //   this.textView.setText("screenWidth: " + SampleButton.getScreenWidth() + "  screenHeight: " + SampleButton.getScreenHeight() + "  btnSample1.left: " + this.btnSample[1].getLeft());

        // sample selector
        this.sampleSelector.setImageDrawable(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleselectortrans));
        this.sampleSelector.setVisibility(View.INVISIBLE);



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
            int sampleIndex = -1;
            sampleIndex = Controller.instance().getCurrentSample().getIndex();
            int left = 0, top = 0;

            // layout
            left = this.btnSample[sampleIndex].getLeft();
            top = this.btnSample[sampleIndex].getTop();
            this.textView.setText(this.textView.getText() + "  entered sample update btnSamle.left: " + left + " btnSample.top: " + top);
            ViewGroup.LayoutParams params = this.sampleSelector.getLayoutParams();
            params.width = 113;
            params.height = 90;
            this.sampleSelector.setTranslationX(left + 10);
            this.sampleSelector.setTranslationY(20);
            this.sampleSelector.setVisibility(View.VISIBLE);
            this.rootLayout.bringChildToFront(this.sampleSelector);

            // play sound if in pause mode
            if (Model.instance().getPauseMode().isInPauseMode()) {  // change to controller not model
                this.mediaPlayer = MediaPlayer.create(this.getApplicationContext(), R.raw.fx1);
                try {
                    //this.mediaPlayer.setDataSource(this.getApplicationContext(), Model.instance().getCurrentSample().getUri());
                    //this.mediaPlayer.setDataSource(this.getApplicationContext(), Model.instance().getCurrentSample().getUri());
                    //this.mediaPlayer.prepare();
                    this.mediaPlayer.start();
                   // this.mediaPlayer.release();

                }
                catch (Exception err) {
                    this.textView.setText("error on pause mode sample play");
                    err.printStackTrace();
                }
                //this.mediaPlayer.release();


            }

        }
    }

    public void setTextView(String str) {
        textView.setText(str);
    }

}
