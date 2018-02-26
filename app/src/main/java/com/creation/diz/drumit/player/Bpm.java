package com.creation.diz.drumit.player;

import com.creation.diz.drumit.changeable.Changeable;

/**
 * Created by Diz on 2/24/2018.
 */

public class Bpm implements Changeable {
    private boolean changed = false;
    private int bpm = 120, stepTime = 125;
    private static Bpm instance;

    // singleton constructor
    private Bpm() {

    }

    // singleton instance
    public static Bpm instance() {
        if (instance == null) {
            instance = new Bpm();
        }
        return instance;
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
/*
    public boolean hasChangedPlayThread() {
        if (this.changed) {
            return true;
        }
    }  */

    public void setBpm(int bpm) {
        this.bpm = bpm;;
        this.changed = true;
    }

    public int getStepTime() {
        double r = 60000.0 / (double)this.bpm;
        return (int)(r * 0.25);
    }
}
