package com.practicaljava.lesson32.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloWorldBean
 */
@Stateless
@LocalBean
public class HelloWorldBean {

    /**
     * Default constructor. 
     */
    public HelloWorldBean() {

    }

    public String sayHello(){
        return "Hello World!";
    }

    
}
