import json
from Student import Student
from ID import ID
from Password import Password


class DataLoader:
    @staticmethod
    def load_students(file_path):

        try:
            with open(file_path, 'r') as file:
                student_data = json.load(file)
                students = []
                for data in student_data:
                    student = Student(
                        student_id=ID(data["studentID"]["id"]),
                        first_name=data["firstName"],
                        last_name=data["lastName"],
                        password=Password(data["password"]["password"]),
                        advisor=None,  # You can link the advisor later in ObjectCreator
                        term=data["term"]
                    )
                    students.append(student)
                return students
        except (IOError, json.JSONDecodeError) as e:
            print(f"Error loading students from {file_path}: {e}")
            return []

    @staticmethod
    def load_advisors(file_path):

        try:
            with open(file_path, 'r') as file:
                return json.load(file)
        except (IOError, json.JSONDecodeError) as e:
            print(f"Error loading advisors from {file_path}: {e}")
            return []

    @staticmethod
    def load_courses(file_path):

        try:
            with open(file_path, 'r') as file:
                return json.load(file)
        except (IOError, json.JSONDecodeError) as e:
            print(f"Error loading courses from {file_path}: {e}")
            return []

    @staticmethod
    def load_data(file_path):

        try:
            with open(file_path, 'r') as file:
                return json.load(file)
        except (IOError, json.JSONDecodeError) as e:
            print(f"Error loading data from {file_path}: {e}")
            return []
