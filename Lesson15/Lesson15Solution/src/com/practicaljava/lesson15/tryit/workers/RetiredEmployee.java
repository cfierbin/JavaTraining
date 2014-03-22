package com.practicaljava.lesson15.tryit.workers;

/**
 * Class describes the employee that was retired.
 * 
 * @author Alexander Naberezhnov
 * 
 */
public class RetiredEmployee extends Employee {

	private Double pension;

	public RetiredEmployee(String name, Double pension) {
		super(name);
		this.pension = pension;
	}

	/**
	 * Amount of the retired employee pension.
	 */
	public Double getPension() {
		return pension;
	}

	public void setPension(Double pension) {
		this.pension = pension;
	}

}
