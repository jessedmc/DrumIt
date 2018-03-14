package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 3/10/2018.
 */

public class HandleBtnBpmUpClickEvent {
    private static HandleBtnBpmUpClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnBpmUpClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnBpmUpClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnBpmUpClickEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnBpmUpTouchDown();
        if (Model.instance().isInPlayMode()) {
            this.incrementBpm();
        }

    }

    public void incrementBpm() {
        Model.instance().incrementBpm();
    }
}
