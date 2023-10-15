import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    double tuitionFees;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.tuitionFees = 0.0;
    }
}

public class fees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("Fees Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Calculate Fees");
            System.out.println("3. Display Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(scanner, students);
                    break;
                case 2:
                    calculateFees(scanner, students);
                    break;
                case 3:
                    displayStudentDetails(scanner, students);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void addStudent(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter student name: ");
        String name = scanner.next();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        students.add(new Student(name, rollNumber));
        System.out.println("Student added successfully.");
    }

    public static void calculateFees(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter roll number of the student: ");
        int rollNumber = scanner.nextInt();

        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                System.out.print("Enter tuition fees for " + student.name + ": ");
                student.tuitionFees = scanner.nextDouble();
                System.out.println("Tuition fees updated for " + student.name);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public static void displayStudentDetails(Scanner scanner, ArrayList<Student> students) {
        System.out.print("Enter roll number of the student: ");
        int rollNumber = scanner.nextInt();

        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                System.out.println("Student Details:");
                System.out.println("Name: " + student.name);
                System.out.println("Roll Number: " + student.rollNumber);
                System.out.println("Tuition Fees: " + student.tuitionFees);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }
}
