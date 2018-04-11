package com.creation.diz.drumit.events;

/**
 * Created by Diz on 4/11/2018.
 */

public class BtnVolumeDownClickEvent {
    private static BtnVolumeDownClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnVolumeDownClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnVolumeDownClickEvent instance() {
        if (instance == null) {
            instance = new BtnVolumeDownClickEvent();
        }
        return instance;
    }
}
