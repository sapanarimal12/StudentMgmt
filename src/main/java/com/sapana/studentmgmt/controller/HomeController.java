package com.sapana.studentmgmt.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeController extends Controller {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter writer=resp.getWriter();
        writer.write("<h1 style='font-size:30px;color:red;text-align:center;margin-top:30px;'>StudentMgmt is Running !!");


    }
}
