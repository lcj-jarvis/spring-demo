package com.mrlu.spring.dao1;

import org.springframework.stereotype.Component;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-09 20:12
 */

/**
 *   @Component 创建对象的，等同于<bean><bean/>的功能
 *   属性 value 就是对象的名称，也就是bean的id值
 *       value的值是唯一的，创建的对象在整个Spring容器就一个
 *   位置：在类的上面
 *
 *   @Component(value = "myStudent") 等同于<bean id="myStudent" class="com.mrlu.spring.dao1.Student"><bean/>
 *
 *   spring中和@Component功能一致，创建对象的注解还有
 *   1、@Repository（用在持久层上面的） ：放在dao的实现类上面的
 *                 表示创建dao对象，dao对象能访问数据库的
 *   2、@Service（用在业务成上面的）：放在service的实现类上面
 *                 创建service对象，service对象是做业务处理的，可以有事务等功能的
 *   3、@Controller（用在控制器上面）：放在控制器(处理器)类的上面，创建控制器对象
 *                 控制器对象，能够接受用户提交的参数，显示请求的处理结果
 *      以上三个注解的使用语法和@Component一样的。都能创建对象，但是这三个注解还有额外的功能
 *      @Repository @Service @Controller 是给项目的对象分层的
 */
//@Component(value = "myStudent")
@Component("myStudent")  //如果注解的属性名是value的话，且只有一个注解，就可以省略value
//@Component //不指定对象名称，由spring提供默认名称。默认值是类名首字母小写，即student
public class Student {
    private String name;
    private Integer age;

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
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
