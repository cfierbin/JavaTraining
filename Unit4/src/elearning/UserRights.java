package elearning;

public class UserRights {

	User user;

	boolean canView;
	boolean canEdit;
	boolean canDelete;
	
	public UserRights(User u, boolean v, boolean e, boolean d){
		user = u;
		canView = v;
		canEdit = e;
		canDelete = d;
	}
}
