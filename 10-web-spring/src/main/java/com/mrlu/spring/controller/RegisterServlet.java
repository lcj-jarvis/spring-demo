package com.mrlu.spring.controller;

import com.mrlu.spring.domain.Student;
import com.mrlu.spring.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-11 16:46
 */
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");

        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        /*获取ServletContext中的容器对象，创建好的容器对象，就来就用*/
        WebApplicationContext context = null;
        ServletContext servletContext = getServletContext();
        /*Object attribute = servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        if (attribute != null){
            context = (WebApplicationContext) attribute;
        }*/

        //使用WebApplicationContextUtils工具类获取WebApplicationContext
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        System.out.println("容器对象的信息====="+context);
        StudentService service = context.getBean("studentService", StudentService.class);
        Student student = new Student(Integer.parseInt(id),name,email,Integer.parseInt(age));
        service.insertStudent(student);
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
