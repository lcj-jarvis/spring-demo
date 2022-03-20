package com.mrlu.spring.dao;

import com.mrlu.spring.domain.Student;

import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 19:36
 */
public interface StudentDao {
    int insertStudent(Student student);
    List<Student> selectStudents();
}
