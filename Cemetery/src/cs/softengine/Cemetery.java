package cs.softengine;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * A cemetery
 */
public class Cemetery {
    public ArrayList<Section> sections; // TODO probably change these to hashmaps later in a refactoring
    public ArrayList<Plot> plots; // list of all plots in the cemetery
    public ArrayList<InterredPerson> interredPeople; // list of all interred people in the cemetery
    public ArrayList<Person> people; // list of all (non-interred) people in the cemetery

    /**
     * Constructs a cemetery
     */
    public Cemetery() {
        sections = new ArrayList<Section>();
        interredPeople = new ArrayList<InterredPerson>();
        people = new ArrayList<Person>();
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
            switch (line) {
                case "<CEMETERY>":
                    loadCemetery(buffer);
                    break;
                case "<SECTION>":
                    loadSection(buffer);
                    break;
                case "<PLOT>":
                    loadPlot(buffer);
                    break;
            }
        }

        buffer.close();
    }

    /**
     * Read cemetery data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private void loadCemetery(BufferedReader buffer) throws IOException {
        String line;
        int numSections; // number of sections in cemetery
        int numInterred; // number of interred people in cemetery
        int numPeople; // number of (non-interred) people

        line = buffer.readLine().trim();
        numSections = Integer.parseInt(line);

        line = buffer.readLine().trim();
        numInterred = Integer.parseInt(line);

        line = buffer.readLine().trim();
        numPeople = Integer.parseInt(line);

        sections = new ArrayList<Section>(numSections);
        interredPeople = new ArrayList<InterredPerson>(numInterred);
        people = new ArrayList<Person>(numPeople);
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
        String line;
        SimpleDateFormat sdf;

        String section; // residing section name
        int id; // plot identifier number
        InterredPerson interred; // interred person
        Person owner; // contact person, also person fiscally responsible for plot
        Date burial; // burial date
        Date purchased; // purchase date
        boolean vacant; // is the plot vacant/not vacant
        boolean ready; // is the plot ready for use or not ready
        int moneyDue; // if not 0, person owes this much IN CENTS (for accuracy)

        sdf = new SimpleDateFormat("YYYY-MM-DD");

        line = buffer.readLine().trim();
        section = line;

        line = buffer.readLine().trim();
        id = Integer.parseInt(line);

        line = buffer.readLine().trim();
        interred = loadInterredPerson(buffer);

        line = buffer.readLine().trim();
        owner = loadPerson(buffer);

        line = buffer.readLine().trim();
        try {
            burial = sdf.parse(line);
        } catch (ParseException e) {
            burial = null;
        }

        line = buffer.readLine().trim();
        try {
            purchased = sdf.parse(line);
        } catch (ParseException e) {
            purchased = null;
        }

        line = buffer.readLine().trim();
        vacant = Boolean.parseBoolean(line);

        line = buffer.readLine().trim();
        ready = Boolean.parseBoolean(line);

        line = buffer.readLine().trim();
        moneyDue = Integer.parseInt(line);

        Plot p = new Plot(section, id, interred, owner, burial, purchased, vacant, ready, moneyDue);

        plots.add(p);
        sections.get(sections.indexOf(new Section(section))).add(p); // this is why we need hashmap probably
    }

    /**
     * Reads a person's data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private Person loadPerson(BufferedReader buffer) throws IOException {
        // TODO in progress by mike
        return null;
    }

    /**
     * Reads an interred person's data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private InterredPerson loadInterredPerson(BufferedReader buffer) throws IOException {
        // TODO in progress by mike
        return null;
    }

    /**
     * Save cemetery data
     */
    public void save(String file) throws IOException {
        // TODO in progress by mike
        PrintWriter buffer;
        File oldFile;
        File newFile;
        String line;

        // rename old file
        oldFile = new File(file);
        oldFile.renameTo(new File(file + ".old"));
        oldFile.deleteOnExit();

        // open new file
        newFile = new File(file);
        buffer = new PrintWriter(new FileWriter(newFile));

        buffer.println(this); // write cemetery data

        for (Section s : sections) {
            buffer.println(s); // write section data
            for (Plot p : s.getPlots()) {
                buffer.println(p); // write plot data
            }
        }

        buffer.close();
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

    /**
     * Write this cemetery to a string (for saving)
     * @return section name and size
     */
    public String toString() {
        return "<CEMETERY>\n"
                + sections.size() + "\n"
                + plots.size() + "\n"
                + interredPeople.size() + "\n"
                + people.size() + "\n"
                + "</CEMETERY>";
    }
}
