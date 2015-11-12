package cs.softengine;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A cemetery
 */
public class Cemetery {
    private ArrayList<Section> sections; // list of all sections in the cemetery
    private ArrayList<Plot> plots; // list of all plots in the cemetery
    private ArrayList<InterredPerson> interred; // list of all interred people in the cemetery
    private ArrayList<Person> contacts; // list of all plot contact people in the cemetery
    private boolean modified; // has the cemetery been modified
    private int nextPlotID; // next available plotID
    private int nextInterredID; // next available interredID
    private int nextContactID; // next available contactID

    /**
     * Constructs a single cemetery
     */
    public Cemetery() {
        modified = false;
        nextPlotID = 0;
        nextInterredID = 0;
        nextContactID = 0;

        sections = new ArrayList<>();
        plots = new ArrayList<>();
        interred = new ArrayList<>();
        contacts = new ArrayList<>();
    }

    /**
     * Construct a cemetery from a file
     * @param file cemetery file
     */
    public Cemetery(File file) {
        modified = false;
        nextPlotID = 0;
        nextInterredID = 0;
        nextContactID = 0;

        try {
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
        // TODO decompress file, then decrypt file

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

        for (Section s : sections) {
            Collections.sort(s.getPlots());
        }
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
        int numContacts; // number of (non-interred) people

        numSections = Integer.parseInt(buffer.readLine().trim());
        numPlots = Integer.parseInt(buffer.readLine().trim());
        numInterred = Integer.parseInt(buffer.readLine().trim());
        numContacts = Integer.parseInt(buffer.readLine().trim());

        sections = new ArrayList<>(numSections);
        plots = new ArrayList<>(numPlots);
        interred = new ArrayList<>(numInterred);
        contacts = new ArrayList<>(numContacts);
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
        Plot plot;

        String sectionName; // residing section name
        int id; // plot identifier number
        InterredPerson interred; // interred person
        Person contact; // contact person, also person fiscally responsible for plot
        String burialMonth, burialDay, burialYear; // burial date
        String purchasedMonth, purchasedDay, purchasedYear; // purchase date
        boolean vacant; // is the plot vacant/not vacant
        boolean ready; // is the plot ready for use or not ready
        BigDecimal moneyDue; // if not 0, person owes this much IN CENTS (for accuracy)

        sectionName = buffer.readLine().trim();
        id = Integer.parseInt(buffer.readLine().trim());

        nextPlotID = id >= nextPlotID ? id + 1 : nextPlotID;

        interred = loadInterredPerson(buffer); // load an interred person belonging to this plot
        contact = loadPerson(buffer); // load a contact belonging to this plot

        // load a burial date
        burialMonth = buffer.readLine().trim();
        burialDay = buffer.readLine().trim();
        burialYear = buffer.readLine().trim();

        // load a purchased date
        purchasedMonth = buffer.readLine().trim();
        purchasedDay = buffer.readLine().trim();
        purchasedYear = buffer.readLine().trim();

        vacant = Boolean.parseBoolean(buffer.readLine().trim());
        ready = Boolean.parseBoolean(buffer.readLine().trim());

        moneyDue = new BigDecimal(buffer.readLine().trim());

        plot = new Plot(sectionName, id, interred, contact, burialMonth, burialDay, burialYear,
                purchasedMonth, purchasedDay, purchasedYear, vacant, ready, moneyDue);

        plots.add(plot);
        section.add(plot);
    }

    /**
     * Reads a person's data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private Person loadPerson(BufferedReader buffer) throws IOException {
        Person contact;

        int contactID;
        String fname, lname;
        String address1, address2;
        String city, state, zip;
        String phone;

        buffer.readLine().trim(); // read empty line
        String temp = buffer.readLine().trim();

        if (temp.equals("null")) {
            contact = null;
            buffer.readLine().trim(); // read empty line
        } else {
            contactID = Integer.parseInt(temp);
            nextContactID = contactID >= nextContactID ? contactID + 1 : nextContactID;

            fname = buffer.readLine().trim();
            lname = buffer.readLine().trim();
            address1 = buffer.readLine().trim();
            address2 = buffer.readLine().trim();
            city = buffer.readLine().trim();
            state = buffer.readLine().trim();
            zip = buffer.readLine().trim();
            phone = buffer.readLine().trim();

            contact = new Person(contactID, fname, lname, address1, address2, city, state, zip, phone);

            buffer.readLine().trim(); // read empty line

            // read owned plots YIKES
            temp = buffer.readLine().trim();
            if (!temp.equals("null")) {
                contact.addOwnedPlot(Integer.parseInt(temp));
                while (!(temp = buffer.readLine().trim()).equals("</OWNEDPLOTS>")) {
                    contact.addOwnedPlot(Integer.parseInt(temp));
                }
            } else {
                buffer.readLine().trim();
            }

            buffer.readLine().trim(); // read empty line

            contacts.add(contact);
        }

        return contact;
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
        String bornMonth, bornDay, bornYear;
        String diedMonth, diedDay, diedYear;
        String fname, lname;

        buffer.readLine().trim(); // read empty line
        String temp = buffer.readLine().trim();

        if (temp.equals("null")) {
            ip = null;
            buffer.readLine().trim();
        } else {
            interredID = Integer.parseInt(temp);
            nextInterredID = interredID >= nextInterredID ? interredID + 1 : nextInterredID;

            plotID = Integer.parseInt(buffer.readLine().trim());

            bornMonth = buffer.readLine().trim();
            bornDay = buffer.readLine().trim();
            bornYear = buffer.readLine().trim();

            diedMonth = buffer.readLine().trim();
            diedDay = buffer.readLine().trim();
            diedYear = buffer.readLine().trim();

            fname = buffer.readLine().trim();
            lname = buffer.readLine().trim();

            buffer.readLine().trim(); // read empty line

            ip = new InterredPerson(interredID, plotID, bornMonth, bornDay, bornYear, diedMonth, diedDay, diedYear,
                    fname, lname);

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

        Collections.sort(sections);
        Collections.sort(plots);
        Collections.sort(interred);
        Collections.sort(contacts);

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
        int index = sections.indexOf(s);

        if (index < 0) {
            return null;
        } else {
            return sections.get(index);
        }
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
     * Get list of all contact people in cemetery
     * @return people
     */
    public ArrayList<Person> getContacts() {
        return contacts;
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
     * Set the next available ID number for a plot
     */
    public void setNextPlotID() {
        nextPlotID++;
    }

    /**
     * Get the next available ID number for a plot
     * @return nextPlotID
     */
    public int getNextPlotID() {
        return nextPlotID;
    }

    /**
     * Set the next available ID number for an interred person
     */
    public void setNextInterredID() {
        nextInterredID++;
    }

    /**
     * Get the next available ID number for an interred person
     * @return nextInterredID
     */
    public int getNextInterredID() {
        return nextInterredID;
    }

    /**
     * Set the next available ID number for a contact
     */
    public void setNextContactID() {
        nextContactID++;
    }

    /**
     * Get the next available ID number for a contact
     * @return nextcontactID
     */
    public int getNextContactID() {
        return nextContactID;
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
                + contacts.size() + "\n"
                + "</CEMETERY>\n";
    }
}