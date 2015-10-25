package cs.softengine;

import java.util.ArrayList;

/**
 * A person. Includes personal information like name and address.
 */
public class Person implements Comparable<Person> {
    private String fname;
    private String lname;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private ArrayList<Integer> plots; // list of plotID's owned by this person

    /**
     * Constructs a person.
     */
    public Person() {
        this.fname = "";
        this.lname = "";
        this.address1 = "";
        this.address2 = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phone = "";
        this.plots = new ArrayList<Integer>();
    }

    /**
     * Constructs a person using his fist name, last name.
     */
    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        this.address1 = "";
        this.address2 = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phone = "";
        this.plots = new ArrayList<Integer>();
    }

    /**
     * Constructs a person using his fist name, last name and phone number.
     */
    public Person(String fname, String lname, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.address1 = "";
        this.address2 = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phone = phone;
        this.plots = new ArrayList<Integer>();
    }

    /**
     * Constructs a person using all needed information
     */
    public Person(String fname, String lname, String address1, String address2, String city, String state, String zip, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.plots = new ArrayList<Integer>();
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
     * Get list of plots owned by this person
     * @return owned plots
     */
    public ArrayList<Integer> getOwnedPlots() {
        return plots;
    }

    /**
     * Set list of plots owned by this person
     * @param p list of plots
     */
    public void setOwnedPlots(ArrayList<Integer> p) {
        plots = p;
    }

    /**
     * Add a plot owned by this person
     * @param plotID plot id number
     * @return true, if successful
     *         false, if unsuccessful
     */
    public boolean addOwnedPlot(int plotID) {
        return plots.add(plotID);
    }

    /**
     * Remove a plot owned by this person
     * @param plotID plot id number
     * @return true, if successful
     *         false, if unsuccessful
     */
    public boolean removeOwnedPlot(int plotID) {
        return plots.remove(plotID) != null;
    }

    /**
     * Compare a person to another person based on last name, first name, and phone
     * @param p a person
     * @return  < 0 if p is less than this person
     *            0 if p is equal to this person
     *          > 0 if p is greater than this person
     */
    @Override
    public int compareTo(Person p) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException();
        }

        int compare;

        compare = lname.toUpperCase().compareTo(p.getLastName().toUpperCase());

        if (compare == 0) { // same last name, compare by first name
            compare = fname.toUpperCase().compareTo(p.getFirstName().toUpperCase());

            if (compare == 0) { // same first name, compare by phone
                compare = phone.compareTo(p.getPhone());
            }
        }

        return compare;
    }

    /**
     * Person equals person
     * @param o a person object
     * @return true if they are the same person
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
        return "<PERSON>\n"
                + fname + "\n"
                + lname + "\n"
                + address1 + "\n"
                + address2 + "\n"
                + city + "\n"
                + state  + "\n"
                + zip + "\n"
                + phone  + "\n"
                + "</PERSON>\n";
    }
}