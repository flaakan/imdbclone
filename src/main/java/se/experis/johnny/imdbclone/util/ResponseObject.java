package se.experis.johnny.imdbclone.util;

import org.springframework.http.HttpStatus;

public class ResponseObject {

    private Object object;
    private String message;
    private HttpStatus status;

    public ResponseObject(){

    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
