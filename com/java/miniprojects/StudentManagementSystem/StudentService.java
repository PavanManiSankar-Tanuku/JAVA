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
        // if block validates the Student Name
        if(studentNameValidation(studentName)) {
            if(studentAgeValidation(studentName)) {

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

}

