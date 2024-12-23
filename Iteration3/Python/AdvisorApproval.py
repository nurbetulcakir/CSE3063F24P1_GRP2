class AdvisorApproval:

    @staticmethod
    def approve_courses(advisor, student):
        # Iterate through the student's chosen courses
        for section in student.get_chosen_courses():
            if section.get_capacity() > 0:
                advisor.add_to_approved_courses(section)
                section.enroll_student(student)  # Enroll the student in the course
                section.set_capacity(section.get_capacity() - 1)  # Decrease capacity
                print(f"Course approved: {section.get_course().get_course_name()}")
            else:
                print(f"Course {section.get_course().get_course_name()} is full.")
        # Update the student's approval request
        student.set_approve_request(2)  # Approved status
