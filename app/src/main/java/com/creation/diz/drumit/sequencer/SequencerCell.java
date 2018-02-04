package com.creation.diz.drumit.sequencer;

import com.creation.diz.drumit.changeable.Changeable;
import com.creation.diz.drumit.itemlist.Matchable;
import com.creation.diz.drumit.samples.Sample;
import com.creation.diz.drumit.samples.SampleList;

import java.io.Serializable;

/**
 * Created by Diz on 1/27/2018.
 */

public class SequencerCell implements Matchable<Integer>, Serializable, Changeable {
    private boolean changed = false;
    private int index;
    private SampleList sampleList;

    public SequencerCell(int index) {
        this.index = index;
        this.sampleList = new SampleList();
    }

    @Override
    public boolean matches(Integer id) {
        if (this.index == id) {
            return true;
        }
        return false;
    }

    public SampleList getSampleList() {
        return sampleList;
    }

    public void setSampleList(SampleList sampleList) {
        this.sampleList = sampleList;
    }

    @Override
    public void setChanged() {
        this.changed = true;
    }

    @Override
    public boolean hasChanged() {
        if (this.changed) {
            this.changed = false;
            return true;
        }
        return false;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
