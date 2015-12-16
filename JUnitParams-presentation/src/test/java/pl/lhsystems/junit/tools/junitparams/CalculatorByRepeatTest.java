package pl.lhsystems.junit.tools.junitparams;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * Here we're trying to test one method with different parameters by repeating code
 */
public class CalculatorByRepeatTest {

    /**
     * Just a "plain" single test with one input
     */
    @Test
    public void addShouldReturnSumOfBothAddends() {
        Calculator systemUnderTest = new Calculator();

        int sum = systemUnderTest.add(1, 2);

        assertThat(sum, is(3));
    }

    /**
     * Here we're testing same method twice by repeating the same code with different parameters
     */
    @Test
    public void addShouldReturnSumOfBothAddends_Multiple() {
        Calculator systemUnderTest = new Calculator();

        //first test
        int sum = systemUnderTest.add(1, 2);
        assertThat(sum, is(3));

        //second test (DRY!)
        sum = systemUnderTest.add(2, 3);
        assertThat(sum, is(5));
    }
}
