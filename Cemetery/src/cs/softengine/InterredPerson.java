package cs.softengine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A person interred in a plot.  Includes information about their plot.
 */
public class InterredPerson implements Comparable<InterredPerson> {
    private int interredID; // id number for the interred person
    private int plotID; // id number of the plot in which this person is interred
    private Date bornMonth; // date of birth
    private Date bornDay;
    private Date bornYear;
    private Date diedMonth; // date of death
    private Date diedDay;
    private Date diedYear;
    private String fname;
    private String lname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private SimpleDateFormat sdfMonth; // month date format
    private SimpleDateFormat sdfDay; // day date format
    private SimpleDateFormat sdfYear; // year date format

    /**
     * Construct a new, empty interred person
     */
    public InterredPerson() {
        this(-1, -1, "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    /**
     * Construct a new interred person with an ID number
     * @param interredID unique ID number for the interred person in the plot
     */
    public InterredPerson(int interredID) {
        this(interredID, -1, "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    /**
     * Construct a new interred person
     * @param interredID unique ID number for the interred person in the plot
     * @param plotID unique ID number of the plot in which this person is interred
     */
    public InterredPerson(int interredID, int plotID) {
        this(interredID, plotID, "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    /**
     * Construct a new interred person with all details
     * @param interredID unique ID number for the interred person in the plot
     * @param plotID unique ID number of the plot in which this person is interred
     * @param bornMonth month, may be null
     * @param bornDay day, may be null
     * @param bornYear year, may be null
     * @param diedMonth month, may be null
     * @param diedDay day, may be null
     * @param diedYear year, may be null
     * @param fname first name
     * @param lname last name
     * @param address1 line 1 of address
     * @param address2 line 2 of address
     * @param city the city
     * @param state the state
     * @param zip the zip code
     * @param phone phone number
     */
    public InterredPerson(int interredID, int plotID,
                          String bornMonth, String bornDay, String bornYear,
                          String diedMonth, String diedDay, String diedYear,
                          String fname, String lname,
                          String address1, String address2,
                          String city, String state, String zip, String phone) {
        sdfMonth = new SimpleDateFormat("MM");
        sdfDay = new SimpleDateFormat("dd");
        sdfYear = new SimpleDateFormat("yyyy");

        this.interredID = interredID;
        this.plotID = plotID;
        setBornDateMonth(bornMonth);
        setBornDateDay(bornDay);
        setBornDateYear(bornYear);
        setDiedDateMonth(diedMonth);
        setDiedDateDay(diedDay);
        setDiedDateYear(diedYear);
        this.fname = fname;
        this.lname = lname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
    }

    /**
     * Get plot id nubmer
     * @return plot id number
     */
    public int getPlotID() {
        return plotID;
    }

    /**
     * Set plot id number
     * @param id plot id number
     */
    public void setPlotID(int id) {
        plotID = id;
    }

    /**
     * Get interred id number
     * @return interred id number
     */
    public int getInterredID() {
        return interredID;
    }

    /**
     * Set interred id number
     * @param id interred id number
     */
    public void setInterredID(int id) {
        interredID = id;
    }

    /**
     * Get month of date born
     * @return month of date born, null if unknown
     */
    public String getBornDateMonth() {
        String date;

        try {
            date = sdfMonth.format(bornMonth);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set month of date born
     * @param d month of date born, null if unknown
     */
    public void setBornDateMonth(String d) {
        try {
            bornMonth = sdfMonth.parse(d);
        } catch (ParseException e) {
            bornMonth = null;
        }
    }

    /**
     * Get day of date born
     * @return day date born, null if unknown
     */
    public String getBornDateDay() {
        String date;

        try {
            date = sdfDay.format(bornDay);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set day of date born
     * @param d day of date born, null if unknown
     */
    public void setBornDateDay(String d) {
        try {
            bornDay = sdfDay.parse(d);
        } catch (ParseException e) {
            bornDay = null;
        }
    }

    /**
     * Get year of date born
     * @return year of date born, null if unknown
     */
    public String getBornDateYear() {
        String date;

        try {
            date = sdfYear.format(bornYear);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set year of date born
     * @param d year of date born, null if unknown
     */
    public void setBornDateYear(String d) {
        try {
            bornYear = sdfYear.parse(d);
        } catch (ParseException e) {
            bornYear = null;
        }
    }

    /**
     * Get month of date died
     * @return month of date died, null if unknown
     */
    public String getDiedDateMonth() {
        String date;

        try {
            date = sdfMonth.format(diedMonth);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set month of date died
     * @param d month of date died, null if unknown
     */
    public void setDiedDateMonth(String d) {
        try {
            diedMonth = sdfMonth.parse(d);
        } catch (ParseException e) {
            diedMonth = null;
        }
    }

    /**
     * Get day of date died
     * @return day of date died, null if unknown
     */
    public String getDiedDateDay() {
        String date;

        try {
            date = sdfDay.format(diedDay);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set day of date died
     * @param d day of date died, null if unknown
     */
    public void setDiedDateDay(String d) {
        try {
            diedDay = sdfDay.parse(d);
        } catch (ParseException e) {
            diedDay = null;
        }
    }

    /**
     * Get year of date died
     * @return year of date died, null if unknown
     */
    public String getDiedDateYear() {
        String date;

        try {
            date = sdfYear.format(diedYear);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set year of date died
     * @param d year of date died, null if unknown
     */
    public void setDiedDateYear(String d) {
        try {
            diedYear = sdfYear.parse(d);
        } catch (ParseException e) {
            diedYear = null;
        }
    }

    /**
     * Set first name
     * @param fname first name
     */
    public void setFirstName(String fname) {
        this.fname = fname;
    }

    /**
     * Get first name
     * @return first name
     */
    public String getFirstName() {
        return fname;
    }

    /**
     * Set last name
     * @param lname last name
     */
    public void setLastName(String lname) {
        this.lname = lname;
    }

    /**
     * Get last name
     * @return lname last name
     */
    public String getLastName() {
        return lname;
    }

    /**
     * Set address line 1
     * @param address1 address line 1
     */
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     * Get address line 1
     * @return address1
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Set address line 2
     * @param address2 address line 2
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Get address line 2
     * @return address2 address line 2
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Set the city
     * @param city city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the state
     * @param state state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get state
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Set zip code
     * @param zip zip code
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Get zip code
     * @return zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * Set phone number
     * @param phone phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Get phone number
     * @return phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Compare an interred person to another interred person based on their interredID
     * @param p an interred person
     * @return  < 0 if p is less than this interredID
     *            0 if p is equal to this interredID
     *          > 0 if p is greater than this interredID
     */
    @Override
    public int compareTo(InterredPerson p) throws NullPointerException {
        if (p == null)
            throw new NullPointerException();

        return p.getInterredID() - interredID;
    }

    /**
     * InterredPerson equals InterredPerson
     * @param o a InterredPerson object
     * @return true if they are the same interred person
     */
    public boolean equals(Object o) throws NullPointerException {
        if (o == null)
            throw new NullPointerException();

        if (getClass() != o.getClass())
            return false;

        final InterredPerson p = (InterredPerson) o;

        return compareTo(p) == 0;
    }

    /**
     * Write this person to a string (for saving)
     * @return all person info
     */
    public String toString() {
        return "<INTERREDPERSON>\n"
                + interredID + "\n"
                + plotID + "\n"
                + getBornDateMonth() + "\n"
                + getBornDateDay() + "\n"
                + getBornDateYear() + "\n"
                + getDiedDateMonth() + "\n"
                + getDiedDateDay() + "\n"
                + getDiedDateYear() + "\n"
                + fname + "\n"
                + lname + "\n"
                + address1 + "\n"
                + address2 + "\n"
                + city + "\n"
                + state  + "\n"
                + zip + "\n"
                + phone  + "\n"
                + "</INTERREDPERSON>\n";
    }
}
