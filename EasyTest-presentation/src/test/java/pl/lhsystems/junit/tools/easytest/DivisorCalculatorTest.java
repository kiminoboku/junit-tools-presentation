package pl.lhsystems.junit.tools.easytest;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by U534102 on 2015-12-18. Testing with input data from excel file
 */
@RunWith(DataDrivenTestRunner.class)
public class DivisorCalculatorTest {

    DivisorCalculator systemUnderTest = new DivisorCalculator();

    @Test
    @DataLoader(filePaths = {"pl/lhsystems/junit/tools/easytest/greatestCommonDivisor.xls"}, loaderType = LoaderType.EXCEL)
    public void calculateGreatestCommonDivisorShouldReturnGreatestCommonDivisor(
            @Param(name = "n1") String n1,
            @Param(name = "n2") String n2,
            @Param(name = "expectedResult") String expectedResult) {

        int number1 = Integer.valueOf(n1);
        int number2 = Integer.valueOf(n2);

        int result = systemUnderTest.calculateGreatestCommonDivisor(number1, number2);

        assertThat(result, is(Integer.valueOf(expectedResult)));
    }
}
