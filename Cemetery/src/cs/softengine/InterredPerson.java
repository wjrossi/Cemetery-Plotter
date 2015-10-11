package cs.softengine;

/**
 * A person interred in a plot.  Includes information about their plot.
 */
public class InterredPerson extends Person {
    /*
    private Plot plot;
    probably don't want this extra object because a person will belong to a plot
    but we need some way to get the plot from the person
    */

    int interredId;   //cem associates numerical id with all of their interred persons

    /**
     * Constructs an interred person
     */
    public InterredPerson() {
        // TODO
    }
}
