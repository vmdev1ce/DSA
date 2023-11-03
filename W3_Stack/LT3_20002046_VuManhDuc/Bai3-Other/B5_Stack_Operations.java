import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import javax.imageio.IIOException;

public class B5_Stack_Operations<E> {
    class Node {
        E element;
        Node next;
    }

    private Node stack;
    private int size;
    private List<E> listStack = new ArrayList<>();

    public void push(E element) {
        Node temp = new Node();
        temp.element = element;
        temp.next = stack;
        stack = temp;
        size++;
        listStack.add(element);
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E element = stack.element;
        stack = stack.next;
        listStack.remove(size);
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static <E> List<String> active(Integer [] target, int n) {
        B5_Stack_Operations<Integer> tempStack = new B5_Stack_Operations<>();
        int target_size = target.length;
        List<String> act = new ArrayList<>();

        if (target_size == n){
            for (int index = 0; index < n; index ++){
                act.add("Push");
            }
        }
        int count = 0;
        if (target_size < n){
            for (int index = 0; index < n; index ++){
                tempStack.push(index + 1);
                act.add("Push");
                if (index + 1 == target[count]){
                    count++;
                    continue;
                }
                else
                {
                    act.add("Pop");
                }

            }
        }

        if (target_size > n) {
            try {
                throw new IIOException("Targe size bigger than n");
            } catch (IIOException e) {
                e.printStackTrace();
            }
        }
        return act;
    }
    public static void main(String[] args) {
        Integer [] target = {1, 2, 3};
        int n = 3;
        List<String> act = active(target, n);
        System.out.println(act);

    }
}
