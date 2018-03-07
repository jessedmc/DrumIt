package com.creation.diz.drumit.events;

/**
 * Created by Diz on 3/3/2018.
 */

public class BtnNewClickEvent {
    private static BtnNewClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnNewClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnNewClickEvent instance() {
        if (instance == null) {
            instance = new BtnNewClickEvent();
        }
        return instance;
    }
}
