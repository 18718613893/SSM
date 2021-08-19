package com.xxx.service.Impl;

import com.xxx.dao.StudentDao;
import com.xxx.domain.Student;
import com.xxx.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    @Override
    public List<Student> selectAllInService() {

        return studentDao.selectAll();
    }

    @Override
    public int insertStudentInService(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public Student selectByIdInService(Integer id) {
        return studentDao.selectById(id);
    }
}
