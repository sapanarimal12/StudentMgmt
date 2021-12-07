package com.sapana.studentmgmt.dao.impl;

import com.sapana.studentmgmt.dao.StudentDao;
import com.sapana.studentmgmt.model.Student;
import com.sapana.studentmgmt.storage.MemoryStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class StudentDaoMemoryImpl  implements StudentDao {

    private  static  String  STUDENT_MEMORY= "STUDENT_MEMORY";
    private  static MemoryStorage memoryStorage=MemoryStorage.getInstance();
    private  static  List<Student> students;

    static {
        if (!memoryStorage.isAvailable(STUDENT_MEMORY)) {
            students = new ArrayList<>();
            memoryStorage.addToStorage(STUDENT_MEMORY,students);
        }else {
           students=(List<Student>) memoryStorage.getStorage().get(STUDENT_MEMORY);
        }
    }

    @Override
    public boolean add(Student student) {
        boolean isAdded =students.add(student);
        if (isAdded){
            return true;
        }
        else {
            throw  new RuntimeException("Adding student failed");
        }


    }

    @Override
    public boolean update(Student student) {
        Optional<Student> optionalStudent = students
                .stream()
                .filter((s) -> s.getId().compareTo(student.getId()) == 0)
                .map((s) -> {
                    if (student.getName()!= null)
                        s.setName(student.getName());
                    if (student.getDob()!= null)
                        s.setDob(student.getDob());
                    if (student.getAddress()!= null)
                        s.setAddress(student.getAddress());
                    if (student.getContactNo()!= null)
                        s.setContactNo(student.getContactNo());
                        return s;
                     }).findFirst();

        boolean isUpdated = optionalStudent.isPresent();

        if (isUpdated) {
            return true;
        } else {
            throw new RuntimeException("Updating Student Failed");
        }

    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Student> getAll() throws Exception {
        if (!students.isEmpty()) {
            return students;
        } else {
            throw new RuntimeException("There are no students in the system yet");
        }
    }

    @Override
    public Student getById(Long id) throws  Exception {


        Optional<Student> optionalStudent=students
                .stream()
                .filter(getStudentPredicate(id))
                .findFirst();
                if(optionalStudent.isPresent()){
                    return optionalStudent.get();
                } else {
                    throw  new RuntimeException("Student with id["+id+"] is not found in our system ");

                }
    }

    private Predicate<Student> getStudentPredicate(Long id) {
        return (s) -> s.getId().compareTo(id) == 0;
    }
}
