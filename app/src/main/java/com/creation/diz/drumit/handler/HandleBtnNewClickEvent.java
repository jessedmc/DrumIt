package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 3/3/2018.
 */

public class HandleBtnNewClickEvent {
    private static HandleBtnNewClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnNewClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnNewClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnNewClickEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnNewTouchUp();
        Model.instance().clearSequencer();
    }
}
