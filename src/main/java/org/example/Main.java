import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Upload Lesson Plan");
            System.out.println("2. View All Lesson Plans");
            System.out.println("3. Exit");

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
                    boolean uploadStatus = admin.uploadLessonPlan(subject, title, description);
                    if (uploadStatus) {
                        System.out.println("Lesson Plan successfully uploaded.");
                    } else {
                        System.out.println("Failed to upload Lesson Plan.");
                    }
                    break;
                case 2:
                    List<LessonPlan> lessonPlans = admin.viewAllLessonPlans();
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
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
