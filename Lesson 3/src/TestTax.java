import java.util.Scanner;


class TestTax {
	static Scanner input= new Scanner(System.in);
	public static void main(String[] args){
		NJTax t = new NJTax(); //creating an instance
		
		/* t.grossIncome= 50000; //assigning values */
		
		t.dependents= 2;
		t.state= "NJ";
		double yourTax;
		
		do{
		
		//Read the value of the income using Scanner
			System.out.println("\n Enter the gross income: ");
			t.grossIncome = input.nextDouble();
		
		//Calculate the tax
			yourTax = t.calcTax(); 
		
		//Print the result
		System.out.println("Your tax is " + yourTax);
		
		}while(true);
	}

}
