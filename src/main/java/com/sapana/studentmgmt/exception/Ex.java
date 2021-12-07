package com.sapana.studentmgmt.exception;

import com.sapana.studentmgmt.util.LogUtil;

public class Ex {

    public static void caught(ExceptionWrapper wrapper) {
        try {
            wrapper.handle();
        } catch (Exception ex) {
            LogUtil.exception(ex);
        }
    }
}
