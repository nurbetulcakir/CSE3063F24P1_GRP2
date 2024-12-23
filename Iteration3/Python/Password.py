class Password:


    def __init__(self, password):
        self.password = password

    def is_secure_password(self):

        if len(self.password) < 8:
            return False
        if not any(char.islower() for char in self.password):
            return False
        if not any(char.isupper() for char in self.password):
            return False
        if not any(char.isdigit() for char in self.password):
            return False
        if not any(char in "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?`~" for char in self.password):
            return False
        return True

    def get_password(self):

        return self.password

    def set_password(self, password):

        self.password = password
