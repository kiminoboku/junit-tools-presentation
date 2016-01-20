package pl.lhsystems.junit.tools.pitest;

/**
 * Created by U534102 on 2015-12-22.
 * <p>
 * Object responsible for calculating multiplication of two numbers. It includes very important feature of counting how
 * many times it was invoked. See {@link #getInvocationCount()}
 */
public class Multiplier {

    private int invocationCount;

    /**
     * Multiplies given numbers and returns result.
     *
     * @param n1 first number
     * @param n2 second number
     * @return result of multiplication
     */
    public int multiply(int n1, int n2) {
        ++invocationCount;

        return n1 * n2;
    }

    /**
     * Returns the number of invocations of {@link #multiply(int, int)} method
     *
     * @return number of multiplies done for this object
     */
    public int getInvocationCount() {
        return invocationCount;
    }
}
