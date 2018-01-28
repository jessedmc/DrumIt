package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.events.BtnSequencerClickEvent;

/**
 * Created by Diz on 1/27/2018.
 */

public class Handler {
    private static Handler instance;
    /**
     * Make it a singleton
     */
    private Handler() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static Handler instance() {
        if (instance == null) {
            instance = new Handler();
        }
        return instance;
    }

    public void handleEvent(BtnSequencerClickEvent event, int index) {
        HandleBtnSequencerClickEvent.instance().handle(index);
    }
/*
    public void handleEvent(BtnSequencerClickEvent event, int index) {
        HandleBtnSequencerClickEvent.instance().handle(index);
    }     */
}

