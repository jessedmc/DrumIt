package com.creation.diz.drumit.itemlist;

/**
 * Created by Diz on 1/27/2018.
 */

public interface Matchable<K> {
    /**
     * Checks whether an item's key matches the given key.
     *
     * @param key
     *            the key value
     * @return true iff the item's key matches the given key
     */
    public boolean matches(K id);
}

