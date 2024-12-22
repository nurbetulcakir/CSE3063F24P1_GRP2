import java.util.ArrayList;

public class Advisor extends Lecturer {

    // Attributes
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Student> awaitingStudents = new ArrayList<>();
    private Student advStudent;
    private ArrayList<String> unreadNotifications = new ArrayList<>();
    private ArrayList<CourseSection> approvedCourses = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();
    private ArrayList<String> readNotifications = new ArrayList<>();

    // Constructor
    public Advisor(ID lecturerID, String firstName, String lastName, Password password, ArrayList<Student> studentList, ArrayList<Student> awaitingStudents) {
        super(lecturerID, firstName, lastName);
        this.setStudentList(studentList);
        this.setAwaitingStudents(awaitingStudents != null ? awaitingStudents : new ArrayList<>());
    }

    public Advisor(ID lecturerID) {
        super(lecturerID);
    }

    // Add a course to the approved list
    public void addToApprovedCourses(CourseSection courseSection) {
        if (courseSection != null) {
            this.approvedCourses.add(courseSection);
        }
    }

    // Display all students assigned to this advisor
    public void viewStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("No students assigned to this advisor.");
            return;
        }

        for (Student student : studentList) {
            System.out.println("ID: " + student.getStudentID().getId());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName() + "\n");
        }
    }

    // Select the next student from the awaiting list
    public void selectNextStudent(int index) {
        if (index < 1 || index > awaitingStudents.size()) {
            System.out.println("Invalid index. Please select a valid student.");
            return;
        }
        this.setAdvStudent(awaitingStudents.get(index - 1));
    }

    // Find students who are awaiting approval
    public void findAwaitingStudents() {
        for (Student student : studentList) {
            if (!awaitingStudents.contains(student) && student.getApproveRequest() == 1) {
                awaitingStudents.add(student);
            }
        }
    }

    // Remove a student from the awaiting list
    private void removeAwaitingStudent(Student student) {
        if (student != null) {
            awaitingStudents.remove(student);
        }
    }

    // Approve the courses selected by the advisor's current student
    public void approveCourses() {
        if (advStudent == null) {
            System.out.println("No student selected for approval.");
            return;
        }

        ArrayList<CourseSection> chosenCourses = advStudent.getChosenCourses();
        if (chosenCourses == null || chosenCourses.isEmpty()) {
            System.out.println("No courses to approve for the selected student.");
            return;
        }

        for (CourseSection courseSection : chosenCourses) {
            advStudent.addToApprovedCourses(courseSection);
            courseSection.enrollStudent(advStudent);
        }

        finalizeApproval(2);
    }

    // Disapprove the courses selected by the advisor's current student
    public void disapproveCourses() {
        if (advStudent == null) {
            System.out.println("No student selected for disapproval.");
            return;
        }

        ArrayList<CourseSection> chosenCourses = advStudent.getChosenCourses();
        if (chosenCourses != null) {
            for (CourseSection courseSection : chosenCourses) {
                courseSection.setCapacity(courseSection.getCapacity() + 1);
            }
        }

        finalizeApproval(3);
    }

    // Finalize the course approval process
    private void finalizeApproval(int approvalStatus) {
        advStudent.setChosenCourses(null);
        advStudent.setApproveRequest(approvalStatus);
        removeAwaitingStudent(advStudent);
        sendNotification("", approvalStatus);
        setAdvStudent(null);
    }

    // Add a notification to the advisor
    public void addNotification(Notification message) {
        if (message != null) {
            notifications.add(message);
        }
    }

    // Send a notification to the current student
    public void sendNotification(String message, int req) {
        if (advStudent == null) {
            System.out.println("No student selected for sending notifications.");
            return;
        }

        String sendMessage = message.isEmpty() 
            ? (req == 2 ? "The request is approved!" : "The request is disapproved!") 
            : message;

        advStudent.addNotification(sendMessage);
    }

    // Mark all notifications as read
    public void notificationsSeen() {
        readNotifications.addAll(unreadNotifications);
        unreadNotifications.clear();
    }

    // Getters and Setters
    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList != null ? studentList : new ArrayList<>();
    }

    public ArrayList<Student> getAwaitingStudents() {
        return awaitingStudents;
    }

    public void setAwaitingStudents(ArrayList<Student> awaitingStudents) {
        this.awaitingStudents = awaitingStudents != null ? awaitingStudents : new ArrayList<>();
    }

    public Student getAdvStudent() {
        return advStudent;
    }

    public void setAdvStudent(Student advStudent) {
        this.advStudent = advStudent;
    }

    public ArrayList<String> getUnreadNotifications() {
        return unreadNotifications;
    }

    public void setUnreadNotifications(ArrayList<String> unreadNotifications) {
        this.unreadNotifications = unreadNotifications;
    }

    public ArrayList<String> getReadNotifications() {
        return readNotifications;
    }

    public void setReadNotifications(ArrayList<String> readNotifications) {
        this.readNotifications = readNotifications;
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications != null ? notifications : new ArrayList<>();
    }
}
