class Course:
    def __init__(self, course_id=None, course_name=None, course_term=None, course_credit=None, course_letter_grade=None, prerequisite_course=None):
        self.course_id = course_id
        self.course_name = course_name
        self.prerequisite_course = prerequisite_course if prerequisite_course else []
        self.course_sections = []
        self.course_term = course_term
        self.course_credit = course_credit
        self.course_letter_grade = course_letter_grade

    def add_prerequisite_course(self, course):
        self.prerequisite_course.append(course)

    def get_course_id(self):
        return self.course_id

    def set_course_id(self, course_id):
        self.course_id = course_id

    def get_course_name(self):
        return self.course_name

    def set_course_name(self, course_name):
        self.course_name = course_name

    def view_prerequisite_courses(self):
        return self.prerequisite_course

    def get_course_term(self):
        return self.course_term

    def set_course_term(self, course_term):
        self.course_term = course_term

    def get_course_credit(self):
        return self.course_credit

    def set_course_credit(self, course_credit):
        self.course_credit = course_credit

    def get_course_letter_grade(self):
        return self.course_letter_grade

    def set_course_letter_grade(self, course_letter_grade):
        self.course_letter_grade = course_letter_grade

    def get_course_sections(self):
        return self.course_sections

    def set_course_sections(self, course_sections):
        self.course_sections = course_sections
