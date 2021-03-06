package elearning;

public class Course {
	
	private String name;
	private String shortName;
	private UserRights[] participants;
	private short numberOfParticipants;

	public Course(String courseName, String shortName, int participants) {
		setName(courseName);
		setShortName(shortName);
		this.participants = new UserRights[participants];
		setNumberOfParticipants((short) 0);
	}
	
	public void printParticipants(){
		System.out.println("\nParticipants to \"" + getName() + "\":");
		for (int i=0; i<numberOfParticipants; i++){
			System.out.println(participants[i].user.getUsername() +
			((participants[i].canView)?(" canView = true"):(" canView = false")) +
			((participants[i].canEdit)?(" canEdit = true"):(" canEdit = false")) + 
			((participants[i].canDelete)?(" canDelete = true"):(" canDelete = false")));
		}
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public UserRights[] getParticipants() {
		return participants;
	}

	public void setParticipants(UserRights[] participants) {
		this.participants = participants;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public short getNumberOfParticipants() {
		return numberOfParticipants;
	}

	public void setNumberOfParticipants(short numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}


}
