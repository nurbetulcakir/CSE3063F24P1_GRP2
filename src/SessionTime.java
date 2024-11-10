//import java.time.LocalDateTime;
//
//public class SessionTime {
//    // Attributes
//    private LocalDateTime startDateTime;
//    private LocalDateTime endDateTime;
//    private String classroom;
//
//    // Constructor
//    public SessionTime(LocalDateTime startDateTime, LocalDateTime endDateTime, String classroom) {
//        super();
//    	this.startDateTime = startDateTime;
//        this.endDateTime = endDateTime;
//        this.setClassroom(classroom);
//    }
//
//    // Method to check if the session time is valid
//    public boolean isValidSession() {
//        // Checks if startDateTime is before endDateTime
//        return startDateTime.isBefore(endDateTime);
//    }
//
//	public String getClassroom() {
//		return classroom;
//	}
//
//	public void setClassroom(String classroom) {
//		this.classroom = classroom;
//	}
//
//}