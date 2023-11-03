package rick.zhou.result;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author rick.zhou
 */
@Data
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;
    private LocalDateTime time;

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<>();
        result.setCode(ReturnCode.RC200.getCode());
        result.setMsg(ReturnCode.RC200.getMsg());
        result.setTime(LocalDateTime.now());
        result.data = object;
        return result;
    }

    public static <T> Result<T> fail(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setTime(LocalDateTime.now());
        return result;
    }
}
