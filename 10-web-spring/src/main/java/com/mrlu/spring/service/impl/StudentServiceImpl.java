package com.mrlu.spring.service.impl;

import com.mrlu.spring.dao.StudentDao;
import com.mrlu.spring.domain.Student;
import com.mrlu.spring.service.StudentService;

import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 19:48
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> selectStudents() {
        return studentDao.selectStudents();

    }
}
