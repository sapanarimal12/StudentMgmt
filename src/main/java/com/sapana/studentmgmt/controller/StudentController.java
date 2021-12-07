package com.sapana.studentmgmt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sapana.studentmgmt.exception.Ex;
import com.sapana.studentmgmt.model.Student;
import com.sapana.studentmgmt.response.Response;
import com.sapana.studentmgmt.service.StudentService;
import com.sapana.studentmgmt.service.impl.StudentServiceImpl;
import com.sapana.studentmgmt.util.JacksonUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import static com.sapana.studentmgmt.util.DateUtil.formatDate;

public class StudentController  extends Controller{
    private final static StudentService studentService = new StudentServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ServletInputStream inputStream=request.getInputStream();
            ObjectMapper objectMapper=new ObjectMapper();
            Student student=objectMapper.readValue(inputStream,Student.class);
            Response responseBody = studentService.add(student);
            buildResponse(response, responseBody);


    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ex.caught(() -> {
            ServletInputStream inputStream=request.getInputStream();
            ObjectMapper objectMapper=new ObjectMapper();
            Student student=objectMapper.readValue(inputStream,Student.class);
            Response studentUpdate = studentService.update(student);

            System.out.println(JacksonUtil.toJson(studentUpdate));

            final PrintWriter writer = response.getWriter();
            response.setContentType("applicatiion/json");
            response.setStatus(200);
            writer.write(JacksonUtil.toJson(studentUpdate));

        });

        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Ex.caught(() -> {
            Response studentAllResponse = studentService.getAll();
            final PrintWriter writer = response.getWriter();
            response.setContentType("applicatiion/json");
            response.setStatus(200);
            writer.write(JacksonUtil.toJson(studentAllResponse));

        });
    }

//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Ex.caught(() -> {
//            request.getRequestURL().toString().split("/");System.out.println(split[0]);
//            Response studentDelete = studentService.delete(Long.parseLong(split[split.length-1]));
//
//            final PrintWriter writer = response.getWriter();
//            response.setContentType("applicatiion/json");
//            response.setStatus(200);
//            writer.write(JacksonUtil.toJson(studentDelete));
//
//
//
//        });
    // }

    public static void getAll() throws Exception {
        Response studentAllResponse = studentService.getAll();
        System.out.println(JacksonUtil.toJson(studentAllResponse));
    }

    public static void getOne() throws Exception {
        Response getByIdResponse = studentService.getById(5L);
        System.out.println(JacksonUtil.toJson(getByIdResponse));
    }

    public static void add() throws Exception {
        Student student = Student
                .builder()
                .name("Maniraj Joshi")
                .dob((Date) formatDate("1998-03-31", "yyyy-MM-dd"))
                .address("Lalitpur")
                .contactNo("9841494167")
                .build();

        Response studentAddResponse = studentService.add(student);
        System.out.println(JacksonUtil.toJson(studentAddResponse));
    }

    public static void update() throws Exception {
        Student student = Student
                .builder()
                .id(4L)
                .name("Sapana Maharjan")
                .dob((Date) formatDate("1998-03-31", "yyyy-MM-dd"))
                .address("Lalitpur")
                .contactNo("9841494167")
                .build();
        Response studentUpdate = studentService.update(student);
        System.out.println(JacksonUtil.toJson(studentUpdate));
    }

    public static void delete() throws Exception {
        Response studentDelete = studentService.delete(7L);
        System.out.println(JacksonUtil.toJson(studentDelete));
    }
}
