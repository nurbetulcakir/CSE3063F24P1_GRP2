public class Notification {
    private String message;
    private String date;
    private boolean isRead;

    // Constructor
    public Notification(String message, String date) {
        this.message = message;
        this.date = date;
        this.setRead(false);  // Default is unread
    }

    // Getter and setter methods
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

	public boolean isRead() {
		return isRead;
	}
	
	public void markAsRead() {
		
		isRead = true;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}


}