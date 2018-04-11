package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 4/11/2018.
 */

public class HandleBtnVolumeUpTouchUpEvent {
    private static HandleBtnVolumeUpTouchUpEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnVolumeUpTouchUpEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnVolumeUpTouchUpEvent instance() {
        if (instance == null) {
            instance = new HandleBtnVolumeUpTouchUpEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnVolumeUpTouchUp();
    }
}
