package com.creation.diz.drumit.modes;

import com.creation.diz.drumit.changeable.Changeable;

/**
 * Created by Diz on 1/30/2018.
 */

public class PauseMode implements Changeable{
    private boolean changed = false;
    private boolean pauseMode = true;

    private static PauseMode instance;
    /**
     * Make it a singleton
     */
    private PauseMode() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static PauseMode instance() {
        if (instance == null) {
            instance = new PauseMode();
        }
        return instance;
    }

    public void start() {
        this.pauseMode = true;
    }

    public void stop() {
        this.pauseMode = false;
    }

    public boolean isInPauseMode() {
        return this.pauseMode;
    }

    // Changeable
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
}
