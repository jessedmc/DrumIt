package com.creation.diz.drumit.events;

/**
 * Created by Diz on 4/11/2018.
 */

public class BtnVolumeUpTouchUpEvent {
    private static BtnVolumeUpTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private BtnVolumeUpTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnVolumeUpTouchUpEvent instance() {
        if (instance == null) {
            instance = new BtnVolumeUpTouchUpEvent();
        }
        return instance;
    }
}
