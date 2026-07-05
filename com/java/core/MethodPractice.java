package com.java.core;

import java.util.Scanner;

public class MethodPractice {

    /* Addition of two numbers: int a, int b */
    public static int add(int a, int b) {
        return (a + b);
    }

    /* Subtraction of two numbers: int a, int b */
    public static int absoluteDifference(int a, int b){
        int result = (a >= b) ? a - b : b - a;
        return result;
    }

    /* Multiplication of two numbers: int a, int b */
    public static int multiply(int a, int b) {
        return (a * b);
    }

    /* Division of two numbers: double a, double b
    * Note: Division is Not Allowed when denominator is zero */
    public static double divide(double a, double b) {
        if(b != 0) {
            return (a / b);
        } else {
            System.err.println("Divide by zero is Not Allowed");
            return -1;
        }
    }

    /* Squaring a number: int a */
    public static int square(int a) {
        return (a * a);
    }

    /* Calculating cube on number: int a */
    public static int cube(int a) {
        return (a * a * a);
    }

    /* Checking number is even or odd */
    public static boolean isEven(int n) {
        return (n % 2 == 0);
    }

    /* Calculating the number is prime or not */
    public static boolean isPrime(int n) {
        boolean checkPrime = true;
        if(n < 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                checkPrime = false;
                break;
            }
        }
        return checkPrime;
    }

    /* Computing factorial of a number */
    public static int factorial(int n) {
        int product = 1;
        if(n < 0) product = -1;
        for(int i = 1; i <= n; i++) {
            product *= i;
        }
        return product;
    }

    /* Computing the GCD of two numbers */
    public static int gcd(int a, int b) {
        if(a == 0 || b == 0) return -1;
        int n = Math.max(a, b);
        while(n > 0) {
            if(a % n == 0 && b % n == 0) {
                return n;
            }
            n--;
        }
        return -1;
    }

    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        System.out.println("Addition: " + add(a, b));
        System.out.println("Subtraction: " + absoluteDifference(a, b));
        System.out.println("Multiplication: " + multiply(a, b));
        System.out.println("Division: " + divide(a, b));
        System.out.println("Square of " + a + ": " + square(a));
        System.out.println("Cube of " + a + ": " + cube(a));
        System.out.println(a + " is even: " + isEven(a));
        System.out.println(a + " is prime: " + isPrime(a));
        System.out.println("Factorial of " + a + ": " + factorial(a));
        System.out.println("GCD of " + a + " and " + b + ": " + gcd(a, b));
    }

}
