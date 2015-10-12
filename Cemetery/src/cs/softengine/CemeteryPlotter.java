package cs.softengine;

import java.io.IOException;

/**
 * CemeteryPlotter utility for cemetery management.
 */
public class CemeteryPlotter {
    /**
     * Main
     * @param args n/a
     */
    public static void main(String [] args){
        String defaultFile = "cemetery.db"; // the default file for saving and loading cemetery data
        Cemetery cemetery = new Cemetery(defaultFile); // initialize cemetery with default file

        // do stuff like cemetery.load(data) ??

        try {
            run();
        } catch (RuntimeException e) {
            // catch some errors??
        } finally {
            try {
                cemetery.save(defaultFile); // clean-up and save data
            } catch (IOException e) {
                // catch some errors
            } finally {
                // don't exit? did it save?
            }
        }
    }

    /**
     * Run CemeteryPlotter
     */
    public static void run() throws RuntimeException {
        // eventually we will make the gui and show it by calling this
        // for now, use command line..

        System.out.println("CemeteryPlotter");
    }
}
