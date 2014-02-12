
class Tax {
double grossIncome;
String state;
int dependents;
static int customerCounter;

//Constructor
Tax(double gi, String st, int depen){
	grossIncome = gi;
	state = st;
	dependents = depen;
	customerCounter++;
	System.out.println("Preparing the tax data for customer #" + customerCounter);
}

public double calcTax(){
	return (grossIncome*0.33 - dependents*100);
}

static void convertToEuroAndPrint(double t){
	System.out.println("The tax in EURO is: " + 1.25 * t);
}
}
