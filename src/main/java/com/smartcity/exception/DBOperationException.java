package com.smartcity.exception;

public class DBOperationException extends RuntimeException{

    private String name;

    public DBOperationException(String message) {
        super(message);
    }

    public DBOperationException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
