package cs.softengine;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A cemetery
 */
public class Cemetery {
    private ArrayList<Section> sections; // list of all sections in the cemetery
    private ArrayList<Plot> plots; // list of all plots in the cemetery
    private ArrayList<InterredPerson> interred; // list of all interred people in the cemetery
    private ArrayList<Person> owners; // list of all plot owner people in the cemetery
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    private boolean modified; // has the cemetery been modified

    /**
     * Constructs a singleton cemetery
     */
    public Cemetery() {
        modified = false;
        sections = new ArrayList<>();
        plots = new ArrayList<>();
        interred = new ArrayList<>();
        owners = new ArrayList<>();
    }

    /**
     * Construct a cemetery from a file
     * @param file cemetery file
     */
    public Cemetery(File file) {
        modified = false;
        try {
            // TODO decompress file, then decrypt file
            load(file); // load the plain-text file
        } catch (IOException e) { // TODO show error dialogs
            System.err.println("Unable to read input file. Exiting.");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Read cemetery data from a file
     * @param file the file name
     * @throws IOException
     */
    public void load(File file) throws IOException {
        BufferedReader buffer;
        String temp;
        Section section = null; // current section for quick loading of plots

        buffer = new BufferedReader(new FileReader(file));
        while ((temp = buffer.readLine()) != null) {
            switch (temp.trim()) {
                case "<CEMETERY>":
                    loadCemetery(buffer);
                    break;
                case "<SECTION>":
                    section = loadSection(buffer);
                    break;
                case "<PLOT>":
                    loadPlot(buffer, section);
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
        int numSections; // number of sections in cemetery
        int numPlots; // number of plots in the cemetery
        int numInterred; // number of interred people in cemetery
        int numOwners; // number of (non-interred) people
        numSections = Integer.parseInt(buffer.readLine().trim());
        numPlots = Integer.parseInt(buffer.readLine().trim());
        numInterred = Integer.parseInt(buffer.readLine().trim());
        numOwners = Integer.parseInt(buffer.readLine().trim());

        sections = new ArrayList<>(numSections);
        plots = new ArrayList<>(numPlots);
        interred = new ArrayList<>(numInterred);
        owners = new ArrayList<>(numOwners);
    }

    /**
     * Read section data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private Section loadSection(BufferedReader buffer) throws IOException {
        Section section; // new section
        String name; // name of new section
        int size; // number of plots in new section

        name = buffer.readLine().trim();
        size = Integer.parseInt(buffer.readLine().trim());

        section = new Section(name, size);

        sections.add(section); // add new section to list of sections

        return section;
    }

    /**
     * Reads plot data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private void loadPlot(BufferedReader buffer, Section section) throws IOException {
        String sectionName; // residing section name
        int id; // plot identifier number
        InterredPerson interred; // interred person
        Person owner; // contact person, also person fiscally responsible for plot
        Date burial; // burial date
        Date purchased; // purchase date
        boolean vacant; // is the plot vacant/not vacant
        boolean ready; // is the plot ready for use or not ready
        int moneyDue; // if not 0, person owes this much IN CENTS (for accuracy)

        sectionName = buffer.readLine().trim();
        id = Integer.parseInt(buffer.readLine().trim());

        buffer.readLine().trim(); // read empty line
        interred = loadInterredPerson(buffer); // load an interred person belonging to this plot

        buffer.readLine().trim(); // read empty line
        owner = loadPerson(buffer); // load an owner belonging to this plot

        try { // load a burial date
            burial = sdf.parse(buffer.readLine().trim());
        } catch (ParseException e) {
            burial = null;
        }

        try { // load a purchased date
            purchased = sdf.parse(buffer.readLine().trim());
        } catch (ParseException e) {
            purchased = null;
        }

        vacant = Boolean.parseBoolean(buffer.readLine().trim());
        ready = Boolean.parseBoolean(buffer.readLine().trim());

        try { // load money due
            moneyDue = Integer.parseInt(buffer.readLine().trim());
        } catch (NumberFormatException e) {
            moneyDue = 0;
        }

        Plot p = new Plot(sectionName, id, interred, owner, burial, purchased, vacant, ready, moneyDue);

        if (p.getOwner() != null) p.getOwner().addOwnedPlot(p.getID());

        plots.add(p);
        section.add(p);
    }

    /**
     * Reads a person's data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private Person loadPerson(BufferedReader buffer) throws IOException {
        Person p;

        String fname,lname;
        String address1, address2;
        String city, state, zip;
        String phone;

        String temp;

        temp = buffer.readLine().trim();

        if (temp.equals("null")) {
            p = null;
            buffer.readLine().trim(); // read empty line
        } else {
            fname = temp;
            lname = buffer.readLine().trim();
            address1 = buffer.readLine().trim();
            address2 = buffer.readLine().trim();
            city = buffer.readLine().trim();
            state = buffer.readLine().trim();
            zip = buffer.readLine().trim();
            phone = buffer.readLine().trim();

            buffer.readLine().trim(); // read empty line

            p = new Person(fname, lname, address1, address2, city, state, zip, phone);
            owners.add(p);
        }

        return p;
    }

    /**
     * Reads an interred person's data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private InterredPerson loadInterredPerson(BufferedReader buffer) throws IOException {
        InterredPerson ip;
        int interredID; // id number for the interred person
        int plotID; // id number of the plot in which this person is interred
        Date born, died;
        String fname, lname;
        String address1, address2;
        String city, state, zip;
        String phone;

        String temp;

        temp = buffer.readLine().trim();

        if (temp.equals("null")) {
            ip = null;
            buffer.readLine().trim();
        } else {
            interredID = Integer.parseInt(temp);
            plotID = Integer.parseInt(buffer.readLine().trim());

            try {
                born = sdf.parse(buffer.readLine().trim());
            } catch (ParseException e) {
                born = null;
            }

            try {
                died = sdf.parse(buffer.readLine().trim());
            } catch (ParseException e) {
                died = null;
            }

            fname = buffer.readLine().trim();
            lname = buffer.readLine().trim();
            address1 = buffer.readLine().trim();
            address2 = buffer.readLine().trim();
            city = buffer.readLine().trim();
            state = buffer.readLine().trim();
            zip = buffer.readLine().trim();
            phone = buffer.readLine().trim();

            buffer.readLine().trim();

            ip = new InterredPerson(interredID, plotID, born, died,
                    fname, lname, address1, address2, city, state, zip, phone);

            interred.add(ip);
        }

        return ip;
    }

    /**
     * Save cemetery data
     */
    public void save(File file) throws IOException {
        if (file == null)
            throw new IOException("No file open to save");

        PrintWriter buffer;
        File oldFile, newFile;

        oldFile = file;
        newFile = new File(file.getName() + ".new");

        buffer = new PrintWriter(new FileWriter(newFile));

        buffer.print(this); // write cemetery data

        for (Section s : sections) {
            buffer.print(s); // write section data
            for (Plot p : s.getPlots()) {
                buffer.print(p); // write plot data
            }
        }

        buffer.close();

        // TODO encrypt newFile, then compress newFile

        if (newFile.exists()) { // delete temporary file if overwriting and rename it to original file name
            oldFile.delete();
            newFile.renameTo(file);
        }
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
     * Get list of all plots in cemetery
     * @return plots
     */
    public ArrayList<Plot> getPlots() {
        return plots;
    }

    /**
     * Get list of all interred people in cemetery
     * @return interred people
     */
    public ArrayList<InterredPerson> getInterred() {
        return interred;
    }

    /**
     * Get list of all owner people in cemetery
     * @return people
     */
    public ArrayList<Person> getOwners() {
        return owners;
    }

    /**
     * Has the cemetery been modified?
     * @return modified
     */
    public boolean isModified() {
        return modified;
    }

    /**
     * Set the cemetery as having been modified
     * @param modifiedValue new modified value
     */
    public void setModified(boolean modifiedValue) {
        modified = modifiedValue;
    }

    /**
     * Write this cemetery to a string (for saving)
     * @return section name and size
     */
    public String toString() {
        return "<CEMETERY>\n"
                + sections.size() + "\n"
                + plots.size() + "\n"
                + interred.size() + "\n"
                + owners.size() + "\n"
                + "</CEMETERY>\n";
    }
}