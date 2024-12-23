import Person

class Lecturer(Person):


    def __init__(self, lecturer_id, first_name=None, last_name=None, given_courses=None):

        super().__init__(first_name, last_name)
        self.lecturer_id = lecturer_id
        self.given_courses = given_courses if given_courses else []

    def view_schedule(self):

        if not self.given_courses:
            print(f"Lecturer {self.first_name} {self.last_name} (ID: {self.lecturer_id}) has no assigned courses.")
            return

        print(f"\nSchedule for Lecturer {self.first_name} {self.last_name} (ID: {self.lecturer_id}):")
        for course in self.given_courses:
            print(f"\nCourse: {course.get_course_name()} (ID: {course.get_course_id()})")
            for section in course.get_course_sections():
                print(f"  Section ID: {section.get_section_id()}")
                for session in section.get_course_sessions():
                    print(f"    Day: {session['day']}, Start: {session['start_time']}, End: {session['end_time']}, Classroom: {session['classroom']}")

    def get_lecturer_id(self):

        return self.lecturer_id

    def set_lecturer_id(self, lecturer_id):

        self.lecturer_id = lecturer_id

    def get_given_courses(self):

        return self.given_courses

    def set_given_courses(self, given_courses):

        self.given_courses = given_courses
