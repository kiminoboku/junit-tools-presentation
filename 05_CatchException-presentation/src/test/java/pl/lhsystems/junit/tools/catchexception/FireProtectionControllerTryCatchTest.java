package pl.lhsystems.junit.tools.catchexception;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by U534102 on 2015-12-22. Here we are testing our FireProtectionController using plain old try-catch
 */
@RunWith(MockitoJUnitRunner.class)
public class FireProtectionControllerTryCatchTest {

    @InjectMocks
    FireProtectionController systemUnderTest;

    @Mock
    SmokeDetector smokeDetector;

    @Mock
    FireExtinguisher fireExtinguisher;

    @Test
    public void shouldThrowFireExceptionWhenSmokeIsDetected() {
        //make sure that collaborator throws an exception
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        try {
            systemUnderTest.checkForFire();
            fail("Missing exception");
        } catch (Exception e) {
            //verify
            assertThat(e, is(instanceOf(FireException.class)));
        }
    }

    @Test
    public void shouldThrowFireExceptionWithProperMessage() {
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        try {
            systemUnderTest.checkForFire();
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Fire!"));
        }
    }

    @Test
    public void shouldEnableFireExtinguisherWhenSmokeIsDetected() {
        when(smokeDetector.checkForSmoke()).thenThrow(new IllegalStateException());

        try {
            systemUnderTest.checkForFire();
        } catch (Exception e) {
            //We don't care about exception here, not part of this test
        }

        verify(fireExtinguisher).enable();
    }
}
