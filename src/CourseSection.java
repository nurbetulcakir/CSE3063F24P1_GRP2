
public class CourseSection extends Course{
	
	private int sectionID;
	private int sectionHour;
	
	public CourseSection(int courseID, String courseName, Lecturer lecturer, int courseHour, int courseCredit, int sectionID, int sectionHour) {
		super(courseID, courseName, lecturer, courseHour, courseCredit);
		this.sectionID = sectionID;
		this.sectionHour = sectionHour;
	}

	public int getSectionID() {
		return sectionID;
	}

	public void setSectionID(int sectionID) {
		this.sectionID = sectionID;
	}

	public int getSectionHour() {
		return sectionHour;
	}

	public void setSectionHour(int sectionHour) {
		this.sectionHour = sectionHour;
	}

	
}
