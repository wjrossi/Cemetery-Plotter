package cs.softengine;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.Date;

/**
 * A plot
 */
public class Plot implements Comparable<Plot> {
    String section; // residing section name
    Person interred; // interred person
    Person owner; // contact person, also person fiscally responsible for plot
    Date burial; // burial date
    Date purchased; // purchase date
    float moneyDue; // if not 0, person owes this much
    boolean vacant; // is the plot vacant/not vacant
    boolean ready; // is the plot ready for use or not ready

    // we need some sort of unique identifier for a plot
    int identifier;
    /**
     * Constructs an empty plot
     */
    public Plot() {

        section = null;
        interred = new Person();
        owner = new Person();
        burial = new Date();
        purchased = new Date();
        moneyDue = 0;
        vacant = true;
        ready = true;

    }

    // TODO add methods

    /**
     * Get a plot
     * @param p a person
     * @return Plot, null if
     */
    public Plot get(Person p){
        // TODO
        return null;
    }

    public void set(Person p){
        // TODO
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
