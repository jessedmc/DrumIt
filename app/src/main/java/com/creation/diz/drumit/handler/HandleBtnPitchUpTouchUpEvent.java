package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 4/11/2018.
 */

public class HandleBtnPitchUpTouchUpEvent {
    private static HandleBtnPitchUpTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnPitchUpTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnPitchUpTouchUpEvent instance() {
        if (instance == null) {
            instance = new HandleBtnPitchUpTouchUpEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnPitchUpTouchUp();
    }
}
