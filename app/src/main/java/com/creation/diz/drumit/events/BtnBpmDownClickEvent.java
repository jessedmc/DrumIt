package com.creation.diz.drumit.events;

/**
 * Created by Diz on 3/10/2018.
 */

public class BtnBpmDownClickEvent {
    private static BtnBpmDownClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnBpmDownClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnBpmDownClickEvent instance() {
        if (instance == null) {
            instance = new BtnBpmDownClickEvent();
        }
        return instance;
    }
}
