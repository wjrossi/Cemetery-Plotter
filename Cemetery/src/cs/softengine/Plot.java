package cs.softengine;

import java.util.Date;

/**
 * A plot
 */
public class Plot implements Comparable<Plot> {
    String section; // residing section name
    Person interred; // interred person
    Person contact; // contact person
    Person purchaser; // purchaser/owner
    Date burial; // burial date
    Date purchased; // purchase date
    boolean vacant; // is the plot vacant/not vacant
    boolean ready; // is the plot ready for use or not ready

    // we need some sort of unique identifier for a plot

    /**
     * Constructs a plot
     */
    public Plot() {
        // TODO
    }

    // TODO add methods

    /**
     * Compare a plot to another plot
     * @param p a plot
     * @return  < 0 if p is less than this plot
     *            0 if p is equal to this plot
     *          > 0 if p is greater than this plot
     */
    @Override
    public int compareTo(Plot p) throws NullPointerException {
        // how do we compare plots? we need a unique identifier TODO
        // this will come in handy when we are searching for plots or people
        return 0;
    }

    /**
     * Plot equals plot
     * @param o a plot object
     * @return true if they are the same plot
     */
    public boolean equals(Object o) throws NullPointerException {
        if (o == null) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        final Plot p = (Plot) o;

        return compareTo(p) == 0;
    }

    /**
     * Write plot to string (for saving)
     * @return plot data
     */
    public String toString() {
        return null; // TODO
    }
}
