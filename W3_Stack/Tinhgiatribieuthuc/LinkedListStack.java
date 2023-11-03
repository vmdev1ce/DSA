import java.util.Iterator;


public class LinkedListStack<T> implements StackInterface<T> {

	class Node {
		T element;
		Node next;
	}

	Node stack = null;

	@Override
	public void push(T element) {
		Node node = new Node();
        node.element = element;
        node.next = stack;
        stack = node;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
            return null;
        }
        T element = stack.element;
        stack = stack.next;
        return element;
	}

	@Override
	public boolean isEmpty() {
		return stack == null;
	}

	@Override
    public int size() {
        int count = 0;
        Node p = stack;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

	 @Override
    public Iterator<T> iterator() {
        
        return new StackIterator();
    }

    class StackIterator implements Iterator<T> {

        Node current = stack;

        @Override

        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T e = current.element;
            current = current.next;
            return e;
        }
    }
}
