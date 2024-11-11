import java.util.ArrayList;

public class ObjectCreator {
	 static ArrayList<Student> students;
     static ArrayList<Advisor> advisors;
     static ArrayList<Course> courses;
     static ArrayList<Transcript> transcripts;

	
	public void createObjects() {
		// File paths for the JSON files
        String studentFilePath = "students.json";
        String advisorFilePath = "advisors.json";
        String courseFilePath = "courses.json";
        String transcriptFilePath1 = "150121674.json";
        String transcriptFilePath2 = "150121675.json";
        String transcriptFilePath3 = "150121676.json";
        String transcriptFilePath4 = "150121677.json";
        String transcriptFilePath5 = "150121678.json";
        String transcriptFilePath6 = "150121679.json";
        String transcriptFilePath7 = "150121680.json";
        String transcriptFilePath8 = "150121681.json";
        String transcriptFilePath9 = "150121682.json";
        String transcriptFilePath10 = "150121683.json";

        // Load data using DataLoader
        students = DataLoader.loadStudents(studentFilePath);
        advisors = DataLoader.loadAdvisors(advisorFilePath);
        courses = DataLoader.loadCourses(courseFilePath);
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath1));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath2));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath3));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath4));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath5));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath6));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath7));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath8));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath9));
        transcripts.addAll(DataLoader.loadTranscripts(transcriptFilePath10));


	}
}
