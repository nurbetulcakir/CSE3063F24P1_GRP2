public abstract class Person {
    // Attributes
    private ID personID;
    private Password password;
    private String firstName;
    private String secondName;
    private CourseRegistrationSystem courseRegistrationSystem;

    // Constructor
    public Person(ID personID, Password password, String firstName, String secondName, CourseRegistrationSystem courseRegistrationSystem) {
        this.personID = personID;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.courseRegistrationSystem = courseRegistrationSystem;
    }

    // Abstract methods
    public abstract boolean login(String personID, Password password);
    public abstract void logout();

    // Getters and Setters
    public ID getPersonID() {
        return personID;
    }

    public void setPersonID(ID personID) {
        this.personID = personID;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public CourseRegistrationSystem getCourseRegistrationSystem() {
        return courseRegistrationSystem;
    }

    public void setCourseRegistrationSystem(CourseRegistrationSystem courseRegistrationSystem) {
        this.courseRegistrationSystem = courseRegistrationSystem;
    }
}
