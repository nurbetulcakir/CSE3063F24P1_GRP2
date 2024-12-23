import NotificationSystem
import ObjectCreator
import UserInterface


class AdvisorInterface:

    def __init__(self):
        self.scanner = input  # Using Python's input function for user input.

    def run(self):

        while True:
            print("\n=== Advisor Menu ===")
            print("1. View Students")
            print("2. Approve/Disapprove Courses")
            print("3. View Notifications")
            print("4. Logout")
            try:
                choice = int(self.scanner("Please select an option: "))
            except ValueError:
                print("Invalid input. Please enter a number between 1 and 4.")
                continue

            if choice == 1:
                self.view_students()
            elif choice == 2:
                self.approve_disapprove_courses()
            elif choice == 3:
                self.view_notifications()
            elif choice == 4:
                print("Logging out...")
                break
            else:
                print("Invalid option. Please try again.")

    def view_students(self):

        current_advisor = self.get_current_advisor()
        if not current_advisor.get_student_list():
            print("No students assigned to you.")
        else:
            current_advisor.view_student_list()

    def approve_disapprove_courses(self):

        current_advisor = self.get_current_advisor()
        awaiting_students = current_advisor.get_awaiting_students()

        if not awaiting_students:
            print("No students awaiting approval.")
            return

        print("\nSelect a student to approve/disapprove courses:")
        for i, student in enumerate(awaiting_students, start=1):
            print(f"{i}. {student.get_first_name()} {student.get_last_name()}")

        try:
            student_index = int(self.scanner(f"Select student (1 to {len(awaiting_students)}): "))
        except ValueError:
            print("Invalid input. Please enter a number.")
            return

        if student_index < 1 or student_index > len(awaiting_students):
            print("Invalid selection.")
            return

        selected_student = awaiting_students[student_index - 1]
        current_advisor.set_adv_student(selected_student)

        print("\nSelect an option:")
        print("1. Approve Courses")
        print("2. Disapprove Courses")
        try:
            action = int(self.scanner("Select an option: "))
        except ValueError:
            print("Invalid input. Please enter 1 or 2.")
            return

        if action == 1:
            current_advisor.approve_courses()
            NotificationSystem.send_advisor_notification(
                current_advisor,
                f"Courses approved for {selected_student.get_first_name()} {selected_student.get_last_name()}."
            )
        elif action == 2:
            current_advisor.disapprove_courses()
            NotificationSystem.send_advisor_notification(
                current_advisor,
                f"Courses disapproved for {selected_student.get_first_name()} {selected_student.get_last_name()}."
            )
        else:
            print("Invalid option.")

    def view_notifications(self):

        current_advisor = self.get_current_advisor()
        NotificationSystem.view_advisor_notifications(current_advisor)

        choice = self.scanner("\nMark all notifications as read? (y/n): ")
        if choice.lower() == "y":
            NotificationSystem.mark_advisor_notifications_as_read(current_advisor)
            print("All notifications marked as read.")

    def get_current_advisor(self):

        try:
            return ObjectCreator.advisors[UserInterface.current_advisors_index]
        except IndexError:
            print("Error: No advisor is currently logged in.")
            return None
