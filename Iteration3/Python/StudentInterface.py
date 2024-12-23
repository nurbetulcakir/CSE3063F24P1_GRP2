import NotificationSystem
import ObjectCreator
import UserInterface


class StudentInterface:


    def run(self):

        current_student = ObjectCreator.students[UserInterface.current_students_index]
        current_transcript = ObjectCreator.transcripts[UserInterface.current_transcripts_index]
        current_student.set_transcript(current_transcript)

        while True:
            print("\nWelcome to the Information Management System!")
            print("1. View Schedule")
            print("2. View Transcript")
            print("3. View Advisor Information")
            print("4. Register for Current Term")
            print("5. Send Courses for Approval")
            print("6. View Notifications")
            print("7. Logout")
            choice = input("Please type the number of your selection: ")

            if choice == "1":
                # View Schedule
                current_student.view_schedule()

            elif choice == "2":
                # View Transcript
                self.view_transcript(current_transcript)

            elif choice == "3":
                # View Advisor Information
                self.view_advisor_information(current_student)

            elif choice == "4":
                # Register for Courses
                self.register_for_courses(current_transcript)

            elif choice == "5":
                # Send Courses for Approval
                self.send_courses_for_approval(current_student, current_transcript)

            elif choice == "6":
                # View Notifications
                self.view_notifications(current_student)

            elif choice == "7":
                # Logout
                print("Logging out...")
                UserInterface.reset_user_session()
                break

            else:
                print("Invalid option. Please try again.")


    def view_transcript(self, current_transcript):

        print("Transcript Details:")
        print(f"Student ID: {current_transcript.get_student_id().get_id()}")
        print(f"Current Term: {current_transcript.get_term()}")
        print(f"First Name: {current_transcript.get_first_name()}")
        print(f"Last Name: {current_transcript.get_last_name()}")
        print(f"GPA: {current_transcript.get_gpa()}")
        print(f"CGPA: {current_transcript.get_cgpa()}")
        print(f"Credits Received: {current_transcript.get_credit_received()}")
        print(f"Credits Earned: {current_transcript.get_credit_earned()}")

        print("\nPassed Courses:")
        for course in current_transcript.get_passed_courses():
            print(f"Course ID: {course.get_course_id().get_id()}")
            print(f"Course Name: {course.get_course_name()}")
            print(f"Final Letter Grade: {course.get_course_letter_grade()}")
            print("-" * 40)

        print("\nFailed Courses:")
        failed_courses = current_transcript.get_failed_courses()
        if failed_courses:
            for course in failed_courses:
                print(f"Course ID: {course.get_course_id().get_id()}")
                print(f"Course Name: {course.get_course_name()}")
                print(f"Final Letter Grade: {course.get_course_letter_grade()}")
                print("-" * 40)
        else:
            print("There is no failed course!")


    def view_advisor_information(self, current_student):

        advisor = current_student.get_advisor()
        if advisor:
            print(f"\nAdvisor Information for {current_student.get_first_name()} {current_student.get_last_name()}:")
            print(f"ID: {advisor.get_lecturer_id().get_id()}")
            print(f"First Name: {advisor.get_first_name()}")
            print(f"Last Name: {advisor.get_last_name()}")
            print("\nGiven Courses:")
            for course in advisor.get_given_courses():
                print(f"Course ID: {course.get_course_id().get_id()} | Course Name: {course.get_course_name()} | Term: {course.get_course_term()} | Credit: {course.get_course_credit()}")
        else:
            print("No advisor assigned. Please contact the administration.")


    def register_for_courses(self, current_transcript):

        current_transcript.set_choosable_courses()
        chosen_courses = []
        max_courses = 5

        while len(chosen_courses) < max_courses:
            print("Choosable Courses:")
            choosable_courses = current_transcript.get_choosable_courses()
            for i, course in enumerate(choosable_courses):
                print(f"{i + 1}. {course.get_course_name()}")

            print(f"{len(choosable_courses) + 1}. Main Menu")
            course_choice = input("Please select a course to register (type the number): ")

            if course_choice == str(len(choosable_courses) + 1):
                break

            try:
                selected_course = choosable_courses[int(course_choice) - 1]
                print(f"Available Sections for {selected_course.get_course_name()}:")
                sections = selected_course.get_course_sections()
                for i, section in enumerate(sections):
                    print(f"{i + 1}. Section {section.get_section_id()} | Capacity: {section.get_capacity()}")

                section_choice = input("Please select a section to register (type the number): ")
                selected_section = sections[int(section_choice) - 1]

                chosen_courses.append(selected_section)
                print(f"Successfully registered for {selected_course.get_course_name()} (Section {selected_section.get_section_id()}).")
            except (IndexError, ValueError):
                print("Invalid selection. Please try again.")

        current_transcript.set_chosen_courses(chosen_courses)


    def send_courses_for_approval(self, current_student, current_transcript):

        if not current_transcript.get_chosen_courses():
            print("You have no chosen courses to send for approval. Please register for courses first.")
            return

        print("The following courses will be sent to your advisor for approval:")
        for course in current_transcript.get_chosen_courses():
            print(f"{course.get_course().get_course_name()} - Section {course.get_section_id()}")

        approval = input("Do you confirm to send for approval? (Y/N): ")
        if approval.lower() == "y":
            current_student.send_for_approval()
            print("Courses successfully sent for approval.")


    def view_notifications(self, current_student):

        NotificationSystem.view_student_notifications(current_student)
        mark_read = input("\nMark all notifications as read? (y/n): ")
        if mark_read.lower() == "y":
            NotificationSystem.mark_student_notifications_as_read(current_student)
