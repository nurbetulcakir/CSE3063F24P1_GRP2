import java.util.ArrayList;

public class CourseSection extends Course {

    // Attributes
    private int sectionID;
    private Course course; // Composition relationship with Course
    private ArrayList<Student> enrolledStudents = new ArrayList<>();
    private int capacity;
    private String day;
    private String startTime;
    private String endTime;
    private String classroom;
    private ArrayList<CourseSession> courseSessions = new ArrayList<>();

    // Constructors
    public CourseSection(int sectionID, Course course, int capacity, String day, String startTime, String endTime, String classroom) {
        super(course.getCourseID(), course.getCourseName());
        this.sectionID = sectionID;
        this.course = course;
        this.capacity = capacity;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.classroom = classroom;
    }

    public CourseSection(int sectionID, Course course, int capacity) {
        this(sectionID, course, capacity, null, null, null, null);
    }

    public CourseSection(int sectionID, Course course, int capacity, ArrayList<CourseSession> courseSessions) {
        this(sectionID, course, capacity);
        this.courseSessions = courseSessions != null ? courseSessions : new ArrayList<>();
    }

    public CourseSection() {
        super();
    }

    // Method to check if the section time is valid
    public boolean isValidSection() {
        // Placeholder for validation logic
        // For example: Ensure start time is before end time
        return startTime != null && endTime != null && startTime.compareTo(endTime) < 0;
    }

    // Methods to manage enrolled students
    public void enrollStudent(Student student) {
        if (student != null && enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
        } else {
            System.out.println("Enrollment failed: Section is full or invalid student.");
        }
    }

    // Getters and Setters
    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents); // Return a copy to maintain encapsulation
    }

    public void setEnrolledStudents(ArrayList<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents != null ? enrolledStudents : new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity >= 0) {
            this.capacity = capacity;
        } else {
            System.out.println("Invalid capacity value.");
        }
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public ArrayList<CourseSession> getCourseSessions() {
        return new ArrayList<>(courseSessions); // Return a copy for encapsulation
    }

    public void setCourseSessions(ArrayList<CourseSession> courseSessions) {
        this.courseSessions = courseSessions != null ? courseSessions : new ArrayList<>();
    }
}
