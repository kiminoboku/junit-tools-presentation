package pl.lhsystems.junit.tools.easytest;

import java.math.BigInteger;

/**
 * Created by U534102 on 2015-12-18.
 * Object responsible for calculating greatest common divisor for two given numbers
 */
public class DivisorCalculator {

    /**
     * @param number1 first number
     * @param number2 second number
     * @return greatest common divisor for given numbers
     */
    public int calculateGreatestCommonDivisor(int number1, int number2) {
        BigInteger n1 = BigInteger.valueOf(number1);
        BigInteger n2 = BigInteger.valueOf(number2);
        return n1.gcd(n2).intValue();
    }
}
