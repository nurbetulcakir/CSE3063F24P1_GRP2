class Notification:
    def __init__(self, message, date):
        self.message = message
        self.date = date
        self.is_read = False  # Default is unread

    def get_message(self):
        return self.message

    def set_message(self, message):
        self.message = message

    def get_date(self):
        return self.date

    def set_date(self, date):
        self.date = date

    def is_read(self):
        return self.is_read

    def mark_as_read(self):
        self.is_read = True

    def set_read(self, is_read):
        self.is_read = is_read
