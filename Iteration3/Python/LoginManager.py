import ObjectCreator


class LoginManager:


    @staticmethod
    def login_student(student_id, password):

        for student in ObjectCreator.students:
            if student.get_student_id().get_id() == student_id:
                if student.get_password().get_password() == password:
                    print(f"Login successful for student: {student.get_first_name()} {student.get_last_name()}.")
                    return student
                else:
                    print("Invalid password.")
                    return None
        print("Student ID not found.")
        return None

    @staticmethod
    def login_advisor(lecturer_id, password):

        for advisor in ObjectCreator.advisors:
            if advisor.get_lecturer_id().get_id() == lecturer_id:
                if advisor.get_password().get_password() == password:
                    print(f"Login successful for advisor: {advisor.get_first_name()} {advisor.get_last_name()}.")
                    return advisor
                else:
                    print("Invalid password.")
                    return None
        print("Lecturer ID not found.")
        return None
