import java.util.ArrayList;

public class Course {
    // Attributes
    private ID courseID;
    private String courseName;
    private ArrayList<Course> prerequisiteCourses = new ArrayList<>();
    private ArrayList<CourseSection> courseSections = new ArrayList<>();
    private int courseTerm;
    private double courseCredit;
    private String courseLetterGrade;

    // Constructors
    public Course(ID courseID, String courseName, int courseTerm, double courseCredit, String courseLetterGrade, ArrayList<Course> prerequisiteCourses) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseTerm = courseTerm;
        this.courseCredit = courseCredit;
        this.courseLetterGrade = courseLetterGrade;
        this.prerequisiteCourses = prerequisiteCourses != null ? prerequisiteCourses : new ArrayList<>();
    }

    public Course(ID courseID, String courseName, int courseTerm, double courseCredit, ArrayList<Course> prerequisiteCourses) {
        this(courseID, courseName, courseTerm, courseCredit, null, prerequisiteCourses);
    }

    public Course(ID courseID, String courseName, ArrayList<Course> prerequisiteCourses) {
        this(courseID, courseName, 0, 0.0, null, prerequisiteCourses);
    }

    public Course(ID courseID, String courseName) {
        this(courseID, courseName, 0, 0.0, null, null);
    }

    public Course() {
        // Default constructor
    }

    // Methods
    // Add a prerequisite course to the list
    public void addPrerequisiteCourse(Course course) {
        if (course != null) {
            this.prerequisiteCourses.add(course);
        }
    }

    // View all prerequisite courses
    public ArrayList<Course> viewPrerequisiteCourses() {
        return new ArrayList<>(this.prerequisiteCourses); // Return a copy for encapsulation
    }

    // Add a course section
    public void addCourseSection(CourseSection courseSection) {
        if (courseSection != null) {
            this.courseSections.add(courseSection);
        }
    }

    // View all course sections
    public ArrayList<CourseSection> viewCourseSections() {
        return new ArrayList<>(this.courseSections); // Return a copy for encapsulation
    }

    // Getters and Setters
    public ID getCourseID() {
        return courseID;
    }

    public void setCourseID(ID courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(int courseTerm) {
        this.courseTerm = courseTerm;
    }

    public double getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(double courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCourseLetterGrade() {
        return courseLetterGrade;
    }

    public void setCourseLetterGrade(String courseLetterGrade) {
        this.courseLetterGrade = courseLetterGrade;
    }

    public ArrayList<Course> getPrerequisiteCourses() {
        return new ArrayList<>(this.prerequisiteCourses); // Return a copy for encapsulation
    }

    public void setPrerequisiteCourses(ArrayList<Course> prerequisiteCourses) {
        this.prerequisiteCourses = prerequisiteCourses != null ? prerequisiteCourses : new ArrayList<>();
    }

    public ArrayList<CourseSection> getCourseSections() {
        return new ArrayList<>(this.courseSections); // Return a copy for encapsulation
    }

    public void setCourseSections(ArrayList<CourseSection> courseSections) {
        this.courseSections = courseSections != null ? courseSections : new ArrayList<>();
    }
}
