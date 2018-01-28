package com.creation.diz.drumit.events;

/**
 * Created by Diz on 1/27/2018.
 */

public class BtnSequencerClickEvent {
    private static BtnSequencerClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnSequencerClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnSequencerClickEvent instance() {
        if (instance == null) {
            instance = new BtnSequencerClickEvent();
        }
        return instance;
    }
}
