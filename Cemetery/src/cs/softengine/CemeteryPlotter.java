package cs.softengine;

import org.parse4j.ParseException;
import java.io.File;
import java.io.FileNotFoundException;

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
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        File defaultFile;

        switch (System.getProperty("os.name").toLowerCase()) {
            case "mac os x":
                System.setProperty("apple.laf.useScreenMenuBar", "true");
                break;
        }

        defaultFile = new File("cemetery.db"); // the default file for saving and loading cemetery data
        workingFile = defaultFile; // set working file to default file
        cemetery = new Cemetery(workingFile); // initialize cemetery with default file
        cemeteryPlotterFrame = new CemeteryPlotterFrame(); // create and initialize GUI

        ParseClient pc = new ParseClient();


        try {
            pc.saveFile(workingFile);
        } catch (ParseException e) {
            System.out.println("Exception thrown  :" + e);
        } catch (FileNotFoundException e) {
            System.out.println("Exception thrown  :" + e);
        }
    }
}
