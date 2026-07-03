package com.java.core;

public class VariablesAndDatatypes {
    static void main(String[] args) {

//        printing the bytes, size and range of primitive datatypes
//        Note: we cant get the min and max values to both character and boolean

        System.out.println("Byte");
        System.out.println("Bytes: " + Byte.BYTES);
        System.out.println("Bits:" + Byte.SIZE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println();

        System.out.println("Short");
        System.out.println("Bytes: " + Short.BYTES);
        System.out.println("Bits:" + Short.SIZE);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println();

        System.out.println("Integer");
        System.out.println("Bytes: " + Integer.BYTES);
        System.out.println("Bits:" + Integer.SIZE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println();

        System.out.println("Long");
        System.out.println("Bytes: " + Long.BYTES);
        System.out.println("Bits:" + Long.SIZE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
        System.out.println();

        System.out.println("Float");
        System.out.println("Bytes: " + Float.BYTES);
        System.out.println("Bits:" + Float.SIZE);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println();

        System.out.println("Double");
        System.out.println("Bytes: " + Double.BYTES);
        System.out.println("Bits:" + Double.SIZE);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);
        System.out.println();

        System.out.println("Character");
        System.out.println("Bytes: " + Character.BYTES);
        System.out.println("Bits:" + Character.SIZE);
        System.out.println(Character.MIN_VALUE);
        System.out.println(Character.MAX_VALUE);
        System.out.println();

        System.out.println("Boolean");
        System.out.println(Boolean.TYPE);
        System.out.println(Boolean.FALSE);
        System.out.println(Boolean.TRUE);
    }
}
