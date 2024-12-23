class LoginManager:
    @staticmethod
    def login_student(student_id, password):
        for student in ObjectCreator.students:
            if student.get_student_id().get_id() == student_id and student.get_password().get_password() == password:
                return student
        return None  # Invalid credentials

    @staticmethod
    def login_advisor(lecturer_id, password):
        for advisor in ObjectCreator.advisors:
            if advisor.get_lecturer_id().get_id() == lecturer_id and advisor.get_password().get_password() == password:
                return advisor
        return None  # Invalid credentials
