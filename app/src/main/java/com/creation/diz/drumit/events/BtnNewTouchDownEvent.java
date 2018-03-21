package com.creation.diz.drumit.events;

/**
 * Created by Diz on 3/6/2018.
 */

public class BtnNewTouchDownEvent {
    private static BtnNewTouchDownEvent instance;
    /**
     * Make it a singleton
     */
    private BtnNewTouchDownEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnNewTouchDownEvent instance() {
        if (instance == null) {
            instance = new BtnNewTouchDownEvent();
        }
        return instance;
    }
}
