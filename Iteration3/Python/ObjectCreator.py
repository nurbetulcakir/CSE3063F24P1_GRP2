import DataLoader


class ObjectCreator:
    students = []
    advisors = []
    courses = []
    transcripts = []
    course_sections = []

    @staticmethod
    def create_objects():

        try:
            print("Loading students...")
            ObjectCreator.students = DataLoader.load_students("students.json")
            print(f"{len(ObjectCreator.students)} students loaded.")

            print("Loading advisors...")
            ObjectCreator.advisors = DataLoader.load_advisors("advisors.json")
            print(f"{len(ObjectCreator.advisors)} advisors loaded.")

            print("Loading courses...")
            ObjectCreator.courses = DataLoader.load_courses("courses.json")
            print(f"{len(ObjectCreator.courses)} courses loaded.")

            print("Loading course sections...")
            ObjectCreator.course_sections = DataLoader.load_courses("course_sections.json")
            print(f"{len(ObjectCreator.course_sections)} course sections loaded.")

        except Exception as e:
            print(f"An error occurred while creating objects: {e}")
