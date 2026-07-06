package com.java.core;

import java.util.Scanner;

public class AreaCalculator {

    // Return area of a square
    public static double area(int side) {
        if(side <= 0) {
            System.err.println("Invalid input. Side must be a positive number.");
            return -1;
        }
        return side * side;
    }

    // Return area of a rectangle
    public static double area(double length, double breadth) {
        if(length <= 0 || breadth <= 0) {
            System.err.println("Invalid input. Length and breadth must be positive numbers.");
            return -1;
        }
        return length * breadth;
    }

    // Return area of circle
    public static double area(double radius) {
        if(radius <= 0) {
            System.err.println("Invalid input. Radius must be a positive number.");
            return -1;
        }
        return Math.PI * (radius * radius);
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the side(Integer) of the square: ");
        int side = scanner.nextInt();
        System.out.println("Area of square: " + area(side));
        System.out.println();

        System.out.print("Enter the length and breadth of the rectangle: ");
        double length = scanner.nextDouble();
        double breadth = scanner.nextDouble();
        System.out.println("Area of rectangle: " + area(length, breadth));
        System.out.println();

        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        System.out.println("Area of circle: " + area(radius));

        scanner.close();
    }

}
