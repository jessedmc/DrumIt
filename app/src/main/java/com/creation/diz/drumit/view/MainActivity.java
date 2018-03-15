package com.creation.diz.drumit.view;

import android.content.pm.ActivityInfo;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

public class MainActivity extends AppCompatActivity {

    // XML controls, made in layout editor
    TextView textView;
    TextView txtSampleName;
    TextView textView2;
    LinearLayout linearLayoutSample;
    LinearLayout linearLayoutSequencer;
    LinearLayout linearLayoutPlayPause;
    LinearLayout linearLayoutUp;
    LinearLayout linearLayoutText;
    LinearLayout linearLayoutDown;
    ImageView sampleSelector;
    ImageView seqCellIndicator;
    ConstraintLayout rootLayout;

    // dynamic controls
    SequencerButton btnSequencer[];
    SampleButton btnSample[];
    PlayButton btnPlay;
    PlayButton btnPause;
    PlayButton btnNew;
    PlayButton btnExport;
    SpinButton btnBpmUp;
    SpinButton btnBpmDown;
    SpinButton btnPitchUp;
    SpinButton btnPitchDown;

    // data
    SoundPool soundPool = new SoundPool.Builder().setMaxStreams(10).build();
    int[] soundId = new int[10];
    private static int countUpdate = 0;

