// In UserInterface.java or a new class for authentication
public class LoginManager {
    // Student login
    public static Student loginStudent(String studentID, String password) {
        for (Student student : ObjectCreator.students) {
            if (student.getStudentID().getId().equals(studentID) && student.getPassword().getPassword().equals(password)) {
                return student;
            }
        }
        return null; // Invalid credentials
    }

    // Advisor login
    public static Advisor loginAdvisor(String lecturerID, String password) {
        for (Advisor advisor : ObjectCreator.advisors) {
            if (advisor.getLecturerID().getId().equals(lecturerID) && advisor.getPassword().getPassword().equals(password)) {
                return advisor;
            }
        }
        return null; // Invalid credentials
    }
}
