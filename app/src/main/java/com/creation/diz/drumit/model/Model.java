package com.creation.diz.drumit.model;

import com.creation.diz.drumit.modes.PauseMode;
import com.creation.diz.drumit.modes.PlayMode;
import com.creation.diz.drumit.samples.Sample;
import com.creation.diz.drumit.samples.SampleList;
import com.creation.diz.drumit.sequencer.SequencerCell;
import com.creation.diz.drumit.sequencer.SequencerCellList;

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


    /**
     * Make it a singleton
     */
    private Model() {

        // make sample list
        for (int i = 0; i < this.NUM_OF_SAMPLES; i++) {
            this.sampleList.add(new Sample());
        }

        // make sequencerCell list
        for (int i = 0; i < this.NUM_OF_CELLS; i++) {
            this.sequencerCellList.add(new SequencerCell());
        }

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

    public void startPlayMode() {
        this.pauseMode.stop();
        this.playMode.start();
        this.playMode.setChanged();
    }

    public void selectSequencerCell(int index) {
        this.selectedSequencerCell = index;
    }

    public Sample getCurrentSample() {
        return currentSample;
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
}
