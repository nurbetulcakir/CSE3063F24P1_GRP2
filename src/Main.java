import com.google.gson.*;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		
		ObjectCreator oc = new ObjectCreator();
		oc.createObjects();
		
		UserInterface ui = new UserInterface();
		ui.login();

		for (int i = 0; i < oc.students.size(); i++) {
			System.out.println(oc.students.get(i));
		}
	}
}