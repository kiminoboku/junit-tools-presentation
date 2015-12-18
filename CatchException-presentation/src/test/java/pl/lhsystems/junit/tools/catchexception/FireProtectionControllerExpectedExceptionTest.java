package pl.lhsystems.junit.tools.catchexception;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by U534102 on 2015-12-22. Here we are testing FireProtectionController using JUnit "expected" feature
 */
@RunWith(MockitoJUnitRunner.class)
public class FireProtectionControllerExpectedExceptionTest {

    /** Special field for adding exception expectations */
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @InjectMocks
    FireProtectionController systemUnderTest;
    @Mock
    SmokeDetector smokeDetector;
    @Mock
    FireExtinguisher fireExtinguisher;

    //We can just add some expected exception type to @Test annotation
    @Test(expected = FireException.class)
    public void checkForFireShouldThrowFireExceptionWhenSmokeDetectorThrowsException() throws FireException {
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        systemUnderTest.checkForFire();
    }

    @Test
    public void checkForFireShouldThrowFireExceptionWithProperMessage() throws FireException {
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        //we can expect some particular message
        expectedException.expectMessage("Fire!");

        systemUnderTest.checkForFire();
    }

    /**
     * We cannot make any post-thrown verifications out of the box using JUnit "expected exception". Because of that we
     * have to use plain old try-catch here.
     */
    @Test
    public void checkForFireShouldEnableFireExtinguisherWhenSmokeDetectorThrowsException() {
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        try {
            systemUnderTest.checkForFire();
        } catch (Exception e) {
            //We don't care about exception here, not part of this test
        }

        verify(fireExtinguisher).enable();
    }
}
