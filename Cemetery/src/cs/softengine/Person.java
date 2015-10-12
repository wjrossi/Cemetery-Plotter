package cs.softengine;

import java.util.ArrayList;

/**
 * A person.  Includes personal information like name and address.
 */
public class Person implements Comparable<Person> {
    String fname;
    String lname;
    String address1;
    String address2;
    String city;
    String state;
    String zip;
    String phone;

    /**
     * Constructs a person.
     */
    public Person() {
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
     * Constructs a person using his fist name, last name.
     *
     */
    public Person(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
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
     * Compare a person to another person
     * @param p a person
     * @return  < 0 if p is less than this person
     *            0 if p is equal to this person
     *          > 0 if p is greater than this person
     */
    @Override
    public int compareTo(Person p) throws NullPointerException {
        // how do we compare people? we need a unique identifier TODO
        // how do we know if they are the same person? name isn't enough.
        // this will come in handy when we are searching for plots or people
        return 0;
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
        return null; // TODO
    }
}