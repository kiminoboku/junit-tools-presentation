package pl.lhsystems.junit.tools.awaitility;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Radek on 2016-02-15.
 */
public class PostOffice {

    MailSentListener mailSentListener;

    public PostOffice(MailSentListener mailSentListener) {
        this.mailSentListener = mailSentListener;
    }

    public void sendMail(final String mail) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit((Callable<Void>) () -> {

            TimeUnit.SECONDS.sleep(3);
            mailSentListener.mailSent(mail);

            return null;
        });
    }
}
