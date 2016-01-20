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
 * Here we're testing method with many inputs using a factory method for test input
 */
@RunWith(JUnitParamsRunner.class)
public class CalculatorWithJUnitParamsMethodTest {

    /**
     * Test with a defined factory method which provides input to the test
     *
     * @param addend1     first addend
     * @param addend2     second addend
     * @param expectedSum expected sum of addends
     */
    @Test
    @Parameters(method = "getAddendsWithProperSums")
    public void addShouldReturnSumOfBothAddends(int addend1, int addend2, int expectedSum) {
        Calculator systemUnderTest = new Calculator();

        int sum = systemUnderTest.add(addend1, addend2);

        assertThat(sum, is(expectedSum));
    }

    public Object[] getAddendsWithProperSums() {
        return $(
                $(1, 2, 3), //1 + 2 = 3
                $(2, 3, 5), //2 + 3 = 5
                $(4, 5, 9) //4 + 5 = 9
        );
    }
}
