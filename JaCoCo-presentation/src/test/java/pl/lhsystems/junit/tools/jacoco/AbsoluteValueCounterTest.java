package pl.lhsystems.junit.tools.jacoco;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-18.
 */
@RunWith(JUnitParamsRunner.class)
public class AbsoluteValueCounterTest {

    AbsoluteValueCounter systemUnderTest = new AbsoluteValueCounter();

    @Test
    @Parameters({"0", "1", "2", "3", "4"})
    public void getAbsoluteValueShouldReturnInputWhenInputIsNonNegative(int anyNonNegativeValue) {
        int result = systemUnderTest.getAbsoluteValue(anyNonNegativeValue);

        assertThat(result, is(anyNonNegativeValue));
    }

    @Test
    @Parameters({"-1|1", "-2|2", "-3|3", "-4|4", "-5|5"})
    public void getAbsoluteValueShouldReturnPositiveNumberWhenInputIsNegative(int anyNegativeValue, int expectedResult) {
        int result = systemUnderTest.getAbsoluteValue(anyNegativeValue);

        assertThat(result, is(expectedResult));
    }
}
