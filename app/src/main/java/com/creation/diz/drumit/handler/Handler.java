package com.creation.diz.drumit.handler;

import com.creation.diz.drumit.events.BtnBpmDownClickEvent;
import com.creation.diz.drumit.events.BtnBpmDownTouchUpEvent;
import com.creation.diz.drumit.events.BtnBpmUpClickEvent;
import com.creation.diz.drumit.events.BtnBpmUpTouchUpEvent;
import com.creation.diz.drumit.events.BtnExportClickEvent;
import com.creation.diz.drumit.events.BtnNewClickEvent;

import com.creation.diz.drumit.events.BtnNewTouchDownEvent;
import com.creation.diz.drumit.events.BtnPauseClickEvent;
import com.creation.diz.drumit.events.BtnPitchDownClickEvent;
import com.creation.diz.drumit.events.BtnPitchDownTouchUpEvent;
import com.creation.diz.drumit.events.BtnPitchUpClickEvent;
import com.creation.diz.drumit.events.BtnPitchUpTouchUpEvent;
import com.creation.diz.drumit.events.BtnPlayClickEvent;
import com.creation.diz.drumit.events.BtnSampleClickEvent;
import com.creation.diz.drumit.events.BtnSequencerClickEvent;
import com.creation.diz.drumit.events.BtnVolumeDownClickEvent;
import com.creation.diz.drumit.events.BtnVolumeDownTouchUpEvent;
import com.creation.diz.drumit.events.BtnVolumeUpClickEvent;
import com.creation.diz.drumit.events.BtnVolumeUpTouchUpEvent;

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

    public void handleEvent(BtnSampleClickEvent event, int index) {
        HandleBtnSampleClickEvent.instance().handle(index);
    }

    public void handleEvent(BtnPlayClickEvent event) {
        HandleBtnPlayClickEvent.instance().handle();
    }

    public void handleEvent(BtnPauseClickEvent event) {
        HandleBtnPauseClickEvent.instance().handle();
    }

    public void handleEvent(BtnExportClickEvent event) {
        HandleBtnExportClickEvent.instance().handle();
    }

    public void handleEvent(BtnBpmDownClickEvent event) {
        HandleBtnBpmDownClickEvent.instance().handle();
    }

    public void handleEvent(BtnBpmUpClickEvent event) {
        HandleBtnBpmUpClickEvent.instance().handle();
    }

    public void handleEvent(BtnPitchDownClickEvent event) {
        HandleBtnPitchDownClickEvent.instance().handle();
    }

    public void handleEvent(BtnPitchUpClickEvent event) {
        HandleBtnPitchUpClickEvent.instance().handle();
    }

    public void handleEvent(BtnVolumeDownClickEvent event) {
        HandleBtnVolumeDownClickEvent.instance().handle();
    }

    public void handleEvent(BtnVolumeUpClickEvent event) {
        HandleBtnVolumeUpClickEvent.instance().handle();
    }

    public void handleEvent(BtnBpmUpTouchUpEvent event) {
        HandleBtnBpmUpTouchUpEvent.instance().handle();
    }

    public void handleEvent(BtnBpmDownTouchUpEvent event) {
        HandleBtnBpmDownTouchUpEvent.instance().handle();
    }

    public void handleEvent(BtnPitchUpTouchUpEvent event) {
        HandleBtnPitchUpTouchUpEvent.instance().handle();
    }

    public void handleEvent(BtnPitchDownTouchUpEvent event) {
        HandleBtnPitchDownTouchUpEvent.instance().handle();
    }

    public void handleEvent(BtnVolumeUpTouchUpEvent event) {
        HandleBtnVolumeUpTouchUpEvent.instance().handle();
    }

    public void handleEvent(BtnVolumeDownTouchUpEvent event) {
        HandleBtnVolumeDownTouchUpEvent.instance().handle();
    }

    public void handleEvent(BtnNewClickEvent event) {
        HandleBtnNewClickEvent.instance().handle();
    }

    public void handleEvent(BtnNewTouchDownEvent event) {
        HandleBtnNewTouchDownEvent.instance().handle();
    }
}

