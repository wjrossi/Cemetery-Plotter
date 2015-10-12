package tests;
import cs.softengine.Section;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jiajiedang on 10/11/15.
 */
public class SectionTest {
    Section s;

    /* Tests that Section.setName() correctly sets the name
        variable of the Section class.
     */
    @Test
    public void testSetName() throws Exception {
        s = new Section("");
        s.setName("section1");
        assertEquals("section name must be 'section1', but is " + s.name, s.name, "section1");
    }

    /* Tests that Section.getName() returns the correct
        value.
     */
    @Test
    public void testGetName() throws Exception {
        s = new Section("section1");
        assertEquals("section name must return 'section1', but returned " + s.getName(), s.getName(), "section1");
    }

    /* Tests that Section.getSize() returns the correct
        value.
     */
    @Test
    public void testGetSize() throws Exception {
        s = new Section("section1", 10);
        assertEquals("section size must return 10, but returned " + s.getSize(), s.getSize(), "10");
    }
}
