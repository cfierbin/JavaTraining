
public class TestingLambdas {

	public static void main(String[] args) {
		
		Person workers[] = new Person[4];
		workers[0] = new Employee("John");
		workers[1] = new Contractor("Mary");
		workers[2] = new Employee("Steve");
		workers[3] = new Person("Cristina");

		for (Person p: workers){
			
			p.increasePay.increasePay(30);
		}

/*
			if (p instanceof Employee) {
				((Employee)p).increasePay.increasePay(30);
			}
			else if (p instanceof Contractor){
				((Contractor)p).increasePay.increasePay(30);
			}
			else p.increasePay.increasePay(30);
		}
*/

	}

}



//functional interface
interface Payable {
	int INCREASE_CAP = 20;
	boolean increasePay(int percent);
}

class Employee extends Person{	  
	
	public Employee(String name){
		super(name);
		increasePay = (int percent) -> {
			System.out.println("Increasing salary by " + percent + "%. " + getName());
			return true;
		};
	}

}

class Contractor extends Person{
	  
    public Contractor(String name){
       super(name);
       
   	   increasePay = (int percent) -> {
   		   if(percent > Payable.INCREASE_CAP){
   			   System.out.println(" Sorry, can't increase hourly rate by more than " + 
   					   Payable.INCREASE_CAP + "%. " + getName()); 
   			   return false;
   		   } else {
   			   System.out.println("Increasing hourly rate by " + percent + 
   					   "%."  + getName()); 
   			   return true;
   		   }
   	   };	
    }
}

class Person {
	private String name;
	Payable increasePay = (int percent) -> {
		System.out.println("This person cannot be paid. " + getName());
		return false;
		};
	
	public Person(String name){
		this.name=name;
	}

	public String getName(){
		return "Person's name is " + name; 
	}
}


