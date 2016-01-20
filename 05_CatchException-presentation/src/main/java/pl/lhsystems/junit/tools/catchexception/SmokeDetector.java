package pl.lhsystems.junit.tools.catchexception;

/**
 * Created by U534102 on 2015-12-22.
 * Dummy implementation of smoke detector
 */
public class SmokeDetector {
    /**
     * @return false if there is no smoke in the room
     * @throws IllegalStateException when there is smoke in the room
     */
    public boolean checkForSmoke() {
        return false; //by default no smoke detected
    }
}
