package pl.lhsystems.junit.tools.pitest;

/**
 * Created by U534102 on 2015-12-22.
 */
public class Multiplier {

    private int invocationCount;

    public int multiply(int n1, int n2) {
        ++invocationCount;

        return n1 * n2;
    }

    public int getInvocationCount() {
        return invocationCount;
    }
}
