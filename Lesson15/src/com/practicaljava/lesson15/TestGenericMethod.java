package com.practicaljava.lesson15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestGenericMethod {
	
	//Generic method
	//From: http://agiledeveloper.com/presentations/the_good_bad_and_ugly_of_generics_java_one.zip
	//http://bit.ly/14k7ORf
	
	public static <T> void copy(List<T> source, List<? super T> destination) {
	    for(T element : source) {
	      destination.add(element);
		  System.out.println("Copied retired employee. " + element.toString());
	    }
	  }


	public static void main(String[] args) {
		
		//create source list
		ArrayList<RetiredEmployee> retiredEmp = new ArrayList<>();
		retiredEmp.add(new RetiredEmployee("John"));
		retiredEmp.add(new RetiredEmployee("Mary"));
		retiredEmp.add(new RetiredEmployee("Chris"));
		
		//create empty destination list
		LinkedList<Employee> copyOfRetiredEmpList = new LinkedList<>();
		
		//invoke generic method to copy source list to destination list
		copy(retiredEmp,copyOfRetiredEmpList);
		
		//print content of copy
		for(Employee emp: copyOfRetiredEmpList){
			System.out.println(emp.getName());
		}
		
		//copyOfRetiredEmpList = copyList(retiredEmp);
		
		//copyList2(copyOfRetiredEmpList, retiredEmp);
	}
	
	<T,S extends T> T[] copyArray (S[] fromArray){
		return fromArray;
	}
	
	static <T>  void copyList2 (LinkedList<T> list, LinkedList<? extends T> fromList){
		for (T element: fromList){
			list.add(element);
			printName(element);
		}
	}
	
	static <T> LinkedList<T> copyList (LinkedList<? extends T> fromList){
		LinkedList<T> list = new LinkedList<T>();
		for (T element: fromList){
			list.add(element);
			printName(element);
		}
		return list;
	}
	
	static <T> void printName (T element){
		System.out.println(element.toString());
	}

}

