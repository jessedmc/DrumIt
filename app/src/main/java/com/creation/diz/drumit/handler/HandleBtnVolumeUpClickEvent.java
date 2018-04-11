package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 4/11/2018.
 */

public class HandleBtnVolumeUpClickEvent {
    private static HandleBtnVolumeUpClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnVolumeUpClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnVolumeUpClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnVolumeUpClickEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnVolumeUpTouchDown();
        Model.instance().incrementVolume();
    }
}
