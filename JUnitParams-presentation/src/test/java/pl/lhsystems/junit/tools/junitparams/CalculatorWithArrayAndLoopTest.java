package pl.lhsystems.junit.tools.junitparams;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * Testing few parameters achieved with assertions in loop
 */
public class CalculatorWithArrayAndLoopTest {

    @Test
    public void addShouldReturnSumOfBothAddends() {
        Object[][] parameters = {
                {1, 2, 3}, //1 + 2 = 3
                {2, 3, 5} //2 + 3 = 5
        };

        //Test should have cyclomatic complexity equal to 1!
        for (Object[] testParameters : parameters) {
            int addend1 = (Integer) testParameters[0];
            int addend2 = (Integer) testParameters[1];
            int expectedSum = (Integer) testParameters[2];

            Calculator systemUnderTest = new Calculator();

            int sum = systemUnderTest.add(addend1, addend2);

            assertThat(sum, is(expectedSum));
        }
    }
}
