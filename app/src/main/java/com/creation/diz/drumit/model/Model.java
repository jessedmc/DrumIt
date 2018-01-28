package com.creation.diz.drumit.model;

import com.creation.diz.drumit.samples.Sample;
import com.creation.diz.drumit.samples.SampleList;
import com.creation.diz.drumit.sequencer.SequencerCellList;

/**
 * Created by Diz on 1/27/2018.
 */

public class Model {
    private static Model instance;
    private int numOFCells = 16;
    private int selectedSequencerCell = 0;
    private SequencerCellList sequencerCellList = SequencerCellList.instance();
    private SampleList sampleList = new SampleList();
    private Sample currentSample = new Sample();

    /**
     * Make it a singleton
     */
    private Model() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static Model instance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public void selectSequencerCell(int index) {
        this.selectedSequencerCell = index;
    }

    public int getNumOFCells() {
        return this.numOFCells;
    }

    public void setNumOFCells(int numOFCells) {
        this.numOFCells = numOFCells;
    }
}
