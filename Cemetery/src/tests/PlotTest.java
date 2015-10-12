package tests;
import cs.softengine.Plot;
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


}
