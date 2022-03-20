package com.mrlu.spring.excption;

/**
 * @author Mr.Lu
 * @version 1.0
 * @email 1802772962@qq.com
 * @createDate 2021-02-11 0:13
 */
public class NotEnoughException extends RuntimeException{
    private static final long serialVersionUID  = 8888L;
    public NotEnoughException() {
        super();
    }

    public NotEnoughException(String message) {
        super(message);
    }
}
