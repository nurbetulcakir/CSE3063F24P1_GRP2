class Transcript(Student):
    def __init__(self, student_id, first_name=None, last_name=None, term=None, gpa=None, cgpa=None,
                 credit_received=None, credit_earned=None, total_credit_received=None, total_credit_earned=None,
                 passed_courses=None, failed_courses=None):
        super().__init__(student_id, first_name, last_name)
        self.gpa = gpa
        self.cgpa = cgpa
        self.credit_received = credit_received
        self.credit_earned = credit_earned
        self.total_credit_received = total_credit_received
        self.total_credit_earned = total_credit_earned
        self.passed_courses = passed_courses if passed_courses else []
        self.failed_courses = failed_courses if failed_courses else []
        self.choosable_courses = []

    def is_prerequisite_courses_passed(self, course):
        temp = 0
        for prerequisite in course.view_prerequisite_courses():
            if self.is_passed_course(prerequisite):
                temp += 1

            for failed_course in self.failed_courses:
                if (failed_course.get_course_letter_grade() == "FD" and
                        prerequisite.get_course_id().get_id() == failed_course.get_course_id().get_id()):
                    temp += 1

        return temp == len(course.view_prerequisite_courses())

    def is_passed_course(self, course):
        for passed_course in self.passed_courses:
            if passed_course.get_course_id().get_id() == course.get_course_id().get_id():
                return True
        return False

    def is_failed_course(self, course):
        for failed_course in self.failed_courses:
            if failed_course.get_course_id().get_id() == course.get_course_id().get_id():
                return True
        return False

    def is_course_taken_before(self, course):
        return self.is_passed_course(course) or self.is_failed_course(course)

    def is_choosable_course(self, course):
        self.set_choosable_courses()
        return course in self.choosable_courses

    def is_chosen_course(self, course_section):
        return course_section in self.get_chosen_courses()

    def get_gpa(self):
        return self.gpa

    def set_gpa(self, gpa):
        self.gpa = gpa

    def get_cgpa(self):
        return self.cgpa

    def set_cgpa(self, cgpa):
        self.cgpa = cgpa

    def get_credit_received(self):
        return self.credit_received

    def set_credit_received(self, credit_received):
        self.credit_received = credit_received

    def get_credit_earned(self):
        return self.credit_earned

    def set_credit_earned(self, credit_earned):
        self.credit_earned = credit_earned

    def get_total_credit_received(self):
        return self.total_credit_received

    def set_total_credit_received(self, total_credit_received):
        self.total_credit_received = total_credit_received

    def get_total_credit_earned(self):
        return self.total_credit_earned

    def set_total_credit_earned(self, total_credit_earned):
        self.total_credit_earned = total_credit_earned

    def view_successful_courses(self):
        print("Successful Courses:")
        for course in self.passed_courses:
            print(f"{course.get_course_name()} - {course.get_course_letter_grade()}")

    def view_failed_courses(self):
        print("Failed Courses:")
        for course in self.failed_courses:
            print(f"{course.get_course_name()} - {course.get_course_letter_grade()}")

    def get_passed_courses(self):
        return self.passed_courses

    def set_passed_courses(self, passed_courses):
        self.passed_courses = passed_courses

    def get_failed_courses(self):
        return self.failed_courses

    def set_failed_courses(self, failed_courses):
        self.failed_courses = failed_courses

    def get_choosable_courses(self):
        return self.choosable_courses

    def set_choosable_courses(self):
        self.choosable_courses = []
        for course in ObjectCreator.courses:
            if (course.get_course_term() <= self.get_term() and not self.is_passed_course(course) and
                    self.is_prerequisite_courses_passed(course)):
                self.choosable_courses.append(course)
            elif (self.is_failed_course(course) and any(
                    failed_course.get_course_letter_grade() == "FD" for failed_course in self.failed_courses)):
                self.choosable_courses.append(course)
