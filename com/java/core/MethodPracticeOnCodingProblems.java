package com.java.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MethodPracticeOnCodingProblems {

    // Returns Maximum of two numbers
    // Taking double as return type - covers edge case
    public static double maximumOfTwoNumbers(double a, double b) {
        return Math.max(a, b);
    }

    // Returns Maximum of three numbers
    // Taking double return type - covers edge case
    public static double maximumOfThreeNumbers(double a, double b, double c) {
        return Math.max(Math.max(a, b), c);
    }

    // Return Minimum of three numbers
    // Taking double return type - covers edge case
    public static double minimumOfThreeNumbers(double a, double b, double c) {
        return Math.min(Math.min(a, b), c);
    }

    // Return the average of an array
    // Taking double array type
    public static double averageOfAnArray(double[] nums) {
        if(nums.length == 0) return 0;
        double total = 0;
        for(double num: nums) {
            total += num;
        }
        return total / nums.length;
    }

    // Return a String that reversed the String
    public static String reverString(String str) {
        if(str.length() == 0) {
            System.err.println("String is Empty!");
            return "";
        }
        // Using String Builder because of single threaded
        StringBuilder sb = new StringBuilder(str);
        int left = 0;
        int right = sb.length() - 1;
        while(left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
        // converting to String before returning from StringBuilder
        return sb.toString();
    }

    // Return number of VOWELS from a String
    public static int countVowels(String str) {
        if(str.length() <= 0) {
            System.err.println("String is Empty!");
            return -1;
        }
        Map<Character, Integer> vowels = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels.put(ch, vowels.getOrDefault(ch, 0) + 1);
            }
        }
        // counting number of vowels
        int total = 0;
        for(Map.Entry<Character, Integer> entry: vowels.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }

    // Return String is Palindrome or not
    public static boolean isPalindrome(String str) {
        if(str.length() <= 0) {
            System.err.println("String is Empty!");
            return false;
        }
        boolean checkPalindrome =  true;
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                checkPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        return checkPalindrome;
    }

    // Return number of digits in a number
    public static int countDigits(int n) {
        int count = 0;
        // if n = 0, return 1, without going into the loop
        if(n == 0) return 1;
        // converting negative number to positive, to avoid '-' sign in 'n'
        if(n < 0) n = -n;
        while(n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    // Return the sum of digits in a number
    public static int sumOfDigits(int n) {
        if(n == 0) return 0;
        if(n < 0) n = -n;
        int total = 0;
        while(n != 0) {
            int lastDigit = n % 10;
            total += lastDigit;
            n /= 10;
        }
        return total;
    }

    // Compute Fibonacci Series of nth term
    public static int nthFibonacciTerm(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int i = 0;
        int a = 0, b = 1, c = 0;
        if(n >= 2) {
            while(i <= n - 2) {
                c = a + b;
                a = b;
                b = c;
                i++;
            }
        }
        return c;
    }

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers to find maximum number: ");
        double twoA = scanner.nextInt();
        double twoB = scanner.nextInt();
        System.out.println("Maximum of two numbers: " + maximumOfTwoNumbers(twoA, twoB));
        System.out.println();

        System.out.print("Enter three numbers to find maximum number: ");
        double threeA = scanner.nextDouble();
        double threeB = scanner.nextDouble();
        double threeC = scanner.nextDouble();
        System.out.println("Maximum of three numbers: " + maximumOfThreeNumbers(threeA, threeB, threeC));
        System.out.println();

        System.out.println("Minimum of three numbers: " + minimumOfThreeNumbers(threeA, threeB, threeC));
        System.out.println();

        System.out.print("Enter the size of the array to find average: ");
        int size = scanner.nextInt();
        double[] nums = new double[size];
        System.out.print("Enter the elements of the array: ");
        for(int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextDouble();
        }
        System.out.println("Average of the array: " + averageOfAnArray(nums));
        System.out.println();

        System.out.println("Enter a string to reverse: ");
        String str = scanner.next();
        System.out.println("Reversed String: " + reverString(str));
        System.out.println();

        System.out.println("Number of Vowels in the string " + str + " is: " + countVowels(str));
        System.out.println();

        System.out.println("Is the string " + str + " a Palindrome? " + isPalindrome(str));
        System.out.println();

        System.out.print("Enter a number to count the digits: ");
        int n = scanner.nextInt();
        System.out.println("Number of digits in the number " + n + " is: " + countDigits(n));
        System.out.println();

        System.out.println("Sum of digits in the number " + n + " is: " + sumOfDigits(n));
        System.out.println();

        System.out.println("Enter the term to find the Fibonacci series: ");
        int nthTerm = scanner.nextInt();
        System.out.println("The " + nthTerm + "th term of the Fibonacci series is: " + nthFibonacciTerm(nthTerm));
        System.out.println();

        scanner.close();
    }

}
