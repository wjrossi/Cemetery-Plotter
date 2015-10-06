package cs.softengine;

import java.util.ArrayList;

/**
 * A section of a cemetery
 */
public class Section {
    private ArrayList<Plot> plots; // TEMPORARY?? data structure for a section
    private String name; // name of the section
    private int size; // the number of plots

    /**
     * Constructs a new, empty section.
     */
    public Section() {
        plots = new ArrayList<Plot>();
    }

    /**
     * Constructs a new section with a name and specified number of plots
     */
    public Section(String name, int size) {
        this.name = name;
        this.size = size;
        plots = new ArrayList<Plot>(size);
    }

    /**
     * Add a plot to this section
     * @param plot the new plot
     * @return success/failure
     */
    public boolean add(Plot plot) {
        return plots.add(plot);
    }

    /**
     * Remove a plot from this section
     * @param plot the old plot
     * @return succes/failure
     */
    public boolean remove(Plot plot) {
        return plots.remove(plot);
    }

    /**
     * Get the number of plots in this section
     * @return the number of plots
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the number of plots in this section
     * @param size the new number of plots
     */
    public void setSize(int size) {
        this.size = size;
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
     * @param name the new name of this section
     */
    public void setName(String name) {
        this.name = name;
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
     * @param plots the new ArrayList of plots in this section
     */
    public void setSection(ArrayList<Plot> plots) {
        this.plots = plots;
    }
}
