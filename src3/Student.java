import java.util.ArrayList;

public class Student extends Person {
    // Attributes
    private ID studentID;
    private Advisor advisor;
    private Transcript transcript;
    private int term;
    private ArrayList<CourseSection> chosenCourses = new ArrayList<>();
    private ArrayList<CourseSection> approvedCourses = new ArrayList<>();
    private int approveRequest = 0; // 0: not sent, 1: sent, 2: approved, 3: disapproved
    private ArrayList<String> unreadNotifications = new ArrayList<>();
    private ArrayList<String> readNotifications = new ArrayList<>();
    private ArrayList<Notification> notifications = new ArrayList<>();

    // Constructor
    public Student(ID studentID, String firstName, String lastName, Password password, Advisor advisor, int term) {
        super(firstName, lastName, password);
        this.studentID = studentID;
        this.advisor = advisor;
        this.term = term;
    }

    public Student(ID studentID, String firstName, String lastName, Password password, Advisor advisor, int term,
                   ArrayList<CourseSection> chosenCourses, ArrayList<CourseSection> approvedCourses) {
        super(firstName, lastName, password);
        this.studentID = studentID;
        this.advisor = advisor;
        this.term = term;
        this.chosenCourses = chosenCourses != null ? chosenCourses : new ArrayList<>();
        this.approvedCourses = approvedCourses != null ? approvedCourses : new ArrayList<>();
    }

    public Student(ID studentID) {
        this.studentID = studentID;
    }

    // Methods for managing chosen courses
    public void addChosenCourse(CourseSection cs) {
        if (cs != null) {
            chosenCourses.add(cs);
        } else {
            System.out.println("Invalid course section.");
        }
    }

    public void removeChosenCourse(CourseSection cs) {
        if (cs != null && chosenCourses.contains(cs)) {
            chosenCourses.remove(cs);
        } else {
            System.out.println("Course section not found in chosen courses.");
        }
    }

    public void addToApprovedCourses(CourseSection cs) {
        if (cs != null) {
            approvedCourses.add(cs);
        } else {
            System.out.println("Invalid course section.");
        }
    }

    // View schedule
    public void viewSchedule() {
        System.out.println("Schedule for " + getFirstName() + " " + getLastName() + ":");
        if (chosenCourses.isEmpty()) {
            System.out.println("No courses selected.");
            return;
        }
        for (CourseSection section : chosenCourses) {
            if (section.getCourseSessions() != null) {
                for (CourseSession session : section.getCourseSessions()) {
                    System.out.println(section.getCourse().getCourseName() + " - " + session.getDay() + " " +
                            session.getStartTime() + " - " + session.getEndTime());
                }
            } else {
                System.out.println(section.getCourse().getCourseName() + " - No scheduled sessions.");
            }
        }
    }

    // Notification methods
    public void addNotification(String message) {
        if (message != null && !message.trim().isEmpty()) {
            unreadNotifications.add(message);
        } else {
            System.out.println("Invalid notification message.");
        }
    }

    public void markNotificationsAsRead() {
        readNotifications.addAll(unreadNotifications);
        unreadNotifications.clear();
    }

    public void addNotification(Notification notification) {
        if (notification != null) {
            notifications.add(notification);
        } else {
            System.out.println("Invalid notification.");
        }
    }

    // Request approval
    public void sendForApproval() {
        this.approveRequest = 1;
        if (advisor == null) {
            System.out.println("No advisor assigned. Please contact the administration.");
            return;
        }
        if (advisor.getAwaitingStudents() == null) {
            advisor.setAwaitingStudents(new ArrayList<>());
        }
        advisor.getAwaitingStudents().add(this);
        advisor.addNotification(getFirstName() + " " + getLastName() + " is waiting for your registration approval.");
    }

    // Getters and Setters
    public ID getStudentID() {
        return studentID;
    }

    public void setStudentID(ID studentID) {
        this.studentID = studentID;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public ArrayList<CourseSection> getChosenCourses() {
        return new ArrayList<>(chosenCourses);
    }

    public void setChosenCourses(ArrayList<CourseSection> chosenCourses) {
        this.chosenCourses = chosenCourses != null ? chosenCourses : new ArrayList<>();
    }

    public ArrayList<CourseSection> getApprovedCourses() {
        return new ArrayList<>(approvedCourses);
    }

    public void setApprovedCourses(ArrayList<CourseSection> approvedCourses) {
        this.approvedCourses = approvedCourses != null ? approvedCourses : new ArrayList<>();
    }

    public int getApproveRequest() {
        return approveRequest;
    }

    public void setApproveRequest(int approveRequest) {
        this.approveRequest = approveRequest;
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public void setTranscript(Transcript transcript) {
        this.transcript = transcript;
    }

    public ArrayList<String> getUnreadNotifications() {
        return new ArrayList<>(unreadNotifications);
    }

    public void setUnreadNotifications(ArrayList<String> unreadNotifications) {
        this.unreadNotifications = unreadNotifications != null ? unreadNotifications : new ArrayList<>();
    }

    public ArrayList<String> getReadNotifications() {
        return new ArrayList<>(readNotifications);
    }

    public void setReadNotifications(ArrayList<String> readNotifications) {
        this.readNotifications = readNotifications != null ? readNotifications : new ArrayList<>();
    }

    public ArrayList<Notification> getNotifications() {
        return new ArrayList<>(notifications);
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications != null ? notifications : new ArrayList<>();
    }
}
