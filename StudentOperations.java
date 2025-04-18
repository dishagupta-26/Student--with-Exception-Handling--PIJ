import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
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

            for (Student s : students) {
                if (s.getPrn() == prn) {
                    throw new DuplicateStudentException("Student with PRN " + prn + " already exists.");
                }
            }

            System.out.println("Enter Name: ");
            String name = sc.nextLine();

            System.out.println("Enter DOB (dd-MM-yyyy): ");
            String dobStr = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date dob = sdf.parse(dobStr);

            System.out.println("Enter Marks (1.0 to 10.0): ");
            float marks = sc.nextFloat();
            sc.nextLine(); // clear buffer

            if (marks < 1.0 || marks > 10.0) {
                throw new InvalidMarksException("Marks should be in the range 1.0 to 10.0");
            }

            students.add(new Student(prn, name, dob, marks));
            System.out.println("Student added successfully!");

        } catch (DuplicateStudentException | InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please use dd-MM-yyyy.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter correct data.");
            sc.nextLine(); // clear buffer
        }
    }

    // method to display all students
    public void displayStudents() {
        try {
            if (students.isEmpty()) {
                throw new EmptyStudentListException("No students to display!");
            }

            for (Student student : students) {
                if (student == null) {
                    throw new DisplayException("Encountered a null student object while displaying.");
                }
                student.displayStudentDetails();
            }

        } catch (EmptyStudentListException | DisplayException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // method to search student by PRN
    public void searchStudentByPrn(Scanner sc) {
        try {
            System.out.print("Enter PRN to search: ");
            long prn = sc.nextLong();
            sc.nextLine(); // clear buffer

            // validate PRN length
            if (String.valueOf(prn).length() != 11) {
                throw new InvalidSearchPrnException("PRN must be exactly 11 digits.");
            }

            for (Student student : students) {
                if (student.getPrn() == prn) {
                    System.out.println("Student found:");
                    student.displayStudentDetails();
                    return;
                }
            }

            throw new PrnDoesNotExistException("No student found with PRN: " + prn);

        } catch (InvalidSearchPrnException | PrnDoesNotExistException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric PRN.");
            sc.nextLine(); // Clear buffer
        }
    }

    // method to search student by name
    public void searchStudentByName(Scanner sc) {
        try {
            System.out.print("Enter Name to search: ");
            String name = sc.nextLine();

            // validate name length
            if (name.length() <= 2) {
                throw new InvalidNameFormatException("Name must be more than 2 characters.");
            }

            for (Student student : students) {
                if (student.getName().equalsIgnoreCase(name)) {
                    System.out.println("Student found:");
                    student.displayStudentDetails();
                    return;
                }
            }

            throw new NameNotFoundException("No student found with name: " + name);

        } catch (InvalidNameFormatException | NameNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
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
                float marks = sc.nextFloat();
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
