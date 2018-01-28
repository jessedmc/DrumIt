package com.creation.diz.drumit.sequencer;

import com.creation.diz.drumit.itemlist.Matchable;
import com.creation.diz.drumit.samples.SampleList;

import java.io.Serializable;

/**
 * Created by Diz on 1/27/2018.
 */

public class SequencerCell implements Matchable<Integer>, Serializable {

    private static int rollingIndex = -1;
    private int id;

    public SequencerCell() {
        SequencerCell.rollingIndex++;
        this.id = SequencerCell.rollingIndex;

    }

    @Override
    public boolean matches(Integer id) {
        if (this.id == id) {
            return true;
        }
        return false;
    }


    public static int getRollingIndex() {
        return rollingIndex;
    }

    public static void setRollingIndex(int rollingIndex) {
        SequencerCell.rollingIndex = rollingIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
