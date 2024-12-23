class NotificationSystem:

    @staticmethod
    def send_student_notification(student, message):
        student.add_notification(message)  # Add to student's unread notifications
        print(f"Notification sent to {student.get_first_name()}: {message}")

    @staticmethod
    def send_advisor_notification(advisor, message):
        advisor.add_notification(message)  # Add to advisor's unread notifications
        print(f"Notification sent to {advisor.get_first_name()}: {message}")

    @staticmethod
    def view_student_notifications(student):
        print(f"Unread Notifications for {student.get_first_name()}:")
        for notification in student.get_unread_notifications():
            print(notification)

    @staticmethod
    def view_advisor_notifications(advisor):
        print(f"Unread Notifications for {advisor.get_first_name()}:")
        for notification in advisor.get_unread_notifications():
            print(notification)

    @staticmethod
    def mark_student_notifications_as_read(student):
        student.notifications_seen()
        print(f"All notifications for {student.get_first_name()} are marked as read.")

    @staticmethod
    def mark_advisor_notifications_as_read(advisor):
        advisor.notifications_seen()
        print(f"All notifications for {advisor.get_first_name()} are marked as read.")
