package com.creation.diz.drumit.modes;

import com.creation.diz.drumit.changeable.Changeable;


/**
 * Created by Diz on 1/30/2018.
 */

public class PlayMode implements Changeable {
    private boolean changed = false;
    private boolean playMode = false;
    private static PlayMode instance;

    /**
     * Make it a singleton
     */
    private PlayMode() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static PlayMode instance() {
        if (instance == null) {
            instance = new PlayMode();
        }
        return instance;
    }

    public void start() {
        this.playMode = true;
    }

    public void stop() {
        this.playMode = false;
    }

    public boolean isInPlayMode() {
        return this.playMode;
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
