package cs.softengine;

import java.util.ArrayList;

// We probably don't need this.  Could all be in Person.

/**
 * A purchaser of a plot. Includes information about what plots they purchased/own.
 */
public class PurchaserPerson extends Person {
    private ArrayList<Plot> ownedPlots;

    /**
     * Constructs a purchaser
     */
    public PurchaserPerson() {
        // TODO
    }
}
