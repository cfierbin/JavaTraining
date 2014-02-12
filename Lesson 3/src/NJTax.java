
class NJTax extends Tax{
double adjustForStudents (double stateTax){
	double adjustedTax = stateTax - 500;
	return adjustedTax;
}
//override Tax.calcTax()
public double calcTax(){
	double tax = super.calcTax();
	return adjustForStudents(tax);
}
}
