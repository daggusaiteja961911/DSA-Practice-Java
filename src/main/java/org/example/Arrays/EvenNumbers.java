package org.example.Arrays;

public class EvenNumbers {
    //Write Even numbers from 1 to 100

    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
