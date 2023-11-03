package rick.zhou.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import rick.zhou.exception.BaseException;
import rick.zhou.result.Result;
import rick.zhou.result.ReturnCode;

/**
 * @author rick.zhou
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<String> resultException(BaseException e) {
        log.error("BUSINESS ERROR {}", e.getMessage(), e);
        return Result.fail(ReturnCode.RC500.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<String> argumentValidException(MethodArgumentNotValidException e) {
        log.error("ARGUMENT VALID ERROR {}", e.getMessage());
        return Result.fail(ReturnCode.RC400.getCode(), e.getBindingResult().getFieldError().getDefaultMessage());
    }
}
