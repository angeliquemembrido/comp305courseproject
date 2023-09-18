package org.example;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        User user = new User("Angelique", "Membrido");
        Admin admin = new Admin("Jennifer", "Olsen");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Upload Lesson Plan");
            System.out.println("2. Remove Lesson Plan");
            System.out.println("3. View All Lesson Plans");
            System.out.println("4. Add Teacher");
            System.out.println("5. Remove Teacher");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter subject: ");
                    String subject = scanner.next();
                    System.out.print("Enter title: ");
                    String title = scanner.next();
                    System.out.print("Enter description: ");
                    String description = scanner.next();
                    boolean uploadStatus = user.uploadLessonPlan(subject, title, description);
                    if (uploadStatus) {
                        System.out.println("Lesson Plan successfully uploaded.");
                    } else {
                        System.out.println("Failed to upload Lesson Plan.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the subject of the lesson plan to remove: ");
                    String removeSubject = scanner.next();
                    System.out.print("Enter the title of the lesson plan to remove: ");
                    String removeTitle = scanner.next();
                    boolean removeStatus = admin.removeLessonPlan(removeSubject, removeTitle);
                    if (removeStatus) {
                        System.out.println("Lesson Plan successfully removed.");
                    } else {
                        System.out.println("Failed to remove Lesson Plan.");
                    }
                    break;
                case 3:
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
                case 4:
                    System.out.print("Enter teacher's first name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter teacher's last name: ");
                    String lastName = scanner.next();
                    System.out.print("Enter teacher subject: ");
                    String teacherSubject = scanner.next();
                    admin.addTeacher(firstName, lastName, teacherSubject);
                    System.out.println("Teacher successfully added.");
                    break;
                case 5:
                    System.out.print("Enter teacher's first name to remove: ");
                    firstName = scanner.next();
                    System.out.print("Enter teacher's last name to remove: ");
                    lastName = scanner.next();
                    removeStatus = admin.removeTeacher(firstName, lastName);
                    if (removeStatus) {
                        System.out.println("Teacher successfully removed.");
                    } else {
                        System.out.println("Teacher not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
