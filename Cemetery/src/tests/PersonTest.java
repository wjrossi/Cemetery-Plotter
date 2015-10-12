package tests;

import cs.softengine.Person;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jamie on 10/11/2015.
 */
public class PersonTest {

    Person p;

    /* Tests that Person.setFirstName() correctly sets the fname
        variable of the Person class.
     */
    @Test
    public void testSetFirstName() throws Exception {
        p = new Person("Frank", "Laboon");
        p.setFirstName("Bill");
        assertEquals("fname must be 'Bill', but is " + p.fname, p.fname, "Bill");
    }

    /* Tests that Person.getFirstName() returns the correct
        value.
     */
    @Test
    public void testGetFirstName() throws Exception {
        p = new Person("Bill", "Laboon");
        assertEquals("getFirstName must return 'Bill', but returned " + p.getFirstName(), p.getFirstName(), "Bill");
    }

    /* Tests that Person.setLastName() correctly sets the lname
        variable of the Person class.
     */
    @Test
    public void testSetLastName() throws Exception {
        p = new Person("Bill", "Frank");
        p.setLastName("Laboon");
        assertEquals("lname must be 'Laboon', but is " + p.lname, p.lname, "Laboon");
    }

    /* Tests that Person.getLastName() returns the correct
        value.
     */
    @Test
    public void testGetLastName() throws Exception {
        p = new Person("Bill", "Laboon");
        assertEquals("getLastName must return 'Laboon', but returned " + p.getLastName(), p.getLastName(), "Laboon");
    }

    /* Tests that Person.setAddress1() correctly sets the address1
        variable of the Person class.
     */
    @Test
    public void testSetAddress1() throws Exception {
        p = new Person("Bill", "Laboon", "Sandwich", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        p.setAddress1("1234 Laboon Place");
        assertEquals("address1 must be '1234 Laboon Place', but was " + p.address1, p.address1, "1234 Laboon Place");
    }

    /* Tests that Person.getAddress1() returns the correct
        value.
     */
    @Test
    public void testGetAddress1() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getAddress1 must return '1234 Laboon Place', but returned " + p.getAddress1(), p.getAddress1(), "1234 Laboon Place");
    }

    /* Tests that Person.setAddress2() correctly sets the address2
        variable of the Person class.
     */
    @Test
    public void testSetAddress2() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "Sandwich", "Laboontown", "Maine", "1337", "555-555-5555");
        p.setAddress2("4567 Bill Street");
        assertEquals("address2 must be '4567 Bill Street', but was " + p.address2, p.address2, "4567 Bill Street");
    }

    /* Tests that Person.getAddress2() returns the correct
        value.
     */
    @Test
    public void testGetAddress2() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getAddress2 must return '4567 Bill Street', but returned " + p.getAddress2(), p.getAddress2(), "4567 Bill Street");
    }

    /* Tests that Person.setCity() correctly sets the city
        variable of the Person class.
     */
    @Test
    public void testSetCity() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Catville", "Maine", "1337", "555-555-5555");
        p.setCity("Laboontown");
        assertEquals("city must be 'Laboontown', but was " + p.city, p.city, "Laboontown");
    }

    /* Tests that Person.getCity() returns the correct
        value.
     */
    @Test
    public void testGetCity() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getCity must return 'Laboontown', but returned " + p.getCity(), p.getCity(), "Laboontown");
    }

    /* Tests that Person.setState() correctly sets the state
        variable of the Person class.
     */
    @Test
    public void testSetState() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Hingle McCringleberry", "1337", "555-555-5555");
        p.setState("Maine");
        assertEquals("state must be 'Maine', but was " + p.state, p.state, "Maine");
    }

    /* Tests that Person.getState() returns the correct
        value.
     */
    @Test
    public void testGetState() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getState must return 'Maine', but returned " + p.getState(), p.getState(), "Maine");
    }

    /* Tests that Person.setZip() correctly sets the zip
        variable of the Person class.
     */
    @Test
    public void testSetZip() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "Not a zipcode", "555-555-5555");
        p.setZip("1337");
        assertEquals("zip must be '1337', but was " + p.zip, p.zip, "1337");
    }

    /* Tests that Person.getZip() returns the correct
        value.
     */
    @Test
    public void testGetZip() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getZip must return '1337', but returned " + p.getZip(), p.getZip(), "1337");
    }

    /* Tests that Person.setPhone() correctly sets the phone
        variable of the Person class.
     */
    @Test
    public void testSetPhone() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-CATS");
        p.setPhone("555-555-5555");
        assertEquals("phone must be '555-555-5555', but was " + p.phone, p.phone, "555-555-5555");
    }

    /* Tests that Person.getPhone() returns the correct
        value.
     */
    @Test
    public void testGetPhone() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        assertEquals("getPhone must return '555-555-5555', but returned " + p.getPhone(), p.getPhone(), "555-555-5555");
    }

    /*
        Tests that the toString() method is working correctly.
     */
    @Test
    public void testToString() throws Exception {
        p = new Person("Bill", "Laboon", "1234 Laboon Place", "4567 Bill Street", "Laboontown", "Maine", "1337", "555-555-5555");
        String testStr = "<PERSON>\n"
                + "Bill" + "\n"
                + "Laboon" + "\n"
                + "1234 Laboon Place" + "\n"
                + "4567 Bill Street" + "\n"
                + "Laboontown" + "\n"
                + "Maine"  + "\n"
                + "1337" + "\n"
                + "555-555-5555"  + "\n"
                + "</PERSON>\n";

        assertEquals("Person string should be " + testStr + " but is " + p.toString(), p.toString(), testStr);
    }
}