package cs.softengine;

import java.util.Date;

/**
 * A plot
 */
public class Plot implements Comparable<Plot> {
    String section; // residing section name
    int id; // plot identifier number
    Person interred; // interred person
    Person owner; // contact person, also person fiscally responsible for plot
    Date burial; // burial date
    Date purchased; // purchase date
    boolean vacant; // is the plot vacant/not vacant
    boolean ready; // is the plot ready for use or not ready
    int moneyDue; // if not 0, person owes this much IN CENTS (for accuracy)

    /**
     * Constructs an empty plot
     */
    public Plot() {
        section = null;
        id = -1;
        interred = null;
        owner = null;
        burial = null;
        purchased = null;
        vacant = true;
        ready = true;
        moneyDue = 0;
    }

    /**
     * Constructs a basic plot
     * @param section name
     * @param id number
     */
    public Plot(String section, int id) {
        this.section = section;
        this.id = id;
    }

    /**
     * Get plot ID number
     * @return id number
     */
    public int getID() {
        return id;
    }

    /**
     * Set plot ID number
     * @param id new id number
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Get section name
     * @return section name
     */
    public String getSection() {
        return section;
    }

    /**
     * Set section name
     * @param s section name
     */
    public void setSection(String s) {
        section = s;
    }

    /**
     * Get interred person
     * @return interred person, null if unknown
     */
    public Person getInterred() {
        return interred;
    }

    /**
     * Set interred person
     * @param p interred person, null if unknown
     */
    public void setInterred(Person p) {
        interred = p;
    }

    /**
     * Get owner of plot
     * @return owner of plot, null if unknown
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Set owner of plot
     * @param p owner of plot, null if unknown
     */
    public void setOwner(Person p) {
        owner = p;
    }

    /**
     * Get burial date
     * @return burial date, null if unknown
     */
    public Date getBurialDate() {
        return burial;
    }

    /**
     * Set burial date
     * @param d burial date, null if unknown
     */
    public void setBurialDate(Date d) {
        burial = d;
    }

    /**
     * Get purchase date
     * @return purchase date, null if unknown
     */
    public Date getPurchasedDate() {
        return purchased;
    }

    /**
     * Set purchase date
     * @param d purchase date, null if unknown
     */
    public void setPurchasedDate(Date d) {
        purchased = d;
    }

    /**
     * Is the plot vacant
     * @return true, if the plot is vacant
     *         false, if the plot is not vacant
     */
    public boolean isVacant() {
        return vacant;
    }

    /**
     * Set the plot to vacant or not vacant
     * @param b true, if the plot is vacant
     *          false, if the plot is not vacant
     */
    public void setVacant(boolean b) {
        vacant = b;
    }

    /**
     * Is the plot ready
     * @return true, if the plot is ready
     *         fakse, if the plot is not ready
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Set the plot to ready or not ready
     * @param b true, if the plot is ready
     *          false, if the plot is not ready
     */
    public void setReady(boolean b) {
        ready = b;
    }

    /**
     * Get the amount of money due
     * @return the money due in cents
     */
    public int getMoneyDue() {
        return moneyDue;
    }

    /**
     * Set the amount of money due
     * @param m the money due in cents
     */
    public void setMoneyDue(int m) {
        moneyDue = m;
    }

    /**
     * Compare a plot to another plot
     * @param p a plot
     * @return  < 0 if p is less than this plot
     *            0 if p is equal to this plot
     *          > 0 if p is greater than this plot
     */
    @Override
    public int compareTo(Plot p) throws NullPointerException {
        if (p == null) {
            throw new NullPointerException();
        }

        return p.getID() - id;
    }

    /**
     * Plot equals plot
     * @param o a plot object
     * @return true if they are the same plot
     */
    public boolean equals(Object o) throws NullPointerException {
        if (o == null) {
            throw new NullPointerException();
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        final Plot p = (Plot) o;

        return compareTo(p) == 0;
    }

    /**
     * Write plot to string (for saving)
     * @return plot data
     */
    public String toString() {
        return "#Plot\n" + "Section:\t" +this.getSection()+ "\n" +"ID:\t" + this.getID()+ "\n"+
                "Interred:\t" +this.getInterred()+ "\n" + "Owner:\t" + this.getOwner()+ "\n" +
                "Burial:\t" + this.getBurialDate()+ "\n" + "Purchased:\t" + this.getPurchasedDate() + "\n" +
                "Vacant:\t" + this.isVacant() + "\n" + "Ready:\t" + this.isReady() + "\n" +
                "Money Due:\t" + this.getMoneyDue() + "\n";
        
    }
}
