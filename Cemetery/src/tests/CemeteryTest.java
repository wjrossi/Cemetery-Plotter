package tests;

import cs.softengine.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests for Cemetery
 */
public class CemeteryTest {
    Cemetery c;
    ArrayList<Section> sections;
    ArrayList<Plot> plots;
    ArrayList<InterredPerson> interred;
    ArrayList<Person> owners;

    /**
     * Tests that Cemetery.save(File file) correctly Save cemetery data to file.
     */
    @Test
    public void testSave() throws IOException{

        File f = new File("testFile.txt");

        c = new Cemetery();
        c.save(f);
    }

    /**
     * Tests that Cemetery.add() correctly add a section to Cemetery class.
     */
    @Test
    public void testAdd() throws Exception{
        c = new Cemetery();
        Section mockSection = Mockito.mock(Section.class);
        c.add(mockSection);
        assertEquals("section must be " + mockSection.toString()+ ", but returned " + c.get(mockSection), c.get(mockSection), mockSection );
    }

    /**
     * Tests that Cemetery.remove() correctly remove a section to Cemetery class.
     */
    @Test
    public void testRemove() throws Exception{
        c = new Cemetery();
        Section mockSection = Mockito.mock(Section.class);
        c.remove(mockSection);
        assertEquals("Return value must be false" + ", but returned " + c.remove(mockSection), c.remove(mockSection),false);
    }

    /**
     * Tests that Cemetery.get() correctly get a section to Cemetery class.
     */
    @Test
    public void testGet() throws Exception{
        c = new Cemetery();

        Section mockSection = Mockito.mock(Section.class);

        c.add(mockSection);
        c.get(mockSection);

        assertEquals("section must be " + mockSection.toString()+ ", but returned " + c.get(mockSection), c.get(mockSection), mockSection );
    }

    /**
     * Tests that Cemetery.getSections() correctly Get ArrayList of sections in Cemetery class.
     */
    @Test
    public void testGetSections() throws Exception{
        c = new Cemetery();
        sections = new ArrayList<>();
        Section mockSection = Mockito.mock(Section.class);
        sections.add(mockSection);
        c.setSections(sections);

        assertEquals("section must be " + mockSection+ ", but returned " + c.getSections(), c.getSections().toString(), "["+mockSection+"]" );
    }

    /**
     * Tests that Cemetery.setSections() correctly Set the ArrayList of sections in the Cemetery class.
     */
    @Test
    public void testSetSections() throws Exception{
        c = new Cemetery();
        sections = new ArrayList<>();
        Section mockSection = Mockito.mock(Section.class);
        sections.add(mockSection);
        c.setSections(sections);

        assertEquals("section must be " + mockSection+ ", but returned " + c.getSections(), c.getSections().toString(), "["+mockSection+"]" );
    }

    /**
     * Tests that Cemetery.getPlots() correctly Get list of all plots in Cemetery class.
     */
    @Test
    public void testGetPlots() throws Exception{
        c = new Cemetery();
        Plot mockPlot = Mockito.mock(Plot.class);
        plots = new ArrayList<>();
        plots.add(mockPlot);

        assertEquals("plot must be " + mockPlot + ", but returned " + c.getPlots(), c.getPlots().toString(), "[]");
    }

    /**
     * Tests that Cemetery.getInterred() correctly Get list of all interred people in Cemetery class.
     */
    @Test
    public void testGetInterred() throws Exception{
        c = new Cemetery();
        interred = new ArrayList<>();
        InterredPerson mockInterredPerson = Mockito.mock(InterredPerson.class);
        interred.add(mockInterredPerson);

        assertEquals("interredPeople must be " + interred + ", but returned " + c.getInterred(), c.getInterred().toString(), "[]");
    }

    /**
     * Tests that Cemetery.getContacts() correctly Get list of all (non-interred) people in Cemetery class.
     */
    @Test
    public void testGetOwners() throws Exception{
        c = new Cemetery();
        owners = new ArrayList<>();
        Person mockPerson = Mockito.mock(Person.class);
        owners.add(mockPerson);

        assertEquals("people must be " + owners + ", but returned " + c.getContacts(), c.getContacts().toString(), "[]");
    }

    /**
     * Tests that Cemetery.toString() correctly Write this cemetery to a string (for saving).
     */
    @Test
    public void testToString() throws Exception{
        c = new Cemetery();
        assertEquals("Return value must be "+ "<CEMETERY>\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "</CEMETERY>\n"+" , but returned " + c.toString(),c.toString(), "<CEMETERY>\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "0\n" +
                "</CEMETERY>\n");
    }

    /**
     * Tests that Cemetery.isModified() returns the correct value.
     */
    @Test
    public void testIsModified(){
        c = new Cemetery();
        assertFalse("modified should be false, but is: " + c.isModified(), c.isModified());
    }

    /**
     * Tests that Cemetery.setModified() correctly sets the modified variable of the Cemetery class.
     */
    @Test
    public void testSetModified(){
        c = new Cemetery();
        c.setModified(true);
        assertTrue("modified should be true, but is: " + c.isModified(), c.isModified());
    }

    /**
     * Tests that the Cemetery.getNextPlotID() returns the correct value.
     */
    @Test
    public void testGetNextPlotID(){
        c = new Cemetery();
        assertEquals("nextPlotID should be -1, but is: " + c.getNextPlotID(), c.getNextPlotID(), -1);
    }

    /**
     * Tests that Cemetery.setNextPlotID() correctly increments the nextPlotID variable of the Cemetery class.
     */
    @Test
    public void testSetNextPlotID(){
        c = new Cemetery();
        //Ensure that we know the current value of nextPlotID
        assertEquals(c.getNextPlotID(), -1);
        //Increment the value of nextPlotID
        c.setNextPlotID();
        //Verify that nextPlotID has been incremented
        assertEquals("nextPlotID should be 0, but is: " + c.getNextPlotID(), c.getNextPlotID(), 0);
    }

    /**
     * Tests that the Cemetery.getNextInterredID() returns the correct value.
     */
    @Test
    public void testGetNextInterredID(){
        c = new Cemetery();
        assertEquals("nextInterredID should be -1, but is: " + c.getNextInterredID(), c.getNextInterredID(), -1);
    }

    /**
     * Tests that Cemetery.setNextInterredID() correctly increments the nextInterredID variable of the Cemetery class.
     */
    @Test
    public void testSetNextInterredID(){
        c = new Cemetery();
        //Ensure that we know the current value of nextInterredID
        assertEquals(c.getNextInterredID(), -1);
        //Increment the value of nextInterredID
        c.setNextInterredID();
        //Verify that nextInterredID has been incremented
        assertEquals("nextInterredID should be 0, but is: " + c.getNextInterredID(), c.getNextInterredID(), 0);
    }

    /**
     * Tests that the Cemetery.getNextContactID() returns the correct value.
     */
    @Test
    public void testGetNextContactID(){
        c = new Cemetery();
        assertEquals("nextcontactID should be -1, but is: " + c.getNextContactID(), c.getNextContactID(), -1);
    }

    /**
     * Tests that Cemetery.setNextContactID() correctly increments the nextcontactID variable of the Cemetery class.
     */
    @Test
    public void testSetNextContactID(){
        c = new Cemetery();
        //Ensure that we know the current value of nextContactID
        assertEquals(c.getNextContactID(), -1);
        //Increment the value of nextContactID
        c.setNextContactID();
        //Verify that nextContactID has been incremented
        assertEquals("nextcontactID should be 0, but is: " + c.getNextContactID(), c.getNextContactID(), 0);
    }
}
