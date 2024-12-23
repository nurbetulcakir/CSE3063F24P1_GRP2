from DataLoader import DataLoader


class ObjectCreator:
    students = []
    advisors = []
    courses = []
    transcripts = []
    course_sections = []

    @staticmethod
    def create_objects():
        # File paths for the JSON files
        student_file_path = "students.json"
        advisor_file_path = "advisors.json"
        course_file_path = "courses.json"
        transcript_file_paths = [
            "150121674.json",
            "150121675.json",
            "150121676.json",
            "150121677.json",
            "150121678.json",
            "150121679.json",
            "150121680.json",
            "150121681.json",
            "150121682.json",
            "150121683.json"
        ]
        course_section_file_path = "course_sections.json"

        # Load data using DataLoader
        ObjectCreator.students = DataLoader.load_students(student_file_path)
        ObjectCreator.advisors = DataLoader.load_advisors(advisor_file_path)
        ObjectCreator.courses = DataLoader.load_courses(course_file_path)

        for file_path in transcript_file_paths:
            transcripts = DataLoader.load_transcripts(file_path)
            if transcripts:
                ObjectCreator.transcripts.extend(transcripts)

        ObjectCreator.course_sections = DataLoader.load_course_sections(course_section_file_path)
