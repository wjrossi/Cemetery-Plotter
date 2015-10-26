package tests;

import cs.softengine.*;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;


import java.io.BufferedReader;
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
    ArrayList<InterredPerson> interredPeople;
    ArrayList<Person> people;




    /*
     * Tests that Cemetery.save(File file) correctly Save cemetery data to file.
     */
    @Test
    public void testSave() throws IOException{
        //todo
        File f = new File("testFile.txt");
        // File file = Mockito.mock(File.class);
        c = new Cemetery();
        c.save(f);

    }

    /*
     * Tests that Cemetery.add() correctly add a section to Cemetery class.
     */
    @Test
    public void testAdd() throws Exception{
        c = new Cemetery();
        Section mockSection = Mockito.mock(Section.class);
        c.add(mockSection);
        assertEquals("section must be " + mockSection.toString()+ ", but returned " + c.get(mockSection), c.get(mockSection), mockSection );
    }

    /*
     * Tests that Cemetery.remove() correctly remove a section to Cemetery class.
     */
    @Test
    public void testRemove() throws Exception{
        c = new Cemetery();
        Section mockSection = Mockito.mock(Section.class);
        c.remove(mockSection);
        assertEquals("Return value must be false" + ", but returned " + c.remove(mockSection), c.remove(mockSection),false);
    }

    /*
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

    /*
     * Tests that Cemetery.getSections() correctly Get ArrayList of sections in Cemetery class.
     */
    @Test
    public void testGetSections() throws Exception{
        c = new Cemetery();
        sections = new ArrayList<Section>();
        Section mockSection = Mockito.mock(Section.class);
        sections.add(mockSection);
        c.setSections(sections);
        assertEquals("section must be " + mockSection+ ", but returned " + c.getSections(), c.getSections().toString(), "["+mockSection+"]" );
    }

    /*
     * Tests that Cemetery.setSections() correctly Set the ArrayList of sections in the Cemetery class.
     */
    @Test
    public void testSetSections() throws Exception{
        c = new Cemetery();
        sections = new ArrayList<Section>();
        Section mockSection = Mockito.mock(Section.class);
        sections.add(mockSection);
        c.setSections(sections);
        assertEquals("section must be " + mockSection+ ", but returned " + c.getSections(), c.getSections().toString(), "["+mockSection+"]" );
    }

    /*
     * Tests that Cemetery.getPlots() correctly Get list of all plots in Cemetery class.
     */
    @Test
    public void testGetPlots() throws Exception{
        c = new Cemetery();
        Plot mockPlot = Mockito.mock(Plot.class);
        plots = new ArrayList<Plot>();
        plots.add(mockPlot);

        assertEquals("plot must be " + mockPlot + ", but returned " + c.getPlots(), c.getPlots().toString(), "[]");
    }

    /*
     * Tests that Cemetery.getInterredPeople() correctly Get list of all interred people in Cemetery class.
     */
    @Test
    public void testGetInterredPeople() throws Exception{
        c = new Cemetery();
        interredPeople = new ArrayList<InterredPerson>();
        InterredPerson mockInterredPerson = Mockito.mock(InterredPerson.class);
        interredPeople.add(mockInterredPerson);
        assertEquals("interredPeople must be " + interredPeople + ", but returned " + c.getInterredPeople(), c.getInterredPeople().toString(), "[]");
    }

    /*
     * Tests that Cemetery.getPeople() correctly Get list of all (non-interred) people in Cemetery class.
     */
    @Test
    public void testGetPeople() throws Exception{
        c = new Cemetery();
        people = new ArrayList<Person>();
        Person mockPerson = Mockito.mock(Person.class);
        people.add(mockPerson);
        assertEquals("people must be " + people + ", but returned " + c.getPeople(), c.getPeople().toString(), "[]");
    }

    /*
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
}
