package com.practicaljava.lesson32.ejb;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldBean
 */
@Stateless

public class HelloWorldBeanL implements Greeting{

    /**
     * Default constructor. 
     */
    public HelloWorldBeanL() {

    }

    public String sayHello(){
        return "Hello World!";
    }

    
}
