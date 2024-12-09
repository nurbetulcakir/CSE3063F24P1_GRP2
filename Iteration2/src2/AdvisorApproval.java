public class AdvisorApproval {

    // Approve courses for a student
    public static void approveCourses(Advisor advisor, Student student) {
        // Iterate through the student's chosen courses
        for (CourseSection section : student.getChosenCourses()) {
            if (section.getCapacity() > 0) {
                advisor.addToApprovedCourses(section);
                section.enrollStudent(student);  // Enroll the student in the course
                section.setCapacity(section.getCapacity() - 1);  // Decrease capacity
                System.out.println("Course approved: " + section.getCourse().getCourseName());
            } else {
                System.out.println("Course " + section.getCourse().getCourseName() + " is full.");
            }
        }
        // Update the student's approval request
        student.setApproveRequest(2);  // Approved status
    }
}
