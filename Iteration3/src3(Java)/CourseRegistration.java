public class CourseRegistration {

    // Register a student for a course section
    public static boolean registerStudentForCourse(Student student, CourseSection section) {
        // Check if the course is already full
        if (section.getCapacity() <= 0) {
            System.out.println("Course section is full!");
            return false;
        }

        // Check for time conflicts with existing courses
        if (hasTimeConflict(student, section)) {
            System.out.println("Time conflict detected with your existing schedule.");
            return false;
        }

        // Register student for the section
        section.enrollStudent(student);
        student.addChosenCourse(section);  // Add to student's chosen courses
        section.setCapacity(section.getCapacity() - 1);  // Decrease the available seats

        System.out.println("Successfully registered for " + section.getCourse().getCourseName());
        return true;
    }

    // Check if there is a time conflict with student's existing courses
    private static boolean hasTimeConflict(Student student, CourseSection section) {
        for (CourseSection registeredSection : student.getChosenCourses()) {
            for (CourseSession session : section.getCourseSessions()) {
                for (CourseSession registeredSession : registeredSection.getCourseSessions()) {
                    // Check if session times overlap
                    if (session.getDay().equals(registeredSession.getDay()) &&
                        session.getStartTime().equals(registeredSession.getStartTime())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
