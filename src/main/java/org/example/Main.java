package org.example;
import java.util.List;
import java.util.Scanner;

import static org.example.Course.allCourses;

public class Main {
    public static void main(String[] args) {
        User user = new User("Angelique", "Membrido");
        Admin admin = new Admin("Jennifer", "Olsen");
        Student student = new Student("Diego", "Torero");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. Teacher");
            System.out.println("3. Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // Handles newline

            switch (roleChoice) {
                case 1:
                    adminMenu(admin, scanner);
                    break;
                case 2:
                    userMenu(user, scanner);
                    break;
                case 3:
                    studentMenu(student, scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void adminMenu(Admin admin, Scanner scanner) {
        userMenu(admin, scanner);

    }

    public static void userMenu(User user, Scanner scanner) {
        int choice;
        while (true) {
            System.out.println("User Menu:");
            System.out.println("1. Back to Role Selection");
            System.out.println("2. View All Lesson Plans");
            System.out.println("3. Search Lesson Plans by Subject");
            System.out.println("4. Upload Lesson Plan");
            System.out.println("5. Add a Teacher");
            System.out.println("6. View All Teachers");


            // If user is an instance of Admin, provide more menu options.
            if (user instanceof Admin) {
                System.out.println("7. Remove Lesson Plan");
                System.out.println("8. Remove Teacher");
                System.out.println("9. View All Courses");
                System.out.println("10. Add a Course");
            }

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    return; // Return to role selection menu
                case 2:
                    List<LessonPlan> lessonPlans = user.viewLessonPlans();
                    if (lessonPlans.isEmpty()) {
                        System.out.println("No Lesson Plans found.");
                    } else {
                        System.out.println("List of Lesson Plans:");
                        System.out.format("%-20s %-20s %-20s%n", "Subject", "Title", "Description");
                        System.out.format("%-20s %-20s %-20s%n", "-------", "-----", "-----------");
                        for (LessonPlan lp : lessonPlans) {
                            System.out.format("%-20s %-20s %-20s%n", lp.getSubject(), lp.getTitle(), lp.getDescription());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the subject to search: ");
                    String searchSubject = scanner.nextLine();
                    List<LessonPlan> searchedPlans = user.searchBySubject(searchSubject);
                    if(searchedPlans.isEmpty()) {
                        System.out.println("No Lesson Plans found for the subject: " + searchSubject);
                    } else {
                        System.out.println("List of Lesson Plans for the subject: " + searchSubject);
                        System.out.format("%-20s %-20s %-20s%n", "Subject", "Title", "Description");
                        System.out.format("%-20s %-20s %-20s%n", "-------", "-----", "-----------");
                        for (LessonPlan lp: searchedPlans) {
                            System.out.format("%-20s %-20s %-20s%n", lp.getSubject(), lp.getTitle(), lp.getDescription());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter subject: ");
                    String subject = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    Boolean uploadStatus = user.uploadLessonPlan(subject, title, description);
                    if (uploadStatus) {
                        System.out.println("Lesson Plan successfully uploaded.");
                    } else {
                        System.out.println("Failed to upload Lesson Plan. Please make sure none of the fields are empty.");
                    }
                    break;
                case 5:
                    if (user instanceof Admin) {
                        System.out.print("Enter teacher's first name: ");
                        String firstName = scanner.nextLine();
                        System.out.print("Enter teacher's last name: ");
                        String lastName = scanner.nextLine();
                        System.out.print("Enter teacher subject: ");
                        String teacherSubject = scanner.nextLine();
                        boolean addStatus = user.addTeacher(firstName, lastName, teacherSubject);
                        if (addStatus) {
                            System.out.println("Teacher successfully added.");
                        } else {
                            System.out.println("Failed to add teacher. Please make sure none of the fields are empty.");
                        }
                        break;
                    }
                case 6:
                    List<Teacher> allTeachers = user.viewAllTeachers();
                    if(allTeachers.isEmpty()) {
                        System.out.println("No teachers available.");
                    } else {
                        System.out.println("List of All Teachers:");
                        System.out.format("%-20s %-20s %-20s%n", "First Name", "Last Name", "Subject");
                        System.out.format("%-20s %-20s %-20s%n", "----------", "---------", "-------");

                        for(Teacher teacher: allTeachers) {
                            System.out.format("%-20s %-20s %-20s%n", teacher.getFirstName(), teacher.getLastName(), teacher.getSubject());
                        }
                    }
                    break;
                case 7:
                    if (user instanceof Admin) {
                        System.out.print("Enter the subject of the lesson plan to remove: ");
                        String removeSubject = scanner.nextLine();
                        System.out.print("Enter the title of the lesson plan to remove: ");
                        String removeTitle = scanner.nextLine();
                        boolean removeStatus = ((Admin) user).removeLessonPlan(removeSubject, removeTitle);
                        if (removeStatus) {
                            System.out.println("Lesson Plan successfully removed.");
                        }
                        else {
                            System.out.println("Failed to remove Lesson Plan.");
                        }
                        break;
                    }
                case 8:
                    if (user instanceof Admin) {
                        System.out.print("Enter teacher's first name to remove: ");
                        String firstName = scanner.next();
                        System.out.print("Enter teacher's last name to remove: ");
                        String lastName = scanner.next();
                        Boolean removeStatus = ((Admin) user).removeTeacher(firstName, lastName);
                        if (removeStatus) {
                            System.out.println("Teacher successfully removed.");
                        } else {
                            System.out.println("Teacher not found.");
                        }
                        break;
                    }
                case 9:
                    List<Course> allCourses = Course.getAllCourses();
                    if (allCourses.isEmpty()) {
                        System.out.println("No courses available.");
                    } else {
                        System.out.println("List of All Courses:");
                        System.out.format("%-15s %-30s%n", "Course Code", "Description");
                        System.out.format("%-15s %-30s%n", "-----------", "-----------");
                        for (Course course : allCourses) {
                            System.out.format("%-15s %-30s%n", course.getCourseCode(), course.getDescription());
                        }
                    }
                    break;
                case 10:
                    if (user instanceof Admin) {
                        System.out.print("Enter the course code: ");
                        String courseCode = scanner.nextLine();
                        System.out.print("Enter the course description: ");
                        String courseDescription = scanner.nextLine();

                        Course newCourse = new Course(courseCode, courseDescription);

                        boolean added = ((Admin) user).addCourse(newCourse);
                        if (added) {
                            System.out.println("Course added successfully.");
                        } else {
                            System.out.println("Failed to add the course.");
                        }
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void studentMenu(Student student, Scanner scanner) {
        while (true) {
            System.out.println("\nStudent Menu:");
            System.out.println("1. View Enrolled Courses");
            System.out.println("2. Enroll in a Course");
            System.out.println("3. View All Course Offerings");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int studentChoice = scanner.nextInt();
            scanner.nextLine(); // Handles newline

            switch (studentChoice) {
                case 1:
                    System.out.println("Enrolled Courses:");
                    List<Course> enrolledCourses = student.getEnrolledCourses();
                    if (enrolledCourses.isEmpty()) {
                        System.out.println("You are not enrolled in any courses.");
                    } else {
                        for (Course course : enrolledCourses) {
                            System.out.println("Course Code: " + course.getCourseCode());
                            System.out.println("Description: " + course.getDescription());
                            System.out.println("-------------------------");
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter the course code you want to enroll in: ");
                    String courseCodeToEnroll = scanner.nextLine();

                    // Find the course with the entered course code
                    Course selectedCourse = null;
                    for (Course course : allCourses) {
                        if (course.getCourseCode().equals(courseCodeToEnroll)) {
                            selectedCourse = course;
                            break;
                        }
                    }

                    if (selectedCourse != null) {
                        student.enrollCourse(selectedCourse);
                        System.out.println("Enrolled in course: " + selectedCourse.getDescription());
                    } else {
                        System.out.println("Course with code " + courseCodeToEnroll + " not found.");
                    }
                    break;
                case 3:
                    List<Course> allCourses = Course.getAllCourses();
                    if (allCourses.isEmpty()) {
                        System.out.println("No courses available.");
                    } else {
                        System.out.println("List of All Courses:");
                        System.out.format("%-15s %-30s%n", "Course Code", "Description");
                        System.out.format("%-15s %-30s%n", "-----------", "-----------");
                        for (Course course : allCourses) {
                            System.out.format("%-15s %-30s%n", course.getCourseCode(), course.getDescription());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Returning to Main Menu.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

