package com.java.Prog;

public class AreaCalculator {

    // Calculate the area of a rectangle
    public static double calculateArea(double length, double width) {
        return length * width;
    }

    // Calculate the area of a circle
    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Calculate the area of a triangle
    public static double calculateArea(double base, double height, String shape) {
        if ("triangle".equalsIgnoreCase(shape)) {
            return 0.5 * base * height;
        } else {
            throw new IllegalArgumentException("Unsupported shape: " + shape);
        }
    }

    public static void main(String[] args) {
        double rectangleArea = calculateArea(5.0, 3.0);
        double circleArea = calculateArea(2.5);
        double triangleArea = calculateArea(4.0, 6.0, "triangle");

        System.out.println("Area of Rectangle: " + rectangleArea);
        System.out.println("Area of Circle: " + circleArea);
        System.out.println("Area of Triangle: " + triangleArea);
    }
}