package pl.lhsystems.junit.tools.hamcrest;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * These are more fancy tests created using Hamcrest assertions
 */
public class MoreSophisticatedTest {

    @Test
    public void checkIfStringIsNotNull() {
        String emptyString = "";

        assertThat(emptyString, is(notNullValue()));
    }

    @Test
    public void checkIfStringStartsWithOtherString() {
        String fooBarBaz = "fooBarBaz";

        assertThat(fooBarBaz, startsWith("foo"));
    }

    @Test
    public void checkIfStringContainsOtherString() {
        String fooBarBaz = "fooBarBaz";

        assertThat(fooBarBaz, containsString("Bar"));
    }

    @Test
    public void checkIfStringEndsWithOtherString() {
        String fooBarBaz = "fooBarBaz";

        assertThat(fooBarBaz, endsWith("Baz"));
    }

    @Test
    public void checkFewThingsAtOnce() {
        String fooBarBaz = "fooBarBaz";

        assertThat(fooBarBaz, allOf(startsWith("f"), containsString("Bar"), endsWith("z")));
        assertThat(fooBarBaz, both(startsWith("f")).and(containsString("Bar")).and(endsWith("z")));
    }

    @Test
    public void checkAnything() {
        String fooBarBaz = "fooBarBaz";

        assertThat(fooBarBaz, anyOf(startsWith("foo"), startsWith("bar"), startsWith("baz")));
        assertThat(fooBarBaz, either(startsWith("foo")).or(startsWith("bar")).or(startsWith("baz")));
    }

    @Test
    public void checkTypes() {
        String fooBarBaz = "fooBarBaz";

        assertThat(fooBarBaz, both(isA(String.class)).and(is(not(instanceOf(Exception.class)))));
    }
}
