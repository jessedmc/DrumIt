package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;

/**
 * Created by Diz on 3/6/2018.
 */

public class HandleBtnNewTouchDownEvent {
    private static HandleBtnNewTouchDownEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnNewTouchDownEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnNewTouchDownEvent instance() {
        if (instance == null) {
            instance = new HandleBtnNewTouchDownEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnNewTouchDown();
    }
}
