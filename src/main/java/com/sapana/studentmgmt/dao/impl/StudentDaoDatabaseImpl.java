package com.sapana.studentmgmt.dao.impl;

import com.sapana.studentmgmt.dao.StudentDao;
import com.sapana.studentmgmt.model.Student;
import com.sapana.studentmgmt.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoDatabaseImpl implements StudentDao {


    @Override
    public boolean add(Student student) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/JDBC_DEMO", "sapana", "sapana");
        //here JDBC_DEMO is database name, sapana is username and password

        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO STUDENTS(NAME,ADDRESS,DOB,CONTACTNO) VALUE(?,?,?,?) ");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getAddress());
        preparedStatement.setString(3, student.getContactNo());
        preparedStatement.setDate(4, DateUtil.convertJavaDateToSQLDate(student.getDob()));

        int rowAffected = preparedStatement.executeUpdate();
        if (rowAffected > 0) {
            return true;
        } else {
            throw new RuntimeException("Adding student failed! ");

        }
    }



    @Override
    public boolean update(Student student) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/JDBC_DEMO", "sapana", "sapana");
        //here JDBC_DEMO is database name, sapana is username and password

        PreparedStatement preparedStatement = con.prepareStatement("UPDATE STUDENTS SET (NAME,ADDRESS,DOB,CONTACTNO) VALUE(?,?,?,?) ");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getAddress());
        preparedStatement.setString(3, student.getContactNo());
        preparedStatement.setDate(4, DateUtil.convertJavaDateToSQLDate(student.getDob()));

        int rowAffected = preparedStatement.executeUpdate();
        if (rowAffected > 0) {
            return true;
        } else {
            throw new RuntimeException("Adding student failed! ");

        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }


    //CRUD- READ
    @Override
    public List<Student> getAll() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/JDBC_DEMO", "sapana", "sapana");
        //here JDBC_DEMO is database name, sapana is username and password
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from students");

        List<Student> students = new ArrayList<>();
        while (rs.next()) {
            Student student = Student
                    .builder()
                    .id(rs.getLong("ID"))
                    .name(rs.getString("Name"))
                    .address(rs.getString("ADDRESS"))
                    .dob(rs.getDate("DOB"))
                    .contactNo(rs.getString("CONTACTNO"))
                    .createDate(rs.getDate("CREATED_DATE"))
                    .status(rs.getBoolean("STATUS"))
                    .build();
            students.add(student);
        }
        if (!students.isEmpty()) {
            return students;

        } else {
            throw new RuntimeException("There is no student in the system yet");


        }

    }


//CRUD-READ
    @Override
    public Student getById(Long id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/JDBC_DEMO", "sapana", "sapana");
        //here JDBC_DEMO is database name, sapana is username and password

       PreparedStatement preparedStatement = con.prepareStatement("SELECT *FROM STUDENTS WHERE ID=?");
        preparedStatement.setLong(1,id);
       ResultSet rs= preparedStatement.executeQuery();
        while (rs.next()) {
           return Student
                    .builder()
                    .id(rs.getLong("ID"))
                    .name(rs.getString("Name"))
                    .address(rs.getString("ADDRESS"))
                    .dob(rs.getDate("DOB"))
                    .contactNo(rs.getString("CONTACTNO"))
                    .createDate(rs.getDate("CREATED_DATE"))
                    .status(rs.getBoolean("STATUS"))
                    .build();

        }
        throw  new RuntimeException("Student with id["+id+"] is not found in our system ");

    }
}
