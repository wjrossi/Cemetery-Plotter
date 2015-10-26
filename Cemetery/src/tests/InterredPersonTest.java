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
        assertEquals("born must be " + bornDate.toString() + ", but is " + i.getBornDate(), i.getBornDate(), bornDate);
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
        assertEquals("died must be " + diedDate.toString() + ", but is " + i.getDiedDate(), i.getDiedDate(), diedDate);
    }

    /*
    Tests that InterredPerson.getFirstName() returns the correct value.
     */
    @Test
    public void testGetFirstName(){
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getFirstName must return 'Bill', but returned " + i.getFirstName(), i.getFirstName(), "Bill");
    }

    /*
    Tests that InterredPerson.setFirstName() correctly sets the fname variable of the InterredPerson class.
     */
    @Test
    public void testSetFirstName(){
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Frank", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        i.setFirstName("Bill");
        assertEquals("fname must be 'Bill', but is " + i.getFirstName(), i.getFirstName(), "Bill");
    }

    /*
     * Tests that InterredPerson.setLastName() correctly sets the lname variable of the InterredPerson class.
     */
    @Test
    public void testSetLastName() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Frank", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        i.setLastName("Laboon");
        assertEquals("lname must be 'Laboon', but is " + i.getLastName(), i.getLastName(), "Laboon");
    }

    /*
     * Tests that InterredPerson.getLastName() returns the correct value.
     */
    @Test
    public void testGetLastName() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getLastName must return 'Laboon', but returned " + i.getLastName(), i.getLastName(), "Laboon");
    }

    /*
     *  Tests that InterredPerson.setAddress1() correctly sets the address1 variable of the InterredPerson class.
     */
    @Test
    public void testSetAddress1() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "Sandwich", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        i.setAddress1("1234 Laboon Place");
        assertEquals("address1 must be '1234 Laboon Place', but was " + i.getAddress1(), i.getAddress1(), "1234 Laboon Place");
    }

    /*
     * Tests that InterredPerson.getAddress1() returns the correct value.
     */
    @Test
    public void testGetAddress1() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getAddress1 must return '1234 Laboon Place', but returned " + i.getAddress1(), i.getAddress1(), "1234 Laboon Place");
    }

    /*
     * Tests that InterredPerson.setAddress2() correctly sets the address2 variable of the InterredPerson class.
     */
    @Test
    public void testSetAddress2() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "Sandwich", "Laboontown", "Maine", "1337", "555-555-5555");
        i.setAddress2("4567 Bill Street");
        assertEquals("address2 must be '4567 Bill Street', but was " + i.getAddress2(), i.getAddress2(), "4567 Bill Street");
    }

    /*
     * Tests that InterredPerson.getAddress2() returns the correct value.
     */
    @Test
    public void testGetAddress2() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getAddress2 must return '4567 Bill Street', but returned " + i.getAddress2(), i.getAddress2(), "4567 Bill Street");
    }

    /*
     * Tests that InterredPerson.setCity() correctly sets the city variable of the InterredPerson class.
     */
    @Test
    public void testSetCity() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Catville", "Maine", "1337", "555-555-5555");
        i.setCity("Laboontown");
        assertEquals("city must be 'Laboontown', but was " + i.getCity(), i.getCity(), "Laboontown");
    }

    /*
     * Tests that InterredPerson.getCity() returns the correct value.
     */
    @Test
    public void testGetCity() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getCity must return 'Laboontown', but returned " + i.getCity(), i.getCity(), "Laboontown");
    }

    /*
     * Tests that InterredPerson.setState() correctly sets the state variable of the InterredPerson class.
     */
    @Test
    public void testSetState() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Hingle McCringleberry", "1337", "555-555-5555");
        i.setState("Maine");
        assertEquals("state must be 'Maine', but was " + i.getState(), i.getState(), "Maine");
    }

    /*
     * Tests that InterredPerson.getState() returns the correct value.
     */
    @Test
    public void testGetState() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getState must return 'Maine', but returned " + i.getState(), i.getState(), "Maine");
    }

    /*
     * Tests that InterredPerson.setZip() correctly sets the zip variable of the InterredPerson class.
     */
    @Test
    public void testSetZip() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "Not a zipcode", "555-555-5555");
        i.setZip("1337");
        assertEquals("zip must be '1337', but was " + i.getZip(), i.getZip(), "1337");
    }

    /*
     * Tests that InterredPerson.getZip() returns the correct value.
     */
    @Test
    public void testGetZip() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getZip must return '1337', but returned " + i.getZip(), i.getZip(), "1337");
    }

    /*
     * Tests that InterredPerson.setPhone() correctly sets the phone variable of the InterredPerson class.
     */
    @Test
    public void testSetPhone() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-CATS");
        i.setPhone("555-555-5555");
        assertEquals("phone must be '555-555-5555', but was " + i.getPhone(), i.getPhone(), "555-555-5555");
    }

    /*
     * Tests that InterredPerson.getPhone() returns the correct value.
     */
    @Test
    public void testGetPhone() {
        i = new InterredPerson(9999, 5678, bornDate, diedDate, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getPhone must return '555-555-5555', but returned " + i.getPhone(), i.getPhone(), "555-555-5555");
    }
}