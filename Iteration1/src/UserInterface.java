import java.util.Scanner;

public class UserInterface {
    static String userIdInput = "";
    static String passwordInput = "";

    public static void main(String[] args) {
		ObjectCreator oc = new ObjectCreator();
		oc.createObjects();
        UserInterface ui = new UserInterface();
        ui.login();
    }

    public void login() {
        ObjectCreator oc = new ObjectCreator();
        oc.createObjects();

        try(Scanner input1 = new Scanner(System.in)) {

        	outerloop:
        		while (true) {
        			System.out.println("Enter Id:");
        			userIdInput = input1.nextLine();
        			// Prompt for password and store it in the Password class
        			System.out.println("Enter Password:");
        			passwordInput = input1.nextLine();

        			if (userIdInput.length() == 6) {  // Advisor login check
        				boolean advisorFound = false;
        				// Iterate through advisors to find the matching ID
        				for (int i = 0; i < oc.advisors.size(); i++) {
        					if (oc.advisors.get(i).getLecturerID().getId().equals(userIdInput)) {
        						advisorFound = true;  // Advisor found
        						if (oc.advisors.get(i).getPassword().getPassword().equals(passwordInput)) {
        							// Login success
        							AdvisorInterface ai = new AdvisorInterface();
        							ai.run();
        							break outerloop;
        						} else {
        							System.out.println("Id or password is wrong. Please try again.");
        							break;
        						}
        					}
        				}

        				// If no advisor found
        				if (!advisorFound) {
        					System.out.println("Id or password is wrong. Please try again.");
        				}

        			} else if (userIdInput.length() == 9) {  // Student login check
        				boolean studentFound = false;
        				// Iterate through students to find the matching ID
        				for (int i = 0; i < oc.students.size(); i++) {
        					if (oc.students.get(i).getStudentID().getId().equals(userIdInput)) {
        						studentFound = true;  // Student found
        						if (oc.students.get(i).getPassword().getPassword().equals(passwordInput)) {
        							// Login success
        							StudentInterface si = new StudentInterface();
        							si.run();
        							break outerloop;
        						} else {
        							System.out.println("Id or password is wrong. Please try again.");
        							break;
        						}
        					}
        				}

        				// If no student found
        				if (!studentFound) {
        					System.out.println("Id or password is wrong. Please try again.");
        				}

        			} else {
        				System.out.println("Invalid id or password");
        			}
        		}
        	}
    	}
	}