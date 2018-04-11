package com.creation.diz.drumit.player;

import com.creation.diz.drumit.changeable.Changeable;

/**
 * Created by Diz on 4/11/2018.
 */

public class Pitch implements Changeable {
    private int[] pitch = new int[10];
    public static final int MAX_PITCH = 10;
    public static final int MIN_PITCH = 0;
    private static Pitch instance;
    private boolean changed = false;

    // singleton constructor
    private Pitch() {
        for (int i = 0; i < pitch.length; i++) {
            this.pitch[i] = 5;
        }
    }

    // singleton instance
    public static Pitch instance() {
        if (instance == null) {
            instance = new Pitch();
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

    public boolean incrementPitch(int sampleIndex) {
        if (this.pitch[sampleIndex] < Pitch.MAX_PITCH) {
            this.pitch[sampleIndex]++;
            return true;
        }
        return false;
    }

    public boolean decrementPitch(int sampleIndex) {
        if (this.pitch[sampleIndex] > Pitch.MIN_PITCH) {
            this.pitch[sampleIndex]--;
            return true;
        }
        return false;
    }

    public int getPitch(int sampleIndex) {
        return pitch[sampleIndex];
    }
}
