package pl.lhsystems.junit.tools.awaitility;

import com.jayway.awaitility.Awaitility;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Radek on 2016-02-15.
 */
public class PostOfficeTest {

    @Test
    public void shouldNotifyThatMailWasSent_TestUsingSleep() throws InterruptedException {
        String anyMail = "ANY_MAIL";
        MailSentListener mailSentListenerMock = mock(MailSentListener.class);
        PostOffice systemUnderTest = new PostOffice(mailSentListenerMock);

        //notifying mail listener can take up to 3 seconds so we wait
        systemUnderTest.sendMail(anyMail);
        TimeUnit.SECONDS.sleep(4); //this makes test run very long, can we reduce the time?

        verify(mailSentListenerMock).mailSent(anyString());
    }

    @Test
    public void shouldNotifyThatMailWasSent_TestUsingLoop() throws InterruptedException {
        //arrange
        String anyMail = "ANY_MAIL";
        MailSentListener mailSentListenerMock = mock(MailSentListener.class);
        PostOffice systemUnderTest = new PostOffice(mailSentListenerMock);
        boolean mailSentInvoked = false;

        //action
        systemUnderTest.sendMail(anyMail);

        //verify
        for (int i = 0; i < 100; ++i) {
            try {
                verify(mailSentListenerMock).mailSent(anyString());
                mailSentInvoked = true;
                break;
            } catch (AssertionError error) {
                //do nothing
            }
            TimeUnit.MILLISECONDS.sleep(50);
        }
        assertTrue(mailSentInvoked);
    }

    @Test
    public void shouldNotifyThatMailWasSent_TestUsingAwaitility() throws InterruptedException {
        String anyMail = "ANY_MAIL";
        MailSentListener mailSentListenerMock = mock(MailSentListener.class);
        PostOffice systemUnderTest = new PostOffice(mailSentListenerMock);

        systemUnderTest.sendMail(anyMail);

        Awaitility
                .await()
                .atMost(4, TimeUnit.SECONDS)
                .with().pollInterval(50, TimeUnit.MILLISECONDS)
                .until(() -> {
                    try {
                        verify(mailSentListenerMock).mailSent(anyString());
                        return true;
                    } catch (AssertionError error) {
                        return false;
                    }
                });
    }


}
