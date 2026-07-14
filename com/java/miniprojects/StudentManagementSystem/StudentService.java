package com.java.miniprojects.StudentManagementSystem;

import java.util.Scanner;
import java.time.LocalDate;

public class StudentService {

    // The college can take max MAX_COLLEGE_INTAKE students
    private static final byte MAX_COLLEGE_INTAKE = (byte) 180;

    /*
     The students array  set to private, which can only access to StudentService class,
     this will prevent the other classes not to access this array.
     Making the students array as final, avoid to reassign the array reference.
    */
    private final Student[] students = new Student[MAX_COLLEGE_INTAKE];

    // scanner is created to ask user where to manipulate the object
    private final Scanner scanner = new Scanner(System.in);

    // The College in-take Departments
    private static final String[] COLLEGE_DEPARTMENTS = {
            "CST", "CSE", "ECE", "ECT", "ITE", "AIE", "EEE", "CVE", "MEC"
    };

    // Each department should take max 'MAX_STUDENTS_PER_DEPARTMENT' students
    private static final byte MAX_STUDENTS_PER_DEPARTMENT = 20;

    /*
    * addStudent() read's the student details:
    * 1. Name
    * 2. Age
    * 3. Department
    * */
    public void addStudent() {
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        byte studentAge = scanner.nextByte();
        scanner.nextLine(); // consume the newline character
        System.out.print("Enter Student Department: ");
        String studentDepartment = scanner.nextLine();
        studentDepartment = studentDepartment.toUpperCase();
        // if block validates the Student Name
        if(studentNameValidation(studentName)) {
            // if studentAgeValidation() is true, validate the Department
            if(studentAgeValidation(studentAge)) {
                // if student department is valid, take admission by generating hall-ticket number
                // and store the student details in the students array
                if(studentDepartmentValidation(studentDepartment)) {
                    byte maxCurrentStudentRollNumber = 0;
                    for(Student student: students) {
                        if(student == null) {
                            break;
                        }
                        if(student.getRollNumber().substring(2, 5).equals(studentDepartment)) {
                            byte runningRollNumber = Byte.parseByte(student.getRollNumber().substring(5, 8));
                            maxCurrentStudentRollNumber = runningRollNumber > maxCurrentStudentRollNumber ? runningRollNumber : maxCurrentStudentRollNumber;
                        }
                    }
                    if(maxCurrentStudentRollNumber >= MAX_STUDENTS_PER_DEPARTMENT) {
                        System.out.println("The Department has Filled. Change your Department");
                        // This return stop the generating roll-number.
                        // You can use 'else' block with below code.
                        return;
                    }
                    // Generate the next student unique number
                    byte nextStudentRollNumber = (byte) (maxCurrentStudentRollNumber + 1);
                    // Generate the admission year
                    LocalDate today = LocalDate.now();
                    int year = today.getYear();
                    String admissionYear = String.valueOf(year);
                    admissionYear = admissionYear.substring(2, 4);
                    // formatting the unique number to 3 digits. (eg: 4 => 004)
                    String uniqueRollNumber = String.format("%03d", nextStudentRollNumber);
                    // New admission roll-number generated
                    String newAdmissionRollNumber = admissionYear + studentDepartment + uniqueRollNumber;

                    // Create the Student object with new Admission
                    Student student = new Student(newAdmissionRollNumber, studentName, studentAge, studentDepartment);
                    // store the student object into the students[]
                    for(int i = 0; i < students.length; i++) {
                        if(students[i] == null) {
                            students[i] = student;
                            break;
                        }
                    }
                }
            }
        }
    }

    /*
    * studentNameValidation() handles the validation of the student details:
    * 1. Name should not be empty
    * 2. Name should not contain special character
    * 3. Name should not contain digits
    * 4. Name should have the minimum length
    * 5. Name should have the maximum length
    * */
    private boolean studentNameValidation(String studentName) {
        boolean isNameValid = true;
        if(studentName.length() >= 5 && studentName.length() <= 20) {
            for(char ch: studentName.toCharArray()) {
                if(!Character.isLetter(ch) && ch != ' ') {
                    isNameValid = false;
                    System.out.println("Name should not contain special characters or digits.");
                    break;
                }
            }
        } else {
            isNameValid = false;
            System.out.println("Name should have a minimum length of 5 and a maximum length of 20.");
        }
        return isNameValid;
    }

    /*
    * studentAgeValidation() handles the student age:
    * 1. Student age should be greater than or equal to 17
    * 2. Student age should be less than or equal to 22
    * */
    private boolean studentAgeValidation(byte studentAge) {
        if(studentAge < 17 || studentAge > 22) {
            System.out.println("Student age should be between 17 and 22.");
            return false;
        }
        return true;
    }

    /*
    * studentDepartmentValidation() handles the student department:
    * college take's the admission only the branch's active in the college
    * */
    private boolean studentDepartmentValidation(String studentDepartment) {
        boolean isDepartmentValid = false;
        for(String dept: COLLEGE_DEPARTMENTS) {
            if(dept.equals(studentDepartment)) {
                isDepartmentValid = true;
                break;
            }
        }
        if(!isDepartmentValid) {
            System.out.println("Invalid department. Please enter a valid department.");
        }
        return isDepartmentValid;
    }
}

