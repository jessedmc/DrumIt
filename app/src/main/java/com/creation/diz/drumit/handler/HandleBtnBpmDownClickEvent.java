package com.creation.diz.drumit.handler;

/**
 * Created by Diz on 3/10/2018.
 */

public class HandleBtnBpmDownClickEvent {
    private static HandleBtnBpmDownClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnBpmDownClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnBpmDownClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnBpmDownClickEvent();
        }
        return instance;
    }

    public void handle() {


    }
}
