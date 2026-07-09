package com.java.miniprojects.StudentManagementSystem;

import java.util.Scanner;

public class StudentService {
    /*
     The students array  set to private, which can only access to StudentService class,
     this will prevent the other classes not to access this array.
     Making the students array as final, avoid to reassign the array reference.
    */
    private final Student[] students = new Student[100];

    // scanner is created to ask user where to manupulate the object
    private final Scanner scanner = new Scanner(System.in);

    /*
    * addStudent() validate the student details to add new student.
    * After validation the new student will be added to the students array.
    * If the validation is failed, pass the error message
    * ErrorMessage: "Student cannot be added. Required details are missing or invalid."
    * */
    private void addStudent() {

        System.out.println("Enter Roll Number:");
        System.out.println("Roll Number format: yydcxxx");
        System.out.println("yy: last two digits of year of admission,\ndc: department code,\nxxx: unique number");
        String rollNumber = scanner.next();
        boolean isRollNumberValid = studentRollNumberValidation(rollNumber);
        // If Admission Year is valid, check the department code validation
        if(isRollNumberValid) {

        }

    }

    /*
    * studentRollNumberValidation() validate the student roll number.
    * The roll number should be 7 characters long.
    * The first two characters should be digits.
    * Assumes rollNumber is non-null.
    * */
    private boolean studentRollNumberValidation(String rollNumber) {

        if(rollNumber.length() != 7) {
            System.out.println("Invalid Roll Number. Roll Number should be 7 characters long");
            return false;
        } else if(!Character.isDigit(rollNumber.charAt(0))) {
            System.out.println("Invalid Roll Number. First character should be a digit.");
            return false;
        } else if(!Character.isDigit(rollNumber.charAt(1))) {
            System.out.println("Invalid Roll Number. Second character should be a digit.");
            return false;
        }
        return true;
    }

}
