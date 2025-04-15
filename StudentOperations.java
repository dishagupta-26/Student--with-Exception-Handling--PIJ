import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class StudentOperations {
    private ArrayList<Student> students;

    // constructor
    public StudentOperations() {
        students = new ArrayList<>();
    }

    // method to add student
    public void addStudent(Scanner sc) {
        try {
            System.out.println("Enter PRN: ");
            long prn = sc.nextLong();
            sc.nextLine();
            System.out.println("Enter Name: ");
            String name = sc.nextLine();
            System.out.println("Enter DOB (yyyy-mm-dd): ");
            String dobStr = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = sdf.parse(dobStr); // parse the input string to a date object
            System.out.println("Enter Marks: ");
            double marks = sc.nextDouble();

            students.add(new Student(prn, name, dob, marks));
            System.out.println("Student added successfully!");
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use dd-MM-yyyy.");
        }
    }

    // method to display all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display!");
            return;
        }
        for (Student student : students) {
            student.displayStudentDetails();
        }
    }

    // method to search student by PRN
    public void searchStudentByPrn(Scanner sc) {
        System.out.print("Enter PRN to search: ");
        long prn = sc.nextLong();

        for (Student student : students) {
            if (student.getPrn() == prn) {
                System.out.println("Student found:");
                student.displayStudentDetails();
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    // method to search student by name
    public void searchStudentByName(Scanner sc) {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("Student found:");
                student.displayStudentDetails();
                return;
            }
        }
        System.out.println("Student with Name " + name + " not found.");
    }

    // method to update student details
    public void updateStudent(Scanner sc) {
        System.out.print("Enter PRN of student to update: ");
        long prn = sc.nextLong();
        sc.nextLine();

        for (Student student : students) {
            if (student.getPrn() == prn) {
                System.out.print("Enter new Name: ");
                String name = sc.nextLine();
                student.setName(name);

                System.out.print("Enter new Date of Birth (yyyy-mm-dd): ");
                String dobStr = sc.nextLine();
                if (!dobStr.isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        Date dob = sdf.parse(dobStr);
                        student.setDob(dob);
                    } catch (ParseException e) {
                        System.out.println("Invalid date format! Please use dd-MM-yyyy.");
                        return;
                    }
                }

                System.out.print("Enter new Marks: ");
                double marks = sc.nextDouble();
                student.setMarks(marks);

                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }

    // method to delete student
    public void deleteStudent(Scanner sc) {
        System.out.print("Enter PRN of student to delete: ");
        long prn = sc.nextLong();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPrn() == prn) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student with PRN " + prn + " not found.");
    }
}
