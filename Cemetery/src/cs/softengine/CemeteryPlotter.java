package cs.softengine;

import java.io.File;

/**
 * CemeteryPlotter utility for cemetery management.
 */
public class CemeteryPlotter {
    private static CemeteryPlotterFrame cemeteryPlotterFrame;
    private static Cemetery cemetery;
    private static File workingFile;

    /**
     * Main
     * @param args n/a
     */
    public static void main(String[] args){
        File defaultFile;

        defaultFile = new File("cemetery.db"); // the default file for saving and loading cemetery data
        workingFile = defaultFile; // set working file to default file
        cemetery = new Cemetery(defaultFile); // initialize cemetery with default file
        cemeteryPlotterFrame = new CemeteryPlotterFrame(); // create and initialize GUI
    }

    /**
     * Get the main cemetery object
     * @return cemetery
     */
    public static Cemetery getCemetery() {
        return cemetery;
    }

    /**
     * Set the working file whenever user opens a file
     * @param file working file, null if you want to use defaultFile
     */
    public static void setWorkingFile(File file) {
        workingFile = file;
    }

    /**
     * Get working file
     * @return working file
     */
    public static File getWorkingFile() {
        return workingFile;
    }
}
