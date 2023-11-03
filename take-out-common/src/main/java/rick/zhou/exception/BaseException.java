package rick.zhou.exception;

/**
 * @author rick.zhou
 */
public class BaseException extends RuntimeException{
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }
}
