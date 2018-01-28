package com.creation.diz.drumit.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.controller.Controller;

public class MainActivity extends AppCompatActivity {
    SequencerButton btnSequencer[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set display in controller
        Controller.instance().setDisplay(this);

        // create sequencer buttons for GUI\
        this.btnSequencer = new SequencerButton[Controller.instance().getNumOfSequencerCells()];
        for (int i = 0; i < Controller.instance().getNumOfSequencerCells(); i++) {
            this.btnSequencer[i] = new SequencerButton(this.getApplicationContext());
        }

    }
}
