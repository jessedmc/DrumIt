package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 4/11/2018.
 */

public class HandleBtnVolumeDownTouchUpEvent {
    private static HandleBtnVolumeDownTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnVolumeDownTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnVolumeDownTouchUpEvent instance() {
        if (instance == null) {
            instance = new HandleBtnVolumeDownTouchUpEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnVolumeDownTouchUp();
    }
}
