import java.util.Iterator;

@SuppressWarnings({ "unchecked", "deprecation" })
public class SimpleLinkedList<T> implements ListInterface<T> {
	class Node {
		T data;
		Node next;
	}

	private Node top = null;
	private Node bot = null;
	private int n = 0;

	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}

		n++;
	}

	@Override
	public T get(int i) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= size()) {
			return null;
		}

		Node currentNode = top;
		for (int j = 0; j < i; j++) {
			currentNode = currentNode.next;
		}
		return currentNode.data;
	}

	@Override
	public void set(int i, T data) {
		// TODO Auto-generated method stub
		if (i < 0 || i >= size()) {
			return;
		}

		Node currentNode = top;
		for (int j = 0; j < i; j++) {
			currentNode = currentNode.next;
		}
		currentNode.data = data;
	}

	@Override
	public void remove(int i) {
		// TODO Auto-generated method stub
		if (top == null)
			return;

		Node current = top;
		if (i == 0) {
			top = current.next;
			current = null;
			return;
		}

		for (int j = 0; j < i - 1; j++) {
			if (current == null)
				return;
			current = current.next;
		}

		if (current == null || current.next == null)
			return;

		Node nextNode = current.next.next;
		current.next = null;
		current.next = nextNode;
		n--;
	}

	@Override
	public boolean isContain(T data) {
		// TODO Auto-generated method stub
		Node currentNode = top;

		while (currentNode.data != null) {
			if (currentNode.data.equals(data)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int indexOf(T data) {
		// TODO Auto-generated method stubNode p = top;
		Node currentNode = top;
		int index = 0;

		while (currentNode != null) {
			if (currentNode.data.equals(data)) {
				return index;
			}
			currentNode = currentNode.next;
			index++;
		}

		return -1;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return n;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return n == 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}

	class LinkedListIterator implements Iterator<T> {
		private Node currentNode;

		public LinkedListIterator() {
			super();
			this.currentNode = (Node) top;
		}

		@Override
		public boolean hasNext() {
			if (currentNode != null)
				return true;
			else
				return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (!hasNext()) return null;

			T node = currentNode.data;
			currentNode = currentNode.next;
			return node;
		}

	}

}
