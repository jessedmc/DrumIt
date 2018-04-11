package com.creation.diz.drumit.controller;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.samples.Sample;
import com.creation.diz.drumit.sequencer.SequencerCell;
import com.creation.diz.drumit.view.MainActivity;

import java.util.Iterator;

/**
 * Created by Diz on 1/27/2018.
 */

public class Controller {
    private static Controller instance;
    private MainActivity display;

    // singleton constructor
    private Controller() {

    }

    // singleton
    public static Controller instance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // update view
    public void updateView() {
        this.display.update();
    }

    // update player
    public void updatePlayer(int[] soundIndex) {
        this.display.updatePlayer(soundIndex);
    }

    public void selectBtnSequencer(int index) {
        Model.instance().selectSequencerCell(index);
    }

    // get context, for testing
    public Context getContext() {
        return this.display.getApplicationContext();
    }

    // for testing
    public void toTextView(String str) {
        this.display.setTextView(str);
    }
    public void toTextView2(String str) {
        this.display.setTextView2(str);
    }
    public void printSequencerAndSampleList() {
        this.toTextView2("");
        this.toTextView("seqCellListLength: " + Model.instance().getSequencerCellList().size());
        for (int i = 0; i < Model.instance().getSequencerCellList().size(); i++) {
            for (int j = 0; j < Model.instance().getSequencerCellList().search(i).getSampleList().size(); j++) {
                this.toTextView2(this.display.getTextView2Text() + " i: " + i + "j: " + j + " ind: " + Model.instance().getSampleIndexFromSeqList(i, j) + " ^^ ");
            }
        }
    }
    public void printSamplesUsed() {
        this.toTextView2("samples used: ");
        for (int i = 0; i < Model.instance().getSamplesUsed().getSamples().size(); i++) {
            this.toTextView2(this.display.getTextView2Text() + " " +  Model.instance().getSamplesUsed().getSamples().get(i));
        }

    }

    // ****************** Getters Setters ******************** //

    public boolean hasPitchChanged() {
        return Model.instance().hasPitchChanged();
    }

    public boolean hasVolumeChanged() {
        return Model.instance().hasVolumeChanged();
    }

    public int getPitch() {
        return Model.instance().getPitch();
    }

    public int getVolume() {
        return Model.instance().getVolume();
    }

    public float getRate(int sampleIndex) {
        double pitch = (double)Model.instance().getPitch(sampleIndex);
        double base = 5.0;
        float rate = (float)(pitch / base);
        return rate;
    }

    public float getVolume(int sampleIndex) {
        return (float)((double)Model.instance().getVolume(sampleIndex) / 10.0);
    }

    public boolean hasBpmViewChanged() {
        return Model.instance().getBpm().hasViewChanged();
    }

    public int getBpm() {
        return Model.instance().getBpm().getBpm();
    }

    public void setBtnNewTouchDown() {
        this.display.setBtnNewTouchDown();
    }

    public void setBtnBpmUpTouchDown() {
        this.display.setBtnBpmUpTouchDown();
    }

    public void setBtnVolumeUpTouchDown() {
        this.display.setBtnVolumeUpTouchDown();
    }

    public void setBtnVolumeUpTouchUp() {
        this.display.setBtnVolumeUpTouchUp();
    }

    public void setBtnVolumeDownTouchDown() {
        this.display.setBtnVolumeDownTouchDown();
    }

    public void setBtnVolumeDownTouchUp() {
        this.display.setBtnVolumeDownTouchUp();
    }

    public void setBtnPitchUpTouchDown() {
        this.display.setBtnPitchUpTouchDown();
    }

    public void setBtnPitchUpTouchUp() {
        this.display.setBtnPitchUpTouchUp();
    }

    public void setBtnPitchDownTouchDown() {
        this.display.setBtnPitchDownTouchDown();
    }

    public void setBtnPitchDownTouchUp() {
        this.display.setBtnPitchDownTouchUp();
    }

    public void setBtnBpmDownTouchDown() {
        this.display.setBtnBpmDownTouchDown();
    }

    public void setBtnBpmDownTouchUp() {
        this.display.setBtnBpmDownTouchUp();
    }

    public void setBtnBpmUpTouchUp() {
        this.display.setBtnBpmUpTouchUp();
    }

    public void setBtnNewTouchUp() {
        this.display.setBtnNewTouchUp();
    }

    public String getCurrentSampleName() {
        return Model.instance().getCurrentSample().getSampleName();
    }
    public boolean isSampleUsed(int index) {
        //this.toTextView2(this.display.getTextView2Text() + " seqCell index: ");
        for (int i = 0; i < Model.instance().getSamplesUsed().getSamples().size(); i++) {
            if (Model.instance().getSamplesUsed().getSamples().get(i) == index) {
                return true;
            }
        }
        return false;
    }

    public boolean getSamplesUsedHasChanged() {
        if (Model.instance().getSamplesUsed().hasChanged()) {
            return true;
        }
        return false;
    }

    public void setCurrentSampleDefault() {
        Model.instance().setCurrentSample(0);
    }
    public boolean playPauseHasChanged() {
        return Model.instance().playPauseHasChanged();
    }
    public boolean isInPlayMode() {
        return Model.instance().isInPlayMode();
    }

    public boolean isInPauseMode() {
        return Model.instance().isInPauseMode();
    }

    public boolean isSequencerCellListAddChanged() {
        return Model.instance().getSequencerCellList().isAddChanged();
    }

    public boolean isSequencerCellListRemoveChanged() {
        return Model.instance().getSequencerCellList().isRemoveChanged();
    }

    public boolean getCurrentSampleHasChanged() {
        return Model.instance().getCurrentSample().hasChanged();
    }

    public int getCellSampleListLength(int index) {
        SequencerCell cell = Model.instance().getSequencerCellList().search(index);
        return cell.getSampleList().size();
    }

    public boolean getCellAndSampleMatchCurrentSample(int i) {
        SequencerCell cell = Model.instance().getSequencerCellList().search(i);
       // this.toTextView("cell found to put color: " + cell.getIndex());
        Iterator<Sample> iter = cell.getSampleList().iterator();
        while (iter.hasNext()) {
            Sample sample = (Sample)iter.next();
            if (sample.getIndex() == Model.instance().getCurrentSample().getIndex()) {
                //this.toTextView2("in match(" + i + ") sample.index: " + sample.getIndex());
                return true;
            }
        }
        return false;
    }

    public int getCurrentSequencerCellIndex() {
        return Model.instance().getCurrentSequencerCell().getIndex();
    }

    public int getCurrentSampleIndex() {
        return Model.instance().getCurrentSample().getIndex();
    }

    public int getSequencerCellListHasChanged() {
        if (Model.instance().getSequencerCellList().hasChanged()) {
            //this.display.setTextView("in seq cell list has changed index: " + Model.instance().getCurrentSequencerCell().getIndex());
            return Model.instance().getCurrentSequencerCell().getIndex();
        }
        return -1;
    }

    public Sample getCurrentSample() {
        return Model.instance().getCurrentSample();
    }

    public void setDisplay(MainActivity display) {
        this.display = display;
    }

    public int getNumOfSequencerCells() {
        return Model.instance().NUM_OF_CELLS;
    }

    public int getNumOfSamples() {
        return Model.instance().NUM_OF_SAMPLES;
    }

}
