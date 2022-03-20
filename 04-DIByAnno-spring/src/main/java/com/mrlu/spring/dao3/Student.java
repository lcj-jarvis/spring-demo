package com.mrlu.spring.dao3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 20:12
 */

@Component("myStudent")
public class Student {

    public Student() {
        System.out.println("====student=====");
    }

    @Value("jack")
    private String name;

    @Value("18")
    private Integer age;

    /**
     * 引用类型
     * @Autowired spring框架提供的数据，实现引用类型的赋值
     * spring中通过注解给引用类型赋值，使用的自动注入的原理，支持byName，byType
     * @Autowired:默认使用的是byType的自动注入。按照类型注入只能有一个同源关系的bean对象
     *      @Autowired的 required属性是一个boolean类型 默认值是true
     *      required=true 表示引用类型赋值失败，程序报错，并终止执行
     *      required=false 表示引用类型如果赋值失败，程序正常执行，引用类型赋值null
     * 位置：1、可以出现在构造器上，方法上，属性上
     *      2、在属性定义上面的时候，无需set方法，常用
     * 如果要使用byName的方式，需要做的是
     *   在属性上面/先忙加多一个注解@Qualifier(value = "bean的id")
     *   表示使用指定的bean完成赋值
     */
      //@Autowired
      //@Qualifier("school1")
   // @Autowired(required = false)
  // @Qualifier("school-1") //错误的情况
    //  private School school;

    /**
     * 引用类型
     *  @Resource 来自jdk的注解，spring框架提供了对这个注解的功能支持
     *            使用的也是自动注入的原理，支持byName,byType 默认是byName
     *  位置：1、在属性定义的上面，无需set方法，推荐使用
     *       2、在set方法上面
     *
     *  默认是byName：先使用ByName，找 有没有 Bean的id 和 被@Resource标注的属性的属性名 相同的bean 。（即看有没有id是school的）
     *              如果找到了注入。如果没有就使用byType，但是使用byType 只能有一个同源的bean对象才能完成注入 【注意***】
     * @Resourve 只使用byName方式，需要添加一个属性name
     */
    //  @Resource
      @Resource(name = "school2")
      private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
