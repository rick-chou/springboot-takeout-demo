package rick.zhou.exception;

/**
 * @author rick.zhou
 */
public class DuplicateEmployeeException extends BaseException{
    public DuplicateEmployeeException() {
    }

    public DuplicateEmployeeException(String message) {
        super(message);
    }
}
