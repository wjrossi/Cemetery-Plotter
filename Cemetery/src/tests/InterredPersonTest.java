package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import cs.softengine.InterredPerson;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Jamie on 10/26/2015.
 */
public class InterredPersonTest {
    InterredPerson i;

    // sadly, we need new tests because the constructors were changed and the date was split into three fields to
    // account for the cemetery having incomplete info for a date of death, for example.
}