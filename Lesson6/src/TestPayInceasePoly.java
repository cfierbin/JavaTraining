import com.practicaljava.lesson6.*;

public class TestPayInceasePoly {

	public static void main(String[] args) {

        Person workers[] = new Person[3];
		workers[0] = new Employee("John");
		workers[1] = new Contractor("Mary");
		workers[2] = new Employee("Steve");
		
			for (Person p: workers){
			          System.out.println(((Payable)p).increasePay(30)?"Done":"Failed");
	 		}
		}
}
