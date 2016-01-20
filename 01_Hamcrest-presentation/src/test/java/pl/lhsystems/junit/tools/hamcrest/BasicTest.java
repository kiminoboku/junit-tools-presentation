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
    public void equalityCheckWithAssertTrueAndAssertEquals() {
        String actual = "unhappy".substring(2); //happy

        assertTrue("happy".equals(actual));
        assertEquals("happy", actual);
    }

    @Test
    public void inequalityCheckWithAssertFalseAndAssertNotEquals() {
        String actual = "unhappy".substring(2); //happy

        assertFalse("someOtherString".equals(actual));
        assertNotEquals("someOtherString", actual);
    }

    @Test
    public void equalityCheckWithHamcrest() {
        String actual = "unhappy".substring(2); //happy

        assertThat(actual, is("happy"));
    }

    @Test
    public void inequalityCheckWithHamcrest() {
        String actual = "unhappy".substring(2); //happy

        assertThat(actual, is(not("someOtherString")));
    }
}
