package cs.softengine;

import java.io.File;

/**
 * CemeteryPlotter utility for cemetery management.
 */
public class CemeteryPlotter {
    static CemeteryPlotterFrame cemeteryPlotterFrame;
    static Cemetery cemetery;
    static File workingFile;

    /**
     * Main
     * @param args n/a
     */
    public static void main(String[] args){
        File defaultFile;

        defaultFile = new File("cemetery.db"); // the default file for saving and loading cemetery data
        workingFile = defaultFile; // set working file to default file
        cemetery = new Cemetery(workingFile); // initialize cemetery with default file
        cemeteryPlotterFrame = new CemeteryPlotterFrame(); // create and initialize GUI
    }
}
