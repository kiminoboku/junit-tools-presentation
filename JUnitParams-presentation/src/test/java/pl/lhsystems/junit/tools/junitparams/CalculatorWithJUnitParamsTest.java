package pl.lhsystems.junit.tools.junitparams;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * Here we're testing method with different inputs using JUnitParams
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorWithJUnitParamsTest {


    /**
     * The {@code @Parameters} annotation can define all the input parameters needed by the test method. We only need
     * to define the method arguments and everything works! Type conversion from String to int is done automatically
     * (as well as splitting the arguments with comma).
     *
     * @param addend1     first addend
     * @param addend2     second addend
     * @param expectedSum expected sum of addends
     */
    @Test
    @Parameters({"1, 2, 3", "2, 3, 5"})
    public void addShouldReturnSumOfBothAddends(int addend1, int addend2, int expectedSum) {
        Calculator systemUnderTest = new Calculator();

        int sum = systemUnderTest.add(addend1, addend2);

        assertThat(sum, is(expectedSum));
    }
}
