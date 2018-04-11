package com.creation.diz.drumit.events;

/**
 * Created by Diz on 4/11/2018.
 */

public class BtnVolumeDownTouchUpEvent {
    private static BtnVolumeDownTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private BtnVolumeDownTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnVolumeDownTouchUpEvent instance() {
        if (instance == null) {
            instance = new BtnVolumeDownTouchUpEvent();
        }
        return instance;
    }
}
