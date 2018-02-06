package com.creation.diz.drumit.events;

/**
 * Created by Diz on 2/6/2018.
 */

public class BtnPauseClickEvent {
    private static BtnPauseClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnPauseClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnPauseClickEvent instance() {
        if (instance == null) {
            instance = new BtnPauseClickEvent();
        }
        return instance;
    }


}
