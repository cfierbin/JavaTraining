package com.practicaljava.lesson15.tryit;

import java.util.LinkedList;

import com.practicaljava.lesson15.tryit.workers.Employee;
import com.practicaljava.lesson15.tryit.workers.RetiredEmployee;

/**
 * Solution for "Try it" section from Lesson 15 "Generics"
 * 
 * @author Alexander Naberezhnov
 * 
 */
public class Lesson15Solution {

	/**
	 * Clone employees collection.
	 * 
	 * @param data
	 *            Employees collection to clone
	 * @return Result collection
	 */
	public static LinkedList<Employee> copyEmployess(
			LinkedList<? extends Employee> data) {
		LinkedList<Employee> result = new LinkedList<Employee>();
		for (Employee e : data) {
			result.add(new Employee(e.getName()));
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// original retired employees
		LinkedList<RetiredEmployee> data = new LinkedList<RetiredEmployee>();
		data.add(new RetiredEmployee("Mark Smith", 123000.0));
		data.add(new RetiredEmployee("John McCalahan", 175000.0));
		data.add(new RetiredEmployee("Patric Stuart", 158000.0));

		// cloned employees
		System.out.println("Cloned employees:");
		LinkedList<Employee> employees = copyEmployess(data);
		for (Employee e : employees) {
			System.out.println(e.getName());
		}
	}
}
