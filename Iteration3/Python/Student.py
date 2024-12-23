class Student(Person):
    def __init__(self, student_id, first_name=None, last_name=None, password=None, advisor=None, term=None, 
                 chosen_courses=None, approved_courses=None):
        super().__init__(first_name, last_name, password)
        self.student_id = student_id
        self.advisor = advisor
        self.term = term
        self.chosen_courses = chosen_courses if chosen_courses else []
        self.approved_courses = approved_courses if approved_courses else []
        self.approve_request = 0
        self.unread_notifications = []
        self.read_notifications = []
        self.notifications = []

    def add_chosen_course(self, course_section):
        self.chosen_courses.append(course_section)

    def remove_chosen_course(self, course_section):
        self.chosen_courses.remove(course_section)

    def add_to_approved_courses(self, course_section):
        self.approved_courses.append(course_section)

    def view_schedule(self):
        print(f"Schedule for {self.first_name} {self.last_name}")
        for section in self.chosen_courses:
            for session in section.get_course_sessions():
                print(f"{section.get_course().get_course_name()} - {session.get_day()} {session.get_start_time()} - {session.get_end_time()}")

    def add_notification(self, message):
        self.unread_notifications.append(message)

    def notifications_seen(self):
        self.read_notifications.extend(self.unread_notifications)
        self.unread_notifications.clear()

    def add_notification_object(self, notification):
        self.notifications.append(notification)

    def mark_notifications_as_read(self):
        for notification in self.notifications:
            notification.mark_as_read()

    def send_for_approval(self):
        self.approve_request = 1
        advisor = self.advisor
        if not advisor:
            print("No advisor assigned to you. Please contact the administration.")
            return
        if not advisor.get_awaiting_students():
            advisor.set_awaiting_students([])
        advisor.get_awaiting_students().append(self)
        if not advisor.get_read_notifications():
            advisor.set_read_notifications([])
        if not advisor.get_unread_notifications():
            advisor.set_unread_notifications([])
        advisor.add_notification(f"{self.first_name} {self.last_name} is waiting for your registration approval.")

    def get_student_id(self):
        return self.student_id

    def set_student_id(self, student_id):
        self.student_id = student_id

    def get_advisor(self):
        return self.advisor

    def set_advisor(self, advisor):
        self.advisor = advisor

    def get_term(self):
        return self.term

    def set_term(self, term):
        self.term = term

    def get_chosen_courses(self):
        return self.chosen_courses

    def set_chosen_courses(self, chosen_courses):
        self.chosen_courses = chosen_courses

    def get_approved_courses(self):
        return self.approved_courses

    def set_approved_courses(self, approved_courses):
        self.approved_courses = approved_courses

    def get_approve_request(self):
        return self.approve_request

    def set_approve_request(self, approve_request):
        self.approve_request = approve_request

    def get_transcript(self):
        return self.transcript

    def set_transcript(self, transcript):
        self.transcript = transcript

    def get_unread_notifications(self):
        return self.unread_notifications

    def set_unread_notifications(self, unread_notifications):
        self.unread_notifications = unread_notifications

    def get_read_notifications(self):
        return self.read_notifications

    def set_read_notifications(self, read_notifications):
        self.read_notifications = read_notifications

    def get_notifications(self):
        return self.notifications

    def set_notifications(self, notifications):
        self.notifications = notifications
