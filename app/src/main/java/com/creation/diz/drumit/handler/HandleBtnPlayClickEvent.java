package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 2/6/2018.
 */

public class HandleBtnPlayClickEvent {
    private static HandleBtnPlayClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnPlayClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnPlayClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnPlayClickEvent();
        }
        return instance;
    }

    public void handle() {
        this.startPlayMode();
    }

    public void startPlayMode() {
        if (Model.instance().isInPauseMode()) {
            Model.instance().startPlayMode();
            Model.instance().updateView();
        }
    }
}
