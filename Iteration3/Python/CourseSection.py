class CourseSection(Course):
    def __init__(self, section_id=None, course=None, capacity=None, day=None, start_time=None, end_time=None, classroom=None, enrolled_students=None):
        super().__init__(course_id=course.get_course_id() if course else None, course_name=course.get_course_name() if course else None)
        self.section_id = section_id
        self.course = course
        self.capacity = capacity
        self.day = day
        self.start_time = start_time
        self.end_time = end_time
        self.classroom = classroom
        self.enrolled_students = enrolled_students if enrolled_students else []
        self.course_sessions = []

    def is_valid_section(self):
        # This is a placeholder implementation.
        return True

    def get_day(self):
        return self.day

    def set_day(self, day):
        self.day = day

    def get_start_time(self):
        return self.start_time

    def set_start_time(self, start_time):
        self.start_time = start_time

    def get_end_time(self):
        return self.end_time

    def set_end_time(self, end_time):
        self.end_time = end_time

    def get_classroom(self):
        return self.classroom

    def set_classroom(self, classroom):
        self.classroom = classroom

    def enroll_student(self, student):
        self.enrolled_students.append(student)

    def get_section_id(self):
        return self.section_id

    def set_section_id(self, section_id):
        self.section_id = section_id

    def get_course(self):
        return self.course

    def set_course(self, course):
        self.course = course

    def get_enrolled_students(self):
        return self.enrolled_students

    def set_enrolled_students(self, enrolled_students):
        self.enrolled_students = enrolled_students

    def get_capacity(self):
        return self.capacity

    def set_capacity(self, capacity):
        self.capacity = capacity

    def get_course_sessions(self):
        return self.course_sessions

    def set_course_sessions(self, course_sessions):
        self.course_sessions = course_sessions
