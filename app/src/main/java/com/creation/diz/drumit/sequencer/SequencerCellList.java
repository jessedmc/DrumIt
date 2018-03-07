package com.creation.diz.drumit.sequencer;

import com.creation.diz.drumit.changeable.Changeable;
import com.creation.diz.drumit.itemlist.ItemList;

/**
 * Created by Diz on 1/27/2018.
 */

public class SequencerCellList extends ItemList<SequencerCell, Integer> implements Changeable {
    private static final long serialVersionUID = 1L;
    private static SequencerCellList instance;
    private boolean changed = false, addChanged = false, removeChanged = false;
    private static final int ADD = 1, REMOVE = 0;

    /*
     * Private constructor for singleton pattern
     */
    private SequencerCellList() {
    }

    /**
     * Supports the singleton pattern
     *
     * @return the singleton object
     */
    public static SequencerCellList instance() {
        if (instance == null) {
            instance = new SequencerCellList();
        }
        return instance;
    }

    public void clear() {
        this.list.clear();
        this.changed = true;
        this.addChanged = false;
        this.removeChanged = false;
    }

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

    public void setChanged(int type) {
        switch (type) {
            case ADD:
                this.addChanged = true;
                this.removeChanged = false;
                break;
            case REMOVE:
                this.removeChanged = true;
                this.addChanged = false;
                break;
            default:
        }

    }

    // xtension of Changeable, indicates if change was add or remove
    public boolean isRemoveChanged() {
        return this.removeChanged;
    }

    // extension of Changeable, indicates if change was add or remove
    public boolean isAddChanged() {
        return this.addChanged;
    }
    /**
     * Checks whether a member with a given member id exists.
     *
     * @param memberId
     *            the id of the member
     * @return true iff member exists
     *
     */
    @Override
    public SequencerCell search(Integer id) {
        return super.search(id);
    }


    /**
     * Inserts a member into the collection
     *
     * @param member
     *            the member to be inserted
     * @return true iff the member could be inserted. Currently always true
     */
    public boolean insertSequencerCell(SequencerCell sequencerCell) {
        return super.add(sequencerCell);
    }


}

