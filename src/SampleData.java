import java.util.Arrays;
import java.util.List;

public class SampleData {

	public static List<Student> generateStudent() {
		Student student1 = new Student("Albert", "Morgan", 222222, "123456", new Advisor("Naomi", "Mosley", 333333, "987654"));
//		Student student2 = new Student();
		return Arrays.asList(student1);
	}
	public static RegistrationData generateRegistrationData() {
		List<Student> sampleStudents = generateStudent();
//		List<Course> sampleCourses = generateCourse();
		return new RegistrationData(sampleStudents);
	}

//	public static List<Course> generateCourse() {
//		Course course1 = new Course();
//		Course course2 = new Course();
//		return Arrays.asList(course1, course2);
//	}
//	
//	public static List<Advisor> generateAdvisor() {
//		Advisor advisor1 = new Advisor();
//		Advisor advisor2 = new Advisor();
//		return Arrays.asList(advisor1, advisor2);
//	}
//	
//	public static List<Lecturer> generateLecturer() {
//		Lecturer lecturer1 = new Lecturer();
//		Lecturer lecturer2 = new Lecturer();
//		return Arrays.asList(lecturer1, lecturer2);
//	}
//	
//	public static List<Staff> generateStaff() {
//		Staff staff1 = new Staff();
//		Staff staff2 = new Staff();
//		return Arrays.asList(staff1, staff2);
//	}
	
	
}
