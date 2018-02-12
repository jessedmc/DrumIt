package com.creation.diz.drumit.view;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
    LinearLayout linearLayoutPlayPause;
    ImageView sampleSelector;
    ImageView seqCellIndicator;
    ConstraintLayout rootLayout;

    // dynamic controls
    SequencerButton btnSequencer[];
    SampleButton btnSample[];
    PlayPauseButton btnPlay;
    PlayPauseButton btnPause;


    // data
    SoundPool soundPool = new SoundPool.Builder().build();
    int[] soundId = new int[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // default, keep these two lines first
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // instantiate Model
        Model.instance();

        // set horizontal
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // hide navigation bar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        // set display in controller
        Controller.instance().setDisplay(this);


        // identify xml controls, controls from design view
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        this.linearLayoutSample = (LinearLayout)findViewById(R.id.linearLayoutSample);
        this.linearLayoutSequencer = (LinearLayout)findViewById(R.id.linearLayoutSequencer);
        this.sampleSelector = (ImageView)findViewById(R.id.sampleSelector);
        this.seqCellIndicator = (ImageView)findViewById(R.id.seqCellIndicator);
        this.linearLayoutPlayPause = (LinearLayout)findViewById(R.id.linearLayoutPlayPause);
        this.rootLayout = (ConstraintLayout)findViewById(R.id.rootLayout);

        // create play pause buttons
        this.btnPlay = new PlayPauseButton(this.getApplicationContext(), this.linearLayoutPlayPause, this, 0);
        this.btnPause = new PlayPauseButton(this.getApplicationContext(), this.linearLayoutPlayPause, this, 1);

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

        // sequencer cell indicator layout
        this.seqCellIndicator.setPadding(30, 0, 0, 20);
        this.seqCellIndicator.getLayoutParams().height = 30;
        this.seqCellIndicator.getLayoutParams().width = 50;

        // sample layout padding
        this.linearLayoutSample.setPadding(20, 0, 0, 0);

        // sequencer layout padding
        this.linearLayoutSequencer.setPadding(10, 0, 10, 50);

        // play/pause layout padding
        this.linearLayoutPlayPause.setPadding(60, 0, 0, 100);

     //   this.textView.setText("screenWidth: " + SampleButton.getScreenWidth() + "  screenHeight: " + SampleButton.getScreenHeight() + "  btnSample1.left: " + this.btnSample[1].getLeft());

        // sample selector
        this.sampleSelector.setImageDrawable(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleselectortrans));
        this.sampleSelector.setVisibility(View.INVISIBLE);

        // load samples to sound pool
        this.soundId[0] = this.soundPool.load(this.getApplicationContext(), R.raw.kick, 0);
        this.soundId[1] = this.soundPool.load(this.getApplicationContext(), R.raw.snare, 0);
        this.soundId[2] = this.soundPool.load(this.getApplicationContext(), R.raw.hitom, 0);
        this.soundId[3] = this.soundPool.load(this.getApplicationContext(), R.raw.lowtom, 0);
        this.soundId[4] = this.soundPool.load(this.getApplicationContext(), R.raw.closedhihat, 0);
        this.soundId[5] = this.soundPool.load(this.getApplicationContext(), R.raw.openhihat, 0);
        this.soundId[6] = this.soundPool.load(this.getApplicationContext(), R.raw.cymbal, 0);
        this.soundId[7] = this.soundPool.load(this.getApplicationContext(), R.raw.rimshot, 0);
        this.soundId[8] = this.soundPool.load(this.getApplicationContext(), R.raw.fx1, 0);
        this.soundId[9] = this.soundPool.load(this.getApplicationContext(), R.raw.fx2, 0);




    } // end onCreate()

    public void update() {
        // hide navigation bar
        /*
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        */

        // current sample changed so modify the sequencer cells to represent only the current sample
        if (Controller.instance().getCurrentSampleHasChanged()) {
            Controller.instance().printSequencerAndSampleList();
            // sequencer cells that have current sample
            for (int i = 0; i < 16; i++) {
                if (Controller.instance().getCellAndSampleMatchCurrentSample(i)) {
                    //this.textView.setText("in main update getCellAndSample i: " + i + "j: " + j);
                    this.setBtnSequencerBackground(i, Controller.instance().getCurrentSample().getIndex());
                }
                else {  // set default backgound if sample is not in sequencer cell
                    this.btnSequencer[i].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.emptycell));
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
            params.width = 112;
            params.height = 90;
            this.sampleSelector.setTranslationX(left + 10);
            this.sampleSelector.setTranslationY(20);
            this.sampleSelector.setVisibility(View.VISIBLE);
            this.rootLayout.bringChildToFront(this.sampleSelector);

            // play sample
            if (Controller.instance().isInPauseMode()) {
                this.soundPool.play(this.soundId[Controller.instance().getCurrentSample().getIndex()], 1.0f, 1.0f, 0, 0, 1.0f);
            }
        } // end sampleHasChanged

        // if there was a click on a sequencer cell
        if (Controller.instance().getSequencerCellListHasChanged() > -1) {
            // get index of current sample so we know which pic to change the cell to
            int currentSampleIndex = Controller.instance().getCurrentSampleIndex();

            // get index of current sequencer cell (the one that was clicked on)
            int currentSequencerCellIndex = Controller.instance().getCurrentSequencerCellIndex();

            // if the change to sequencer cell list was an add
            if (Controller.instance().isSequencerCellListAddChanged()) {
                // clicked sequencer cell change
                this.setBtnSequencerBackground(currentSequencerCellIndex, currentSampleIndex);
            }
            else if (Controller.instance().isSequencerCellListRemoveChanged()) {
                this.btnSequencer[currentSequencerCellIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.emptycell));
            }
        }

        // play / pause modes have changed
        if (Controller.instance().playPauseHasChanged()) {
            if (Controller.instance().isInPlayMode()) {    // in play mode
                this.btnPlay.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.playon));
                this.btnPause.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.pauseoff));
            }
            else if (Controller.instance().isInPauseMode()) {
                this.btnPlay.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.playoff));
                this.btnPause.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.pauseon));
            }
        }


    }// end update

    public void updatePlayer(int[] soundIndex) {
        if (soundIndex.length > 0) {
            this.soundPool.play(soundIndex[0], 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

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
