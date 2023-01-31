package day0125;

public class Stack {
    int top;
    int[] stack;
    int size;

    public Stack(int size) {
        top = -1;
        stack = new int[size];
        this.size = size;
    }

    public int peek() {
        return stack[top];
    }

    public void push(int value) {
        stack[++top] = value;
        System.out.println(stack[top] + "PUSH");
    }
    public int pop(int value) {
        System.out.println(stack[top] + "POP");
        return stack[top--];
    }

    public void printStack() {
        System.out.println("-- STACK LIST --");
        for (int i = top; i >= 0; i--)
            System.out.println(stack[i]);
        System.out.println("-- END OF LIST --");
    }

}
