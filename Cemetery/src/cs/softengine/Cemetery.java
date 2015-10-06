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
        sections = new ArrayList<>();
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
     * @param sections of the cemetery
     */
    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    /**
     * Get ArrayList of sections in the cemetery
     * @return sections
     */
    public ArrayList<Section> getSections() {
        return sections;
    }
}
