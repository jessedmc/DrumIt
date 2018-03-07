package com.creation.diz.drumit.events;

/**
 * Created by Diz on 3/3/2018.
 */

public class BtnExportClickEvent {
    private static BtnExportClickEvent instance;
    /**
     * Make it a singleton
     */
    private BtnExportClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static BtnExportClickEvent instance() {
        if (instance == null) {
            instance = new BtnExportClickEvent();
        }
        return instance;
    }
}
