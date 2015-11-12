package tests;

import cs.softengine.Person;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests for Person
 */
public class PersonTest {
    Person p;

    /**
     * Tests that Person.setFirstName() correctly sets the fname variable of the Person class.
     */
    @Test
    public void testSetFirstName() throws Exception {
        p = new Person("Frank", "Laboon");
        p.setFirstName("Bill");
        assertEquals("fname must be 'Bill', but is " + p.getFirstName(), p.getFirstName(), "Bill");
    }

    /**
     *  Tests that Person.getFirstName() returns the correct value.
     */
    @Test
    public void testGetFirstName() throws Exception {
        p = new Person("Bill", "Laboon");
        assertEquals("getFirstName must return 'Bill', but returned " + p.getFirstName(), p.getFirstName(), "Bill");
    }

    /**
     * Tests that Person.setLastName() correctly sets the lname variable of the Person class.
     */
    @Test
    public void testSetLastName() throws Exception {
        p = new Person("Bill", "Frank");
        p.setLastName("Laboon");
        assertEquals("lname must be 'Laboon', but is " + p.getLastName(), p.getLastName(), "Laboon");
    }

    /**
     * Tests that Person.getLastName() returns the correct value.
     */
    @Test
    public void testGetLastName() throws Exception {
        p = new Person("Bill", "Laboon");
        assertEquals("getLastName must return 'Laboon', but returned " + p.getLastName(), p.getLastName(), "Laboon");
    }

    /**
     *  Tests that Person.setAddress1() correctly sets the address1 variable of the Person class.
     */
    @Test
    public void testSetAddress1() throws Exception {
        p = new Person("Bill", "Laboon", "Sandwich", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        p.setAddress1("1234 Laboon Place");
        assertEquals("address1 must be '1234 Laboon Place', but was " + p.getAddress1(), p.getAddress1(), "1234 Laboon Place");
    }

    /**
     * Tests that Person.getAddress1() returns the correct value.
     */
    @Test
    public void testGetAddress1() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getAddress1 must return '1234 Laboon Place', but returned " + p.getAddress1(), p.getAddress1(), "1234 Laboon Place");
    }

