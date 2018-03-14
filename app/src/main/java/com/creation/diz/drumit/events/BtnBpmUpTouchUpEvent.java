package com.creation.diz.drumit.events;

/**
 * Created by Diz on 3/14/2018.
 */

public class BtnBpmUpTouchUpEvent {
    private static BtnBpmUpTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private BtnBpmUpTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnBpmUpTouchUpEvent instance() {
        if (instance == null) {
            instance = new BtnBpmUpTouchUpEvent();
        }
        return instance;
    }
}
