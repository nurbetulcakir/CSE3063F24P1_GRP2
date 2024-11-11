public abstract class Person {
    // Attributes
    private String firstName;
    private String lastName;
    private Password password;
    // Constructor
    public Person(String firstName, String lastName, Password password) {
    	super();
        this.setFirstName(firstName);
        this.setLastName(lastName);
    	this.setPassword(password);
    }
    
    public Person(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Password getPassword() {
		return password;
	}
	public void setPassword(Password password) {
		this.password = password;
	}
}