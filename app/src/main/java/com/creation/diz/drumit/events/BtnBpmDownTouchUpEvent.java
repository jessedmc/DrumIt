package com.creation.diz.drumit.events;

/**
 * Created by Diz on 3/19/2018.
 */

public class BtnBpmDownTouchUpEvent {
    private static BtnBpmDownTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private BtnBpmDownTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnBpmDownTouchUpEvent instance() {
        if (instance == null) {
            instance = new BtnBpmDownTouchUpEvent();
        }
        return instance;
    }
}
