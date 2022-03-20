package com.mrlu.spring.service4;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 13:52
 */

/**
 * @Aspect 是aspectj框架中的注解
 *        作用：表示当前类是切面类
 *        切面类：是用来给业务方法增强功能的类，在这个类中有切面的功能代码
 */
@Aspect
public class MyAspect {

    /**
     *  @Pointcut 定义和管理切入点，如果你项目中有多个切入点表达式是重复的，可以复用的
     *            可以使用@Pointcut
     *      属性：value 切入点表达式的值
     *      位置：在自定义的方法上面
     *      特点:
     *      当使用@Point定义在一个方法的上面时候，此时的这个方法的名称就是切入点表达式的别名
     *      其他的通知中，value属性就可以使用这个方法的名称，代替切入点表达式了
     *
     *      该方法一般是private的
     */
    @Pointcut(value = "execution(* *..service4.*.doSome(..))")
    private void pointcut(){
        //这里无需代码
    }

    @Before(value = "pointcut()")
    public void before(){
        System.out.println("前置通知");
    }

    @After(value = "pointcut()")
    public void after(){
        System.out.println("最终通知");
    }
}
