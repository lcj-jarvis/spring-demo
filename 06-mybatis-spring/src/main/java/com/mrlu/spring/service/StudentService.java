package com.mrlu.spring.service;

import com.mrlu.spring.domain.Student;

import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 19:47
 */
public interface StudentService {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
