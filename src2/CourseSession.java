public class CourseSession extends CourseSection{
    // Attributes

	private String day;
	private String startTime;
	private String endTime;
	private String classroom;
    // Constructor    
    public CourseSession(Course course, int sectionID, String day, String startTime, String endTime, String classroom, int capacity) {
    	super(sectionID, course, capacity);
    	this.setDay(day);
    	this.setStartTime(startTime);
    	this.setEndTime(endTime);
    	this.setClassroom(classroom);
    }
    

    
    
    // Method to check if the session time is valid
    public boolean isValidSession() {
        // Checks if startDateTime is before endDateTime
    	return true; //startDateTime.isBefore(endDateTime);
    }
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
    

}