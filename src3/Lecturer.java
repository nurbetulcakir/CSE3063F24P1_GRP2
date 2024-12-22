import java.util.ArrayList;

public class Lecturer extends Person {
    private ID lecturerID;                         // Unique ID for the lecturer
    private ArrayList<Course> givenCourses;        // List of courses assigned to the lecturer

    // Constructor with all attributes
    public Lecturer(ID lecturerID, String firstName, String lastName, ArrayList<Course> givenCourses) {
        super(firstName, lastName);
        this.lecturerID = lecturerID;
        this.givenCourses = givenCourses != null ? givenCourses : new ArrayList<>();
    }

    // Constructor with basic attributes (without courses)
    public Lecturer(ID lecturerID, String firstName, String lastName) {
        super(firstName, lastName);
        this.lecturerID = lecturerID;
        this.givenCourses = new ArrayList<>();
    }

    // Constructor with only lecturer ID
    public Lecturer(ID lecturerID) {
        this.lecturerID = lecturerID;
        this.givenCourses = new ArrayList<>();
    }

    @Override
    public void viewSchedule() {
        System.out.println("Lecturer ID: " + this.lecturerID);
        System.out.println("Lecturer Name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("Assigned Courses:");

        if (givenCourses.isEmpty()) {
            System.out.println("No courses assigned to this lecturer.");
        } else {
            for (Course course : givenCourses) {
                System.out.println(" - " + course.getCourseName() + " (Course ID: " + course.getCourseID() + ")");
            }
        }
    }

    // Getters and Setters
    public ID getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(ID lecturerID) {
        this.lecturerID = lecturerID;
    }

    public ArrayList<Course> getGivenCourses() {
        return new ArrayList<>(givenCourses); // Return a copy for encapsulation
    }

    public void setGivenCourses(ArrayList<Course> givenCourses) {
        this.givenCourses = givenCourses != null ? givenCourses : new ArrayList<>();
    }

    public void addGivenCourse(Course course) {
        if (course != null) {
            givenCourses.add(course);
        } else {
            System.out.println("Invalid course. Cannot add to given courses.");
        }
    }

    public void removeGivenCourse(Course course) {
        if (givenCourses.remove(course)) {
            System.out.println("Course removed successfully.");
        } else {
            System.out.println("Course not found in the list.");
        }
    }
}
