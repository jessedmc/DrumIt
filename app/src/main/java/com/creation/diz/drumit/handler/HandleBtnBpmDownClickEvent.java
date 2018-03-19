package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.controller.Controller;
import com.creation.diz.drumit.model.Model;

/**
 * Created by Diz on 3/10/2018.
 */

public class HandleBtnBpmDownClickEvent {
    private static HandleBtnBpmDownClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnBpmDownClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnBpmDownClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnBpmDownClickEvent();
        }
        return instance;
    }

    public void handle() {
        Controller.instance().setBtnBpmDownTouchDown();
        if (Model.instance().isInPlayMode()) {
            if (Model.instance().getBpm().getBpm() > Model.instance().MIN_BPM) {
                this.decrementBpm();
            }
        }

    }

    public void decrementBpm() {
        Model.instance().decrementBpm();
    }
}
