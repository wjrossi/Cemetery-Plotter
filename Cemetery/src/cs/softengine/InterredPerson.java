package cs.softengine;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A person interred in a plot.  Includes information about their plot.
 */
public class InterredPerson extends Person implements Comparable<Person> {
    public int interredID; // id number for the interred person
    public int plotID; // id number of the plot in which this person is interred
    public Date born;
    public Date died;

    /**
     * Construct a new, empty interred person
     */
    public InterredPerson() {
        interredID = -1;
        plotID = -1;
        born = null;
        died = null;
    }

    /**
     * Construct a new interred person
     * @param interredID unique number
     * @param plotID unique number
     * @param born may be null
     * @param died may be null
     */
    public InterredPerson(int interredID, int plotID, Date born, Date died) {
        this.interredID = interredID;
        this.plotID = plotID;
        this.born = born;
        this.died = died;
        fname = "";
        lname = "";
        address1 = "";
        address2 = "";
        city = "";
        state = "";
        zip = "";
        phone = "";
    }

    /**
     * Construct a new interred person with fname and lnamme
     * @param interredID unique number
     * @param plotID unique number
     * @param born may be null
     * @param died may be null
     */
    public InterredPerson(int interredID, int plotID, Date born, Date died, String fname, String lname) {
        this.interredID = interredID;
        this.plotID = plotID;
        this.born = born;
        this.died = died;
        this.fname = fname;
        this.lname = lname;
        address1 = "";
        address2 = "";
        city = "";
        state = "";
        zip = "";
        phone = "";
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
     * Compare an interred person to another interred person based on their interredID
     * @param p a person
     * @return  < 0 if p is less than this interredID
     *            0 if p is equal to this interredID
     *          > 0 if p is greater than this interredID
     */
    @Override
    public int compareTo(Person p) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException();
        }

        InterredPerson ip = (InterredPerson) p;

        return ip.getInterredID() - interredID;
    }

    /**
     * InterredPerson equals InterredPerson
     * @param o a InterredPerson object
     * @return true if they are the same interred person
     */
    public boolean equals(Object o) throws NullPointerException {
        if (o == null) {
            throw new NullPointerException();
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        final Person p = (Person) o;

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
