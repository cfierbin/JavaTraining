import com.practicaljava.lesson7.Contractor;
import com.practicaljava.lesson7.Employee;
import com.practicaljava.lesson7.Person;

public class TestPayIncrease3{

	public static void main(String[] args) {

        Object workers[] = new Object[3];
		workers[0] = new Employee("John");
		workers[1] = new Contractor("Mary");
		workers[2] = new Employee("Steve");

		for (Object p: workers){
		      ((Person) p).promote(30);
		}
	}
}
