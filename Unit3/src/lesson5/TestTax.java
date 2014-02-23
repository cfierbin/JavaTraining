package lesson5;

public class TestTax {

	public static void main(String[] args) {
		double grossIncome;
		String state;
		int dependents;
		
		if (args.length != 3){
			System.out.println("The program expects 3 arguments in the command line!");
			System.out.println("Sample usage of the program: " + 
								"java lesson5.TestTax 50000 NJ 2");
		}
		
		grossIncome = Double.parseDouble(args[0]);
		state = args[1];
		dependents = Integer.parseInt(args[2]);
		
		//test usage of String as a switch variable
		
		switch (state){
		case "NJ":
			System.out.println("Your state is New Jersey");
			break;
		case "NY":
			System.out.println("Your state is New York");
			break;
		case "NM":
			System.out.println("Your state is New Mexico");
			break;
		default:
			System.out.println("I don't know your state.");
		}
		
		Tax t = new Tax(grossIncome, state, dependents);
		
		double yourTax = t.calcTax();
		
		System.out.println("Yout tax is: " + yourTax);

	}

}
