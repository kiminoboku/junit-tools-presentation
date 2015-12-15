package pl.lhsystems.junit.tools.hamcrest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * These are pretty basic tests written using Hamcrest assertions
 */
public class BasicTest {

    @Test
    public void equalityTest() {
        String actual = "someString";

        //equality checks with basic assertions
        assertTrue("someString".equals(actual));
        assertEquals("someString", actual);

        //un-equality checks with basic assertions
        assertFalse("someOtherString".equals(actual));
        assertNotEquals("someOtherString", actual);

        //same with hamcrest
        assertThat(actual, is("someString"));
        assertThat(actual, is(not("someOtherString")));

    }
}
