package Activities.Activity2Feb11;

import java.util.Stack;

public class InfixToPostfix {

    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    public static String convert(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char ch : infix.toCharArray()) {

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            // Operator
            else {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String input = "A+B*C";
        System.out.println("Infix: " + input);
        System.out.println("Postfix: " + convert(input));
    }
}
