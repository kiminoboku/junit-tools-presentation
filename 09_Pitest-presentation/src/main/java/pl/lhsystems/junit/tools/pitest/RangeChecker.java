package pl.lhsystems.junit.tools.pitest;

/**
 * Created by U534102 on 2015-12-18.
 * <p>
 * Object responsible for calculating absolute value of given number
 */
public class RangeChecker {

    public boolean isNumberGreaterThanOrEqualTwo(int checkedNumber) {
        if(checkedNumber >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
