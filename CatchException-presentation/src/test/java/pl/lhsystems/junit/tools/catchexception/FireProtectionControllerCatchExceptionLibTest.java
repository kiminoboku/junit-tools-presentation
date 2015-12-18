package pl.lhsystems.junit.tools.catchexception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by U534102 on 2015-12-22. Here we are testing FireProtectionController using catch-exception library
 */
@RunWith(MockitoJUnitRunner.class)
public class FireProtectionControllerCatchExceptionLibTest {

    @InjectMocks
    FireProtectionController systemUnderTest;

    @Mock
    SmokeDetector smokeDetector;

    @Mock
    FireExtinguisher fireExtinguisher;

    /**
     * catchException() creates a proxy for SUT which intercepts every exception from it,
     * <p>
     * caughtException() allows that access exception intercepted previously.
     *
     * @throws FireException
     */
    @Test
    public void checkForFireShouldThrowFireExceptionWhenSmokeDetectorThrowsException() throws FireException {
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        catchException(systemUnderTest).checkForFire();

        assertThat(caughtException(), is(instanceOf(FireException.class)));
    }

    @Test
    public void checkForFireShouldThrowFireExceptionWithProperMessage() throws FireException {
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        catchException(systemUnderTest).checkForFire();

        assertThat(caughtException(), is(notNullValue()));
        assertThat(caughtException().getMessage(), is("Fire!"));
    }

    @Test
    public void checkForFireShouldEnableFireExtinguisherWhenSmokeDetectorThrowsException() throws FireException {
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        catchException(systemUnderTest).checkForFire();

        verify(fireExtinguisher).enable();
    }
}
