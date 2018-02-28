package com.creation.diz.drumit.handler;

import android.widget.Toast;

import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.samples.Sample;

import java.util.Iterator;

/**
 * Created by Diz on 1/29/2018.
 */

public class HandleBtnSampleClickEvent {
    private static HandleBtnSampleClickEvent instance;
    /**
     * Make it a singleton
     */
    private HandleBtnSampleClickEvent() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static HandleBtnSampleClickEvent instance() {
        if (instance == null) {
            instance = new HandleBtnSampleClickEvent();
        }
        return instance;
    }

    public void handle(int index) {
        this.setCurrentSampleInGui(index);
    }

    // search through sampleList and set currentSample
    public void setCurrentSampleInGui(int index) {
        //Model.instance().toTextView("got to setCurrentSampleInGui() sampleList len: " + Model.instance().getSampleList().size() + "sampleList[0].index: " + Model.instance().getSampleList().get(0).getIndex() + " index param: " + index);
        Model.instance().setCurrentSample(index);

    }


}
