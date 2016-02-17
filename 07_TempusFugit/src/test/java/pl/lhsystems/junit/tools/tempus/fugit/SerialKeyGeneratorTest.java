package pl.lhsystems.junit.tools.tempus.fugit;

import com.google.code.tempusfugit.concurrency.ConcurrentRule;
import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Concurrent;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Radek on 2016-02-17.
 */
public class SerialKeyGeneratorTest {

    @Rule
    public ConcurrentRule concurrentRule = new ConcurrentRule();

    @Rule
    public RepeatingRule repeatingRule = new RepeatingRule();

    Set<Long> ids = Collections.synchronizedSet(new HashSet<>());

    SerialKeyGenerator systemUnderTest = new SerialKeyGenerator();

    @Test
    @Concurrent(count = 5)
    @Repeating(repetition = 1000)
    public void shouldReturnUniqueIdentifier() {
        long key = systemUnderTest.nextKey();

        Assert.assertTrue("Serial key generator returned duplicate keys", ids.add(key));
    }
}
