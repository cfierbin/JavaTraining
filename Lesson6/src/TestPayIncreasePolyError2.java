import com.practicaljava.lesson6.*;

public class TestPayIncreasePolyError2 {

	public static void main(String[] args) {

        Payable workers[] = new Payable [3];
		workers[0] = new Employee("John");
		workers[1] = new Contractor("Mary");
		//workers[2] = new ForeignContractor("Boris");
		
			for (Payable p: workers){
			          ((Payable)p).increasePay(30);
	 		}
		} 
}
