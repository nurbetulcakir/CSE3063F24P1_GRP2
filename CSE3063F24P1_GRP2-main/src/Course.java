import java.util.ArrayList;

public class Course {
    // Attributes
    private ID courseID;
    private String courseName;
    private ArrayList<Course> prerequisiteCourse;
    private int courseTerm;
    private double courseCredit;
    private String courseLetterGrade;

    // Constructor
    public Course(ID courseID, String courseName, ArrayList<Course> prerequisiteCourse, int courseTerm, double courseCredit, String courseLetterGrade) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.prerequisiteCourse = prerequisiteCourse != null ? prerequisiteCourse : new ArrayList<>();
        this.courseTerm = courseTerm;
        this.courseCredit = courseCredit;
        this.courseLetterGrade = courseLetterGrade;
    }

    // Constructor with empty prerequisiteCourse list
    public Course(ID courseID, String courseName) {
        this(courseID, courseName, new ArrayList<>(), 0, 0.0, "");  // Default values for courseTerm, courseCredit, and courseLetterGrade
    }

    // Method to add a prerequisite course
    public void addPrerequisiteCourse(Course course) {
        if (course != null && !this.prerequisiteCourse.contains(course)) {
            this.prerequisiteCourse.add(course);
        }
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

    public ArrayList<Course> viewPrerequisiteCourses() {
        return this.prerequisiteCourse;
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
}
