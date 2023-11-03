import java.util.Iterator;

public class SimpleLinkedList<T> implements ListInterface<T>{
    class Node {
        T data;
        Node next;
    }

    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add(T data) {
        // Thêm phần tử vào đầu danh sách
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

    public void addBot(T data) {
        // Thêm phần tử vào cuối danh sách
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (isEmpty()) {
            top = newNode;
            bot = newNode;
        } else {
            bot.next = newNode;
            bot = newNode;
        }

        n++;
    }

    public T get(int i) {
        // Lấy phần tử ở vị trí thứ i
        if (i < 0 || i >= size()) {
            return null;
        }

        Node currentNode = top;
        for (int j = 0; j < i; j++) {
            currentNode = currentNode.next;
        }

        return currentNode.data;
    }

    public void set(int i, T data) {
        // Gán giá trị ở vị trí i bằng data
        if (i < 0 || i >= size()) {
            return;
        }

        Node currentNode = top;
        for (int j = 0; j < i; j++) {
            currentNode = currentNode.next;
        }

        currentNode.data = data;
    }

    public boolean isContain(T data) {
        // Kiểm tra trong danh sách có chứa phần tử data hay không?
        Node currentNode = top;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public int size() {
        // Trả lại thông tin số phần tử có trong danh sách
        return n;
    }

    public boolean isEmpty() {
        // Kiểm tra danh sách có rỗng hay không?
        return n == 0;
    }

    public T removeTop() {
        // Xóa phần tử ở đầu danh sách, trả lại giá trị data của phần tử đó
        if (isEmpty()) {
            return null;
        }

        T removedData = top.data;
        top = top.next;

        if (top == null) {
            bot = null;
        }

        n--;

        return removedData;
    }

    public T removeBot() {
        // Xóa phần tử ở cuối danh sách, trả lại giá trị data của phần tử đó
        if (isEmpty()) {
            return null;
        }

        T removedData;
        if (top == bot) {
            removedData = top.data;
            top = null;
            bot = null;
        } else {
            Node currentNode = top;
            while (currentNode.next != bot) {
                currentNode = currentNode.next;
            }
            removedData = bot.data;
            currentNode.next = null;
            bot = currentNode;
        }

        n--;

        return removedData;
    }

    public void remove(T data) {
        // Xóa tất cả các phần tử có giá trị bằng data

        if (n == 0)
            return;
        while (top != null) {
            if (top.data == data) {
                removeTop();
            }
        }
        if (n > 0) {
            Node newNode = top;
            while (newNode.next != null) {
                if (newNode.data == data) {
                    newNode.next = newNode.next.next;
                    n--;
                }
            }
        }
    }

    public int indexOf(T data) {
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