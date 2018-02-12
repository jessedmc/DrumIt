package com.creation.diz.drumit.controller;

import android.content.Context;

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

    // ****************** Getters Setters ******************** //
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
