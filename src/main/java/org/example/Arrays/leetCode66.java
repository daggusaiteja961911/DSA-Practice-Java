package org.example.Arrays;

public class leetCode66 {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }

        public static void main(String[] args) {
            leetCode66 solution = new leetCode66();
            int[] digits = {9, 1, 9};
            int[] result = solution.plusOne(digits);
            System.out.print("Result: ");
            for (int digit : result) {
                System.out.print(digit);
            }
            // Output: 1000
        }

}
