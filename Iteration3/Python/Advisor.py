import Lecturer


class Advisor(Lecturer):


    def __init__(self, lecturer_id, first_name=None, last_name=None, password=None, student_list=None, awaiting_students=None):
        super().__init__(lecturer_id, first_name, last_name, password)
        self.student_list = student_list if student_list else []
        self.awaiting_students = awaiting_students if awaiting_students else []
        self.adv_student = None
        self.unread_notifications = []
        self.read_notifications = []
        self.notifications = []

    def add_to_approved_courses(self, course_section):

        self.approved_courses.append(course_section)

    def view_student_list(self):

        if not self.student_list:
            print("No students assigned to this advisor.")
        else:
            for student in self.student_list:
                print(f"ID: {student.get_student_id().get_id()}")
                print(f"First Name: {student.get_first_name()}")
                print(f"Last Name: {student.get_last_name()}\n")

    def find_awaiting_students(self):

        for student in self.student_list:
            if student not in self.awaiting_students and student.get_approve_request() == 1:
                self.awaiting_students.append(student)

    def select_next_student(self, index):

        if 0 < index <= len(self.awaiting_students):
            self.adv_student = self.awaiting_students[index - 1]
        else:
            print("Invalid index. Please select a valid student.")

    def approve_courses(self):

        if self.adv_student:
            selected_courses = self.adv_student.get_chosen_courses()
            if selected_courses:
                for course_section in selected_courses:
                    self.adv_student.add_to_approved_courses(course_section)
                    course_section.enroll_student(self.adv_student)
                self.adv_student.set_chosen_courses([])
                self.adv_student.set_approve_request(2)  # Approved
                self.remove_awaiting_student(self.adv_student)
                self.send_notification(None, 2)
                self.adv_student = None
            else:
                print("No courses selected by the student.")
        else:
            print("No student selected for approval.")

    def disapprove_courses(self):

        if self.adv_student:
            selected_courses = self.adv_student.get_chosen_courses()
            if selected_courses:
                for course_section in selected_courses:
                    course_section.set_capacity(course_section.get_capacity() + 1)
                self.adv_student.set_chosen_courses([])
                self.adv_student.set_approve_request(3)  # Disapproved
                self.remove_awaiting_student(self.adv_student)
                self.send_notification(None, 3)
                self.adv_student = None
            else:
                print("No courses selected by the student.")
        else:
            print("No student selected for disapproval.")

    def add_notification(self, notification):

        self.notifications.append(notification)

    def send_notification(self, message, req):

        if self.adv_student:
            if not message:
                message = "The request is approved!" if req == 2 else "The request is disapproved!"
            self.adv_student.add_notification(message)
        else:
            print("No student selected for sending a notification.")

    def add_unread_notification(self, message):

        self.unread_notifications.append(message)

    def notifications_seen(self):

        self.read_notifications.extend(self.unread_notifications)
        self.unread_notifications.clear()

    # Getters and Setters
    def get_student_list(self):
        return self.student_list

    def set_student_list(self, student_list):
        self.student_list = student_list

    def get_awaiting_students(self):
        return self.awaiting_students

    def set_awaiting_students(self, awaiting_students):
        self.awaiting_students = awaiting_students

    def get_adv_student(self):
        return self.adv_student

    def set_adv_student(self, adv_student):
        self.adv_student = adv_student

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
