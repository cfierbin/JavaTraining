package elearning;

public class Student extends User{

	public Student(String string) {
		username = string;
	}

	@Override
	public void enroll(Course course) {
		System.out.println("Enrolling student " + username + " to course \"" + course.name + "\"");
		
	}

}
