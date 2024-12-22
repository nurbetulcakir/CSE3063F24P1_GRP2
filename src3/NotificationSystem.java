import java.util.List;

public class NotificationSystem {

    public static void sendStudentNotification(Student student, String message) {
        if (student != null && message != null && !message.trim().isEmpty()) {
            student.addNotification(message); // Add to student's unread notifications
            System.out.println("Notification sent to " + student.getFirstName() + ": " + message);
        } else {
            System.out.println("Failed to send notification: Invalid student or message.");
        }
    }


    public static void sendAdvisorNotification(Advisor advisor, Notification message) {
        if (advisor != null && message != null && !message.toString().trim().isEmpty()) {
            advisor.addNotification(message); // Add to advisor's unread notifications
            System.out.println("Notification sent to " + advisor.getFirstName());
        } else {
            System.out.println("Failed to send notification: Invalid advisor or message.");
        }
    }
    
	public static void sendAdvisorNotification(Advisor advisor, String message) {
        if (advisor != null && message != null && !message.toString().trim().isEmpty()) {
            advisor.addNotification(message.toString()); // Add to advisor's unread notifications
            System.out.println("Notification sent to " + advisor.getFirstName());
        } else {
            System.out.println("Failed to send notification: Invalid advisor or message.");
        }
		
	}

    public static void viewStudentNotifications(Student student) {
        if (student != null) {
            List<String> unreadNotifications = student.getUnreadNotifications();
            if (unreadNotifications.isEmpty()) {
                System.out.println("No unread notifications for " + student.getFirstName() + ".");
            } else {
                System.out.println("Unread Notifications for " + student.getFirstName() + ":");
                for (String notification : unreadNotifications) {
                    System.out.println("- " + notification);
                }
            }
        } else {
            System.out.println("Invalid student.");
        }
    }

    public static void viewAdvisorNotifications(Advisor advisor) {
        if (advisor != null) {
            List<String> unreadNotifications = advisor.getUnreadNotifications();
            if (unreadNotifications.isEmpty()) {
                System.out.println("No unread notifications for " + advisor.getFirstName() + ".");
            } else {
                System.out.println("Unread Notifications for " + advisor.getFirstName() + ":");
                for (String notification : unreadNotifications) {
                    System.out.println("- " + notification);
                }
            }
        } else {
            System.out.println("Invalid advisor.");
        }
    }

    public static void markStudentNotificationsAsRead(Student student) {
        if (student != null) {
            student.setNotifications(null);
            System.out.println("All notifications for " + student.getFirstName() + " are marked as read.");
        } else {
            System.out.println("Invalid student.");
        }
    }

    public static void markAdvisorNotificationsAsRead(Advisor advisor) {
        if (advisor != null) {
            advisor.notificationsSeen();
            System.out.println("All notifications for " + advisor.getFirstName() + " are marked as read.");
        } else {
            System.out.println("Invalid advisor.");
        }
    }


}
