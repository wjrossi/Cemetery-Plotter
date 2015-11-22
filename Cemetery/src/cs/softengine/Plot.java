package cs.softengine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A plot
 */
public class Plot implements Comparable<Plot> {
    private String section; // residing section name
    private int id; // plot identifier number
    private InterredPerson interred; // interred person
    private Person contact; // contact person, also person fiscally responsible for plot
    private Date burialMonth; // burial date
    private Date burialDay;
    private Date burialYear;
    private Date purchasedMonth; // purchase date
    private Date purchasedDay;
    private Date purchasedYear;
    private boolean vacant; // is the plot vacant/not vacant
    private boolean ready; // is the plot ready for use or not ready
    private String notes;
    private BigDecimal moneyDue; // person owes this much in DOLLARS and CENTS
    private String mapLocation;
    private SimpleDateFormat sdfMonth; // month date format
    private SimpleDateFormat sdfDay; // day date format
    private SimpleDateFormat sdfYear; // year date format
    private NumberFormat nf; // money format

    /**
     * Constructs an empty plot
     */
    public Plot() {
        this("", -1, null, null, "", "", "", "", "", "", true, false, new BigDecimal(0), "", "");
    }

    /**
     * Constructs a basic plot
     * @param section name
     * @param id number
     */
    public Plot(String section, int id) {
        this(section, id, null, null, "", "", "", "", "", "", true, false, new BigDecimal(0), "", "");
    }

    /**
     * Constructs a plot
     * @param section name
     * @param id number
     * @param interred interred person
     * @param contact of this plot
     * @param burialMonth month
     * @param burialDay day
     * @param burialYear year
     * @param purchasedMonth month
     * @param purchasedDay day
     * @param purchasedYear year
     * @param vacant boolean
     * @param ready boolean
     * @param moneyDue BigDecimal
     * @param notes String
     * @paran mapLocation String
     */
    public Plot(String section, int id, InterredPerson interred, Person contact,
                String burialMonth, String burialDay, String burialYear,
                String purchasedMonth, String purchasedDay, String purchasedYear,
                boolean vacant, boolean ready, BigDecimal moneyDue, String notes, String mapLocation) {
        sdfMonth = new SimpleDateFormat("MM");
        sdfDay = new SimpleDateFormat("dd");
        sdfYear = new SimpleDateFormat("yyyy");
        nf = NumberFormat.getCurrencyInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);

        this.section = section;
        this.id = id;
        this.interred = interred;
        this.contact = contact;
        setBurialDateMonth(burialMonth);
        setBurialDateDay(burialDay);
        setBurialDateYear(burialYear);
        setPurchasedDateMonth(purchasedMonth);
        setPurchasedDateDay(purchasedDay);
        setPurchasedDateYear(purchasedYear);
        this.vacant = vacant;
        this.ready = ready;
        this.moneyDue = moneyDue;
        this.notes = notes;
        this.mapLocation = mapLocation;
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
    public InterredPerson getInterred() {
        return interred;
    }

    /**
     * Set interred person
     * @param p interred person, null if unknown
     */
    public void setInterred(InterredPerson p) {
        interred = p;
    }

    /**
     * Get contact of plot
     * @return contact of plot, null if unknown
     */
    public Person getContact() {
        return contact;
    }

    /**
     * Set contact of plot
     * @param p contact of plot, null if unknown
     */
    public void setContact(Person p) {
        contact = p;
    }

