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
    public ArrayList<Section> sections; // TODO probably change these to hashmaps later in a refactoring
    public ArrayList<Plot> plots; // list of all plots in the cemetery
    public ArrayList<InterredPerson> interredPeople; // list of all interred people in the cemetery
    public ArrayList<Person> people; // list of all (non-interred) people in the cemetery

    /**
     * Constructs a cemetery
     */
    public Cemetery() {
        sections = new ArrayList<Section>();
        plots = new ArrayList<Plot>();
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

        while ((line = buffer.readLine()) != null) {
            line = line.trim();
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
        int numPlots; // number of plots in the cemetery
        int numInterred; // number of interred people in cemetery
        int numPeople; // number of (non-interred) people

        line = buffer.readLine().trim();
        numSections = Integer.parseInt(line);

        line = buffer.readLine().trim();
        numPlots = Integer.parseInt(line);

        line = buffer.readLine().trim();
        numInterred = Integer.parseInt(line);

        line = buffer.readLine().trim();
        numPeople = Integer.parseInt(line);

        sections = new ArrayList<Section>(numSections);
        plots = new ArrayList<Plot>(numPlots);
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
        if (line.isEmpty())
            moneyDue = 0;
        else {
            moneyDue = Integer.parseInt(line);
        }

        Plot p = new Plot(section, id, interred, owner, burial, purchased, vacant, ready, moneyDue);

        if (p.getOwner() != null) {
            p.getOwner().addOwnedPlot(p.getID());
        }

        plots.add(p);
        sections.get(sections.indexOf(new Section(section))).add(p); // this is why we need hashmap probably
    }

    /**
     * Reads a person's data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private Person loadPerson(BufferedReader buffer) throws IOException {
        String line;
        Person p;

        String fname;
        String lname;
        String address1;
        String address2;
        String city;
        String state;
        String zip;
        String phone;

        line = buffer.readLine().trim();

        if (line.equals("null")) {
            p = null;
            line = buffer.readLine().trim();
        } else {
            fname = line;
            lname = buffer.readLine().trim();
            address1 = buffer.readLine().trim();
            address2 = buffer.readLine().trim();
            city = buffer.readLine().trim();
            state = buffer.readLine().trim();
            zip = buffer.readLine().trim();
            phone = buffer.readLine().trim();

            line = buffer.readLine().trim();

            p = new Person(fname, lname, address1, address2, city, state, zip, phone);

            people.add(p);
        }

        return p;
    }

    /**
     * Reads an interred person's data from file
     * @param buffer of cemetery file
     * @throws IOException
     */
    private InterredPerson loadInterredPerson(BufferedReader buffer) throws IOException {
        String line;
        InterredPerson ip;

        SimpleDateFormat sdf;

        int interredID; // id number for the interred person
        int plotID; // id number of the plot in which this person is interred
        Date born;
        Date died;
        String fname;
        String lname;
        String address1;
        String address2;
        String city;
        String state;
        String zip;
        String phone;

        sdf = new SimpleDateFormat("YYYY-MM-DD");

        line = buffer.readLine().trim();

        if (line.equals("null")) {
            ip = null;
            line = buffer.readLine().trim();
        } else {
            interredID = Integer.parseInt(line);

            line = buffer.readLine().trim();
            plotID = Integer.parseInt(line);

            line = buffer.readLine().trim();
            try {
                born = sdf.parse(line);
            } catch (ParseException e) {
                born = null;
            }

            line = buffer.readLine().trim();
            try {
                died = sdf.parse(line);
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

            line = buffer.readLine().trim();

            ip = new InterredPerson(interredID, plotID, born, died,
                    fname, lname, address1, address2, city, state, zip, phone);

            interredPeople.add(ip);
        }

        return ip;
    }

    /**
     * Save cemetery data
     */
    public void save(String file) throws IOException {
        PrintWriter buffer;
        File oldFile;
        File newFile;
        String line;

        oldFile = new File(file);
        newFile = new File(file + ".new");

        buffer = new PrintWriter(new FileWriter(newFile));

        buffer.print(this); // write cemetery data

        for (Section s : sections) {
            buffer.print(s); // write section data
            for (Plot p : s.getPlots()) {
                buffer.print(p); // write plot data
            }
        }

        buffer.close();

        if (newFile.exists()) {
            oldFile.delete();
            newFile.renameTo(new File(file));
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
    public ArrayList<InterredPerson> getInterredPeople() {
        return interredPeople;
    }

    /**
     * Get list of all (non-interred) people in cemetery
     * @return people
     */
    public ArrayList<Person> getPeople() {
        return people;
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
                + "</CEMETERY>\n";
    }
}