package com.creation.diz.drumit.player;

import com.creation.diz.drumit.changeable.Changeable;

/**
 * Created by Diz on 2/24/2018.
 */

public class Bpm implements Changeable {
    private boolean playbackChanged = false, viewChanged = false;
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
        this.playbackChanged = true;
        this.viewChanged = true;
    }

    @Override
    public boolean hasChanged() {
        return false;
    }

    public boolean hasPlaybackChanged() {
        if (this.playbackChanged) {
            this.playbackChanged = false;
            return true;
        }
        return false;
    }

    public boolean hasViewChanged() {
        if (this.viewChanged) {
            this.viewChanged = false;
            return true;
        }
        return false;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;;
    }

    public int getBpm() {
        return this.bpm;
    }

    public int getStepTime() {
        double r = 60000.0 / (double)this.bpm;
        return (int)(r * 0.25);
    }
}
