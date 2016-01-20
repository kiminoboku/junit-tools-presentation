package pl.lhsystems.junit.tools.jacoco;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-22.
 */
@RunWith(JUnitParamsRunner.class)
public class MultiplierTest {

    Multiplier systemUnderTest = new Multiplier();


    @Test
    @Parameters({"1|1|1", "1|2|2", "2|3|6", "2|5|10", "2|7|14", "2|11|22", "11|2|22"})
    public void multiplyShouldReturnMultiplication(int n1, int n2, int expectedResult) {
        int result = systemUnderTest.multiply(n1, n2);

        assertThat(result, is(expectedResult));
    }


    @Test
    public void getInvocationCountShouldReturnZeroValue() {
        int result = systemUnderTest.getInvocationCount();

        assertThat(result, is(0));
    }

    @Test
//    @Ignore
    public void getInvocationCountShouldReturnIncreasedValue() {
        int anyNumber = 1;

        systemUnderTest.multiply(anyNumber, anyNumber);
        int result = systemUnderTest.getInvocationCount();

        assertThat(result, is(1));
    }
}
