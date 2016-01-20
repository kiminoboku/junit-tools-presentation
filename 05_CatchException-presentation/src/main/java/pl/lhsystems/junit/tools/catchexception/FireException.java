package pl.lhsystems.junit.tools.catchexception;

/**
 * Created by U534102 on 2015-12-22.
 * Simple exception indicating fire in the room.
 */
public class FireException extends Exception {
    public FireException(String message, Throwable cause) {
        super(message, cause);
    }
}
