package com.sapana.studentmgmt.dao;


import com.sapana.studentmgmt.model.Student;

import java.util.List;

public interface StudentDao {

    boolean add(Student student)  throws  Exception;   //Create
    boolean update(Student student) throws Exception; //update
    boolean delete(Long id) throws  Exception;       //delete

    List<Student> getAll() throws Exception;       //Read

    Student getById(Long id) throws Exception;     // Read



}
