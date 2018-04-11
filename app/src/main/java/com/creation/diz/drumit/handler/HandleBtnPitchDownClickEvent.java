package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 4/11/2018.
 */

public class HandleBtnPitchDownClickEvent {
    private static HandleBtnPitchDownClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnPitchDownClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnPitchDownClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnPitchDownClickEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnPitchDownTouchDown();
        Model.instance().decrementPitch();
    }

    public void decrementBpm() {
        Model.instance().decrementBpm();
    }
}
