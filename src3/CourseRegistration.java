public class CourseRegistration {

    public static boolean registerStudentForCourse(Student student, CourseSection section) {
        if (student == null || section == null) {
            System.out.println("Invalid input: student or course section is null.");
            return false;
        }

        // Check if the course section is already full
        if (section.getCapacity() <= 0) {
            System.out.println("Course section is full!");
            return false;
        }

        // Check for time conflicts with the student's existing schedule
        if (hasTimeConflict(student, section)) {
            System.out.println("Time conflict detected with your existing schedule.");
            return false;
        }

        // Register student for the section
        section.enrollStudent(student);
        student.addChosenCourse(section); // Add to student's chosen courses
        section.setCapacity(section.getCapacity() - 1); // Decrease the available seats

        System.out.println("Successfully registered for " + section.getCourse().getCourseName());
        return true;
    }

    private static boolean hasTimeConflict(Student student, CourseSection section) {
        if (student.getChosenCourses() == null || section.getCourseSessions() == null) {
            return false; // No conflicts if student or section has no sessions
        }

        for (CourseSection registeredSection : student.getChosenCourses()) {
            if (registeredSection.getCourseSessions() == null) {
                continue; // Skip sections with no sessions
            }
            for (CourseSession session : section.getCourseSessions()) {
                for (CourseSession registeredSession : registeredSection.getCourseSessions()) {
                    // Check for overlapping days and times
                    if (session.getDay().equals(registeredSession.getDay()) &&
                        session.getStartTime().equals(registeredSession.getStartTime())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
