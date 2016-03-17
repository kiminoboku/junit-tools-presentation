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
public class RangeCheckerTest {

    RangeChecker systemUnderTest = new RangeChecker();

    @Test
    @Parameters({"1|false", "3|true"})
    public void shouldCheckIfNumberIsGreaterThanOrEqualTwo(int checkedNumber, boolean expectedResult) {
        boolean result = systemUnderTest.isNumberGreaterThanOrEqualTwo(checkedNumber);

        assertThat(result, is(expectedResult));
    }
}
