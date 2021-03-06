package cs.softengine;

import java.util.ArrayList;

/**
 * A section of a cemetery
 */
public class Section implements Comparable<Section> {
    private String name; // name of the section
    private ArrayList<Plot> plots; // list of plots in this section

    /**
     * Constructs a new, empty section.
     * @param name of this section
     */
    public Section(String name) {
        this.name = name;
        plots = new ArrayList<>();
    }

    /**
     * Constructs a new section with a name and specified number of plots
     * @param name of this section
     * @param size number of plots
     */
    public Section(String name, int size) {
        this.name = name;
        plots = new ArrayList<>(size);
    }

    /**
     * Add a plot to this section
     * @param p the new plot
     * @return success/failure
     */
    public boolean add(Plot p) {
        return p != null && plots.add(p);
    }

    /**
     * Get a plot
     * @param p plot
     * @return plot, null if it does not exist
     */
    public Plot get(Plot p) {
        return plots.get(plots.indexOf(p));
    }

    /**
     * Remove a plot from this section
     * @param p the old plot
     * @return succes/failure
     */
    public boolean remove(Plot p) {
        return p != null && plots.remove(p);
    }

    /**
     * Get the number of plots in this section
     * @return the number of plots
     */
    public int getSize() {
        return plots.size();
    }

    /**
     * Get the name of this section
     * @return the name of this section
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of this section
     * @param n the new name of this section
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Get the plots in this section
     * @return ArrayList of plots in this section
     */
    public ArrayList<Plot> getPlots() {
        return plots;
    }

    /**
     * Set the ArrayList of plots in this section
     * @param p the new ArrayList of plots in this section
     */
    public void setPlots(ArrayList<Plot> p) {
        plots = p;
    }

    /**
     * Compare a section to another section
     * @param s a section
     * @return  < 0 if s is less than this section
     *            0 if s is equal to this section
     *          > 0 if s is greater than this section
     */
    @Override
    public int compareTo(Section s) throws NullPointerException {
        return name.toUpperCase().compareTo(s.getName().toUpperCase());
    }

    /**
     * Section equals section
     * @param o a section objct
     * @return true if they are the same person
     */
    public boolean equals(Object o) throws NullPointerException {
        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;

        final Section s = (Section) o;

        return compareTo(s) == 0;
    }

    /**
     * Write this section to a string (for saving)
     * @return section name and size
     */
    public String toString() {
        return "<SECTION>\n"
                + name + "\n"
                + plots.size() + "\n"
                + "</SECTION>\n";
    }
}
