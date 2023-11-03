// 1.1 Xây dựng kiểu dữ liệu UnsortedArrayPriorityQueue sử dụng mảng, 
//cài đặt giao diện PriorityQueueInterface đã xây dựng ở trên với lược đồ gợi ý 
public class UnsortedArrayPriorityQueue<K extends Comparable<K>, E> implements PriorityQueueInterface<K, E> {

    protected class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;

        public ArrEntry(K k, E e) {
            key = k;
            element = e;
        }

        public K getKey() {
            return key;
        }

        public E getValue() {
            return element;
        }
    }

    ArrEntry<K, E>[] array;
    int n = 0;
    int defaultSize = 1000;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    public UnsortedArrayPriorityQueue(int capacity) {
        array = new ArrEntry[capacity];
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Entry<K, E> entry) {
        if (n == array.length) {
            throw new IllegalStateException("Priority queue is full");
        }
        array[n] = (ArrEntry<K, E>) entry;
        n++;
    }

    public void insert(K key, E element) {
        insert(new ArrEntry<>(key, element));
    }

    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        Entry<K, E> minEntry = array[minIndex];
        array[minIndex] = array[n - 1];
        array[n - 1] = null;
        n--;
        return minEntry;
    }

    public Entry<K, E> min() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        return array[minIndex];
    }
}
