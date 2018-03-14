package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;

/**
 * Created by Diz on 3/14/2018.
 */

public class HandleBtnBpmUpTouchUpEvent {
    private static HandleBtnBpmUpTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnBpmUpTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnBpmUpTouchUpEvent instance() {
        if (instance == null) {
            instance = new HandleBtnBpmUpTouchUpEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnBpmUpTouchUp();
    }
}
