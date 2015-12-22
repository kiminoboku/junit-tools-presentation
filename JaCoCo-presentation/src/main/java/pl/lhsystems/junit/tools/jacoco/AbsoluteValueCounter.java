package pl.lhsystems.junit.tools.jacoco;

/**
 * Created by U534102 on 2015-12-18.
 * <p>
 * Object responsible for calculating absolute value of given number
 */
public class AbsoluteValueCounter {

    public int getAbsoluteValue(int n) {
        if (n < 0) {
            n = n * -1;
        }

        return n;
    }
}
