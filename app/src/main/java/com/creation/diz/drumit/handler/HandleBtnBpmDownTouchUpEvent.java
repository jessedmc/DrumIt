package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 3/19/2018.
 */

public class HandleBtnBpmDownTouchUpEvent {
    private static HandleBtnBpmDownTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnBpmDownTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnBpmDownTouchUpEvent instance() {
        if (instance == null) {
            instance = new HandleBtnBpmDownTouchUpEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnBpmDownTouchUp();
    }
}
