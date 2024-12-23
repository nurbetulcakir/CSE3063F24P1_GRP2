from AdvisorInterface import AdvisorInterface
from AdvisorInterface import ObjectCreator
from StudentInterface import StudentInterface


class UserInterface:
    user_id_input = ""
    password_input = ""
    current_students_index = None
    current_transcripts_index = None
    current_advisors_index = None

    @staticmethod
    def main():
        oc = ObjectCreator()
        oc.create_objects()
        ui = UserInterface()
        ui.login()

    def login(self):
        oc = ObjectCreator()
        oc.create_objects()

        while True:
            user_id_input = input("Enter Id: ")
            password_input = input("Enter Password: ")

            if len(user_id_input) == 6:  # Advisor login check
                advisor_found = False

                for i, advisor in enumerate(ObjectCreator.advisors):
                    if advisor.get_lecturer_id().get_id() == user_id_input:
                        advisor_found = True
                        if advisor.get_password().get_password() == password_input:
                            UserInterface.current_advisors_index = i
                            ai = AdvisorInterface()
                            ai.run()
                            return
                        else:
                            print("Id or password is wrong. Please try again.")
                            break

                if not advisor_found:
                    print("Id or password is wrong. Please try again.")

            elif len(user_id_input) == 9:  # Student login check
                student_found = False

                for i, student in enumerate(ObjectCreator.students):
                    if student.get_student_id().get_id() == user_id_input:
                        student_found = True
                        if student.get_password().get_password() == password_input:
                            UserInterface.current_students_index = i
                            UserInterface.current_transcripts_index = i
                            si = StudentInterface()
                            si.run()
                            return
                        else:
                            print("Id or password is wrong. Please try again.")
                            break

                if not student_found:
                    print("Id or password is wrong. Please try again.")

            else:
                print("Invalid id or password")
