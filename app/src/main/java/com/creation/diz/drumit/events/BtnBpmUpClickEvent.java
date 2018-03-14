package com.creation.diz.drumit.events;

/**
 * Created by Diz on 3/10/2018.
 */

public class BtnBpmUpClickEvent {
    private static BtnBpmUpClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnBpmUpClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnBpmUpClickEvent instance() {
        if (instance == null) {
            instance = new BtnBpmUpClickEvent();
        }
        return instance;
    }
}
