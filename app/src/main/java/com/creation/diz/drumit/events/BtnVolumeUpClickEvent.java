package com.creation.diz.drumit.events;

/**
 * Created by Diz on 4/11/2018.
 */

public class BtnVolumeUpClickEvent {
    private static BtnVolumeUpClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnVolumeUpClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnVolumeUpClickEvent instance() {
        if (instance == null) {
            instance = new BtnVolumeUpClickEvent();
        }
        return instance;
    }
}
