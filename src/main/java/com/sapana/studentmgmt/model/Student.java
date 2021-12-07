package com.sapana.studentmgmt.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;

//@Entity
//@Table(name = "STUDENTS")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Student implements Serializable {


    private  Long id;

    private String name;
    private  String  address;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd" )
    private Date dob;
    private  String contactNo;
    private Date createDate;
    private  Boolean status;

    public Student(String name, String address, Date dob, String contactNo) {
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.contactNo = contactNo;
    }
    public Student(Long id, String name, String address,Date dob, String contactNo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.contactNo = contactNo;
    }
}
