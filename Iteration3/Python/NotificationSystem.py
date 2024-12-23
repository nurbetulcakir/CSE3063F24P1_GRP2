class NotificationSystem:


    @staticmethod
    def send_student_notification(student, message):

        if student:
            student.add_notification(message)  # Add to student's unread notifications
            print(f"Notification sent to {student.get_first_name()} {student.get_last_name()}: {message}")
        else:
            print("Error: Student not found.")

    @staticmethod
    def send_advisor_notification(advisor, message):

        if advisor:
            advisor.add_notification(message)  # Add to advisor's unread notifications
            print(f"Notification sent to {advisor.get_first_name()} {advisor.get_last_name()}: {message}")
        else:
            print("Error: Advisor not found.")

    @staticmethod
    def view_student_notifications(student):

        if student:
            unread_notifications = student.get_unread_notifications()
            if unread_notifications:
                print(f"Unread Notifications for {student.get_first_name()} {student.get_last_name()}:")
                for i, notification in enumerate(unread_notifications, start=1):
                    print(f"{i}. {notification}")
            else:
                print(f"No unread notifications for {student.get_first_name()} {student.get_last_name()}.")
        else:
            print("Error: Student not found.")

    @staticmethod
    def view_advisor_notifications(advisor):

        if advisor:
            unread_notifications = advisor.get_unread_notifications()
            if unread_notifications:
                print(f"Unread Notifications for {advisor.get_first_name()} {advisor.get_last_name()}:")
                for i, notification in enumerate(unread_notifications, start=1):
                    print(f"{i}. {notification}")
            else:
                print(f"No unread notifications for {advisor.get_first_name()} {advisor.get_last_name()}.")
        else:
            print("Error: Advisor not found.")

    @staticmethod
    def mark_student_notifications_as_read(student):

        if student:
            student.notifications_seen()
            print(f"All notifications for {student.get_first_name()} {student.get_last_name()} have been marked as read.")
        else:
            print("Error: Student not found.")

    @staticmethod
    def mark_advisor_notifications_as_read(advisor):

        if advisor:
            advisor.notifications_seen()
            print(f"All notifications for {advisor.get_first_name()} {advisor.get_last_name()} have been marked as read.")
        else:
            print("Error: Advisor not found.")
