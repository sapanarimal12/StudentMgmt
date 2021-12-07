package com.sapana.studentmgmt.exception;

import com.sapana.studentmgmt.response.Response;


@FunctionalInterface
    public interface ExceptionDataWrapper {
        Response handle() throws Exception;
    }

