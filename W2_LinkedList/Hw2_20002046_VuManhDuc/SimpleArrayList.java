import java.util.Iterator;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array;
    private int n = 0;
    private int defaultSize = 100;

    public SimpleArrayList() {
        array = (T[]) new Object[defaultSize];
    }

    public SimpleArrayList(int capacity) {
        // Hàm dựng với kích thước mảng là capacity
        array = (T[]) new Object[capacity];
    }

    public void add(T data) {
        int now_size = this.size();
        this.array[now_size] = data;
        this.n += 1;
    }

    public T get(int i) {
        if (i >= this.size() || i < 0) {
            System.out.println("OutOfIndex");
            return null;
        }

        // Return i-th element of array presenting i-th element of array list
        return array[i];
    }

    public void set(int i, T data) {
        if (i > this.size() || i < 0) {
            return;
        }
        array[i] = data;
    }

    public int indexOf(T data) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i].equals(data)) {
                return i;
            }
        }
        return 0;
    }

    public void remove(T data) {
        int index = -1;
        for (int i = 0; i < this.size(); i++) {
            if (array[i].equals(data)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < this.size() - 1; i++) {
                array[i] = array[i + 1];
            }
            this.n -= 1;
        }
    }

    public boolean isContain(T data) {
        for (int i = 0; i < this.size(); i++) {
            if (array[i].equals(data))
                return true;
        }
        return false;
    }

    public int size() {
        return this.n;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public Iterator<T> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<T> {
        int cursor = -1;

        Iter() {
        }

        @Override
        public boolean hasNext() {
            cursor += 1;
            return cursor < size();
        }

        @Override
        public T next() {
            return array[cursor];
        }
    }
}