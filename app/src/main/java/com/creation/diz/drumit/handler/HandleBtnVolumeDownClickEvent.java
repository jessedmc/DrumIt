package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 4/11/2018.
 */

public class HandleBtnVolumeDownClickEvent {
    private static HandleBtnVolumeDownClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnVolumeDownClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnVolumeDownClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnVolumeDownClickEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnVolumeDownTouchDown();
        Model.instance().decrementVolume();
    }
}
