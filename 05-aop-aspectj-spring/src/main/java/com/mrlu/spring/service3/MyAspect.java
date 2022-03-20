package com.mrlu.spring.service3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.lang.reflect.InvocationHandler;

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
     * @Around:环绕通知
     *    属性:value 切入点表达式
     *    位置:在方法的定义上面
     *   特点：
     *     1、它是功能最强的通知
     *     2、在目标方法的前和后都能增强功能
     *     3、控制目标方法是否被调用执行
     *     4、修改原来的目标方法的执行结果。影响最后的调用结果
     *
     *     环绕通知，等同于jdk动态代理的，InvocationHandler接口
     *
     *     方法的参数：ProceedingJoinPoint，是JointPoint的子类
     *               作用：执行目标的方法
     *
     *     返回值：就是目标方法的执行结果，可以被修改
     *
     *     环绕通知：经常做事务，在目标方法之前开启事务，执行目标方法，在目标方法之后提交事务
     */
    @Around(value = "execution(* *..service3.*.doFirst(..))")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object result = null;
        //实现环绕通知
        System.out.println("环绕通知,在目标方法执行之前开启事务");
        //获取目标方法的参数。
        String str = null;
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 0){
           str  = (String) args[0];
        }
        //控制目标方法的执行
        if ("jack".equals(str)){
            System.out.println("目标方法调用！！！");
            //目标方法调用
            result = proceedingJoinPoint.proceed();
            //相当于InvocationHandler的invoke方法中的method.invoke(); 也相当于Object result = doFirst();
            //修改目标方法的执行结果
            result = "Hello" + result;
        }

        System.out.println("环绕通知，在目标方法之后提交事务");
        return result;
    }


    /**
     * 异常通知方法的格式
     * 1、public
     * 2、没有返回值
     * 3、方法名称自定义的
     * 4、方法有一个Exception，如果还有就是JoinPoint
     *
     * @AfterThrowing：异常通知
     *   属性：1、value 切入点表达式
     *        2、throwing 自定义的变量，表示目标方法抛出异常对象
     *           变量名必须和方法的参数名一样
     *   特点：
     *      1、在目标方法做出异常时执行的
     *      2、可以做异常的监控程序，监控目标方法执行时是否有异常
     *         如果有异常是，可以发送邮件，短信进行通知等
     *      3、
     *   相当于
     *   try{
     *       doSome();
     *   }catch(Exception e){
     *       afterException(e);
     *   }
     *
     */
    @AfterThrowing(value = "execution(* *..service3.*.doSome(..))",throwing = "ex")
    public void afterException(Exception ex){
        System.out.println("发生了异常："+ex.getMessage());
        //发送邮件、短信、通知开发人员

    }

    /**
     * 最终通知方法的格式
     * 1、public
     * 2、没有返回值
     * 3、方法名称自定义的
     * 4、方法一般没有参数，如果还有就是JoinPoint
     *
     * @After：最终通知
     *   属性：1、value 切入点表达式
     *
     *   特点：
     *      1、总是会执行
     *      2、在目标方法之后执行
     *      3、
     *   相当于
     *   try{
     *       doSome();
     *   }catch(Exception e){
     *       afterException(e);
     *   }finally{
     *       myAfter()
     *   }
     *
     */
    @After(value = "execution(* *..service3.*.doSome(..))")
    public void myAfter(){
        System.out.println("最终通知总是会执行的");
    }
}
