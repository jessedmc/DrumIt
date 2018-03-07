package com.creation.diz.drumit.samples;

import com.creation.diz.drumit.changeable.Changeable;
import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.sequencer.SequencerCell;

import java.util.ArrayList;

/**
 * Created by Diz on 2/26/2018.
 */

public class SamplesUsed implements Changeable {
    private boolean changed = false;
    private static SamplesUsed instance;
    private ArrayList<Integer> samples = new ArrayList<Integer>();


    // singleton constructor
    private SamplesUsed() {
    }

    // singleton instance
    public static SamplesUsed instance() {
        if (instance == null) {
            instance = new SamplesUsed();
        }
        return instance;
    }

    public void addCurrentSampleToUsed() {
        int currentSampleIndex = Model.instance().getCurrentSample().getIndex();
        int count = 0;
        for (int i = 0; i < this.samples.size(); i++) {
            if (this.samples.get(i) == currentSampleIndex) {
                count++;
            }
        }
        if (count == 0) {
            this.samples.add(currentSampleIndex);
            this.changed = true;
        }
    }

    public void removeCurrentSampleFromUsed() {
        //Model.instance().toTextView("in removeCurrentSampleFromUsed()");
        int currentSampleIndex = Model.instance().getCurrentSample().getIndex();
        int count = 0;
        boolean exitLoop = false;
        // iter through sequencerCellList
        for (int i = 0; i < Model.instance().getSequencerCellList().size(); i++) {
            if (exitLoop) {
                break;
            }
            SequencerCell cell = Model.instance().getSequencerCellList().get(i);
            for (int j = 0; j < cell.getSampleList().size(); j++) {
                if (cell.getSampleList().get(j).getIndex() == currentSampleIndex) {
                    count++;
                   // Model.instance().toTextView("in remove() count: " + count);
                    if (count > 0) {
                        exitLoop = true;
                    }
                }
            }
        }
        if (count == 0) {
            //Model.instance().toTextView("in remove() currentSample: " + currentSampleIndex);
            for (int i = 0; i < this.samples.size(); i++) {
                if (this.samples.get(i) == currentSampleIndex) {
                    //Model.instance().toTextView("should remove because only one sample: " + i);
                    this.samples.remove(i);
                    this.changed = true;
                }
            }
        }
        else {
            //Model.instance().toTextView("count not one");
        }
    }

    public void clear() {
        this.samples.clear();
        this.changed = true;
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

    public ArrayList<Integer> getSamples() {
        return samples;
    }
}
