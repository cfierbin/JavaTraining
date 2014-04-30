package com.practicaljava.lesson24;

import java.lang.annotation.*;
@Inherited
@Documented
@Target({ ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyJDBCExecutor {
	//String value();
	   String sqlStatement();
	   boolean transactionRequired() default false;
	   boolean notifyOnUpdates() default false; 

}
