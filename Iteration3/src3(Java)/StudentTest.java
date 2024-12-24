//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//
//public class StudentTest {
//
//    private Student student;
//    private Course course1, course2;
//    private CourseSection section1, section2;
//    private Advisor advisor;
//    
//    @BeforeEach
//    public void setup() {
//        // Create a sample advisor
//        advisor = new Advisor("John", "Doe", new Password("advisor123"));
//        
//        // Create some sample courses
//        course1 = new Course(new ID("CSE101"), "Intro to Programming");
//        course2 = new Course(new ID("CSE102"), "Data Structures");
//        
//        // Create CourseSections for the student to choose
//        section1 = new CourseSection(1, course1, 30);
//        section2 = new CourseSection(2, course2, 30);
//
//        // Create a Student with passed courses
//        ArrayList<Course> passedCourses = new ArrayList<>();
//        passedCourses.add(course1);
//        student = new Student(new ID("S123"), "Alice", "Smith", new Password("password123"), advisor, 1, passedCourses);
//    }
//
//    @Test
//    public void testStudentCreation() {
//        assertNotNull(student);
//        assertEquals("Alice", student.getFirstName());
//        assertEquals("Smith", student.getLastName());
//        assertEquals("S123", student.getStudentID().getId());
//    }
//
//    @Test
//    public void testIsPrerequisiteCoursesPassed() {
//        // Add prerequisites to a course
//        course2.addPrerequisiteCourse(course1);
//        
//        // Test if student passed prerequisite
//        assertTrue(student.isPrerequisiteCoursesPassed(course2));
//
//        // Create a course that has not been passed by the student
//        Course course3 = new Course(new ID("CSE103"), "Algorithms");
//        
//        // Test if student passed prerequisite
//        assertFalse(student.isPrerequisiteCoursesPassed(course3));
//    }
//
//    @Test
//    public void testViewAdvisor() {
//        // Set an advisor to the student
//        student.setAdvisor(advisor);
//        
//        // Test if advisor's details are correct
//        student.viewAdvisor();
//        // The test here would normally verify output, but since it's printed, we assume
//        // a manual check or mocking framework (like Mockito) would verify the actual output.
//    }
//
//    @Test
//    public void testViewSchedule() {
//        ArrayList<CourseSection> chosenCourses = new ArrayList<>();
//        chosenCourses.add(section1);
//        chosenCourses.add(section2);
//        student.setChosenCourses(chosenCourses);
//        
//        // Test if the student can view the schedule
//        student.viewSchedule();
//        // This will print the schedule. Again, manual verification or mocking would be used.
//    }
//
//    @Test
//    public void testSetAdvisor() {
//        Advisor newAdvisor = new Advisor("Jane", "Smith", new Password("advisor456"));
//        student.setAdvisor(newAdvisor);
//        
//        // Verify if advisor has been set correctly
//        assertEquals("Jane", student.getAdvisor().getFirstName());
//        assertEquals("Smith", student.getAdvisor().getLastName());
//    }
//    
//    @Test
//    public void testSetCourses() {
//        ArrayList<CourseSection> chosenCourses = new ArrayList<>();
//        chosenCourses.add(section1);
//        chosenCourses.add(section2);
//        
//        student.setChosenCourses(chosenCourses);
//        
//        // Verify if the chosen courses are set correctly
//        assertEquals(2, student.getChosenCourses().size());
//        assertEquals(course1, student.getChosenCourses().get(0).getCourse());
//    }
//    
//    @Test
//    public void testAddPassedCourse() {
//        // Test adding a passed course to the student
//        Course course3 = new Course(new ID("CSE103"), "Algorithms");
//        student.getPassedCourses().add(course3);
//        
//        // Verify if the course is added
//        assertTrue(student.getPassedCourses().contains(course3));
//    }
//}
//
