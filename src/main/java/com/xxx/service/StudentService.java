package com.xxx.service;

import com.xxx.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAllInService();

    int insertStudentInService(Student student);

    Student selectByIdInService(Integer id);
}
