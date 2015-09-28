package cs.softengine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CryptFinderTest {

    CryptFinder cf = new CryptFinder();

    /*Tests the first greeting.*/
    @Test
    public void testGreetingOne(){
        assertEquals(cf.greeting(1), "Hello, World!");
    }

    /*Tests the second greeting.*/
    @Test
    public void testGreetingTwo(){
        assertEquals(cf.greeting(2), "Maybe, World!");
    }

    /*Tests the third greeting.*/
    @Test
    public void testGreetingThree(){
        assertEquals(cf.greeting(3), "Goodbye, World!");
    }
}