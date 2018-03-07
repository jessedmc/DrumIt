package com.creation.diz.drumit.handler;

/**
 * Created by Diz on 3/3/2018.
 */

public class HandleBtnExportClickEvent {
    private static HandleBtnExportClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnExportClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnExportClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnExportClickEvent();
        }
        return instance;
    }

    public void handle() {


    }
}
