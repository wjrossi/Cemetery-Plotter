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
    Date bornDate = new Date(1000000);
    Date diedDate = new Date(1010101);
    Date testDate = new Date(9999999);

    /*
    Tests that InterredPerson.getPlotID() returns the correct value.
     */
    @Test
    public void testGetPlotID(){
        i = new InterredPerson(1234, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getPlotID must return 5678, but returned " + i.getPlotID(), i.getPlotID(), 5678);
    }

    /*
    Tests that InterredPerson.setPlotID() correctly sets the plotID variable of the InterredPerson class.
    */
    @Test
    public void testSetPlotID(){
        i = new InterredPerson(1234, 9999, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        i.setPlotID(5678);
        assertEquals("plotID must be 5678, but is " + i.getPlotID(), i.getPlotID(), 5678);
    }

    /*
    Tests that InterredPerson.getInterredID() returns the correct value.
     */
    @Test
    public void testGetInterredID(){
        i = new InterredPerson(1234, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getPlotID must return 1234, but returned " + i.getInterredID(), i.getInterredID(), 1234);
    }

    /*
    Tests that InterredPerson.setInterredID() correctly sets the interredID variable of the InterredPerson class.
    */
    @Test
    public void testSetInterredID(){
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        i.setInterredID(1234);
        assertEquals("plotID must be 1234, but is " + i.getInterredID(), i.getInterredID(), 1234);
    }

    /*
    Tests that InterredPerson.getBornDate() returns the correct value.
     */
    @Test
    public void testGetBornDate(){
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getBornDate must return " + bornDate.toString() + ", but returned " + i.getBornDate(), i.getBornDate(), bornDate);
    }

    /*
    Tests that InterredPerson.setBornDate() correctly sets the born variable of the InterredPerson class.
     */
    @Test
    public void testSetBornDate(){
        i = new InterredPerson(9999, 5678, testDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        i.setBornDate(bornDate);
        assertEquals("born must be " + bornDate.toString() + " but is " + i.getBornDate(), i.getBornDate(), bornDate);
    }

    /*
    Tests that InterredPerson.getDiedDate() returns the correct value.
     */
    @Test
    public void testGetDiedDate(){
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getDiedDate must return " + diedDate.toString() + ", but returned " + i.getDiedDate(), i.getDiedDate(), diedDate);
    }

    /*
    Tests that InterredPerson.setDiedDate() correctly sets the died variable of the InterredPerson class.
     */
    @Test
    public void testSetDiedDate(){
        i = new InterredPerson(9999, 5678, bornDate, testDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        i.setDiedDate(diedDate);
        assertEquals("died must be " + diedDate.toString() + " but is " + i.getDiedDate(), i.getDiedDate(), diedDate);
    }
}