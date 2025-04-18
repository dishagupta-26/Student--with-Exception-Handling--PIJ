# Student Management System

This is a Java-based Student Data Entry System that allows adding, updating, deleting, and searching student records. Each function is equipped with custom exception handling to ensure robust performance.

## Features

- **Add Student**: Input and store new student details.
- **View Students**: Display all stored student records.
- **Update Student**: Modify existing student information.
- **Search Student by PRN**: Find a student using their unique PRN.
- **Search Student by Name**: Locate students based on their names.
- **Delete Student**: Remove a student's record from the system.

## Custom Exceptions per Function

### **1. Add Student**
- `DuplicateStudentException` – Thrown when student with the entered PRN already exist.
- `InvalidMarksException` – Thrown when marks are not in the range of 1.0 to 10.0.

### **2. Display All Students**
- `EmptyStudentListException` – Thrown when student list is empty.
- `DisplayException` – Thrown when a null student object is encountered during diplay.

### **3. Search Student by PRN**
- `InvalidSearchPrnException` – Thrown when PRN input is invalid (not 11 digits).
- `PrnDoesNotExistException` – Thrown when theentered PRN doesn't exist.

### **4. Search Student by Name**
- `InvalidNameFormatException` – Thrown when the name is less than or equal to 2 characters.
- `NameNotFoundException` – Thrown when no student is found with the given name.

### **5. Update Student**
- `StudentNotFoundForUpdateException` – Thrown when the student with the given PRN is not found.
- `InvalidUpdateMarksException` – Thrown when new marks are outside the valid range (1.0 to 10.0).

### **6. Delete Student**
- `InvalidDeletePrnException` – Thrown when the PRN entered for deletion is invalid (not 11 digits).
- `StudentNotFoundForDeleteException` – Thrown when no student matches the PRN for deletion.

## Prerequisites

Before running the application, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 8 or higher.
- **Integrated Development Environment (IDE)**: Such as IntelliJ IDEA, Eclipse, or NetBeans.

## Installation

1. **Clone the Repository**: Download or clone the project repository to your local machine.

   ```bash
   git clone https://github.com/dishagupta-26/Student-PIJ.git
