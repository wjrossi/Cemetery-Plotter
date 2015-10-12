package cs.softengine;

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
}
