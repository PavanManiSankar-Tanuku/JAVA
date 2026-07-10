package com.java.miniprojects.StudentManagementSystem;

import java.util.Scanner;

public class StudentService {
    /*
     The students array  set to private, which can only access to StudentService class,
     this will prevent the other classes not to access this array.
     Making the students array as final, avoid to reassign the array reference.
    */
    private final Student[] students = new Student[100];

    // scanner is created to ask user where to manipulate the object
    private final Scanner scanner = new Scanner(System.in);

    /*
    * addStudent() validate the student details to add new student.
    * After validation the new student will be added to the students array.
    * If the validation is failed, pass the error message
    * ErrorMessage: "Student cannot be added. Required details are missing or invalid."
    * */
    public void addStudent() {

        System.out.println("Enter Roll Number:");
        System.out.println("Roll Number format: yydpcxxx");
        System.out.println("yy: last two digits of year of admission,\ndpc: department code,\nxxx: unique number");
        String rollNumber = scanner.next();
        boolean isAdmissionYearValid = rollNumberLengthAndAdmissionYearValidation(rollNumber);
        // If roll number is valid, continue reading remaining details.
        if(isAdmissionYearValid) {
            boolean isDepartmentValid = rollNumberDepartmentValidation(rollNumber);
            if(isDepartmentValid) {

            }
        }

    }

    /*
    * studentRollNumberValidation() validate the student roll number.
    * The roll number should be 8 characters long.
    * The first two characters should be digits.
    * Assumes rollNumber is non-null.
    * */
    private boolean rollNumberLengthAndAdmissionYearValidation(String rollNumber) {

        if(rollNumber.length() != 8) {
            System.out.println("Invalid Roll Number. Roll Number should be 8 characters long");
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

    /*
    * rollNumberDepartmentValidation() validates the student roll number
    * It handles the Department Codes validation, that only the college accepts.
    * */
    // Valid department codes offered by the college
    private static final String[] VALID_DEPARTMENTS = new String[] { "CST", "CSE", "ITE", "AME", "EEE", "ECE", "ECT", "MEC", "CIV", "CIC" };

    private boolean rollNumberDepartmentValidation(String rollNumber) {

        if(!Character.isLetter(rollNumber.charAt(2))) {
            System.out.println("Invalid Roll Number. Please enter valid Department Characters.");
            return false;
        } else if (!Character.isLetter(rollNumber.charAt(3))) {
            System.out.println("Invalid Roll Number. Please enter valid Department Characters.");
            return false;
        } else if(!Character.isLetter(rollNumber.charAt(4))) {
            System.out.println("Invalid Roll Number. Please enter valid Department Characters.");
            return false;
        }

        rollNumber = rollNumber.toUpperCase();
        String userDep = rollNumber.substring(2, 5);
        boolean isValidDepartment = false;
        for (String validDepartment : VALID_DEPARTMENTS) {
            if (userDep.equals(validDepartment)) {
                isValidDepartment = true;
                break;
            }
        }
        if (!isValidDepartment) {
            System.out.println("Invalid Roll Number. Please enter valid Department Codes.");
        }
        return isValidDepartment;
    }
}

