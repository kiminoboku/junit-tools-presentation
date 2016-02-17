package pl.lhsystems.junit.tools.tempus.fugit;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Radek on 2016-02-17.
 */
public class SerialKeyGenerator {
    AtomicLong key = new AtomicLong();
    long key2 = 0L;

    public long nextKey() {
        return key.incrementAndGet();
//        return ++key2;
    }
}
