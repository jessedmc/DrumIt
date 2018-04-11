package com.creation.diz.drumit.events;

/**
 * Created by Diz on 4/11/2018.
 */

public class BtnPitchUpClickEvent {
    private static BtnPitchUpClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnPitchUpClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnPitchUpClickEvent instance() {
        if (instance == null) {
            instance = new BtnPitchUpClickEvent();
        }
        return instance;
    }
}
