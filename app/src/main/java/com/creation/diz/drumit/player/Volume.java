package com.creation.diz.drumit.player;

import com.creation.diz.drumit.changeable.Changeable;

/**
 * Created by Diz on 4/11/2018.
 */

public class Volume implements Changeable{// imps then obj in model
    private int volume[] = new int[10];
    public static final int MAX_VOLUME = 10;
    public static final int MIN_VOLUME = 0;
    private static Volume instance;
    private boolean changed = false;

    // singleton constructor
    private Volume() {
        for (int i = 0; i < volume.length; i++) {
            this.volume[i] = 5;
        }
    }

    // singleton instance
    public static Volume instance() {
        if (instance == null) {
            instance = new Volume();
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

    public boolean incrementVolume(int sampleIndex) {
        if (this.volume[sampleIndex] < Volume.MAX_VOLUME) {
            this.volume[sampleIndex]++;
            return true;
        }
        return false;
    }

    public boolean decrementVolume(int sampleIndex) {
        if (this.volume[sampleIndex] > Volume.MIN_VOLUME) {
            this.volume[sampleIndex]--;
            return true;
        }
        return false;
    }

    public int getVolume(int sampleIndex) {
        return volume[sampleIndex];
    }
}
