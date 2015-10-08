package cs.softengine;
import java.util.ArrayList;

/**
 * A cemetery
 */
public class Cemetery {
    private ArrayList<Section> sections;

    /**
     * Constructs a cemetery
     */
    public Cemetery() {
        sections = new ArrayList<Section>();
    }

    /**
     * Construct a cemetery from a file
     * @param file cemetery file
     */
    public Cemetery(String file) {
        load(file);
    }

    /**
     * Read cemetery data from a file
     * @param file the file name
     */
    public void load(String file) {
        // do stuff
        // sections = new ArrayList<>(size); // based on file data
    }

    /**
     * Save cemetery data
     */
    public void save() {
        // do stuff
    }

    /**
     * Set the sections in the cemetery
     * @param s of the cemetery
     */
    public void setSections(ArrayList<Section> s) {
        sections = s;
    }

    /**
     * Get ArrayList of sections in the cemetery
     * @return sections
     */
    public ArrayList<Section> getSections() {
        return sections;
    }

    /**
     * Get a section
     * @param s section
     * @return section of the cemetery, null if it does not exist
     */
    public Section get(Section s) {
        return null; // TODO
    }

    /**
     * Get a plot
     * @param p plot
     * @return plot, null if it does not exist
     */
    public Plot get(Plot p) {
        return null; // TODO
    }

    /**
     * Get a person
     * @param p person
     * @return person, null if they do not exist
     */
    public Person get(Person p) {
        return null; // TODO
        // should this return a list of possible results or will that be in some other findPerson method somewhere?
    }
}
