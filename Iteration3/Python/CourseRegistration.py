class CourseRegistration:


    @staticmethod
    def register_student_for_course(student, section):

        if section.get_capacity() <= 0:
            print(f"Course section {section.get_section_id()} is full!")
            return False

        if any(sec.get_course().get_course_id() == section.get_course().get_course_id() for sec in student.get_chosen_courses()):
            print(f"You are already registered for {section.get_course().get_course_name()}.")
            return False

        if not CourseRegistration.has_completed_prerequisites(student, section.get_course()):
            print(f"You have not completed the prerequisites for {section.get_course().get_course_name()}.")
            return False

        if CourseRegistration.has_time_conflict(student, section):
            print("Time conflict detected with your existing schedule.")
            return False

        section.enroll_student(student)
        student.add_chosen_course(section)
        section.set_capacity(section.get_capacity() - 1) 

        print(f"Successfully registered for {section.get_course().get_course_name()} in section {section.get_section_id()}.")
        return True

    @staticmethod
    def has_completed_prerequisites(student, course):

        prerequisites = course.get_prerequisite_courses()
        completed_courses = [completed_course.get_course_id() for completed_course in student.get_passed_courses()]

        for prereq in prerequisites:
            if prereq.get_course_id() not in completed_courses:
                return False 
        return True

    @staticmethod
    def has_time_conflict(student, section):

        for registered_section in student.get_chosen_courses():
            for session in section.get_course_sessions():
                for registered_session in registered_section.get_course_sessions():
                    # Check if session times conflict
                    if (session.get_day() == registered_session.get_day() and
                        session.get_start_time() < registered_session.get_end_time() and
                        session.get_end_time() > registered_session.get_start_time()):
                        return True 
        return False

    @staticmethod
    def drop_student_from_course(student, section):

        if section not in student.get_chosen_courses():
            print(f"You are not registered in section {section.get_section_id()} of {section.get_course().get_course_name()}.")
            return False

        section.remove_student(student)  
        student.remove_chosen_course(section) 
        section.set_capacity(section.get_capacity() + 1) 

        print(f"Successfully dropped {section.get_course().get_course_name()} from section {section.get_section_id()}.")
        return True
