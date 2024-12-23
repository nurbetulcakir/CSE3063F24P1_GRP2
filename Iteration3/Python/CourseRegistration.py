class CourseRegistration:

    @staticmethod
    def register_student_for_course(student, section):
        # Check if the course is already full
        if section.get_capacity() <= 0:
            print("Course section is full!")
            return False

        # Check for time conflicts with existing courses
        if not CourseRegistration.has_time_conflict(student, section):
            print("Time conflict detected with your existing schedule.")
            return False

        # Register student for the section
        section.enroll_student(student)
        student.add_chosen_course(section)  # Add to student's chosen courses
        section.set_capacity(section.get_capacity() - 1)  # Decrease the available seats

        print(f"Successfully registered for {section.get_course().get_course_name()}")
        return True

    @staticmethod
    def has_time_conflict(student, section):
        for registered_section in student.get_chosen_courses():
            for session in section.get_course_sessions():
                for registered_session in registered_section.get_course_sessions():
                    # Check if session times overlap
                    if (session.get_day() == registered_session.get_day() and
                            session.get_start_time() == registered_session.get_start_time()):
                        return False
        return True
