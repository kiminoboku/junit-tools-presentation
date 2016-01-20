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
    public void shouldReturnSumOfBothAddends() {
        //arrange
        Calculator systemUnderTest = new Calculator();

        //action
        int sum = systemUnderTest.add(1, 2);

        //verify
        assertThat(sum, is(3));
    }

    /**
     * Here we're testing same method twice by repeating the same code with different parameters
     *
     * How can this be improved?
     */
    @Test
    public void shouldReturnSumOfBothAddends_Multiple() {
        //arrange
        Calculator systemUnderTest = new Calculator();

        //action, verify - first test
        int sum = systemUnderTest.add(1, 2);
        assertThat(sum, is(3));

        //action, verify - second test (DRY!)
        sum = systemUnderTest.add(2, 3);
        assertThat(sum, is(5));
    }
}
