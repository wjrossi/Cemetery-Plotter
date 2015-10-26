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
    private Date born;
    private Date died;
    private String fname;
    private String lname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Construct a new, empty interred person
     */
    public InterredPerson() {
        this(-1, -1, null, null, "", "", "", "", "", "", "", "");
    }

    /**
     * Construct a new interred person
     * @param interredID unique number
     * @param plotID unique number
     * @param born may be null
     * @param died may be null
     */
    public InterredPerson(int interredID, int plotID, Date born, Date died) {
        this(interredID, plotID, born, died, "", "", "", "", "", "", "", "");
    }

    /**
     * Construct a new interred person with fname and lnamme
     * @param interredID unique number
     * @param plotID unique number
     * @param born may be null
     * @param died may be null
     */
    public InterredPerson(int interredID, int plotID, Date born, Date died, String fname, String lname) {
        this(interredID, plotID, born, died, fname, lname, "", "", "", "", "", "");
    }

    /**
     * Construct a new interred person with all details
     * @param interredID unique number
     * @param plotID unique number
     * @param born may be null
     * @param died may be null
     */
    public InterredPerson(int interredID, int plotID, Date born, Date died, String fname, String lname,
                          String address1, String address2, String city, String state, String zip, String phone) {
        this.interredID = interredID;
        this.plotID = plotID;
        this.born = born;
        this.died = died;
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
     * Get date born
     * @return date born, null if unknown
     */
    public Date getBornDate() {
        return born;
    }

    /**
     * Set date born
     * @param d date born, null if unknown
     */
    public void setBornDate(Date d) {
        born = d;
    }

    /**
     * Get died date
     * @return died date, null if unknown
     */
    public Date getDiedDate() {
        return died;
    }

    /**
     * Set date died
     * @param d date died, null if unknown
     */
    public void setDiedDate(Date d) {
        died = d;
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
                + born + "\n"
                + died + "\n"
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
