package pl.lhsystems.junit.tools.catchexception;

/**
 * Created by U534102 on 2015-12-22.
 */
public class FireProtectionController {

    SmokeDetector smokeDetector;
    FireExtinguisher fireExtinguisher;

    public FireProtectionController(SmokeDetector smokeDetector, FireExtinguisher fireExtinguisher) {
        this.smokeDetector = smokeDetector;
        this.fireExtinguisher = fireExtinguisher;
    }

    /**
     * Checks for smoke and if there is some, enables fire extinguisher and then throws exception.
     *
     * @throws FireException if there is smoke in the room
     */
    public void checkForFire() throws FireException {
        try {
            smokeDetector.checkForSmoke();
        } catch (IllegalStateException e) {
            fireExtinguisher.enable();
            throw new FireException("Fire!", e);
        }
    }
}
