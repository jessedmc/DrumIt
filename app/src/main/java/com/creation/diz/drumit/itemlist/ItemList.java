package com.creation.diz.drumit.itemlist;

import com.creation.diz.drumit.changeable.Changeable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Diz on 1/27/2018.
 */

public class ItemList<T extends Matchable<K>, K> implements Serializable {
    private static final long serialVersionUID = 1L;
    protected List<T> list = new ArrayList<T>();


    /**
     * Checks whether an item with a given id exists.
     *
     * @param key
     *            the id of the item
     * @return the item iff the item exists
     *
     */
    public T search(K id) {
        for (T item : list) {
            if (item.matches(id)) {
                return item;
            }
        }
        return null;
    }

    public T get(int index) {
        return list.get(index);
    }

    /**
     * Adds an item to the list.
     *
     * @param item
     *            the item to be added
     * @return true iff the item could be added
     */
    public boolean add(T item) {
        return list.add(item);
    }

    /**
     * Removes the item from the list
     *
     * @param item
     *            the item to be removed
     * @return true iff the item could be removed
     */
    public boolean remove(T item) {
        return list.remove(item);
    }

    public void clear() {
        this.list.clear();
    }

    /**
     * Returns an iterator for the collection
     *
     * @return iterator for the collection
     */
    public Iterator<T> iterator() {
        return list.iterator();
    }

    public int size() {
        return list.size();
    }


}

