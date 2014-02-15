/**
 * The increment/decrement operators can be applied before (prefix) or after (postfix) the operand. 
 * The code result++; and ++result; will both end in result being incremented by one. 
 * The only difference is that the prefix version (++result) evaluates to the incremented value, 
 * whereas the postfix version (result++) evaluates to the original value. 
 * If you are just performing a simple increment/decrement, it doesn't really matter which version you choose. 
 * But if you use this operator in part of a larger expression, the one that you choose may make a significant difference.
 * http://docs.oracle.com/javase/tutorial/java/nutsandbolts/op1.html
 */
package preAndPostOperators;

import java.util.Scanner;

public class TestPreAndPostOperators {
	
static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		double number = 0.01, quiz = 0;
		do{
		//get a number from user
			System.out.println("\nEnter a number: ");
			number = input.nextDouble();
		//print the value of number++
			System.out.println("number++ is: " + number++);
		//print the value of number
			System.out.println("number is: " + number);
		//print the value of ++number
			System.out.println("++number is: " + ++number);
		//print the value of number
			System.out.println("number is: " + number);
		//test user 
			//Ask question
			System.out.println("What will the following statement print?");
			System.out.println("System.out.println((quiz++ == quiz + 1)?\"correct\":\"wrong\");");
	//		System.out.println((quiz++ == quiz + 1)?"correct":"wrong");
			//Get user answer
			String answer = input.next();
			System.out.println("You answered \"" + answer + "\"");
			System.out.println("This is " + ((answer.equals("wrong"))?"correct":"wrong"));
		}
		while (true);

	}

}
