package com.practicaljava.lesson15;

import java.util.LinkedList;

public class TestGenericMethod {

	public static void main(String[] args) {
		
		LinkedList<RetiredEmployee> retiredEmp = new LinkedList<RetiredEmployee>();
		retiredEmp.add(new RetiredEmployee("John A."));
		retiredEmp.add(new RetiredEmployee("Mary B."));
		retiredEmp.add(new RetiredEmployee("Chris C."));
		
		LinkedList<Employee> copyOfRetiredEmpList = new LinkedList<Employee>();
		
		//copyOfRetiredEmpList = copyList(retiredEmp);
		
		copyList2(copyOfRetiredEmpList, retiredEmp);
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

