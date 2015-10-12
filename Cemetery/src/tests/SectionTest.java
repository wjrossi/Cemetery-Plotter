package tests;
import cs.softengine.Plot;
import cs.softengine.Section;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by jiajiedang on 10/11/15.
 */
public class SectionTest {
    Section s;

    /* Tests that Section.setName() correctly sets the name
        variable of the Section class.
     */
    @Test
    public void testSetName() throws Exception {
        s = new Section("Laboon", 0);
        s.setName("section1");
        assertEquals("section name must be 'section1', but is " + s.name, s.name, "section1");
    }

    /* Tests that Section.getName() returns the correct
        value.
     */
    @Test
    public void testGetName() throws Exception {
        s = new Section("section1", 0);
        assertEquals("section name must return 'section1', but returned " + s.getName(), s.getName(), "section1");
    }

    /* Tests that Section.getSize() returns the correct
        value.
     */
    @Test
    public void testGetSize() throws Exception {
        s = new Section("section1", 1);
        s.add(new Plot(s.getName(), 0));
        assertEquals("section size must return 1," + "but returned " + s.getSize(), s.getSize(), 1);
    }

    /*
        Tests that you can add plots to a section using Section.add(Plot p).
     */
    @Test
    public void testAddPlots() throws Exception {
        s = new Section("A", 0);
        Plot mockPlot = Mockito.mock(Plot.class);
        assertTrue("Could not add plot " + mockPlot.getID(), s.add(mockPlot));
    }

    /*
        Tests that you can successfully remove plots from a section using Section.remove(Plot p).
     */
    @Test
    public void testRemovePlots() throws Exception {
        s = new Section("A", 0);
        Plot mockPlot = Mockito.mock(Plot.class);

        //Verify that the plot has been added
        assertTrue("Could not add plot " + mockPlot.getID(), s.add(mockPlot));
        //Now remove the plot
        assertTrue("Could not remove plot " + mockPlot.getID(), s.remove(mockPlot));
    }

    /*
        Tests that the toString() method is working correctly.
     */
    @Test
    public void testToString() throws Exception {
        s = new Section("SectionName", 0);
        String testStr = "<SECTION>\n"
                + "SectionName" + "\n"
                + "0" + "\n"
                + "</SECTION>\n";
        assertEquals("Section string should be " + testStr + " but is " + s.toString(), s.toString(), testStr);

    }


}
