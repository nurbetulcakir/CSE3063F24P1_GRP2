import Person


class Lecturer(Person):
    def __init__(self, lecturer_id, first_name=None, last_name=None, given_courses=None):
        super().__init__(first_name, last_name)
        self.lecturer_id = lecturer_id
        self.given_courses = given_courses if given_courses else []

    def view_schedule(self):
        for _ in range(5):
            print(f"Lecturer ID: {self.lecturer_id.get_id()}, Lecturer Name: {self.first_name} {self.last_name}")
            print("Days:")

    def get_lecturer_id(self):
        return self.lecturer_id

    def set_lecturer_id(self, lecturer_id):
        self.lecturer_id = lecturer_id

    def get_given_courses(self):
        return self.given_courses

    def set_given_courses(self, given_courses):
        self.given_courses = given_courses
