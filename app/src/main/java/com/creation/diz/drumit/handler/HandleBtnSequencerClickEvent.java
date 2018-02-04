package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.sequencer.SequencerCell;

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
        Model.instance().toTextView("in handle seq click index: " + index);
        // set current sequencerCell in Model
        this.setCurrentSequencerCell(index);

        // add sample to sequencerCell and setChanged()
        this.addSampleToSequencerCell();
    }

    public void setCurrentSequencerCell(int index) {
        Model.instance().setCurrentSequencerCell(index);
    }

    public void addSampleToSequencerCell() {
        SequencerCell cell = Model.instance().getCurrentSequencerCell();
        //Model.instance().toTextView("in handleSeqCell addSample curSeqCell index: " + Model.instance().getCurrentSequencerCell().getIndex());
        if (cell != null) {
           // Model.instance().toTextView("in handle addSample cell != null");
            cell.getSampleList().add(Model.instance().getCurrentSample());
            Model.instance().toTextView("sample list added curSample sampleList size: " + cell.getSampleList().size());
            cell.setChanged();
            Model.instance().updateView();
        }
    }
}
