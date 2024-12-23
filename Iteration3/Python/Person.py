class Person():
    def __init__(self, first_name=None, last_name=None, password=None):
        self.first_name = first_name
        self.last_name = last_name
        self.password = password
        self.schedule = None

    def view_schedule(self):
        pass

    def get_first_name(self):
        return self.first_name

    def set_first_name(self, first_name):
        self.first_name = first_name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def get_password(self):
        return self.password

    def set_password(self, password):
        self.password = password

    def get_schedule(self):
        return self.schedule

    def set_schedule(self, schedule):
        self.schedule = schedule
