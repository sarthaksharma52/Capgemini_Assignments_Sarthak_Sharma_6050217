package Activities.Activity2Feb11;

import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input1 = "(A+B)";
        String input2 = "(A+B";

        System.out.println(input1 + " → " +
                (isBalanced(input1) ? "Balanced" : "Not Balanced"));

        System.out.println(input2 + " → " +
                (isBalanced(input2) ? "Balanced" : "Not Balanced"));
    }
}
