import AdvisorInterface
import ObjectCreator
import StudentInterface


class UserInterface:

    user_id_input = ""
    password_input = ""
    current_students_index = None
    current_transcripts_index = None
    current_advisors_index = None

    @staticmethod
    def main():

        print("Welcome to the Information Management System!")
        ObjectCreator.ObjectCreator.create_objects()
        ui = UserInterface()
        ui.login()

    def login(self):

        while True:
            user_id_input = input("Enter ID: ")
            password_input = input("Enter Password: ")

            if len(user_id_input) == 6:  # Advisor login check
                self.handle_advisor_login(user_id_input, password_input)
            elif len(user_id_input) == 9:  # Student login check
                self.handle_student_login(user_id_input, password_input)
            else:
                print("Invalid ID format. Please try again.")

    def handle_advisor_login(self, user_id_input, password_input):

        for i, advisor in enumerate(ObjectCreator.ObjectCreator.advisors):
            if advisor.get_lecturer_id().get_id() == user_id_input:
                if advisor.get_password().get_password() == password_input:
                    UserInterface.current_advisors_index = i
                    print(f"Welcome, {advisor.get_first_name()} {advisor.get_last_name()}!")
                    ai = AdvisorInterface.AdvisorInterface()
                    ai.run()
                    return
                else:
                    print("ID or password is incorrect. Please try again.")
                    return
        print("Advisor ID not found. Please try again.")

    def handle_student_login(self, user_id_input, password_input):

        for i, student in enumerate(ObjectCreator.ObjectCreator.students):
            if student.get_student_id().get_id() == user_id_input:
                if student.get_password().get_password() == password_input:
                    UserInterface.current_students_index = i
                    UserInterface.current_transcripts_index = i
                    print(f"Welcome, {student.get_first_name()} {student.get_last_name()}!")
                    si = StudentInterface.StudentInterface()
                    si.run()
                    return
                else:
                    print("ID or password is incorrect. Please try again.")
                    return
        print("Student ID not found. Please try again.")


if __name__ == "__main__":
    UserInterface.main()
