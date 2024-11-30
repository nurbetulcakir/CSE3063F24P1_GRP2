import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DataLoader {
    private static final Gson gson = new Gson();

    public static ArrayList<Student> loadStudents(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type studentListType = new TypeToken<ArrayList<Student>>() {}.getType();
            return gson.fromJson(reader, studentListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static ArrayList<Advisor> loadAdvisors(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type advisorListType = new TypeToken<ArrayList<Advisor>>() {}.getType();
            return gson.fromJson(reader, advisorListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static ArrayList<Course> loadCourses(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type courseListType = new TypeToken<ArrayList<Course>>() {}.getType();
            return gson.fromJson(reader, courseListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public static ArrayList<Transcript> loadTranscripts(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type transcriptListType = new TypeToken<ArrayList<Transcript>>() {}.getType();
            return gson.fromJson(reader, transcriptListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public static ArrayList<CourseSection> loadCourseSections(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Type courseSectionListType = new TypeToken<ArrayList<CourseSection>>() {}.getType();
            return gson.fromJson(reader, courseSectionListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
