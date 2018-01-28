package com.creation.diz.drumit.sequencer;

import com.creation.diz.drumit.itemlist.ItemList;

/**
 * Created by Diz on 1/27/2018.
 */

public class SequencerCellList extends ItemList<SequencerCell, Integer> {
    private static final long serialVersionUID = 1L;
    private static SequencerCellList instance;

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

