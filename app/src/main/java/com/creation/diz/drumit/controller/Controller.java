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

    // update
    public void updateView() {
        this.display.update();
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

    // ****************** Getters Setters ******************** //
    public boolean getCurrentSampleHasChanged() {
        return Model.instance().getCurrentSample().hasChanged();
    }

    public int getCellSampleListLength(int index) {
        SequencerCell cell = Model.instance().getSequencerCellList().search(index);
        return cell.getSampleList().size();
    }

    public boolean getCellAndSampleMatchCurrentSample(int i, int j) {
        SequencerCell cell = Model.instance().getSequencerCellList().search(i);
        Sample sample = cell.getSampleList().search(j);
        if (sample != null) {
            if (sample.matches(Model.instance().getCurrentSample().getIndex())) {
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
        Iterator<SequencerCell> iter = Model.instance().getSequencerCellList().iterator();
        while (iter.hasNext()) {
            SequencerCell cell = (SequencerCell)iter.next();
            if (cell.hasChanged()) {
                //Model.instance().toTextView("in controller seqCellHasChanged found index: " + cell.getIndex());
                return cell.getIndex();
            }
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
