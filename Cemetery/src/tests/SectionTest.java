package tests;
import cs.softengine.Section;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiajiedang on 10/11/15.
 */
public class SectionTest {
    Section s;

    /* Tests that Person.setFirstName() correctly sets the fname
        variable of the Person class.
     */
    @Test
    public void testSetFirstName() throws Exception {
        s = new Section();
        s.setName("section1");
        assertEquals("section name must be 'section1', but is " + s.name, s.name, "section1");
    }
}
