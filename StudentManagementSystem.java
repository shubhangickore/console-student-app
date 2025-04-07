import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll Number");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    // We'll add these methods in the next steps
    
public static void addStudent() {
    System.out.print("Enter Roll Number: ");
    int roll = scanner.nextInt();
    scanner.nextLine(); // consume newline

    System.out.print("Enter Name: ");
    String name = scanner.nextLine();

    System.out.print("Enter Course: ");
    String course = scanner.nextLine();

    Student student = new Student(roll, name, course);
    students.add(student);

    System.out.println("✅ Student added successfully!");
}
public static void viewStudents() {
    if (students.isEmpty()) {
        System.out.println("⚠️ No students found.");
    } else {
        System.out.println("\n📋 List of Students:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}

   public static void searchStudent() {
    System.out.print("Enter Roll Number to Search: ");
    int roll = scanner.nextInt();
    scanner.nextLine(); // consume newline

    boolean found = false;

    for (Student s : students) {
        if (s.getRollNumber() == roll) {
            System.out.println("🎯 Student Found: " + s);
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("❌ Student with Roll Number " + roll + " not found.");
    }
}
public static void updateStudent() {
    System.out.print("Enter Roll Number to Update: ");
    int roll = scanner.nextInt();
    scanner.nextLine(); // consume newline

    boolean found = false;

    for (Student s : students) {
        if (s.getRollNumber() == roll) {
            System.out.print("Enter New Name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter New Course: ");
            String newCourse = scanner.nextLine();

            s.setName(newName);
            s.setCourse(newCourse);

            System.out.println("✅ Student details updated successfully!");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("❌ Student with Roll Number " + roll + " not found.");
    }
}
public static void deleteStudent() {
    System.out.print("Enter Roll Number to Delete: ");
    int roll = scanner.nextInt();
    scanner.nextLine(); // consume newline

    boolean found = false;

    for (Student s : students) {
        if (s.getRollNumber() == roll) {
            students.remove(s);
            System.out.println("🗑️ Student removed successfully!");
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("❌ Student with Roll Number " + roll + " not found.");
    }
}

}
