package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;

/**
 * Created by Diz on 3/6/2018.
 */

public class HandleBtnNewTouchEvent {
    private static HandleBtnNewTouchEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnNewTouchEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnNewTouchEvent instance() {
        if (instance == null) {
            instance = new HandleBtnNewTouchEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnNewTouchDown();
    }
}
