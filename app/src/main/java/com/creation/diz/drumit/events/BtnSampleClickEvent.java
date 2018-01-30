package com.creation.diz.drumit.events;

/**
 * Created by Diz on 1/29/2018.
 */

public class BtnSampleClickEvent {
    private static BtnSampleClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnSampleClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnSampleClickEvent instance() {
        if (instance == null) {
            instance = new BtnSampleClickEvent();
        }
        return instance;
    }
}
