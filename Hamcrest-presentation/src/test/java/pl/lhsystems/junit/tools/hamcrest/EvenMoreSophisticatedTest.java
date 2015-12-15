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

        //you can check if the string matches your custom matcher
        //plain English: you can check if tenDigits has length 10
        assertThat(tenDigits, hasLength(10));
    }

    @Test
    public void testItemsInCollection() {
        List<String> someList = Arrays.asList("123", "456", "789");

        //you can check if list has some item (checked by equals method)
        assertThat(someList, hasItem("123"));

        //you can check if lit has some item matching some given matcher
        assertThat(someList, hasItem(startsWith("1"))); //123
        assertThat(someList, hasItem(both(startsWith("4")).and(endsWith("6")))); //456
        assertThat(someList, hasItem(endsWith("9"))); //789

        //you can check every item
        assertThat(someList, everyItem(hasLength(3)));
    }
}
