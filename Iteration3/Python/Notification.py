class Notification:


    def __init__(self, message, date):

        self.message = message
        self.date = date
        self.is_read_status = False  # Default is unread

    def get_message(self):

        return self.message

    def set_message(self, message):

        self.message = message

    def get_date(self):

        return self.date

    def set_date(self, date):

        self.date = date

    def is_read(self):

        return self.is_read_status

    def mark_as_read(self):

        self.is_read_status = True

    def set_read(self, is_read):

        self.is_read_status = is_read

    def __str__(self):

        status = "Read" if self.is_read_status else "Unread"
        return f"[{status}] {self.date}: {self.message}"
