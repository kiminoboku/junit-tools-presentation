package pl.lhsystems.junit.tools.junitparams;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * Testing few parameters achieved with repeating code
 */
public class CalculatorByRepeatTest {

    @Test
    public void addShouldReturnSumOfBothAddends() {
        Calculator systemUnderTest = new Calculator();

        int sum = systemUnderTest.add(1, 2);

        assertThat(sum, is(3));
    }

    @Test
    public void addShouldReturnSumOfBothAddends_Multiple() {
        Calculator systemUnderTest = new Calculator();

        int sum = systemUnderTest.add(1, 2);
        assertThat(sum, is(3));

        // DRY!
        sum = systemUnderTest.add(2, 3);
        assertThat(sum, is(5));
    }
}
