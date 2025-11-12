package org.example.Arrays;

public class ConstructASmallestNumberFromDIString {
    // Leetcode Problem 2375: Construct Smallest Number From DI String
    public String smallestNumber(String pattern) {
        StringBuilder res = new StringBuilder();
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i <= pattern.length(); i++) {
            stack.append((char) ('1' + i));
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                res.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        ConstructASmallestNumberFromDIString solution = new ConstructASmallestNumberFromDIString();
        String pattern = "IIIDIDDD";
        String result = solution.smallestNumber(pattern);
        System.out.println("Smallest number for pattern " + pattern + " is: " + result);
    }

}
