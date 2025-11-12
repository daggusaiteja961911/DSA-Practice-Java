package org.example.StackAndQueues;

import java.util.*;

public class InfixToPostfix {
    public static void main(String[] args) {
        String infix = "A+B*(C^D-E)";
        System.out.println("Infix Expression:   " + infix);
        System.out.println("Postfix Expression: " + infixToPostfix(infix));
    }

    public static String infixToPostfix(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            // 1️⃣ Operand → directly add to result
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            }
            // 2️⃣ '(' → push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // 3️⃣ ')' → pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // remove '('
            }
            // 4️⃣ Operator → pop higher/equal precedence operators
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // 5️⃣ Pop all remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // Helper to check if character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^';
    }

    // Helper to define operator precedence
    private static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        if (c == '^') return 3;
        return -1;
    }
}
