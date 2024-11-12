import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CourseTest {

    private Course course;
    private Course prerequisiteCourse;
    private ID courseID;
    private ID prerequisiteCourseID;

    @BeforeEach
    public void setup() {
        courseID = new ID("CSE101");
        course = new Course(courseID, "Introduction to Programming");

        prerequisiteCourseID = new ID("CSE102");
        prerequisiteCourse = new Course(prerequisiteCourseID, "Data Structures");
    }

    @Test
    public void testCourseCreation() {
        assertNotNull(course);
        assertEquals("Introduction to Programming", course.getCourseName());
        assertEquals("CSE101", course.getCourseID().getId());
    }

    @Test
    public void testAddPrerequisiteCourse() {
        course.addPrerequisiteCourse(prerequisiteCourse);
        assertTrue(course.viewPrerequisiteCourses().contains(prerequisiteCourse));
    }

    @Test
    public void testViewPrerequisiteCourses() {
        course.addPrerequisiteCourse(prerequisiteCourse);
        assertEquals(1, course.viewPrerequisiteCourses().size());
        Course additionalCourse = new Course(new ID("CSE103"), "Algorithms");
        course.addPrerequisiteCourse(additionalCourse);
        assertEquals(2, course.viewPrerequisiteCourses().size());
    }

    @Test
    public void testCourseSetterAndGetter() {
        course.setCourseName("Advanced Programming");
        assertEquals("Advanced Programming", course.getCourseName());
        course.setCourseID(new ID("CSE104"));
        assertEquals("CSE104", course.getCourseID().getId());
    }

    @Test
    public void testPrerequisiteCourses() {
        course.addPrerequisiteCourse(prerequisiteCourse);

        ArrayList<Course> prerequisites = course.viewPrerequisiteCourses();
        assertNotNull(prerequisites);
        assertTrue(prerequisites.contains(prerequisiteCourse));
    }

    @Test
    public void testCourseID() {
        assertEquals("CSE101", course.getCourseID().getId());

        ID newCourseID = new ID("CSE105");
        course.setCourseID(newCourseID);
        assertEquals("CSE105", course.getCourseID().getId());
    }
}

