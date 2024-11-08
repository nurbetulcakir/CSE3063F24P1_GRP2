
public abstract class Person {

	private ID PersonID;
	private Password password;
	private String firstName;
	private String secondName;
	public CourseRegistrationSystem courseRegistrationSystem;
	
	public Person(ID personID, Password password, String firstName, String secondName, CourseRegistrationSystem courseRegistrationSystem) {
		

	}
	
	public abstract boolean login(String personID, Password password);
	
	public abstract void logout();
}
	
	
