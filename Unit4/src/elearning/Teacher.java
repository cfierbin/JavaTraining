package elearning;

public class Teacher extends User{

	public Teacher(String string) {
		setUsername(string);
	}

	@Override
	public void enroll(Course course) {	
		System.out.println("Enrolling teacher "+ getUsername() + " to course \"" + course.getName() +"\"");
		course.setNumberOfParticipants((short) (course.getNumberOfParticipants()+1));
		UserRights newParticipant = new UserRights(this, true, true, false);
		course.getParticipants()[course.getNumberOfParticipants()-1] = newParticipant;
	}

}
