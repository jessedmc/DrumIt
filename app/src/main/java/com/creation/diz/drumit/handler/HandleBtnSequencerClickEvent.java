package com.creation.diz.drumit.handler;

/**
 * Created by Diz on 1/27/2018.
 */

public class HandleBtnSequencerClickEvent {
    private static HandleBtnSequencerClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnSequencerClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnSequencerClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnSequencerClickEvent();
        }
        return instance;
    }

    public void handle(int index) {
        //Controller.instance().selectBtnSequencer(index);
    }
}
