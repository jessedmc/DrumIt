package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 2/6/2018.
 */

public class HandleBtnPauseClickEvent {
    private static HandleBtnPauseClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnPauseClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnPauseClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnPauseClickEvent();
        }
        return instance;
    }

    public void handle() {
        this.startPauseMode();
    }

    public void startPauseMode() {
        Model.instance().startPauseMode();
        Model.instance().updateView();
    }
}
