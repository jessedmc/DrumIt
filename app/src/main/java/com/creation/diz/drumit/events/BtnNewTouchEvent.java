package com.creation.diz.drumit.events;

/**
 * Created by Diz on 3/6/2018.
 */

public class BtnNewTouchEvent {
    private static BtnNewTouchEvent instance;
    /**
     * Make it a singleton
     */
    private BtnNewTouchEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnNewTouchEvent instance() {
        if (instance == null) {
            instance = new BtnNewTouchEvent();
        }
        return instance;
    }
}
