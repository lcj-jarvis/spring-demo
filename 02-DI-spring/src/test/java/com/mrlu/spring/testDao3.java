package com.mrlu.spring;

import com.mrlu.spring.dao3.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 16:27
 */
public class testDao3 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("dao3/applicationContext.xml");
        Student student = context.getBean("student", Student.class);
        Student student1= context.getBean("student1", Student.class);
        Student student2 = context.getBean("student2", Student.class);
        System.out.println(student);
        System.out.println(student1);
        System.out.println(student2);
    }


    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("dao3/applicationContext.xml");

        File file = context.getBean("file", File.class);
        InputStream in = null;
        try {
           in = new FileInputStream(file);
           byte[] arr = new byte[1024];
           int readDate;
           StringBuilder stringBuilder = new StringBuilder();
           while ((readDate = in.read(arr)) != -1){
               stringBuilder.append(new String(arr,0,readDate));
           }
            System.out.println(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
