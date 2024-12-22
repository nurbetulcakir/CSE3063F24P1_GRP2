public class AdvisorApproval {

    // Approve courses for a student
    public static void approveCourses(Advisor advisor, Student student) {
        // Check if the student has chosen courses
        if (student.getChosenCourses() == null || student.getChosenCourses().isEmpty()) {
            System.out.println("No courses to approve for this student.");
            return;
        }

        // Iterate through the student's chosen courses
        for (CourseSection section : student.getChosenCourses()) {
            if (section.getCapacity() > 0) {
                advisor.addToApprovedCourses(section);
                section.enrollStudent(student);  // Enroll the student in the course
                section.setCapacity(section.getCapacity() - 1);  // Decrease capacity
                System.out.println("Course approved: " + section.getCourse().getCourseName());
                // Notify the student
                student.addNotification("Course approved: " + section.getCourse().getCourseName());
            } else {
                System.out.println("Course " + section.getCourse().getCourseName() + " is full.");
                student.addNotification("Course " + section.getCourse().getCourseName() + " is full.");
            }
        }
        // Update the student's approval request
        student.setApproveRequest(2);  // Approved status
        student.addNotification("All course approvals have been processed.");
    }
}
