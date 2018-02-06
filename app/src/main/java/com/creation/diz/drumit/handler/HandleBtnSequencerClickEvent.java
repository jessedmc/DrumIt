package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.samples.Sample;
import com.creation.diz.drumit.sequencer.SequencerCell;

import java.util.Iterator;

/**
 * Created by Diz on 1/27/2018.
 */

public class HandleBtnSequencerClickEvent {
    private static HandleBtnSequencerClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnSequencerClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnSequencerClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnSequencerClickEvent();
        }
        return instance;
    }

    public void handle(int index) {
        //Model.instance().toTextView("in handle seq click index: " + index);
        // set current sequencerCell in Model
        this.setCurrentSequencerCell(index);

        // if the sample selected already exists in the cell, remove the sample
        if (this.sampleExistsInCell()) {
            this.removeCurrentSampleFromCell();
        }
        else {
            // add sample to sequencerCell and setChanged()
            this.addSampleToSequencerCell();
        }
        Model.instance().updateView();

    }

    public void setCurrentSequencerCell(int index) {
        Model.instance().setCurrentSequencerCell(index);
    }

    public void addSampleToSequencerCell() {
        SequencerCell cell = Model.instance().getCurrentSequencerCell();
        cell.getSampleList().add(Model.instance().getCurrentSample());
        Model.instance().getSequencerCellList().setChanged();
        Model.instance().getSequencerCellList().setChanged(1);
    }

    public boolean sampleExistsInCell() {
        Iterator<Sample> iter = Model.instance().getCurrentSequencerCell().getSampleList().iterator();
        while (iter.hasNext()) {
            Sample sample = (Sample)iter.next();
            if (sample.getIndex() == Model.instance().getCurrentSample().getIndex()) {
                return true;
            }
        }
        return false;
    }

    public void removeCurrentSampleFromCell() {
        Model.instance().getCurrentSequencerCell().getSampleList().remove(Model.instance().getCurrentSample());
        Model.instance().getSequencerCellList().setChanged();
        Model.instance().getSequencerCellList().setChanged(0);
    }
}
