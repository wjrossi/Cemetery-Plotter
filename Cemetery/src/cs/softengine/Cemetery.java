package cs.softengine;

import java.io.*;
import java.util.ArrayList;

/**
 * A cemetery
 */
public class Cemetery {
    public ArrayList<Section> sections; // TODO probably change these to hashmaps later in a refactoring
    public ArrayList<Person> people; // list of all people in the cemetery
    public ArrayList<InterredPerson> interredPeople; // list of all interred people in the cemetery

    /**
     * Constructs a cemetery
     */
    public Cemetery() {
        sections = new ArrayList<Section>();
        people = new ArrayList<Person>();
        interredPeople = new ArrayList<InterredPerson>();
    }

    /**
     * Construct a cemetery from a file
     * @param file cemetery file
     */
    public Cemetery(String file) {
        try {
            load(file);
        } catch (IOException e) {
            // show some kind of error to user
        }
    }

    /**
     * Read cemetery data from a file
     * @param file the file name
     * @throws IOException
     */
    public void load(String file) throws IOException {
        BufferedReader buffer;
        String line;

        buffer = new BufferedReader(new FileReader(file));

        while ((line = buffer.readLine().trim()) != null) {
            if (line.equals("#SECTIONS")) {
                int size; // number of sections in cemetery
                line = buffer.readLine().trim();
                size = Integer.parseInt(line);
                sections = new ArrayList<Section>(size);
            } else if (line.equals("#SECTION")) {
                loadSection(buffer);
            } else if (line.equals("#PLOT")) {
                loadPlot(buffer);
            }
        }

        buffer.close();
    }

    /**
     * Read section data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private void loadSection(BufferedReader buffer) throws IOException {
        String line;
        String name; // name of new section
        int size; // number of plots in new section

        line = buffer.readLine().trim();
        name = line;

        line = buffer.readLine().trim();
        size = Integer.parseInt(line);

        Section s = new Section(name, size);

        sections.add(s); // add new section to list of sections
    }

    /**
     * Reads plot data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private void loadPlot(BufferedReader buffer) throws IOException {
        // TODO in progress
    }

    /**
     * Reads a person's data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private void loadPerson(BufferedReader buffer) throws IOException {
        // TODO in progress
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
        return sections.get(sections.indexOf(s));
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
