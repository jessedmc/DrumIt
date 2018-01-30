package com.creation.diz.drumit.handler;

/**
 * Created by Diz on 1/29/2018.
 */

public class HandleBtnSampleClickEvent {
    private static HandleBtnSampleClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnSampleClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnSampleClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnSampleClickEvent();
        }
        return instance;
    }

    public void handle(int index) {
        //Controller.instance().selectBtnSequencer(index);
    }
}
