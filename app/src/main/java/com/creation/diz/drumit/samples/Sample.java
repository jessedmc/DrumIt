package com.creation.diz.drumit.samples;

import android.net.Uri;

import com.creation.diz.drumit.itemlist.Matchable;

import java.io.Serializable;

/**
 * Created by Diz on 1/27/2018.
 */

public class Sample implements Matchable<Integer>, Serializable {
    private Integer id;
    private Uri uri;

    @Override
    public boolean matches(Integer id) {
        return false;
    }
}