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
    public void testOurCarString() {
        //Somewhat definition of a car
        String carString = "hood with engine and 4 wheels, ending with trunk";

        //you can check if object is not null
        assertThat(carString, is(notNullValue()));

        //you can check car conditions with separate assertions
        assertThat(carString, startsWith("hood"));
        assertThat(carString, containsString("engine"));
        assertThat(carString, containsString("4 wheels"));
        assertThat(carString, endsWith("trunk"));

        //on the other hand you can check all conditions at once
        assertThat(carString, allOf(startsWith("hood"), containsString("engine"), containsString("4 wheels"),
                endsWith("trunk")));

        //sometimes car ends either with truck or a trailer
        assertThat(carString, anyOf(endsWith("trunk"), endsWith("trailer")));
        assertThat(carString, either(endsWith("trunk")).or(endsWith("trailer")));

        //it may even end with something else
        assertThat(carString, either(endsWith("trunk")).or(endsWith("trailer")).or(endsWith("something else")));

        //but it must have both wheels and engine
        assertThat(carString, both(containsString("4 wheels")).and(containsString("engine")));

        //but unfortunately this is String after all, not any Car object
        assertThat(carString, both(isA(String.class)).and(is(not(instanceOf(Car.class)))));
    }

    class Car {

    }
}
