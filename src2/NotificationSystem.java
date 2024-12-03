import java.util.ArrayList;

public class NotificationSystem {

    // Send notification to a student
    public static void sendStudentNotification(Student student, String message) {
        student.addNotification(message);  // Add to student's unread notifications
        System.out.println("Notification sent to " + student.getFirstName() + ": " + message);
    }

    // Send notification to an advisor
    public static void sendAdvisorNotification(Advisor advisor, String message) {
        advisor.addNotification(message);  // Add to advisor's unread notifications
        System.out.println("Notification sent to " + advisor.getFirstName() + ": " + message);
    }

    // View unread notifications for a student
    public static void viewStudentNotifications(Student student) {
        System.out.println("Unread Notifications for " + student.getFirstName() + ":");
        for (String notification : student.getUnreadNotifications()) {
            System.out.println(notification);
        }
    }

    // View unread notifications for an advisor
    public static void viewAdvisorNotifications(Advisor advisor) {
        System.out.println("Unread Notifications for " + advisor.getFirstName() + ":");
        for (String notification : advisor.getUnreadNotifications()) {
            System.out.println(notification);
        }
    }

    // Mark all notifications as read for a student
    public static void markStudentNotificationsAsRead(Student student) {
        student.notificationsSeen();
        System.out.println("All notifications for " + student.getFirstName() + " are marked as read.");
    }

    // Mark all notifications as read for an advisor
    public static void markAdvisorNotificationsAsRead(Advisor advisor) {
        advisor.notificationsSeen();
        System.out.println("All notifications for " + advisor.getFirstName() + " are marked as read.");
    }
}
