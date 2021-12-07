package com.sapana.studentmgmt.service;

import com.sapana.studentmgmt.model.Student;
import com.sapana.studentmgmt.response.Response;

public interface StudentService {
    Response add(Student student)  ;   //Create
    Response update(Student student) ; //update
    Response delete(Long id)   ;       //delete

    Response  getAll()  ;       //Read

    Response getById(Long id)  ;     // Read


}
