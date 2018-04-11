package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 4/11/2018.
 */

public class HandleBtnPitchDownTouchUpEvent {
    private static HandleBtnPitchDownTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnPitchDownTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnPitchDownTouchUpEvent instance() {
        if (instance == null) {
            instance = new HandleBtnPitchDownTouchUpEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnPitchDownTouchUp();
    }
}
