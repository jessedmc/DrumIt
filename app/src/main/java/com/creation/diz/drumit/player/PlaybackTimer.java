package com.creation.diz.drumit.player;

import com.creation.diz.drumit.model.Model;
import com.creation.diz.drumit.samples.SampleList;
import com.creation.diz.drumit.sequencer.SequencerCellList;

/**
 * Created by Diz on 2/12/2018.
 */

public class PlaybackTimer implements Runnable{
    private static PlaybackTimer instance;
    private final int SEQ_CELL_MAX = 15;
    private int interval = 0, bpm = 0, seqCellIndex, stepTime = 125;
    private int[] soundList;



    private PlaybackTimer() {

    }

    public static PlaybackTimer instance() {
        if (instance == null) {
            instance = new PlaybackTimer();
        }
        return instance;
    }


    public void play() {
        new Thread(this).start();
    }

    public void stop() {

    }

    @Override
    public void run() {
        int message = -1;
        this.seqCellIndex = 0;
        SequencerCellList seqCellList = Model.instance().getSequencerCellList();

        // iter here
        while (Model.instance().isInPlayMode()) {
            if (Model.instance().getBpm().hasPlaybackChanged()) {
                this.stepTime = Model.instance().getBpm().getStepTime();
            }
            this.seqCellIndex++;
            SampleList sampleList = seqCellList.get(this.seqCellIndex).getSampleList();
            int sampleListLength = sampleList.size();
            soundList = new int[sampleListLength];
            if (sampleListLength == 0) {
                soundList = new int[0];
            }
            else if (sampleListLength == 1) {
                soundList = new int[1];
                soundList[0] = sampleList.get(0).getIndex();
                //Model.instance().toTextView("samleList[0].index: " + sampleList.get(0).getIndex());
            }
            else if (sampleListLength > 1) {
                soundList = new int[sampleListLength];
                for (int i = 0; i < sampleListLength; i++) {
                    soundList[i] = sampleList.get(i).getIndex();
                }
            }
            Model.instance().setPlaybackMessage(soundList);
            Model.instance().updatePlayer();
            try {
                Thread.sleep(stepTime);
            } catch (Exception err) {
                err.printStackTrace();
            }
            if (this.seqCellIndex == this.SEQ_CELL_MAX) {
                this.seqCellIndex = -1;
            }
        }
    }

}
