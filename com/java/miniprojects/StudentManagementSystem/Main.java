package com.java.miniprojects.StudentManagementSystem;

import java.util.Scanner;

public class Main {
//    The object scanner is created used to know the user choice
    private final static Scanner scanner = new Scanner(System.in);
//    The object studentService is created to access the StudentService class methods
//    The studentService is created as field to avoid often creation, when main method is called
    private final static StudentService studentService = new StudentService();

    private static void menu() {

        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");

        System.out.print("Please enter your choice: ");
        byte userChoice = scanner.nextByte();
        scanner.nextLine(); // consume the newline character

        switch (userChoice) {
            case 1:
                System.out.println();
                studentService.addStudent();
                break;
            case 2:
                System.out.println();
                studentService.viewStudents();
                break;
            case 3:
                System.out.println();
                studentService.searchStudent();
                break;
            case 4:
                System.out.println();
                studentService.updateStudent();
                break;
            case 5:
                System.out.println();
                studentService.deleteStudent();
                break;
            case 6:
                System.out.println("Thank you for using Student Management System.");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }


    static void main(String[] args) {
        System.out.println("Welcome to Student Management System");
        while(true) {
            Main.menu();
            System.out.println();
        }
    }
}
