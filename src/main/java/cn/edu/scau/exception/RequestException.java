package cn.edu.scau.exception;

public class RequestException extends GlobalException{
    public RequestException(String message, int code) {
        super(message, code);
    }

    public RequestException(String message) {
        super(message);
    }
}
