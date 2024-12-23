import CourseSection


class CourseSession(CourseSection):


    def __init__(self, section_id=None, course=None, capacity=None, day=None, start_time=None, end_time=None, classroom=None):
        super().__init__(section_id=section_id, course=course, capacity=capacity)
        self.day = day 
        self.start_time = start_time 
        self.end_time = end_time
        self.classroom = classroom  

    def is_valid_session(self):

        return all([self.day, self.start_time, self.end_time, self.classroom])

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

    def is_conflicting_with(self, other_session):

        if self.day == other_session.get_day():
            # Check if time intervals overlap
            if (self.start_time < other_session.get_end_time() and self.end_time > other_session.get_start_time()):
                return True
        return False

    def __str__(self):

        return f"Day: {self.day}, Start: {self.start_time}, End: {self.end_time}, Classroom: {self.classroom}"
