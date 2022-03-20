package com.mrlu.spring.dao1;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 15:20
 */
public class Student {
    private String name;
    private Integer age;

    public Student() {
        System.out.println("执行了无参构造");
    }

    public Student(String name, Integer age) {
        System.out.println("执行了有参构造");
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("证明Spring调用了name属性的set方法");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("证明Spring调用了name属性的set方法");
        this.age = age;
    }


    public void setEmail(String email) {
        System.out.println("有set方法就行。不用属性存在");
    }
}
