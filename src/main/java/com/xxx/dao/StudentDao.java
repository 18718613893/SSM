package com.xxx.dao;

import com.xxx.domain.Student;

import java.util.List;

public interface StudentDao {
    List<Student> selectAll();
    int insertStudent(Student student);
    Student selectById(Integer id);
}
