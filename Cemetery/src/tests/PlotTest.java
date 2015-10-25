package tests;

import cs.softengine.InterredPerson;
import cs.softengine.Person;
import cs.softengine.Plot;
import cs.softengine.Person;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Tests for Plot
 */
public class PlotTest {
    Plot p;

    /**
     * Tests that Plot.getID() correctly gets the id of the Plot class.
     */
    @Test
    public void testGetID() throws Exception {
        p = new Plot();
        assertEquals("ID must be '-1', but is " + p.getID(), p.getID(), -1);
    }

    /**
     * Tests that Plot.setID() correctly sets the id of the Plot class.
     */
    @Test
    public void testSetID() throws Exception {
        p = new Plot();
        p.setID(1);
        assertEquals("ID must be 1, but is " + p.getID(), p.getID(), 1);
    }

    /**
     * Tests that Plot.getSection() correctly gets the section variable of the Plot class.
     */
    @Test
    public void testGetSection() throws Exception {
        p = new Plot();
        p.setSection("section1");
        assertEquals("Section must be 'section1', but is " + p.getSection(), p.getSection(), "section1");
    }

    /**
     * Tests that Plot.getInterred() correctly gets the interred variable of the Plot class.
     */
   @Test
    public void testGetInterred() throws Exception {
        p = new Plot();
        p.setInterred(new InterredPerson());
        p.getInterred().setFirstName("Bill");
        p.getInterred().setLastName("Laboon");
        p.getInterred().setAddress1("address1");
        p.getInterred().setAddress2("address2");
        p.getInterred().setCity("Pittsburgh");
        p.getInterred().setState("PA");
        p.getInterred().setZip("15213");
        p.getInterred().setPhone("4120000000");
        assertEquals("Interred person should be:\n-1\n" +
                "-1\n" +
                "null\n" +
                "null\n" +
                "Bill\n" +
                "Laboon\n" +
                "address1\n" +
                "address2\n" +
                "Pittsburgh\n" +
                "PA\n" +
                "15213\n" +
                "4120000000, but is\n" +
                p.getInterred().toString(), p.getInterred().toString(), "<INTERREDPERSON>\n-1\n" +
                "-1\n" +
                "null\n" +
                "null\n" +
                "Bill\n" +
                "Laboon\n" +
                "address1\n" +
                "address2\n" +
                "Pittsburgh\n" +
                "PA\n" +
                "15213\n" +
                "4120000000\n" +
                "</INTERREDPERSON>\n");
    }

    /**
     * Tests that Plot.getOwner() correctly gets the owner variable of the Plot class.
     */
    @Test
    public void testGetOwner() throws Exception {
        p = new Plot();
        p.setOwner(new Person());
        p.getOwner().setFirstName("Bill");
        p.getOwner().setLastName("Laboon");
        p.getOwner().setAddress1("address1");
        p.getOwner().setAddress2("address2");
        p.getOwner().setCity("Pittsburgh");
        p.getOwner().setState("PA");
        p.getOwner().setZip("15213");
        p.getOwner().setPhone("4120000000");
        assertEquals("Owner should be:\nBill\n" +
                "Laboon\n" +
                "address1\n" +
                "address2\n" +
                "Pittsburgh\n" +
                "PA\n" +
                "15213\n" +
                "4120000000, but is" +
                p.getOwner().toString(), p.getOwner().toString(), "<PERSON>\nBill\n" +
                "Laboon\n" +
                "address1\n" +
                "address2\n" +
                "Pittsburgh\n" +
                "PA\n" +
                "15213\n" +
                "4120000000\n" +
                "</PERSON>\n");
    }

    /**
     * Tests that Plot.getBurialDate() correctly gets the burial variable of the Plot class.
    */
    @Test
    public void testGetBurialDate() throws Exception {
        p = new Plot();
        p.setBurialDate(null);
        assertEquals("Burial must be 'null', but is " + p.getBurialDate(), p.getBurialDate(), null);
    }

    /**
     * Tests that Plot.getPurchasedDate() correctly gets the purchased variable of the Plot class.
    */
    @Test
    public void testGetPurchasedDate() throws Exception {
        p = new Plot();
        p.setPurchasedDate(null);
        assertEquals("Purchased must be 'null', but is " + p.getPurchasedDate(), p.getPurchasedDate(), null);
    }

    /**
     * Tests that Plot.isVacant() correctly gets the vacant variable of the Plot class.
    */
    @Test
    public void testIsVacant() throws Exception {
        p = new Plot();
        p.setVacant(true);
        assertEquals("Vacant must be 'true', but is " + p.isVacant(), p.isVacant(), true);
    }

    /**
     * Tests that Plot.isReady() correctly gets the ready variable of the Plot class.
    */
    @Test
    public void testIsReady() throws Exception {
        p = new Plot();
        p.setReady(true);
        assertEquals("Ready must be 'true', but is " + p.isReady(), p.isReady(), true);
    }

    /**
     * Tests that Plot.getMoneyDue() correctly gets the moneyDue variable of the Plot class.
    */
    @Test
    public void testGetMoneyDue() throws Exception {
        p = new Plot();
        p.setMoneyDue(100);
        assertEquals("MoneyDue must be '100', but is " + p.getMoneyDue(), p.getMoneyDue(), 100);
    }

    /**
     * Tests that Plot.setSection() correctly sets the section variable of the Plot class.
     */
    @Test
    public void testSetSection() throws Exception {
        p = new Plot();
        p.setSection("section1");
        assertEquals("Plot section must be section1, but is " + p.getSection(), p.getSection(), "section1");
    }

    /**
     * Tests that Plot.setInterred() correctly sets the interred person variable of the Plot class.
     */
    @Test
    public void testSetInterred() throws Exception {
        p = new Plot();
        InterredPerson person = new InterredPerson(35, 2346, null, null, "Kobe", "Bryant");
        p.setInterred(person);
        assertEquals("Plot interred person must be Kobe Bryant, but is " + p.getInterred(), p.getInterred(), person);
    }

    /**
     * Tests that Plot.setOwner() correctly sets the owner variable of the Plot class.
     */
    @Test
    public void testSetOwner() throws Exception {
        p = new Plot();
        Person person = new Person("Kobe", "Bryant");
        p.setOwner(person);
        assertEquals("Plot section must be Kobe Bryant, but is " + p.getOwner(), p.getOwner(), person);
    }

    /**
     * Tests that Plot.setVacant() correctly sets the Vacant variable of the plot class.
     */
    @Test
    public void testSetVacant() throws Exception {
        p = new Plot();
        p.setVacant(true);
        assertEquals("Plot vacant must be true, but is " + p.isVacant(), p.isVacant(), true);
    }

    /**
     * Tests that Plot.setReady() correctly sets the Ready variable of the plot class.
     */
    @Test
    public void testSetReady() throws Exception {
        p = new Plot();
        p.setReady(true);
        assertEquals("Plot ready must be true, but is " + p.isReady(), p.isReady(), true);
    }

    /**
     * Tests that Plot.setMoneyDue() correctly sets the money due variable of the plot class.
     */
    @Test
    public void testSetMoneyDue() throws Exception {
        p = new Plot();
        p.setMoneyDue(100);
        assertEquals("Plot money due must be 100, but is " + p.getMoneyDue(), p.getMoneyDue(), 100);
    }
}
