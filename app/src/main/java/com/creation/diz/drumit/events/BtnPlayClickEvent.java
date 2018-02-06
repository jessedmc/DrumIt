package com.creation.diz.drumit.events;

/**
 * Created by Diz on 2/6/2018.
 */

public class BtnPlayClickEvent {
    private static BtnPlayClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnPlayClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnPlayClickEvent instance() {
        if (instance == null) {
            instance = new BtnPlayClickEvent();
        }
        return instance;
    }


}
