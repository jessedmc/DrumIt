package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 4/11/2018.
 */

public class HandleBtnPitchUpClickEvent {
    private static HandleBtnPitchUpClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnPitchUpClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnPitchUpClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnPitchUpClickEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnPitchUpTouchDown();
        Model.instance().incrementPitch();
    }
}
