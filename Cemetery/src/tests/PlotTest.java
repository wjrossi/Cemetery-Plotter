package tests;

import cs.softengine.InterredPerson;
import cs.softengine.Person;
import cs.softengine.Plot;
import cs.softengine.Person;

import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
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
        InterredPerson i = Mockito.mock(InterredPerson.class);
        p.setInterred(i);
       assertEquals("Interred person should be: " + i + " but is: " + p.getInterred(), p.getInterred(), i);
    }

    /**
     * Tests that Plot.getContact() correctly gets the contact variable of the Plot class.
     */
    @Test
    public void testGetContact() throws Exception {
        p = new Plot();
        Person person = Mockito.mock(Person.class);
        p.setContact(person);
        assertEquals("contact should be: " + person + " but is: " + p.getContact(), p.getContact(), person);
    }

    /**
     * Tests that Plot.getBurialDateMonth() returns the correct value.
     */
    @Test
    public void testGetBurialDateMonth(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        assertEquals("getBurialDateMonth must return '11' but returned: " + p.getBurialDateMonth(), p.getBurialDateMonth(), "11");
    }

    /**
     * Tests that Plot.setBurialDateMonth() correctly sets the burialMonth value of the Plot class.
     */
    @Test
    public void testSetBurialDateMonth(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        p.setBurialDateMonth("12");
        assertEquals("burialMonth should be '12', but is: " + p.getBurialDateMonth(), p.getBurialDateMonth(), "12");
    }

    /**
     * Tests that Plot.getBurialDateDay() returns the correct value.
     */
    @Test
    public void testGetBurialDateDay(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        assertEquals("getBurialDateDay must return '11', but returned: " + p.getBurialDateDay(), p.getBurialDateDay(), "11");
    }

    /**
     * Tests that Plot.setBurialDateDay() correctly sets the burialDay variable of the Plot class.
     */
    @Test
    public void testSetBurialDateDay(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        p.setBurialDateDay("12");
        assertEquals("burialDay should be '12', but is: " + p.getBurialDateDay(), p.getBurialDateDay(), "12");
    }

    /**
     * Tests that Plot.getBurialDateYear() returns the correct value.
     */
    @Test
    public void testGetBurialDateYear(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        assertEquals("getBurialDateYear must return '1111', but returned: " + p.getBurialDateYear(), p.getBurialDateYear(), "1111");
    }

    /**
     * Tests that Plot.setBurialDateYear() correctly sets the burialYear variable of the Plot class.
     */
    @Test
    public void testSetBurialDateYear(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        p.setBurialDateYear("2222");
        assertEquals("burialDay should be '2222', but is: " + p.getBurialDateYear(), p.getBurialDateYear(), "2222");
    }

    /**
     * Tests that Plot.getPurchasedDateMonth() returns the correct value.
     */
    @Test
    public void testGetPurchasedDateMonth(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        assertEquals("getPurchasedDateMonth must return '12' but returned: " + p.getPurchasedDateMonth(), p.getPurchasedDateMonth(), "12");
    }

    /**
     * Tests that Plot.setPurchasedDateMonth() correctly sets the purchasedMonth value of the Plot class.
     */
    @Test
    public void testSetPurchasedDateMonth(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        p.setPurchasedDateMonth("11");
        assertEquals("PurchasedMonth should be '11', but is: " + p.getPurchasedDateMonth(), p.getPurchasedDateMonth(), "11");
    }

    /**
     * Tests that Plot.getPurchasedDateDay() returns the correct value.
     */
    @Test
    public void testGetPurchasedDateDay(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        assertEquals("getPurchasedDateDay must return '12', but returned: " + p.getPurchasedDateDay(), p.getPurchasedDateDay(), "12");
    }

    /**
     * Tests that Plot.setPurchasedDateDay() correctly sets the purchasedDay variable of the Plot class.
     */
    @Test
    public void testSetPurchasedDateDay(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        p.setPurchasedDateDay("11");
        assertEquals("PurchasedDay should be '11', but is: " + p.getPurchasedDateDay(), p.getPurchasedDateDay(), "11");
    }

    /**
     * Tests that Plot.getPurchasedDateYear() returns the correct value.
     */
    @Test
    public void testGetPurchasedDateYear(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        assertEquals("getPurchasedDateYear must return '2222', but returned: " + p.getPurchasedDateYear(), p.getPurchasedDateYear(), "2222");
    }

    /**
     * Tests that Plot.setPurchasedDateYear() correctly sets the purchasedYear variable of the Plot class.
     */
    @Test
    public void testSetPurchasedDateYear(){
        p = new Plot("A", 0, new InterredPerson(), new Person(), "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        p.setPurchasedDateYear("1111");
        assertEquals("PurchasedDay should be '1111', but is: " + p.getPurchasedDateYear(), p.getPurchasedDateYear(), "1111");
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
        assertEquals("getMoneyDue must return $0.00, but returns: " + p.getMoneyDue(), p.getMoneyDue(), "$0.00");
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
     * Tests that Plot.setContact() correctly sets the contact variable of the Plot class.
     */
    @Test
    public void testSetContact() throws Exception {
        p = new Plot();
        Person person = new Person("Kobe", "Bryant");
        p.setContact(person);
        assertEquals("Plot section must be Kobe Bryant, but is " + p.getContact(), p.getContact(), person);
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
        p.setMoneyDue("$11.99");
        assertEquals("moneyDue must be $11.99, but is: " + p.getMoneyDue(), p.getMoneyDue(), "$11.99");
    }

    /**
     * Tests that Plot.compareTo() is working correctly.
     */
    @Test
    public void testCompareTo() {
        p = new Plot();
        Plot p2 = new Plot();

        p.setID(1234);
        p2.setID(5678);

        assertNotEquals("These plots should not be considered equal.", p.compareTo(p2), 0);
    }

    /**
     * Tests that the Plot.equals() method is working correctly.
     */
    @Test
    public void testEquals() {
        p = new Plot();
        Plot p2 = new Plot();

        p.setID(1234);
        p2.setID(1234);

        assertTrue("These plots should be considered equal, but are not.", p.equals(p2));
    }

    /**
     * Tests that the Plot.toString() method is working correctly.
     */
    public void testToString(){
        p = new Plot("A", 0, null, null, "11", "11", "1111", "12", "12", "2222", false, false, new BigDecimal(0), "", "");
        String testStr = "<PLOT>\n"
                + 0
                + "<INTERREDPERSON>\nnull\n</INTERREDPERSON\n"
                + "<PERSON>\nnull\n</PERSON>\n"
                + "11\n"
                + "11\n"
                + "1111\n"
                + "12\n"
                + "12\n"
                + "2222\n"
                + false + "\n"
                + false + "\n"
                + "$0.00\n"
                + "\n"
                + "\n"
                + "<PLOT>\n";

        assertEquals("toString() should return: " + testStr + " but returned: " + p.toString(), p.toString(), testStr);
    }
}
