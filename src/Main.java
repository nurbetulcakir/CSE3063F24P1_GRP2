
public class Main {
	public static void main(String[] args) {
		
		ObjectCreator oc = new ObjectCreator();
		oc.createObjects();
		
		UserInterface ui = new UserInterface();
		ui.login();

	}
}