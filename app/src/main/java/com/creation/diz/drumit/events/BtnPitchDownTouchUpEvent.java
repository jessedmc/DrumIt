package com.creation.diz.drumit.events;

/**
 * Created by Diz on 4/11/2018.
 */

public class BtnPitchDownTouchUpEvent {
    private static BtnPitchDownTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private BtnPitchDownTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnPitchDownTouchUpEvent instance() {
        if (instance == null) {
            instance = new BtnPitchDownTouchUpEvent();
        }
        return instance;
    }
}
