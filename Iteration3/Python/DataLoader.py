import json

class DataLoader:
    @staticmethod
    def load_students(file_path):
        return DataLoader.load_data(file_path)

    @staticmethod
    def load_advisors(file_path):
        return DataLoader.load_data(file_path)

    @staticmethod
    def load_courses(file_path):
        return DataLoader.load_data(file_path)

    @staticmethod
    def load_course_sections(file_path):
        return DataLoader.load_data(file_path)

    @staticmethod
    def load_transcripts(file_path):
        return DataLoader.load_data(file_path)

    @staticmethod
    def load_data(file_path):
        try:
            with open(file_path, 'r') as file:
                return json.load(file)
        except (IOError, json.JSONDecodeError) as e:
            print(f"Error loading data from {file_path}: {e}")
            return None
