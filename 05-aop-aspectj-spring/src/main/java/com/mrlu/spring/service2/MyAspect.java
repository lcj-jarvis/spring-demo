package com.mrlu.spring.service2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-10 13:52
 */

/**
 * @Aspects 是aspectj框架中的注解
 *        作用：表示当前类是切面类
 *        切面类：是用来给业务方法增强功能的类，在这个类中有切面的功能代码
 */
@Aspect
public class MyAspect {


    /**
     * 后置定义方法，方法是实现切面功能的
     * 方法的定义要求：
     * 1、公共方法public
     * 2、方法没有返回值
     * 3、方法名称自定义
     * 4、方法可以有参数，推荐是Object，参数名自定义
     *
     */

    /**
     *  @AfterReturning : 后置通知注解
     *  属性：1、value，是切入点表达式，表示切面功能执行的位置
     *       2、returning 自定义的变量，表示目标方法的返回值的。
     *                    自定义变量名是必须和通知方法的形参名一样。
     *  位置：位于方法之上
     *
     *  特点：
     *  1、在目标方法返回结果后执行的
     *  2、能够获取到目标方法的返回值，可以根据这个返回值做不同的处理功能
     *  3、不会修改这个返回值
     */
    @AfterReturning(value = "execution(* *..service2.*.doOther(..))",returning = "object")
    /*public void afterReturning(Object object,JoinPoint joinPoint){ JoinPoint只能放在参数的第一位*/
    public void afterReturning(JoinPoint joinPoint,Object object){

        System.out.println("目标方法名："+joinPoint.getSignature().getName());

        //Object object是目标方法之后的返回值，根据返回值做你的切面的功能处理
        System.out.println("后置通知：在目标方法返回结果之后执行，获取的返回值是:"+object);

        //修改目标方法的返回值，看看是否会影响最后方法的调用的结果
        /*
           相当于这样Object object = doOther();
                   afterReturning(object);
                   System.out.println(object);
         */
        if ("abcd".equals(object)){
            object = "Hello aspectJ";
        }
    }

    @AfterReturning(value = "execution(* *..service2.*.newStudent(..))",returning = "object")
    public void afterGetStudent(Object object){
        //Object object是目标方法之后的返回值，根据返回值做你的切面的功能处理
        System.out.println("后置通知：在目标方法返回结果之后执行，获取的返回值是:"+object);

        //修改目标方法的返回值，看看是否会影响最后方法的调用的结果
        /*
           相当于这样Object object = doOther();
                   afterReturning(object);
                   System.out.println(object);

           原理和java中的值传递和引用传递一样
         */
        Student student = (Student) object;
        student.setName("mary");
        student.setAge(20);

    }
}
