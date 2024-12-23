import re

class ID:


    def __init__(self, id_value):
        self.id = id_value

    def is_valid_id_format(self):

        if re.fullmatch(r'\d{9}', self.id):  # Assuming a valid ID is a 9-digit number
            return True
        return False

    def get_id(self):

        return self.id

    def set_id(self, id_value):

        self.id = id_value

