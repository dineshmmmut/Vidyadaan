package com.example.sampleapp.Controller.response;

public class ErrorClass {

    private String message;

    private String errorCode;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorClass() {

    }

}
