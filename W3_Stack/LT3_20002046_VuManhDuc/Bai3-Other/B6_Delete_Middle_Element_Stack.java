import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class B6_Delete_Middle_Element_Stack<E> {
    class Node {
        E element;
        Node next;
    }

    private Node stack;
    private int size;
    List<E> EList = new ArrayList<>();

    public void push(E element) {
        Node temp = new Node();
        temp.element = element;
        temp.next = stack;
        stack = temp;
        size++;
        EList.add(element);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E element = stack.element;
        stack = stack.next;
        size--;
        EList.remove(size);
        return element;
    }

    public boolean isEmpty() {
        return stack == null;
    }

    public int getSize() {
        return size;
    }

    public static B6_Delete_Middle_Element_Stack<Integer> delete_middle_element_stack(
            B6_Delete_Middle_Element_Stack<Integer> inputStack) {

        B6_Delete_Middle_Element_Stack<Integer> tempStack = new B6_Delete_Middle_Element_Stack<>();

        int size = inputStack.getSize();
        int index_middle = (int) Math.ceil(size / 2) + 1;

        if (size % 2 == 0) {
            for (int step = 0; step < size / 2 + 1; step++) {
                tempStack.push(inputStack.pop());
            }
        } else {
            for (int step = 0; step < index_middle; step++) {
                tempStack.push(inputStack.pop());
            }
        }

        tempStack.pop();

        while (!tempStack.isEmpty()) {
            inputStack.push(tempStack.pop());
        }
        return inputStack;
    }


    public static void main(String[] args) {
        B6_Delete_Middle_Element_Stack<Integer> inputStack = new B6_Delete_Middle_Element_Stack<>();
        inputStack.push(10);
        inputStack.push(20);
        inputStack.push(30);
        inputStack.push(40);
        inputStack.push(50);
        inputStack.push(60);
        System.out.println(inputStack.EList);
        B6_Delete_Middle_Element_Stack<Integer> outputStack = delete_middle_element_stack(inputStack);
        System.out.println(outputStack.EList);
    }

}
