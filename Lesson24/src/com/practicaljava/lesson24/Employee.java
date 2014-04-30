package com.practicaljava.lesson24;
public class Employee extends Person{
 public void raiseSalary() {
   System.out.println("Raising salary for Employee...");
  }
 public void  changeAddress(String newAddress) {
	 System.out.println("New address is "+ newAddress);
 }
 
 public void  changeAddress(String newAddress, int number) {
	 System.out.println("New address is "+ newAddress + " : " + number);
 }
}
