package pl.lhsystems.junit.tools.junitparams;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * Checking few parameters with default JUnit parameterized tests
 */
@RunWith(Parameterized.class)
public class CalculatorWithParameterizedAnnotationTest {

    int addend1;
    int addend2;
    int expectedSum;

    public CalculatorWithParameterizedAnnotationTest(int addend1, int addend2, int expectedSum) {
        this.addend1 = addend1;
        this.addend2 = addend2;
        this.expectedSum = expectedSum;
    }

    @Parameters
    public static Collection<Object[]> getAddendsWithSums() {
        return Arrays.asList(
                new Object[]{1, 2, 3},
                new Object[]{2, 3, 5}
        );
    }

    @Test
    public void addShouldReturnSumOfBothAddends() {
        Calculator systemUnderTest = new Calculator();

        int sum = systemUnderTest.add(addend1, addend2);

        assertThat(sum, is(expectedSum));
    }
}
