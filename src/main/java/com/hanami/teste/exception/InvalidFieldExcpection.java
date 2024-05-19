package com.hanami.teste.exception;

public class InvalidFieldExcpection extends RuntimeException{
    private String field;

    public InvalidFieldExcpection(String field){
        this.field = field;
    }

    public String getMessage(){
        return this.field + " invalido";
    }
}
