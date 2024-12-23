class AdvisorApproval:


    @staticmethod
    def approve_courses(advisor, student):

        if not student.get_chosen_courses():
            print(f"Student {student.get_first_name()} {student.get_last_name()} has not selected any courses.")
            return

        approved_courses = []
        full_courses = []

        for section in student.get_chosen_courses():
            if section.get_capacity() > 0:
                advisor.add_to_approved_courses(section)
                section.enroll_student(student)  # Enroll the student in the course
                section.set_capacity(section.get_capacity() - 1)  # Decrease capacity
                approved_courses.append(section.get_course().get_course_name())
            else:
                full_courses.append(section.get_course().get_course_name())

        # Display approved and full courses
        if approved_courses:
            print(f"Courses approved for {student.get_first_name()} {student.get_last_name()}:")
            for course_name in approved_courses:
                print(f"- {course_name}")

        if full_courses:
            print(f"The following courses are full and could not be approved:")
            for course_name in full_courses:
                print(f"- {course_name}")

        # Update the student's approval request status
        student.set_approve_request(2)  # Status: Approved

        # Notify the student of approval
        advisor.send_notification(
            message=f"Your course selection has been approved: {', '.join(approved_courses)}.",
            req=2
        )
