public class StackArrayList<E> {
    private E[] stack;
    private int top = 0;

    public StackArrayList(int capacity) {
        stack = (E[]) new Object[capacity];
    }

    public void push(E element) {
        stack[top] = element;
        top++;
    }

    public E pop() {
        top--;
        return stack[top];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public static void main(String[] args) {
        StackArrayList<Integer> stack2 = new StackArrayList<>(3); 
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }
}
