package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import cs.softengine.InterredPerson;

import java.util.Date;

import static org.junit.Assert.*;

public class InterredPersonTest {
    InterredPerson i;

    /**
     * Tests that InterredPerson.getPlotID() returns the correct value.
     */
    @Test
    public void testGetPlotID(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getPlotID must return 5678, but returns: " + i.getPlotID(), i.getPlotID(), 5678);
    }

    /**
     * Tests that InterredPerson.setPlotID() correctly sets the plotID variable of the InterredPerson class.
     */
    @Test
    public void testSetPlotID(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        i.setPlotID(5678);
        assertEquals("plotID should be 5678, but is: " + i.getPlotID(), i.getPlotID(), 5678);
    }

    /**
     * Tests that InterredPerson.getInterredID() returns the correct value.
     */
    @Test
    public void testGetInterredID(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getInterredID must return 1234, but returns: " + i.getInterredID(), i.getInterredID(), 1234);
    }

    /**
     * Tests that InterredPerson.setInterredID() correctly sets the interredID variable of the InterredPerson class.
     */
    @Test
    public void testSetInterredID(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        i.setInterredID(1234);
        assertEquals("interredID should be 1234, but is: " + i.getInterredID(), i.getInterredID(), 1234);
    }

    /**
     * Tests that InterredPerson.getBornDateMonth() returns the correct value.
     */
    @Test
    public void testGetBornDateMonth(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getBornDateMonth must return 11, but returns: " + i.getBornDateMonth(), i.getBornDateMonth(), "11");
    }

    /**
     * Tests that InterredPerson.setBornDateMonth() correctly sets the bornMonth variable of the InterredPerson class.
     */
    @Test
    public void testSetBornDateMonth(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        i.setBornDateMonth("11");
        assertEquals("bornMonth should be 11, but is: " + i.getBornDateMonth(), i.getBornDateMonth(), "11");
    }

    /**
     * Tests that InterredPerson.getBornDateDay() returns the correct value.
     */
    @Test
    public void testGetBornDateDay(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getBornDateDay must return 11, but returns: " + i.getBornDateDay(), i.getBornDateDay(), "11");
    }

    /**
     * Tests that InterredPerson.setBornDateDay() correctly sets the bornDay variable of the InterredPerson class.
     */
    @Test
    public void testSetBornDateDay(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        i.setBornDateDay("11");
        assertEquals("bornDay should be 11, but is: " + i.getBornDateDay(), i.getBornDateDay(), "11");
    }

    /**
     * Tests that InterredPerson.getBornDateYear() returns the correct value.
     */
    @Test
    public void testGetBornDateYear(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getBornDateYear must return 1111, but returns: " + i.getBornDateYear(), i.getBornDateYear(), "1111");
    }

    /**
     * Tests that InterredPerson.setBornDateYear() correctly sets the bornYear variable of the InterredPerson class.
     */
    @Test
    public void testSetBornDateYear(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        i.setBornDateYear("1111");
        assertEquals("bornYear should be 1111, but is: " + i.getBornDateYear(), i.getBornDateYear(), "1111");
    }

    /**
     * Tests that InterredPerson.getDiedDateMonth() returns the correct value.
     */
    @Test
    public void testGetDiedDateMonth(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getDiedDateMonth must return 02, but returned: " + i.getDiedDateMonth(), i.getDiedDateMonth(), "02");
    }

    /**
     * Tests that InterredPerson.setDiedDateMonth() correctly sets the diedMonth variable of the InterredPerson class.
     */
    @Test
    public void testSetDiedDateMonth(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "03", "22", "2222", "Bill", "Laboon");
        i.setDiedDateMonth("02");
        assertEquals("diedMonth should be 02, but is: " + i.getDiedDateMonth(), i.getDiedDateMonth(), "02");
    }

    /**
     * Tests that InterredPerson.getDiedDateDay() returns the correct value.
     */
    @Test
    public void testGetDiedDateDay(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getDiedDateDay must return 22, but returned: " + i.getDiedDateDay(), i.getDiedDateDay(), "22");
    }

    /**
     * Tests that InterredPerson.setDiedDateDay() correctly sets the diedDay variable of the InterredPerson class.
     */
    @Test
    public void testSetDiedDateDay(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "02", "2222", "Bill", "Laboon");
        i.setDiedDateDay("22");
        assertEquals("diedDay should be 22, but is: " + i.getDiedDateDay(), i.getDiedDateDay(), "22");
    }

    /**
     * Tests that InterredPerson.getDiedDateYear() returns the correct value.
     */
    @Test
    public void testGetDiedDateYear(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getDiedDateYear must return 2222, but returned: " + i.getDiedDateYear(), i.getDiedDateYear(), "2222");
    }

    /**
     * Tests that InterredPerson.setDiedDateYear() correctly sets the diedYear variable of the InterredPerson class.
     */
    @Test
    public void testSetDiedDateYear(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "0002", "Bill", "Laboon");
        i.setDiedDateYear("2222");
        assertEquals("diedYear should be 2222, but is: " + i.getDiedDateYear(), i.getDiedDateYear(), "2222");
    }

    /**
     * Tests that InterredPerson.getFirstName() returns the correct value.
     */
    @Test
    public void testGetFirstName(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Bill", "Laboon");
        assertEquals("getFIrstName must return 'Bill', but returned: " + i.getFirstName(), i.getFirstName(), "Bill");
    }

    /**
     * Tests that InterredPerson.setFirstName() correctly sets the fname variable of the InterredPerson class.
     */
    @Test
    public void testSetFirstName(){
        i = new InterredPerson(1234, 5678, "11", "11", "1111", "02", "22", "2222", "Frank", "Laboon");
        i.setFirstName("Bill");
        assertEquals("fname should be 'Bill', but is: " + i.getFirstName(), i.getFirstName(), "Bill");
    }
}