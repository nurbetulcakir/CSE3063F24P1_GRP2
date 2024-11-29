public abstract class Person {
    // Attributes
    private String firstName;
    private String lastName;
    private Password password;
    private String schedule;
    // Constructor
    
    public Person(String firstName, String lastName, Password password, String schedule) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    	this.setPassword(password);
    	this.setSchedule(schedule);
    }
    
    public Person(String firstName, String lastName, Password password) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    	this.setPassword(password);
    }
    
    public Person(String firstName, String lastName) {
    	this.setFirstName(firstName);
    	this.setLastName(lastName);
    }
    
    
    public abstract String viewSchedule();
    
    
    
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

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
}