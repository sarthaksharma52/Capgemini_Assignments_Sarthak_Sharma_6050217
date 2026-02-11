package Activities.Activity1Feb11;

class StackArray {
    int[] arr;
    int top;
    int size;

    StackArray(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int val) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = val;
        System.out.println(val + " pushed into stack");
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

public class StackUsingArray {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        stack.push(40);
        System.out.println("Peek element : " + stack.peek());
    }
}