package app.model;

import org.springframework.http.HttpStatus;

public class ResponseObject {

    private HttpStatus code;
    private String message;

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
