package elearning;

public class Student extends User{

	public Student(String string) {
		setUsername(string);
	}

	@Override
	public void enroll(Course course) {
		System.out.println("Enrolling student " + getUsername() + " to course \"" + course.getName() + "\"");
		
	}

}
