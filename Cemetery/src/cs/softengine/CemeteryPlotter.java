package cs.softengine;

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
        } catch (Exception e) {
            // catch some errors??
        } finally {
            cemetery.save(); // clean-up and save data
        }
    }

    /**
     * Run CemeteryPlotter
     */
    public static void run() throws Exception {
        // eventually we will make the gui and show it by calling this
        // for now, use command line..

        System.out.println("CemeteryPlotter");
    }
}
