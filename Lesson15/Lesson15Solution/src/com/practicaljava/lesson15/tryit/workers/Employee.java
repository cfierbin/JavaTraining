package com.practicaljava.lesson15.tryit.workers;

/**
 * Class describes employee.
 * 
 * @author Alexander Naberezhnov
 * 
 */
public class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}

	/**
	 * Name of the employee.
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
