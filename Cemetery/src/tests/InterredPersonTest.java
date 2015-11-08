package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import cs.softengine.InterredPerson;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Jamie on 10/26/2015.
 */
public class InterredPersonTest {
    InterredPerson i;

    /**
     * Tests that InterredPerson.getPlotID() returns the correct value.
     */
    @Test
    public void testGetPlotID(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "22", "22", "2222", "Bill", "Laboon");
        assertEquals("getPlotID must return 5678, but returns: " + i.getPlotID(), i.getPlotID(), 5678);
    }

    /**
     * Tests that InterredPerson.setPlotID() correctly sets the plotID variable of the InterredPerson class.
     */
    @Test
    public void testSetPlotID(){
        i = new InterredPerson(1234, 9999, "11", "11", "1111", "22", "22", "2222", "Bill", "Laboon");
        i.setPlotID(5678);
        assertEquals("plotID should be 5678, but is: " + i.getPlotID(), i.getPlotID(), 5678);
    }

    /**
     * Tests that InterredPerson.getInterredID() returns the correct value.
     */
    @Test
    public void testGetInterredID(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "22", "22", "2222", "Bill", "Laboon");
        assertEquals("getInterredID must return 1234, but returns: " + i.getInterredID(), i.getInterredID(), 1234);
    }

    /**
     * Tests that InterredPerson.setInterredID() correctly sets the interredID variable of the InterredPerson class.
     */
    @Test
    public void testSetInterredID(){
        i = new InterredPerson(9999, 5678, "11", "11", "1111", "22", "22", "2222", "Bill", "Laboon");
        i.setInterredID(1234);
        assertEquals("interredID should be 1234, but is: " + i.getInterredID(), i.getInterredID(), 1234);
    }

    /**
     * Tests that InterredPerson.getBornDateMonth() returns the correct value.
     */
    @Test
    public void testGetBornDateMonth(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "22", "22", "2222", "Bill", "Laboon");
        assertEquals("getBornDateMonth must return 11, but returns: " + i.getBornDateMonth(), i.getBornDateMonth(), "11");
    }

    /**
     * Tests that InterredPerson.setBornDateMonth() correctly sets the bornMonth variable of the InterredPerson class.
     */
    @Test
    public void testSetBornDateMonth(){
        i = new InterredPerson(1234, 5678, "01", "11", "1111", "22", "22", "2222", "Bill", "Laboon");
        i.setBornDateMonth("11");
        assertEquals("bornMonth should be 11, but is: " + i.getBornDateMonth(), i.getBornDateMonth(), "11");
    }

    /**
     * Tests that InterredPerson.getBornDateDay() returns the correct value.
     */
    @Test
    public void testGetBornDateDay(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "22", "22", "2222", "Bill", "Laboon");
        assertEquals("getBornDateDay must return 11, but returns: " + i.getBornDateDay(), i.getBornDateDay(), "11");
    }

    /**
     * Tests that InterredPerson.setBornDateDay() correctly sets the bornDay variable of the InterredPerson class.
     */
    @Test
    public void testSetBornDateDay(){
        i = new InterredPerson(1234, 5678, "11", "01", "1111", "22", "22", "2222", "Bill", "Laboon");
        i.setBornDateDay("11");
        assertEquals("bornDay should be 11, but is: " + i.getBornDateDay(), i.getBornDateDay(), "11");
    }

    /**
     * Tests that InterredPerson.getBornDateYear() returns the correct value.
     */
    @Test
    public void testGetBornDateYear(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "22", "22", "2222", "Bill", "Laboon");
        assertEquals("getBornDateYear must return 1111, but returns: " + i.getBornDateYear(), i.getBornDateYear(), "1111");
    }

    /**
     * Tests that InterredPerson.setBornDateYear() correctly sets the bornYear variable of the InterredPerson class.
     */
    @Test
    public void testSetBornDateYear(){
        i = new InterredPerson(1234, 5678, "11", "11", "0001", "22", "22", "2222", "Bill", "Laboon");
        i.setBornDateYear("1111");
        assertEquals("setBornDateYear should be 1111, but is: " + i.getBornDateYear(), i.getBornDateYear(), "1111");
    }
}