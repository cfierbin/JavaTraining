package lesson5;

public class Tax {
	double grossIncome;
	String state;
	int dependents;
	
	public Tax(double gi, String state, int depen){
		grossIncome = gi;
		this.state = state;
		dependents = depen;
	}
	
	public double calcTax(){
		double stateTax = 0;
		if(grossIncome < 30000){
			stateTax = grossIncome*0.05;
		}
		else{
			stateTax = grossIncome*0.06;
		}
		return stateTax;
	}

}
