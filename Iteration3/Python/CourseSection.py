import Course


class CourseSection(Course):


    def __init__(self, section_id=None, course=None, capacity=None, course_sessions=None, enrolled_students=None):
        super().__init__(
            course_id=course.get_course_id() if course else None,
            course_name=course.get_course_name() if course else None,
            course_term=course.get_course_term() if course else None,
            course_credit=course.get_course_credit() if course else None,
            prerequisite_course=course.get_prerequisite_courses() if course else None
        )
        self.section_id = section_id
        self.course = course
        self.capacity = capacity
        self.enrolled_students = enrolled_students if enrolled_students else []
        self.course_sessions = course_sessions if course_sessions else []

    def enroll_student(self, student):

        if len(self.enrolled_students) < self.capacity:
            self.enrolled_students.append(student)
            print(f"Student {student.get_first_name()} {student.get_last_name()} successfully enrolled in section {self.section_id}.")
        else:
            print(f"Section {self.section_id} is full. Enrollment failed.")

    def remove_student(self, student):

        if student in self.enrolled_students:
            self.enrolled_students.remove(student)
            print(f"Student {student.get_first_name()} {student.get_last_name()} removed from section {self.section_id}.")
        else:
            print(f"Student not found in section {self.section_id}.")

    def is_valid_section(self):

        return all([self.section_id, self.course, self.capacity, self.course_sessions])

    def get_section_id(self):

        return self.section_id

    def set_section_id(self, section_id):

        self.section_id = section_id

    def get_course(self):

        return self.course

    def set_course(self, course):

        self.course = course

    def get_capacity(self):

        return self.capacity

    def set_capacity(self, capacity):

        self.capacity = capacity

    def get_enrolled_students(self):

        return self.enrolled_students

    def set_enrolled_students(self, enrolled_students):

        self.enrolled_students = enrolled_students

    def get_course_sessions(self):

        return self.course_sessions

    def set_course_sessions(self, course_sessions):

        self.course_sessions = course_sessions

    def __str__(self):

        sessions = "\n".join([f"Day: {session['day']}, Start: {session['start_time']}, End: {session['end_time']}, Room: {session['classroom']}" for session in self.course_sessions])
        return (f"Section ID: {self.section_id}\n"
                f"Course: {self.course.get_course_name() if self.course else 'None'}\n"
                f"Capacity: {self.capacity}\n"
                f"Enrolled Students: {len(self.enrolled_students)}/{self.capacity}\n"
                f"Sessions:\n{sessions}")