    /**
     * Get burial month date
     * @return burial month date, null if unknown
     */
    public String getBurialDateMonth() {
        String date;

        try {
            date = sdfMonth.format(burialMonth);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set burial month date
     * @param d burial month date, null if unknown
     */
    public void setBurialDateMonth(String d) {
        try {
            burialMonth = sdfMonth.parse(d);
        } catch (ParseException e) {
            burialMonth = null;
        }
    }

    /**
     * Get burial day date
     * @return burial day date, null if unknown
     */
    public String getBurialDateDay() {
        String date;

        try {
            date = sdfDay.format(burialDay);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set burial day date
     * @param d burial day date, null if unknown
     */
    public void setBurialDateDay(String d) {
        try {
            burialDay = sdfDay.parse(d);
        } catch (ParseException e) {
            burialDay = null;
        }
    }

    /**
     * Get burial year date
     * @return burial year date, null if unknown
     */
    public String getBurialDateYear() {
        String date;

        try {
            date = sdfYear.format(burialYear);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;    }

    /**
     * Set burial year date
     * @param d burial year date, null if unknown
     */
    public void setBurialDateYear(String d) {
        try {
            burialYear = sdfYear.parse(d);
        } catch (ParseException e) {
            burialYear = null;
        }
    }

    /**
     * Get purchase month date
     * @return purchase month date, null if unknown
     */
    public String getPurchasedDateMonth() {
        String date;

        try {
            date = sdfMonth.format(purchasedMonth);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set purchase month date
     * @param d purchase month date, null if unknown
     */
    public void setPurchasedDateMonth(String d) {
        try {
            purchasedMonth = sdfMonth.parse(d);
        } catch (ParseException e) {
            purchasedMonth = null;
        }
    }

    /**
     * Get purchase day date
     * @return purchase day date, null if unknown
     */
    public String getPurchasedDateDay() {
        String date;

        try {
            date = sdfDay.format(purchasedDay);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set purchase day date
     * @param d purchase day date, null if unknown
     */
    public void setPurchasedDateDay(String d) {
        try {
            purchasedDay = sdfDay.parse(d);
        } catch (ParseException e) {
            purchasedDay = null;
        }
    }

    /**
     * Get purchase year date
     * @return purchase year date, null if unknown
     */
    public String getPurchasedDateYear() {
        String date;

        try {
            date = sdfYear.format(purchasedYear);
        } catch (NullPointerException e) {
            date = "";
        }

        return date;
    }

    /**
     * Set purchase year date
     * @param d purchase year date, null if unknown
     */
    public void setPurchasedDateYear(String d) {
        try {
            purchasedYear = sdfYear.parse(d);
        } catch (ParseException e) {
            purchasedYear = null;
        }
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
     * Get the amount of money due, performs necessary conversion from CENTS to DOLLARS
     * @return the money due in DOLLARS
     */
    public String getMoneyDue() {
        BigDecimal displayMoney = moneyDue.setScale(2, RoundingMode.HALF_EVEN);

        return nf.format(displayMoney.doubleValue());
    }

    /**
     * Set the amount of money due
     * @param m the money due in cents
     */
    public void setMoneyDue(String m) {
        try {
            moneyDue = new BigDecimal(nf.parse(m).toString());
        } catch (ParseException e) {
            // do NOT change money due on parse exception
        }
    }

    /**
     * Get notes
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Set notes
     * @param n notes
     */
    public void setNotes(String n) {
        notes = n;
    }

    /**
     * Get map location
     * @return mapLocation -- "(x, y)"
     */
    public String getMapLocation() {
        return mapLocation;
    }

    /**
     * Set map location
     * @param m map location -- "(x, y)"
     */
    public void setMapLocation(String m) {
        mapLocation = m;
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
        if (p == null)
            throw new NullPointerException();

        return p.getID() - id;
    }

    /**
     * Plot equals plot
     * @param o a plot object
     * @return true if they are the same plot
     */
    public boolean equals(Object o) throws NullPointerException {
        if (o == null)
            throw new NullPointerException();

        if (getClass() != o.getClass())
            return false;

        final Plot p = (Plot) o;

        return compareTo(p) == 0;
    }

    /**
     * Write plot to string (for saving)
     * @return plot data
     */
    public String toString() {
        String result;

        result = "<PLOT>\n"
                + section + "\n"
                + id + "\n";

        if (interred == null)
            result += "<INTERREDPERSON>\nnull\n</INTERREDPERSON>\n";
        else
            result += interred;

        if (contact == null)
            result += "<PERSON>\nnull\n</PERSON>\n";
        else
            result += contact;

        result += getBurialDateMonth() + "\n"
                + getBurialDateDay() + "\n"
                + getBurialDateYear() + "\n"
                + getPurchasedDateMonth() + "\n"
                + getPurchasedDateDay() + "\n"
                + getPurchasedDateYear() + "\n"
                + vacant + "\n"
                + ready + "\n"
                + moneyDue + "\n"
                + "<NOTES>\n"
                + notes + "\n"
                + "</NOTES>\n"
                + mapLocation + "\n"
                + "</PLOT>\n";

        return result;
    }
}