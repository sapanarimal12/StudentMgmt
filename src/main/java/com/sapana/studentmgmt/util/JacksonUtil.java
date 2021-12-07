package com.sapana.studentmgmt.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
    private  static ObjectMapper objectMapper=new ObjectMapper();

    public  static String  toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            System.out.println("Exception:" + ex.getMessage());
            return null;
        }
    }
}
