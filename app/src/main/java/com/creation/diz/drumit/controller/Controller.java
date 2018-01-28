package com.creation.diz.drumit.controller;

import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.view.MainActivity;

/**
 * Created by Diz on 1/27/2018.
 */

public class Controller {
    private static Controller instance;
    private MainActivity display;
    /**
     * Make it a singleton
     */
    private Controller() {

    }

    /**
     * Return the instance
     *
     * @return the object
     */
    public static Controller instance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void selectBtnSequencer(int index) {
        Model.instance().selectSequencerCell(index);
    }

    public void setDisplay(MainActivity display) {
        this.display = display;
    }

    public int getNumOfSequencerCells() {
        return Model.instance().getNumOFCells();
    }

}
