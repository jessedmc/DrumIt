package com.creation.diz.drumit.samples;

import android.net.Uri;

import com.creation.diz.drumit.R;
import com.creation.diz.drumit.changeable.Changeable;
import com.creation.diz.drumit.itemlist.Matchable;

import java.io.Serializable;

/**
 * Created by Diz on 1/27/2018.
 */

public class Sample implements Matchable<Integer>, Serializable, Changeable {
    private boolean changed = false;
    private static int numOfSamples = 10;
    private static String[] nameList;// = new String[Sample.numOfSamples];
    private int index;
    private Uri uri;
    // Uri uri = Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.uhi2);
    public Sample(int index) {
        this.index = index;

        // create name list to connect code to wav files in resources/raw/drumkitNum default = 0
        if (nameList == null) {
            this.createNameList();
        }

        // create uri
        this.uri = Uri.parse("android.resource://" + this.getClass().getPackage() + "/res/raw/0/" + Sample.nameList[this.index] + ".wav");

    }

    private void createNameList() {
        Sample.nameList = new String[Sample.numOfSamples];
        Sample.nameList[0] = "kick";
        Sample.nameList[1] = "snare";
        Sample.nameList[2] = "lowTom";
        Sample.nameList[3] = "hiTom";
        Sample.nameList[4] = "rimShot";
        Sample.nameList[5] = "closedHiHat";
        Sample.nameList[6] = "openHiHat";
        Sample.nameList[7] = "cymbal";
        Sample.nameList[8] = "fx1";
        Sample.nameList[9] = "fx2";

    }

    // Changeable
    @Override
    public void setChanged() {
        this.changed = true;
    }

    @Override
    public boolean hasChanged() {
        if (this.changed) {
            this.changed = false;
            return true;
        }
        return false;
    }

    // Matchable
    @Override
    public boolean matches(Integer id) {
        if (this.index == id.intValue()) {
            return true;
        }
        return false;
    }
}