package com.sapana.studentmgmt.service.impl;

import com.sapana.studentmgmt.builder.ResponseBuilder;
import com.sapana.studentmgmt.dao.StudentDao;
import com.sapana.studentmgmt.dao.impl.StudentDaoDatabaseImpl;
import com.sapana.studentmgmt.model.Student;
import com.sapana.studentmgmt.response.Response;
import com.sapana.studentmgmt.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private  StudentDao studentDAO = new StudentDaoDatabaseImpl();

    @Override
    public Response add(Student student) {
        Response response =null;
        try{
            studentDAO.add(student);
            response=ResponseBuilder.success("Student added successfully");
        } catch (Exception ex){
            response=ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }

    @Override
    public Response update(Student student) {
        Response response =null;
        try{
            studentDAO.update(student);
            response=ResponseBuilder.success("Student updated successfully");
        } catch (Exception ex){
            response=ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }

    @Override
    public Response delete(Long id) {
        Response response =null;
        try{
            studentDAO.delete(1l);
            response=ResponseBuilder.success("Student deleted successfully");
        } catch (Exception ex){
            response=ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }

    @Override
    public Response getAll() {
        Response response =null;
        try{
             List<Student> students =studentDAO.getAll();
            response=ResponseBuilder.success("Student fetched successfully",students);
        } catch (Exception ex){
            response=ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }

    @Override
    public Response getById(Long id) {
        Response response =null;
        try{
            Student student =studentDAO.getById(id);
            response=ResponseBuilder.success("Student fetched successfully",student);
        } catch (Exception ex){
            response=ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }
}