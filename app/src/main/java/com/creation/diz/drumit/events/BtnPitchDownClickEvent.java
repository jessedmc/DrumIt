package com.creation.diz.drumit.events;

/**
 * Created by Diz on 4/11/2018.
 */

public class BtnPitchDownClickEvent {
    private static BtnPitchDownClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnPitchDownClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnPitchDownClickEvent instance() {
        if (instance == null) {
            instance = new BtnPitchDownClickEvent();
        }
        return instance;
    }
}
