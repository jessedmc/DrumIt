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

import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {

    // XML controls
    TextView textView;
    TextView textView2;
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
        textView2 = (TextView)findViewById(R.id.textView2);
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
        // current sample changed so modify the sequencer cells to represent only the current sample
        if (Controller.instance().getCurrentSampleHasChanged()) {
            Controller.instance().printSequencerAndSampleList();
            // sequencer cells that have current sample
            for (int i = 0; i < 16; i++) {   // *** There is an issue here, not right
                for (int j = 0; j < Controller.instance().getCellSampleListLength(i); j++) {
                    if (Controller.instance().getCellAndSampleMatchCurrentSample(i, j)) {
                        //this.textView.setText("in main update getCellAndSample i: " + i + "j: " + j);
                        this.setBtnSequencerBackground(i, j);
                        break;
                    }
                    else {  // set default backgound if sample is not in sequencer cell
                        this.btnSequencer[i].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.emptycell));
                    }
                }

            }

            // display sample selector box
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
        }

        // if there was a click on a sequencer cell
        if (Controller.instance().getSequencerCellListHasChanged() > -1) {
            // get index of current sample so we know which pic to change the cell to
            int currentSampleIndex = Controller.instance().getCurrentSampleIndex();

            // get index of current sequencer cell (the one that was clicked on)
            int currentSequencerCellIndex = Controller.instance().getCurrentSequencerCellIndex();

            // clicked sequncer cell change
            this.setBtnSequencerBackground(currentSequencerCellIndex, currentSampleIndex);
        }

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



            /*
            // play sound if in pause mode
            if (Model.instance().getPauseMode().isInPauseMode()) {  // change to controller not model
                this.textView.setText(this.textView.getText() + " in the play part");
                this.mediaPlayer = MediaPlayer.create(this.getApplicationContext(), R.raw.fx2);
                try {
                    //this.mediaPlayer.setDataSource(this.getApplicationContext(), Model.instance().getCurrentSample().getUri());
                    //this.mediaPlayer.setDataSource(this.getApplicationContext(), Model.instance().getCurrentSample().getUri());
                    //this.mediaPlayer.prepare();
                    this.mediaPlayer.setVolume(50, 50);
                    this.mediaPlayer.start();
                    this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            mp.stop();
                            mp.release();
                        }
                    });
                  

                }
                catch (Exception err) {
                    this.textView.setText("error on pause mode sample play");
                    err.printStackTrace();
                }
                this.mediaPlayer.release();
                */


    }// end update

    public void setBtnSequencerBackground(int btnSequencerIndex, int sampleIndex) {
        switch (sampleIndex) {
            case 0:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell0));
                break;
            case 1:
                this.textView.setText("in main setBtnSeqBack case 1");
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell1));
                break;
            case 2:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell2));
                break;
            case 3:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell3));
                break;
            case 4:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell4));
                break;
            case 5:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell5));
                break;
            case 6:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell6));
                break;
            case 7:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell7));
                break;
            case 8:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell8));
                break;
            case 9:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell9));
                break;
            default:
        }
    }


    public void setTextView(String str) {
        textView.setText(str);
    }
    public void setTextView2(String str) {
        textView2.setText(str);
    }
    public String getTextView2Text() {
        return (String) this.textView2.getText();
    }

}