    /**
     * Tests that Person.setAddress2() correctly sets the address2 variable of the Person class.
     */
    @Test
    public void testSetAddress2() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "Sandwich", "Laboontown", "Maine", "1337", "555-555-5555");
        p.setAddress2("4567 Bill Street");
        assertEquals("address2 must be '4567 Bill Street', but was " + p.getAddress2(), p.getAddress2(), "4567 Bill Street");
    }

    /**
     * Tests that Person.getAddress2() returns the correct value.
     */
    @Test
    public void testGetAddress2() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getAddress2 must return '4567 Bill Street', but returned " + p.getAddress2(), p.getAddress2(), "4567 Bill Street");
    }

    /**
     * Tests that Person.setCity() correctly sets the city variable of the Person class.
     */
    @Test
    public void testSetCity() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Catville", "Maine", "1337", "555-555-5555");
        p.setCity("Laboontown");
        assertEquals("city must be 'Laboontown', but was " + p.getCity(), p.getCity(), "Laboontown");
    }

    /**
     * Tests that Person.getCity() returns the correct value.
     */
    @Test
    public void testGetCity() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getCity must return 'Laboontown', but returned " + p.getCity(), p.getCity(), "Laboontown");
    }

    /**
     * Tests that Person.setState() correctly sets the state variable of the Person class.
     */
    @Test
    public void testSetState() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Hingle McCringleberry", "1337", "555-555-5555");
        p.setState("Maine");
        assertEquals("state must be 'Maine', but was " + p.getState(), p.getState(), "Maine");
    }

    /**
     * Tests that Person.getState() returns the correct value.
     */
    @Test
    public void testGetState() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getState must return 'Maine', but returned " + p.getState(), p.getState(), "Maine");
    }

    /**
     * Tests that Person.setZip() correctly sets the zip variable of the Person class.
     */
    @Test
    public void testSetZip() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "Not a zipcode", "555-555-5555");
        p.setZip("1337");
        assertEquals("zip must be '1337', but was " + p.getZip(), p.getZip(), "1337");
    }

    /**
     * Tests that Person.getZip() returns the correct value.
     */
    @Test
    public void testGetZip() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getZip must return '1337', but returned " + p.getZip(), p.getZip(), "1337");
    }

    /**
     * Tests that Person.setPhone() correctly sets the phone variable of the Person class.
     */
    @Test
    public void testSetPhone() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-CATS");
        p.setPhone("555-555-5555");
        assertEquals("phone must be '555-555-5555', but was " + p.getPhone(), p.getPhone(), "555-555-5555");
    }

    /**
     * Tests that Person.getPhone() returns the correct value.
     */
    @Test
    public void testGetPhone() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getPhone must return '555-555-5555', but returned " + p.getPhone(), p.getPhone(), "555-555-5555");
    }

    /**
     * Tests that the toString() method is working correctly.
     */
    @Test
    public void testToString() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        String testStr = "<PERSON>\n"
                + -1 + "\n"
                + "Bill" + "\n"
                + "Laboon" + "\n"
                + "1234 Laboon Place" + "\n"
                + "4567 Bill Street" + "\n"
                + "Laboontown" + "\n"
                + "Maine"  + "\n"
                + "1337" + "\n"
                + "555-555-5555"  + "\n"
                + "<OWNEDPLOTS>" + "\n"
                + "null" + "\n"
                + "</OWNEDPLOTS>\n"
                + "</PERSON>\n";

        assertEquals("Person string should be " + testStr + " but is " + p.toString(), p.toString(), testStr);
    }

    /**
     * Tests that Person.setOwnedPlot() correctly sets the plots variable of the Person class, and Person.getOwnedPlots() returns the correct values.
     * NOTE: this test assumes that the ArrayList constructor works correctly (because it does and that's not the focus of this test).
     */
    @Test
    public void testSetOwnedPlot() {
        p = new Person();
        ArrayList<Integer> plots = new ArrayList<Integer>();

        //Set the 'plots' variable
        p.setOwnedPlots(plots);

        //Verify that the 'plots' variable has been set for this Person
        assertEquals("getOwnedPlots should return " + plots + ", but returned " + p.getOwnedPlots(), p.getOwnedPlots(), plots);
    }

    /**
     * Tests that Person.addOwnedPlots() correctly adds plots to the 'plots' ArrayList of a Person object.
     * NOTE: this test assumes that the ArrayList constructor works correctly (because it does and that's not the focus of this test).
     */
    @Test
    public void testAddOwnedPlot() {
        p = new Person();
        ArrayList<Integer> plots = new ArrayList<Integer>();

        //Set the 'plots' variable
        p.setOwnedPlots(plots);

        //Verify that the plot has been added.
        assertTrue("Failed to add the plot!", p.addOwnedPlot(1));

        //Verify that the plot added was the correct plot.
        assertEquals("Added plot should be " + plots.get(0).toString() + ", but is " + p.getOwnedPlots().get(0).toString(), p.getOwnedPlots().get(0).toString(), plots.get(0).toString());
    }

    /**
     * Tests that Person.removeOwnedPlot() correctly removes plots from the 'plots' ArrayList of a Person object.
     * NOTE: this test assumes that the ArrayList constructor and add method works correctly (becase they do and that's not the focus of this test).
     */
    @Test
    public void testRemoveOwnedPlot() {
        p = new Person();
        ArrayList<Integer> plots = new ArrayList<Integer>();
        plots.add(1);

        //Set the 'plots' variable
        p.setOwnedPlots(plots);

        //Verify that the plot was removed
        assertTrue("Failed to remove the plot!", p.removeOwnedPlot(1));
    }

    /**
     * Tests that the Person.compareTo() method is working correctly in the negative case.
     */
    @Test
    public void testCompareToLastName() {
        p = new Person(1234, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        Person p2 = new Person(5678, "Bill", "Catboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");

        assertNotEquals("Bill Laboon and Bill Catboon should not be equal!", p.compareTo(p2), 0);
    }

    /**
     * Tests that the Person.equals() method is working correctly.
     */
    @Test
    public void testEquals() {
        p = new Person(1234, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        Person p2 = new Person(1234, "Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");

        assertTrue("These people should be considered equal, but are not.", p.equals(p2));
    }
}