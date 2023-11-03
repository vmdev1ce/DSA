import javax.imageio.IIOException;

public class B9_Caculate_Postfix<E> {
    class Node {
        E element;
        Node next;
    }

    private Node stack;

    public void push(E element) {
        Node temp = new Node();
        temp.element = element;
        temp.next = stack;
        stack = temp;
    }

    public E pop() {
        if (isEmpty()) {
            try {
                throw new IIOException("Stack 6is Empty!");
            } catch (IIOException e) {
                e.printStackTrace();
            }
        }
        E element = stack.element;
        stack = stack.next;
        return element;
    }

    public boolean isEmpty() {
        return stack == null;
    }

    public static Double caculate_basic(Double a, char operand, Double b) throws IIOException {
        if (operand == '+') {
            return a + b;
        } else if (operand == '-') {
            return a - b;
        } else if (operand == '*') {
            return a * b;
        } else if (operand == '/') {
            return a / b;
        }
        else {
            throw new IIOException("Operand is not correct!");
        }
    }

    public static Double cacualate_postfix(String postfix_str) throws IIOException {
        String [] postfix_str_without_space = postfix_str.split(" ");

        B9_Caculate_Postfix<Double> stackNumber = new B9_Caculate_Postfix<>();

        for (int index = 0; index < postfix_str_without_space.length; index++) {
            if (postfix_str_without_space[index].matches("\\d+")) {
                stackNumber.push(Double.parseDouble(postfix_str_without_space[index]));
            } else {
                Double b = stackNumber.pop();
                Double a = stackNumber.pop();
                char operand = postfix_str_without_space[index].charAt(0);
                Double results = caculate_basic(a, operand, b);
                stackNumber.push(results);
            }
        }
        return stackNumber.pop();
    }

    public static void main(String[] args) throws IIOException {
        String postfix_str = "3 4 5 * + 6 -";
        System.out.println(cacualate_postfix(postfix_str));
    }
}
