// Name: Disha Deepak Gupta
// PRN: 24070126513
// Batch: A2

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // creating Scanner object
        Scanner sc = new Scanner(System.in);
        // creating StudentOperations object
        StudentOperations operations = new StudentOperations();
        int choice;

        // displaying the menu
        do {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student by PRN");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Update Student");
            System.out.println("6. Delete Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            // switch case to handle operations according to input
            switch (choice) {
                case 1:
                    operations.addStudent(sc);
                    break;
                case 2:
                    operations.displayStudents();
                    break;
                case 3:
                    operations.searchStudentByPrn(sc);
                    break;
                case 4:
                    operations.searchStudentByName(sc);
                    break;
                case 5:
                    operations.updateStudent(sc);
                    break;
                case 6:
                    operations.deleteStudent(sc);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 7);
        sc.close();
    }
}
