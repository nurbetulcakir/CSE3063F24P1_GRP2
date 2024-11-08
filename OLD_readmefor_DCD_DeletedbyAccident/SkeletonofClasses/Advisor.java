import java.util.ArrayList;
import java.util.List;

public abstract class Advisor extends Person {
    // Attributes
    private List<Student> assignedStudents;
    private List<Student> awaitingStudents;

    // Constructor
    public Advisor(ID personID, Password password, String firstName, String secondName, 
                   CourseRegistrationSystem courseRegistrationSystem) {
        super(personID, password, firstName, secondName, courseRegistrationSystem);
        this.assignedStudents = new ArrayList<>(); // Start as an empty list
        this.awaitingStudents = new ArrayList<>(); // Start as an empty list
    }

    // Methods
    public List<Student> viewAssignedStudents() {
        // Returns the list of assigned students.
        return assignedStudents;
    }

    public List<Student> viewAwaitingStudents() {
        // Returns the list of students awaiting approval.
        return awaitingStudents;
    }

    @Override
    public abstract boolean login(String personID, Password password);

    @Override
    public abstract void logout();

    // Getters for assigned and awaiting students
    public List<Student> getAssignedStudents() {
        return assignedStudents;
    }

    public List<Student> getAwaitingStudents() {
        return awaitingStudents;
    }
}
    