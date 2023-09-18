package org.taerock.apitest01.filter.exception;

public class AccessTokenException extends RuntimeException{

    private String msg;

    public AccessTokenException(String msg){
        super(msg);
        this.msg = msg;
    }
}
