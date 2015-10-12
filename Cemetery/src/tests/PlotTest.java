package tests;
import cs.softengine.Plot;
import cs.softengine.Person;
import org.junit.Test;

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

    /* Tests that Plot.setSection() correctly sets the section
        variable of the Plot class.
     */
    @Test
    public void testSetSection() throws Exception {
        p = new Plot();
        p.setSection("section1");
        assertEquals("Plot section must be section1, but is " + p.section, p.section, "section1");
    }

    /* Tests that Plot.setInterred() correctly sets the interred person
        variable of the Plot class.
     */
    @Test
    public void testSetInterred() throws Exception {
        p = new Plot();
        Person person = new Person("Kobe", "Bryant");
        p.setInterred(person);
        assertEquals("Plot interred person must be Kobe Bryant, but is " + p.interred, p.interred, person);
    }

    /* Tests that Plot.setOwner() correctly sets the owner
        variable of the Plot class.
     */
    @Test
    public void testSetOwner() throws Exception {
        p = new Plot();
        Person person = new Person("Kobe", "Bryant");
        p.setOwner(person);
        assertEquals("Plot section must be Kobe Bryant, but is " + p.owner, p.owner, person);
    }

    /* Tests that Plot.setVacant() correctly sets the Vacant
        variable of the plot class.
     */
    @Test
    public void testSetVacant() throws Exception {
        p = new Plot();
        p.setVacant(true);
        assertEquals("Plot vacant must be true, but is " + p.vacant, p.vacant, true);
    }

    /* Tests that Plot.setReady() correctly sets the Ready
        variable of the plot class.
     */
    @Test
    public void testSetReady() throws Exception {
        p = new Plot();
        p.setReady(true);
        assertEquals("Plot ready must be true, but is " + p.ready, p.ready, true);
    }

    /* Tests that Plot.setMoneyDue() correctly sets the money due
        variable of the plot class.
     */
    @Test
    public void testSetMoneyDue() throws Exception {
        p = new Plot();
        p.setMoneyDue(100);
        assertEquals("Plot money due must be 100, but is " + p.moneyDue, p.moneyDue, 100);
    }


}
