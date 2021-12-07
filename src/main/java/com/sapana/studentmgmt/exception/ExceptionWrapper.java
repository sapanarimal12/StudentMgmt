package com.sapana.studentmgmt.exception;

@FunctionalInterface
public interface ExceptionWrapper {
    void  handle() throws Exception;

}
