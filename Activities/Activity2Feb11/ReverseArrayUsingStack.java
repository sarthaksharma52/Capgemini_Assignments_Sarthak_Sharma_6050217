package Activities.Activity2Feb11;

import java.util.Stack;
import java.util.Arrays;

public class ReverseArrayUsingStack {

    public static void reverse(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int num : arr) {
            stack.push(num);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        reverse(arr);

        System.out.println(Arrays.toString(arr));
    }
}

