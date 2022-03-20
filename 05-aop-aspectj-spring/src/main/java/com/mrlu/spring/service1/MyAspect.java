package com.mrlu.spring.service1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.Date;

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
     * 定义方法，方法是实现切面功能的
     * 方法的定义要求：
     * 1、公共方法public
     * 2、方法没有返回值
     * 3、方法名称自定义
     * 4、方法可以有参数，也可以没有参数
     *   如果有参数，参数不是自定义的，有几个参数类型是可以使用的
     */

    /**
     *  @Before : 前置通知注解
     *  属性：value，是切入点表达式，表示切面功能执行的位置
     *  位置：位于方法之上
     *
     *  特点：
     *  1、在目标方法之前先执行的
     *  2、不会改变目标方法的执行结果
     *  3、不会影响目标方法的执行
     */
   /* @Before(value = "execution(public void com.mrlu.spring.service1.SomeServiceImpl.doSome(String, Integer) )")
    public void before(){
        System.out.println("前置通知,在目标方法执行之前输出执行时间："+new Date());
    }*/

   //优化切入点表达式一
    /*@Before(value = "execution(void *..service1.*.doSome(..) )")
    public void before(){
        System.out.println("前置通知,在目标方法执行之前输出执行时间："+new Date());
    }*/

    //优化切入点表达式二
    /*@Before(value = "execution(* *..service1.*.do*(..) )")
    public void before(){
        System.out.println("前置通知,在目标方法执行之前输出执行时间："+new Date());
    }*/

    //优化切入点表达式三
    /*@Before(value = "execution(* do*(..) )")
    public void before(){
        System.out.println("前置通知,在目标方法执行之前输出执行时间："+new Date());
    }*/

    //注意：如果切入点表示式，书写错误，就不能正确的创建代理对象

    /**
     *   指定通知方法中的参数：JointPoint
     *   JointPoint：连接点，业务方法，要加入切面的业务方法
     *   作用是：可以在通知方法中获取方法执行时的信息，例如方法名称，方法的实参
     *   如果你的切面功能中需要用到方法的信息，就加入JointPoint
     *   这个JointPoint参数的值是有框架赋予的，必须是第一个位置的参数，所以的通知偶读可以用这个参数【注意】
     */
    @Before(value = "execution(void *..service1.*.doSome(..) )")
    public void before(JoinPoint joinPoint){
        //获取方法的签名(即定义)
        Signature signature = joinPoint.getSignature();
        System.out.println("获取方法的完整定义" + signature);
        //获取方法的名称
        System.out.println("获取方法的名称"+joinPoint.getSignature().getName());
        //获取方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        System.out.println("前置通知,在目标方法执行之前输出执行时间："+new Date());
    }
}
