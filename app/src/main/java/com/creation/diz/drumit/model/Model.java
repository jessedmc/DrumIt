package com.creation.diz.drumit.model;

import android.widget.Toast;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.modes.PauseMode;
import com.creation.diz.drumit.modes.PlayMode;
import com.creation.diz.drumit.samples.Sample;
import com.creation.diz.drumit.samples.SampleList;
import com.creation.diz.drumit.sequencer.SequencerCell;
import com.creation.diz.drumit.sequencer.SequencerCellList;

import java.util.Iterator;

/**
 * Created by Diz on 1/27/2018.
 */

public class Model {
    private static Model instance;
    public final int NUM_OF_CELLS = 16, NUM_OF_SAMPLES = 10;
    private int selectedSequencerCell = 0;
    private int currentDrumKit = 0;
    private SequencerCellList sequencerCellList = SequencerCellList.instance();
    private SampleList sampleList = SampleList.instance();
    private Sample currentSample;
    private SequencerCell currentSequencerCell;
    private PlayMode playMode = PlayMode.instance();
    private PauseMode pauseMode = PauseMode.instance();

    // singleton constructor
    private Model() {

        // make sample list
        for (int i = 0; i < this.NUM_OF_SAMPLES; i++) {
            this.sampleList.add(new Sample(i));
        }

        // make sequencerCell list
        for (int i = 0; i < this.NUM_OF_CELLS; i++) {
            this.sequencerCellList.add(new SequencerCell());
        }

    }

    // singleton method
    public static Model instance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    // update
    public void updateView() {
        Controller.instance().updateView();
    }

    public void startPlayMode() {
        this.pauseMode.stop();
        this.playMode.start();
        this.playMode.setChanged();
    }

    // toast msg, for testing
    public void makeToast(String str) {
        Toast toast = Toast.makeText(Controller.instance().getContext(), str, Toast.LENGTH_LONG);
    }

    // for testing
    public void toTextView(String str) {
        Controller.instance().toTextView(str);
    }

    public void setCurrentSample(int index) {
        Iterator<Sample> iter = this.sampleList.iterator();
        while (iter.hasNext()) {
            Sample sample = (Sample)iter.next();
            Model.instance().toTextView("sample.index: " + sample.getIndex() + " sample: " + sample.toString() + " paramIndex: " + index);
            if (sample.getIndex() == index) {
                this.currentSample = sample;
                break;
            }
        }
       // this.toTextView(" currentSample: " + this.currentSample.toString());
        if (Model.instance().getCurrentSample() == null) {
            //Model.instance().toTextView("current sample is null");
        }
        else {
            Model.instance().toTextView("current sample: " + this.currentSample.getIndex());
            Model.instance().getCurrentSample().setChanged();
            Model.instance().updateView();
        }
    }

    public void selectSequencerCell(int index) {
        this.selectedSequencerCell = index;
    }

    public Sample getCurrentSample() {
        return currentSample;
    }

    public void setCurrentSample(Sample sample) {
        this.currentSample = currentSample;
    }

    public SequencerCell getCurrentSequencerCell() {
        return currentSequencerCell;
    }

    public PlayMode getPlayMode() {
        return playMode;
    }

    public PauseMode getPauseMode() {
        return pauseMode;
    }

    public int getCurrentDrumKit() {
        return currentDrumKit;
    }

    public void setCurrentDrumKit(int currentDrumKit) {
        this.currentDrumKit = currentDrumKit;
    }

    public SequencerCellList getSequencerCellList() {
        return sequencerCellList;
    }

    public void setSequencerCellList(SequencerCellList sequencerCellList) {
        this.sequencerCellList = sequencerCellList;
    }

    public SampleList getSampleList() {
        return sampleList;
    }

    public void setSampleList(SampleList sampleList) {
        this.sampleList = sampleList;
    }

    public void setCurrentSequencerCell(SequencerCell currentSequencerCell) {
        this.currentSequencerCell = currentSequencerCell;
    }
}
