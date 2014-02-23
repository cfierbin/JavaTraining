package elearning;

public abstract class User {

	private String username;
	private String name;
	private short age;
	private String emailAddress;
	
	public boolean login(){
		System.out.println("Welcome " + username + "!");
		return true;
	}

	public boolean logout(){
		System.out.println("Bye " + username + "!");
		return true;
	}
	
	public abstract void enroll(Course course);

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}
}
