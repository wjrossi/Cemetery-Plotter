package tests;
import cs.softengine.InterredPerson;
import cs.softengine.Person;
import cs.softengine.Plot;
import org.junit.Test;

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
        assertEquals("ID must be -1, but is " + p.getID(), p.getID(), "-1");
    }

    /* Tests that Plot.setID() correctly sets the id
         of the Plot class.
     */
    @Test
    public void testSetID() throws Exception {
        p = new Plot();
        p.setID(1);
        assertEquals("ID must be 1, but is " + p.getID(), p.getID(), "1");
    }

    /* Tests that Plot.getSection() correctly gets the section variable
         of the Plot class.
     */
    @Test
    public void testGetSection() throws Exception {
        p = new Plot();
        p.section = "section1";
        assertEquals("ID must be 'section1', but is " + p.getSection(), p.getSection(), "section1");
    }

    /* Tests that Plot.getInterred() correctly gets the interred variable
         of the Plot class.
     */
    @Test
    public void testGetInterred() throws Exception {
        p = new Plot();
        p.interred = new Person();
        assertEquals("ID must be -1, but is " + p.getID(), p.getID(), "-1");
    }

    /* Tests that Plot.getOwner() correctly gets the owner variable
         of the Plot class.
     */
    @Test
    public void testGetOwner() throws Exception {
        p = new Plot();
        p.owner = new Person();
        assertEquals("ID must be -1, but is " + p.getID(), p.getID(), "-1");
    }

    /* Tests that Plot.getBurialDate() correctly gets the burial variable
        of the Plot class.
    */
    @Test
    public void testGetBurialDate() throws Exception {
        p = new Plot();
        p.burial = new Date();
        assertEquals("Burial must be null, but is " + p.getBurialDate(), p.getBurialDate(), "-1");
    }

    /* Tests that Plot.getPurchasedDate() correctly gets the purchased variable
        of the Plot class.
    */
    @Test
    public void testGetPurchasedDate() throws Exception {
        p = new Plot();
        p.purchased = new Date();
        assertEquals("Purchased must be -1, but is " + p.getPurchasedDate(), p.getPurchasedDate(), "-1");
    }

    /* Tests that Plot.isVacant() correctly gets the vacant variable
        of the Plot class.
    */
    @Test
    public void testIsVacant() throws Exception {
        p = new Plot();
        p.vacant = true;
        assertEquals("Vacant must be -1, but is " + p.isVacant(), p.isVacant(), "-1");
    }

    /* Tests that Plot.isReady() correctly gets the ready variable
        of the Plot class.
    */
    @Test
    public void testIsReady() throws Exception {
        p = new Plot();
        p.ready = true;
        assertEquals("Ready must be -1, but is " + p.isReady(), p.isReady(), "-1");
    }

    /* Tests that Plot.getMoneyDue() correctly gets the moneyDue variable
        of the Plot class.
    */
    @Test
    public void testGetMoneyDue() throws Exception {
        p = new Plot();
        p.moneyDue = 100;
        assertEquals("MoneyDue must be 100, but is " + p.getMoneyDue(), p.getMoneyDue(), "100");
    }

}
