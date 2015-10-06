package cs.softengine;

import java.util.Date;

/**
 * A plot
 */
public class Plot implements Comparable<Plot> {
    Section section;
    Person interredPerson;
    Person contactPerson;
    Date burialDate;
    boolean isVacant;

    /**
     * Constructs a plot
     */
    public Plot() {

    }

    /**
     * Compare a plot to another plot
     * @param p a plot
     * @return  < 0 if p is less than this plot
     *            0 if p is equal to this plot
     *          > 0 if p is greater than this plot
     */
    @Override
    public int compareTo(Plot p) throws NullPointerException {
        // how do we compare plots? we need a unique identifier
        // this will come in handy when we are searching for plots or people
        return 0;
    }

    /**
     * Plot equals plot
     * @param p a plot
     * @return true if they are the same plot
     */
    public boolean equals(Plot p) throws NullPointerException {
        // how do we know if they are the same plot?
        return compareTo(p) == 0;
    }
}
