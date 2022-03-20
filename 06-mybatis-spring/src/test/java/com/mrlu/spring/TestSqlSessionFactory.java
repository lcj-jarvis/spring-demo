package com.mrlu.spring;

import com.mrlu.spring.domain.Student;
import com.mrlu.spring.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 20:24
 */
public class TestSqlSessionFactory {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = context.getBeanDefinitionNames();
        for (String name:names) {
            System.out.println(name+"|"+context.getBean(name));
        }
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = context.getBean("studentService", StudentService.class);
        /* List<Student> students = studentService.selectStudents();
         students.forEach(System.out::println);*/
        //spring整合mybatis在一起使用，事务是中提交的。无序执行SqlSession.commit();【注意】
        Student student = new Student(1011,"Lisa","lisa@qq.com",25);
        int i = studentService.insertStudent(student);
        System.out.println(i);

    }
}
