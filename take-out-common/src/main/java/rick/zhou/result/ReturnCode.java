package rick.zhou.result;

import org.springframework.http.HttpStatus;

/**
 * @author rick.zhou
 */

public enum ReturnCode {

    RC200(200, HttpStatus.OK.getReasonPhrase()),
    RC400(400, HttpStatus.BAD_REQUEST.getReasonPhrase()),
    RC500(500, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

    private int code;
    private String msg;

    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
