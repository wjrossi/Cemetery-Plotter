package tests;
import cs.softengine.InterredPerson;
import cs.softengine.Person;
import cs.softengine.Plot;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;
/**
 * Created by jiajiedang on 10/11/15.
 */
public class PlotTest {

    Plot p;

    /* Tests that Plot.getID() correctly gets the id
         of the Plot class.
     */
    @Test
    public void testGetID() throws Exception {
        p = new Plot();
        assertEquals("ID must be '-1', but is " + p.getID(), p.getID(), -1);
    }

    /* Tests that Plot.setID() correctly sets the id
         of the Plot class.
     */
    @Test
    public void testSetID() throws Exception {
        p = new Plot();
        p.setID(1);
        assertEquals("ID must be 1, but is " + p.getID(), p.getID(), 1);
    }

    /* Tests that Plot.getSection() correctly gets the section variable
         of the Plot class.
     */
    @Test
    public void testGetSection() throws Exception {
        p = new Plot();
        p.section = "section1";
        assertEquals("Section must be 'section1', but is " + p.getSection(), p.getSection(), "section1");
    }

    /* Tests that Plot.getInterred() correctly gets the interred variable
         of the Plot class.
     */
    @Test
    public void testGetInterred() throws Exception {
        p = new Plot();
        p.interred = new Person();
        p.interred.fname = "Bill";
        p.interred.lname = "Laboon";
        p.interred.address1 = "address1";
        p.interred.address2 = "address2";
        p.interred.city = "Pittsburgh";
        p.interred.state = "PA";
        p.interred.zip = "15213";
        p.interred.phone = "4120000000";
        assertEquals("Interred must be '\"Name: Bill Laboon\\n\" +\n" +
                "                \"Address: address1 ,address2\\n\" +\n" +
                "                \"         Pittsburgh ,PA ,15213\\n\" +\n" +
                "                \"Phone number: 4120000000\"', but is " +
                p.getInterred().toString(), p.getInterred().toString(), "Name: Bill Laboon\n" +
                "Address: address1 ,address2\n" +
                "         Pittsburgh ,PA ,15213\n" +
                "Phone number: 4120000000");
    }

    /* Tests that Plot.getOwner() correctly gets the owner variable
         of the Plot class.
     */
    @Test
    public void testGetOwner() throws Exception {
        p = new Plot();
        p.owner = new Person();
        p.owner.fname = "Bill";
        p.owner.lname = "Laboon";
        p.owner.address1 = "address1";
        p.owner.address2 = "address2";
        p.owner.city = "Pittsburgh";
        p.owner.state = "PA";
        p.owner.zip = "15213";
        p.owner.phone = "4120000000";
        assertEquals("Interred must be '\"Name: Bill Laboon\\n\" +\n" +
                "                \"Address: address1 ,address2\\n\" +\n" +
                "                \"         Pittsburgh ,PA ,15213\\n\" +\n" +
                "                \"Phone number: 4120000000\"', but is " +
                p.getOwner().toString(), p.getOwner().toString(), "Name: Bill Laboon\n" +
                "Address: address1 ,address2\n" +
                "         Pittsburgh ,PA ,15213\n" +
                "Phone number: 4120000000");
    }

    /* Tests that Plot.getBurialDate() correctly gets the burial variable
        of the Plot class.
    */
    @Test
    public void testGetBurialDate() throws Exception {
        p = new Plot();
        p.burial = new Date(000000);
        assertEquals("Burial must be 20000101, but is " + p.getBurialDate(), p.getBurialDate(), 20000101);
    }


    /* Tests that Plot.getPurchasedDate() correctly gets the purchased variable
        of the Plot class.
    */
    @Test
    public void testGetPurchasedDate() throws Exception {
        p = new Plot();
        p.purchased = new Date();
        assertEquals("Purchased must be 20000101, but is " + p.getPurchasedDate(), p.getPurchasedDate(), 20000101);
    }


    /* Tests that Plot.isVacant() correctly gets the vacant variable
        of the Plot class.
    */
    @Test
    public void testIsVacant() throws Exception {
        p = new Plot();
        p.vacant = true;
        assertEquals("Vacant must be 'true', but is " + p.isVacant(), p.isVacant(), true);
    }

    /* Tests that Plot.isReady() correctly gets the ready variable
        of the Plot class.
    */
    @Test
    public void testIsReady() throws Exception {
        p = new Plot();
        p.ready = true;
        assertEquals("Ready must be 'true', but is " + p.isReady(), p.isReady(), true);
    }

    /* Tests that Plot.getMoneyDue() correctly gets the moneyDue variable
        of the Plot class.
    */
    @Test
    public void testGetMoneyDue() throws Exception {
        p = new Plot();
        p.moneyDue = 100;
        assertEquals("MoneyDue must be '100', but is " + p.getMoneyDue(), p.getMoneyDue(), 100);
    }

}
