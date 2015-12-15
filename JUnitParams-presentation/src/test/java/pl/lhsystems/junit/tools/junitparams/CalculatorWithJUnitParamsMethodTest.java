package pl.lhsystems.junit.tools.junitparams;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * Checking few params with JUnitParams library
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorWithJUnitParamsMethodTest {

    @Test
    @Parameters(method = "getAddendsWithProperSums")
    public void addShouldReturnSumOfBothAddends(int addend1, int addend2, int expectedSum) {
        Calculator systemUnderTest = new Calculator();

        int sum = systemUnderTest.add(addend1, addend2);

        assertThat(sum, is(expectedSum));
    }

    public Object[] getAddendsWithProperSums() {
        return $(
                $(1, 2, 3),
                $(2, 3, 5),
                $(4, 5, 9)
        );
    }
}
