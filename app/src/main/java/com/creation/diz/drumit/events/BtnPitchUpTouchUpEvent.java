package com.creation.diz.drumit.events;

/**
 * Created by Diz on 4/11/2018.
 */

public class BtnPitchUpTouchUpEvent {
    private static BtnPitchUpTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private BtnPitchUpTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnPitchUpTouchUpEvent instance() {
        if (instance == null) {
            instance = new BtnPitchUpTouchUpEvent();
        }
        return instance;
    }
}
