package cs.softengine;

import java.io.IOException;
import java.util.ArrayList;

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

        try {
            run(cemetery);
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
    public static void run(Cemetery c) throws RuntimeException {
        // eventually we will make the gui and show it by calling this
        // for now, use command line..

        System.out.println("CemeteryPlotter");

        ArrayList<Section> sections = c.getSections();
        ArrayList<Plot> plots = c.getPlots();
        ArrayList<InterredPerson> interredPeople = c.getInterredPeople();
        ArrayList<Person> people = c.getPeople();

        for (Section s : sections) {
            System.out.println("Section:\n" + s);
            for (Plot p : s.getPlots()) {
                System.out.println("Plot in " + s.getName() + "\n" + p);
            }
        }

        for (Section s : sections) {
            System.out.println("Section:\n" + s);
        }

        for (Plot p : plots) {
            System.out.println("Plot:\n" + p);
        }

        for (InterredPerson ip : interredPeople) {
            System.out.println("InterredPerson:\n" + ip);
        }

        for (Person p : people) {
            System.out.println("Person:\n" + p);
        }
    }
}