    // sample order
    /*
    kick
    snare
    hitom
    lowtom
    closedhihat
    openhihat
    cymbal
    rimshot
    fx1
    fx2
     */


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
                | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);


        // set display in controller
        Controller.instance().setDisplay(this);




        // identify xml controls, controls from design view
        textView = (TextView)findViewById(R.id.textView);
        txtSampleName = (TextView)findViewById(R.id.txtSampleName);
        textView2 = (TextView)findViewById(R.id.textView2);
        this.linearLayoutSample = (LinearLayout)findViewById(R.id.linearLayoutSample);
        this.linearLayoutDown = (LinearLayout)findViewById(R.id.linearLayoutDown);
        this.linearLayoutText = (LinearLayout)findViewById(R.id.linearLayoutChangingText);
        this.linearLayoutUp = (LinearLayout)findViewById(R.id.linearLayoutUp);
        this.linearLayoutSequencer = (LinearLayout)findViewById(R.id.linearLayoutSequencer);
        this.sampleSelector = (ImageView)findViewById(R.id.sampleSelector);
        this.seqCellIndicator = (ImageView)findViewById(R.id.seqCellIndicator);
        this.linearLayoutPlayPause = (LinearLayout)findViewById(R.id.linearLayoutPlayPause);
        this.rootLayout = (ConstraintLayout)findViewById(R.id.rootLayout);

        // LayoutMananger initialize
        LayoutManager.instance().initialize(this);


        // create play pause buttons
        this.btnPlay = new PlayButton(this.getApplicationContext(), this.linearLayoutPlayPause, 0);
        this.btnPause = new PlayButton(this.getApplicationContext(), this.linearLayoutPlayPause, 1);
        this.btnNew = new PlayButton(this.getApplicationContext(), this.linearLayoutPlayPause, 2);
        this.btnExport = new PlayButton(this.getApplicationContext(), this.linearLayoutPlayPause, 3);

        // create spin buttons (up , down)
        this.btnBpmUp = new SpinButton(this.getApplicationContext(), this.linearLayoutUp, 0, 100); // 100 is up   ,   101 is down
        this.btnBpmDown = new SpinButton(this.getApplicationContext(), this.linearLayoutDown, 1, 101);

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
        this.seqCellIndicator.setVisibility(View.INVISIBLE);

        // sample layout padding
        this.linearLayoutSample.setPadding(LayoutManager.SAMPLE_PADDING_LEFT, 0, 0, LayoutManager.SAMPLE_PADDING_BOTTOM);

        // sequencer layout padding
        this.linearLayoutSequencer.setPadding(LayoutManager.SEQ_CELL_PADDING_LEFT, 0, 0, LayoutManager.SEQ_CELL_PADDING_BOTTOM);

        // play/pause layout padding
        this.linearLayoutPlayPause.setPadding(LayoutManager.PLAY_BUTTON_PADDING_LEFT, 0, 0, LayoutManager.PLAY_BUTTON_PADDING_BOTTOM);

        // linear layout up
        this.linearLayoutUp.setPadding(LayoutManager.UP_BUTTON_PADDING_LEFT, 0, 0, LayoutManager.UP_BUTTON_PADDING_BOTTOM);

        // linear layout down
        this.linearLayoutDown.setPadding(LayoutManager.DOWN_BUTTON_PADDING_LEFT, 0, 0, LayoutManager.DOWN_BUTTON_PADDING_BOTTOM);


     //   this.textView.setText("screenWidth: " + SampleButton.getScreenWidth() + "  screenHeight: " + SampleButton.getScreenHeight() + "  btnSample1.left: " + this.btnSample[1].getLeft());

        // sample selector
        this.sampleSelector.setImageDrawable(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleselectortrans));
        this.sampleSelector.setVisibility(View.INVISIBLE);
        this.sampleSelector.setX(this.linearLayoutSample.getX());
        this.sampleSelector.setY(this.linearLayoutSample.getY());

        // load samples to soundpool
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

        // set testing textviews to blank
        //this.textView.setText("");
        this.textView2.setText("");
        //this.textView.setVisibility(View.VISIBLE);

        // set txtSampleName to blank
        this.txtSampleName.setText("");




        // KEEP LAST
        // pick a default current sample, this contains a call to update
        /*
        try {
            Thread.sleep(1000);
        } catch (Exception err) {

        }
        Controller.instance().setCurrentSampleDefault();      */


    } // end onCreate()

    public void update() {

        this.countUpdate++;
        if (this.countUpdate == 1) {
            this.sampleSelector.setVisibility(View.VISIBLE);
        }

        if (Controller.instance().getCurrentSampleHasChanged()) {
            //Controller.instance().printSequencerAndSampleList();
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
           // this.textView.setText(this.textView.getText() + "  entered sample update btnSamle.left: " + left + " btnSample.top: " + top);
            ViewGroup.LayoutParams params = this.sampleSelector.getLayoutParams();
            params.width = LayoutManager.SAMPLE_WIDTH + 10;
            params.height = LayoutManager.SAMPLE_HEIGHT + 6;
            this.sampleSelector.setTranslationX(left + (LayoutManager.SAMPLE_WIDTH / 2));
            this.sampleSelector.setTranslationY(top - LayoutManager.SAMPLE_HEIGHT);
            this.sampleSelector.setVisibility(View.VISIBLE);
            this.rootLayout.bringChildToFront(this.sampleSelector);

            // play sample
            if (Controller.instance().isInPauseMode()) {
                this.soundPool.play(this.soundId[Controller.instance().getCurrentSample().getIndex()], 1.0f, 1.0f, 0, 0, 1.0f);
            }

            // display name of sample
            this.txtSampleName.setText(Controller.instance().getCurrentSampleName());
        } // end sampleHasChanged

        // if there was a click on a sequencer cell
        int seqCellChanged = Controller.instance().getSequencerCellListHasChanged();
        if (seqCellChanged > -1) {  // -1 is no change
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

            // check the samples currently being used in the sequencer and change btnSample background to used
            if (Controller.instance().getSamplesUsedHasChanged()) {
                //Controller.instance().printSamplesUsed();
                int currentSample = Controller.instance().getCurrentSample().getIndex();
                for (int i = 0; i < btnSample.length; i++) {
                    if (Controller.instance().isSampleUsed(i)) {
                        this.setBtnSampleBackgroundAsUsed(i);
                    }
                    else {
                        this.setBtnSampleBackground(i);
                    }
                }
            }

        }
        else if (seqCellChanged == -10) {       // -10 is new blank sequencer, set samples to regular background (not used)
            for (int i = 0; i < 10; i++) {
                this.setBtnSampleBackground(i);
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

        // bpm text view
        if (Controller.instance().hasBpmViewChanged()) {
            this.textView.setText("bpm: " + Controller.instance().getBpm());
        }


    }// end update

    public void updatePlayer(int[] soundIndex) {
        if (soundIndex.length == 1) {
            this.soundPool.play(soundIndex[0] + 1, 1.0f, 1.0f, 0, 0, 1.0f);
        }
        else if (soundIndex.length > 1) {
            for (int i = 0; i < soundIndex.length; i++) {
                this.soundPool.play(soundIndex[i] + 1, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
    }

    public void setBtnNewTouchDown() {
        this.btnNew.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.newon));
    }

    public void setBtnBpmUpTouchDown() {
        this.btnBpmUp.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.upon));
    }

    public void setBtnBpmUpTouchUp() {
        this.btnBpmUp.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.upoff));
    }

    public void setBtnNewTouchUp() {
        this.btnNew.setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.newoff));
    }

    public void setBtnSampleBackgroundAsUsed(int sampleIndex) {
        switch (sampleIndex) {
            case 0:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused0));
                break;
            case 1:
                //this.textView.setText("in main setBtnSeqBack case 1");
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused1));
                break;
            case 2:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused2));
                break;
            case 3:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused3));
                break;
            case 4:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused4));
                break;
            case 5:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused5));
                break;
            case 6:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused6));
                break;
            case 7:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused7));
                break;
            case 8:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused8));
                break;
            case 9:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sampleused9));
                break;
            default:
        }
    }

    public void setBtnSampleBackground(int sampleIndex) {
        switch (sampleIndex) {
            case 0:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample0));
                break;
            case 1:
                //this.textView.setText("in main setBtnSeqBack case 1");
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample1));
                break;
            case 2:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample2));
                break;
            case 3:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample3));
                break;
            case 4:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample4));
                break;
            case 5:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample5));
                break;
            case 6:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample6));
                break;
            case 7:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample7));
                break;
            case 8:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample8));
                break;
            case 9:
                this.btnSample[sampleIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.sample9));
                break;
            default:
        }
    }

    public void setBtnSequencerBackground(int btnSequencerIndex, int sampleIndex) {
        switch (sampleIndex) {
            case 0:
                this.btnSequencer[btnSequencerIndex].setBackground(ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.cell0));
                break;
            case 1:
                //this.textView.setText("in main setBtnSeqBack case 1");
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
