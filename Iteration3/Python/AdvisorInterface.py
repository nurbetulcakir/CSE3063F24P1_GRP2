from NotificationSystem import NotificationSystem
from ObjectCreator import ObjectCreator
from UserInterface import UserInterface


class AdvisorInterface:

    def __init__(self):
        self.scanner = input  # Using Python's input function

    def run(self):
        while True:
            print("\n=== Advisor Menu ===")
            print("1. View Students")
            print("2. Approve/Disapprove Courses")
            print("3. View Notifications")
            print("4. Logout")
            choice = int(self.scanner("Please select an option: "))

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
        current_advisor.view_student_list()

    def approve_disapprove_courses(self):
        current_advisor = self.get_current_advisor()
        print("\nSelect a student to approve/disapprove courses:")

        for i, student in enumerate(current_advisor.get_awaiting_students(), start=1):
            print(f"{i}. {student.get_first_name()} {student.get_last_name()}")

        student_index = int(self.scanner(f"Select student (1 to {len(current_advisor.get_awaiting_students())}): "))

        if student_index < 1 or student_index > len(current_advisor.get_awaiting_students()):
            print("Invalid selection.")
            return

        selected_student = current_advisor.get_awaiting_students()[student_index - 1]

        print("Select an option:")
        print("1. Approve Courses")
        print("2. Disapprove Courses")
        action = int(self.scanner("Select an option: "))

        if action == 1:
            current_advisor.approve_courses()
            NotificationSystem.send_advisor_notification(
                current_advisor,
                f"{selected_student.get_first_name()} {selected_student.get_last_name()}'s courses have been approved."
            )
        elif action == 2:
            current_advisor.disapprove_courses()
            NotificationSystem.send_advisor_notification(
                current_advisor,
                f"{selected_student.get_first_name()} {selected_student.get_last_name()}'s courses have been disapproved."
            )
        else:
            print("Invalid option.")

    def view_notifications(self):
        current_advisor = self.get_current_advisor()
        NotificationSystem.view_advisor_notifications(current_advisor)

        choice = self.scanner("\nMark all notifications as read? (y/n): ")
        if choice.lower() == "y":
            NotificationSystem.mark_advisor_notifications_as_read(current_advisor)

    def get_current_advisor(self):
        return ObjectCreator.advisors[UserInterface.current_advisors_index]
