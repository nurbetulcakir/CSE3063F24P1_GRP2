
public class LoginManager {

    public static Student loginStudent(String studentID, String password) {
        return (Student) authenticate(ObjectCreator.students, studentID, password);
    }

    public static Advisor loginAdvisor(String lecturerID, String password) {
        return (Advisor) authenticate(ObjectCreator.advisors, lecturerID, password);
    }

    private static Object authenticate(Iterable<?> users, String userID, String password) {
        for (Object user : users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                if (student.getStudentID().getId().equals(userID) && student.getPassword().getPassword().equals(password)) {
                    return student;
                }
            } else if (user instanceof Advisor) {
                Advisor advisor = (Advisor) user;
                if (advisor.getLecturerID().getId().equals(userID) && advisor.getPassword().getPassword().equals(password)) {
                    return advisor;
                }
            }
        }
        return null; 
    }
}
