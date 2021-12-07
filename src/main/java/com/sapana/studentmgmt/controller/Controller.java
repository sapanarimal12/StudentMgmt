package com.sapana.studentmgmt.controller;

import com.sapana.studentmgmt.response.Response;
import com.sapana.studentmgmt.util.JacksonUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller extends HttpServlet {

    public  void  buildResponse(HttpServletResponse response , Response responseBody ) throws IOException{
        final PrintWriter writer=response.getWriter();
        response.setContentType("Application/json");
        response.setStatus(200);
        writer.write(JacksonUtil.toJson(responseBody));
    }
}
