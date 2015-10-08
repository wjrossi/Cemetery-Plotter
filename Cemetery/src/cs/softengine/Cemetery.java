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
        // do stuff TODO
        // sections = new ArrayList<>(size); // based on file data
    }

    /**
     * Save cemetery data
     */
    public void save() {
        // do stuff TODO
    }

    /**
     * Add a section to the cemetery
     * @param s the new section
     * @return success/failure
     */
    public boolean add(Section s) {
        return s != null && sections.add(s);

    }

    /**
     * Remove a section from the cemetery
     * @param s the old section
     * @return succes/failure
     */
    public boolean remove(Section s) {
        return s != null && sections.remove(s);

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
     * Get ArrayList of sections in the cemetery
     * @return sections
     */
    public ArrayList<Section> getSections() {
        return sections;
    }

    /**
     * Set the sections in the cemetery
     * @param s of the cemetery
     */
    public void setSections(ArrayList<Section> s) {
        sections = s;
    }
}
