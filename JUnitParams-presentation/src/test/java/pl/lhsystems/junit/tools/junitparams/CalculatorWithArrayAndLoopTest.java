package pl.lhsystems.junit.tools.junitparams;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-15.
 * <p>
 * Here we're trying to test one method with different input using Object[][] table and loop
 */
public class CalculatorWithArrayAndLoopTest {

    @Test
    public void addShouldReturnSumOfBothAddends() {
        Object[][] parameters = {
                {1, 2, 3}, //1 + 2 = 3
                {2, 3, 5} //2 + 3 = 5
        };

        //Why is this wrong? How this can be improved?
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
