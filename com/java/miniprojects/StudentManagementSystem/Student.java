package com.java.miniprojects.StudentManagementSystem;

public class Student {
    private String rollNumber;
    private String name;
    private byte age;
    private float cgpa;
    private static String collegeName;
    private static int studentCount;

    static {
        collegeName = "Akhil Institute of Technology and Engineering";
    }

    //    default constructor
    public Student() {

    }

    // parameterised constructor
    public Student(String rollNumber, String name, byte age, float cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
        studentCount++;
    }

    // setters and getters
    public static void setCollegeName(String collegeName) {
        Student.collegeName = collegeName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setCGPA(float cgpa) {
        this.cgpa = cgpa;
    }

    public static String getCollegeName() {
        return collegeName;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getName() {
        return name;
    }

    public byte getAge() {
        return age;
    }

    public float getCgpa() {
        return cgpa;
    }

}