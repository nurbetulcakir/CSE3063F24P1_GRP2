public class Notification {
    private String message;   // Notification message
    private String date;      // Notification date (e.g., "YYYY-MM-DD")
    private boolean isRead;   // Read status of the notification

    // Constructor
    public Notification(String message, String date) {
        this.message = message != null ? message : "No message";  // Ensure non-null message
        this.date = date != null ? date : "Unknown date";          // Ensure non-null date
        this.isRead = false;                                      // Default is unread
    }

    // Getter and Setter methods
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message != null && !message.trim().isEmpty()) {
            this.message = message;
        } else {
            System.out.println("Invalid message. Cannot be empty or null.");
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()) {
            this.date = date;
        } else {
            System.out.println("Invalid date. Cannot be empty or null.");
        }
    }

    public boolean isRead() {
        return isRead;
    }

    // Mark the notification as read
    public void markAsRead() {
        this.isRead = true;
    }

    // Mark the notification as unread
    public void markAsUnread() {
        this.isRead = false;
    }

    // Display notification details
    public void displayNotification() {
        System.out.println("Message: " + message);
        System.out.println("Date: " + date);
        System.out.println("Status: " + (isRead ? "Read" : "Unread"));
    }
}
