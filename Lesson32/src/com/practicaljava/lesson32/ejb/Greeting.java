package com.practicaljava.lesson32.ejb;

import javax.ejb.Local;

@Local
public interface Greeting {
	  public String sayHello();
}
