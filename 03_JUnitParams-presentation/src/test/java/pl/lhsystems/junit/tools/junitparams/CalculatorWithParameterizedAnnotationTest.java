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
 * Here we're testing method with different input using default JUnit {@code @Parameterized} mechanism
 */
@RunWith(Parameterized.class)
public class CalculatorWithParameterizedAnnotationTest {

    int addend1;
    int addend2;
    int expectedSum;

    /**
     * We need custom constructor to initialize fields which will be then used in test
     *
     * @param addend1     first addend
     * @param addend2     second addend
     * @param expectedSum expected sum of addends
     */
    public CalculatorWithParameterizedAnnotationTest(int addend1, int addend2, int expectedSum) {
        this.addend1 = addend1;
        this.addend2 = addend2;
        this.expectedSum = expectedSum;
    }

    /**
     * @return Collection of invocation parameters for unit test
     */
    @Parameters
    public static Collection<Object[]> getAddendsWithSums() {
        return Arrays.asList(
                new Object[]{1, 2, 3}, //1 + 2 = 3
                new Object[]{2, 3, 5} //2 + 3 = 5
        );
    }

    /**
     * Test looks nice but at what cost?
     */
    @Test
    public void shouldReturnSumOfBothAddends() {
        Calculator systemUnderTest = new Calculator();

        int sum = systemUnderTest.add(addend1, addend2);

        assertThat(sum, is(expectedSum));
    }
}
