package com.creation.diz.drumit.controller;

import android.content.Context;

import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.samples.Sample;
import com.creation.diz.drumit.view.MainActivity;

/**
 * Created by Diz on 1/27/2018.
 */

public class Controller {
    private static Controller instance;
    private MainActivity display;

    // singleton constructor
    private Controller() {

    }

    // singleton
    public static Controller instance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    // update
    public void updateView() {
        this.display.update();
    }

    public void selectBtnSequencer(int index) {
        Model.instance().selectSequencerCell(index);
    }

    // get context, for testing
    public Context getContext() {
        return this.display.getApplicationContext();
    }

    // for testing
    public void toTextView(String str) {
        this.display.setTextView(str);
    }

    // ****************** Getters Setters ******************** //
    public Sample getCurrentSample() {
        return Model.instance().getCurrentSample();
    }

    public void setDisplay(MainActivity display) {
        this.display = display;
    }

    public int getNumOfSequencerCells() {
        return Model.instance().NUM_OF_CELLS;
    }

    public int getNumOfSamples() {
        return Model.instance().NUM_OF_SAMPLES;
    }

}
