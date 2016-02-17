package pl.lhsystems.junit.tools.hamcrest;

import org.hamcrest.CustomTypeSafeMatcher;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * These tests shows some advanced features of Hamcrest
 */
public class EvenMoreSophisticatedTest {

    /**
     * Returns string matcher checking if given string has given length
     *
     * @param length length to be checked
     * @return string matcher checking for given string length
     */
    public static Matcher<String> hasLength(final int length) {
        return new CustomTypeSafeMatcher<String>("has length " + length) {
            @Override
            protected boolean matchesSafely(String s) {
                return s.length() == length;
            }
        };
    }

    @Test
    public void useCustomLengthMatcher() {
        String tenDigits = "1234567890";

        assertThat(tenDigits.length(), is(10));
        assertThat(tenDigits, hasLength(10)); //same as above with custom matcher
    }

    @Test
    public void checkIfCollectionHasSomeItem() {
        List<String> someList = Arrays.asList("123", "456", "789");

        assertThat(someList, hasItem("123"));
        assertThat(someList, both(hasItem("123")).and(hasItem("456")));
    }

    @Test
    public void checkIfCollectionHasItemMatchingSomeCriteria() {
        List<String> someList = Arrays.asList("123", "456", "789");

        assertThat(someList, hasItem(both(startsWith("1")).and(endsWith("3")))); //123
    }

    @Test
    public void checkIfEveryItemMatchSomeCriteria() {
        List<String> someList = Arrays.asList("123", "456", "789");

        assertThat(someList, everyItem(hasLength(3)));
    }
}
