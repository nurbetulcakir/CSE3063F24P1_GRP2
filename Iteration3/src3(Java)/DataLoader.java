import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataLoader {
    private static final Gson gson = new Gson();

    // Load students from JSON
    public static ArrayList<Student> loadStudents(String filePath) {
        return loadData(filePath, new TypeToken<ArrayList<Student>>() {}.getType());
    }

    // Load advisors from JSON
    public static ArrayList<Advisor> loadAdvisors(String filePath) {
        return loadData(filePath, new TypeToken<ArrayList<Advisor>>() {}.getType());
    }

    // Load courses from JSON
    public static ArrayList<Course> loadCourses(String filePath) {
        return loadData(filePath, new TypeToken<ArrayList<Course>>() {}.getType());
    }

    // Load course sections from JSON
    public static ArrayList<CourseSection> loadCourseSections(String filePath) {
        return loadData(filePath, new TypeToken<ArrayList<CourseSection>>() {}.getType());
    }

    // Load transcripts from JSON
    public static ArrayList<Transcript> loadTranscripts(String filePath) {
        return loadData(filePath, new TypeToken<ArrayList<Transcript>>() {}.getType());
    }

    // Generic method to load data
    private static <T> T loadData(String filePath, Type type) {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
