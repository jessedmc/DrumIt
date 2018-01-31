package com.creation.diz.drumit.samples;

import com.creation.diz.drumit.itemlist.ItemList;
import com.creation.diz.drumit.sequencer.SequencerCell;
import com.creation.diz.drumit.sequencer.SequencerCellList;

/**
 * Created by Diz on 1/27/2018.
 */

public class SampleList extends ItemList<Sample, Integer> {

    private static final long serialVersionUID = 1L;
    private static SampleList instance;

    /*
     * Private constructor for singleton pattern
     */
    private SampleList() {
    }

    /**
     * Supports the singleton pattern
     *
     * @return the singleton object
     */
    public static SampleList instance() {
        if (instance == null) {
            instance = new SampleList();
        }
        return instance;
    }


}
