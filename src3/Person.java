public abstract class Person {
    // Attributes
    private String firstName;
    private String lastName;
    private Password password;
    private String schedule; // Optional schedule representation

    // Constructors
    public Person(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Person(String firstName, String lastName, Password password) {
        this(firstName, lastName);
        this.setPassword(password);
    }

    public Person() {
        // Default constructor
    }

    // Abstract method for viewing the schedule (to be implemented by subclasses)
    public abstract void viewSchedule();

    // Getters and Setters with validation
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty.");
        }
        this.lastName = lastName;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null.");
        }
        this.password = password;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        if (schedule == null || schedule.trim().isEmpty()) {
            this.schedule = "No schedule available.";
        } else {
            this.schedule = schedule;
        }
    }

    // Utility method to display full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Method to display basic information
    public void displayInfo() {
        System.out.println("Name: " + getFullName());
        System.out.println("Schedule: " + (schedule != null ? schedule : "No schedule available."));
    }
}
