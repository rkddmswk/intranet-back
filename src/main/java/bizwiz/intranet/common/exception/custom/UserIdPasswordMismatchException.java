package bizwiz.intranet.common.exception.custom;

public class UserIdPasswordMismatchException extends RuntimeException {

    UserIdPasswordMismatchException() {

    }

    public UserIdPasswordMismatchException(String message) {
        super(message);
    }

    public UserIdPasswordMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}

